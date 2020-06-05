package com.zjxdqh.happchargeserver.service;

import com.zjxdqh.face.enums.CouponEnum;
import com.zjxdqh.face.enums.OrderEnum;
import com.zjxdqh.face.exception.BuzzException;
import com.zjxdqh.face.vo.FCouponsUser;
import com.zjxdqh.face.vo.FCouponsUserOrderLog;
import com.zjxdqh.face.vo.FOrder;
import com.zjxdqh.face.vo.FOrderSettlement;
import com.zjxdqh.face.vo.user.FAccount;
import com.zjxdqh.happchargeserver.controller.HappyServiceImpl;
import com.zjxdqh.happchargeserver.mapper.FAccountInfoMapper;
import com.zjxdqh.happchargeserver.mapper.FAccountMapper;
import com.zjxdqh.happchargeserver.mapper.FCouponsUserMapper;
import com.zjxdqh.happchargeserver.mapper.FCouponsUserOrderLogMapper;
import com.zjxdqh.happchargeserver.model.FAccountInfo;
import com.zjxdqh.tools.MathUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collections;

/**
 * @author Yorking
 * @date 2019/09/19
 */
@Service
public class CommonService {

    /**
     * 冻结帐户操作
     */
    public static final int ACCOUNT_OPER_TYPE_FREEZONE = 1;

    /**
     * 消费操作记录
     */
    public static final int ACCOUNT_OPER_TYPE_CONSUME = -1;
    /**
     * 退款操作记录
     */
    public static final int ACCOUNT_OPER_TYPE_BACK = 0;

    @Resource
    private FAccountMapper fAccountMapper;
    @Resource
    private FAccountInfoMapper accountInfoMapper;

    @Resource
    private FCouponsUserOrderLogMapper couponsUserOrderLogMapper;
    @Resource
    private FCouponsUserMapper couponsUserMapper;


    /**
     * 添加帐户操作记录
     *
     * @param order   订单
     * @param account 帐户
     * @param amount  消费金额
     * @param title   操作标题
     * @param type    操作类型，1预付费，-1支付消费
     */
    public boolean updateAccount(FOrder order, FAccount account, BigDecimal amount, String title, int type) {
        if (amount.doubleValue() < 0) {
            throw new RuntimeException("操作帐户金额需要不小于零！");
        }
        if (account == null) {
            account = fAccountMapper.getOne(Collections.singletonMap("uid", order.getUid()));
        }
        if (account == null) {
            throw new BuzzException("用户[" + order.getUid() + "]帐户不存在");
        }
        FAccountInfo accountInfo = new FAccountInfo();
        accountInfo.setSn(order.getSn());
        // 充电订单
        accountInfo.setOtype(type == ACCOUNT_OPER_TYPE_BACK?4:1);
        accountInfo.setUid(order.getUid());
        accountInfo.setOid(order.getOid());
        accountInfo.setTitle(title);

        accountInfo.setCashbef(account.getCash());
        accountInfo.setAccountbef(account.getAmount());
        accountInfo.setBalancebef(account.getBalance());
        if (type == ACCOUNT_OPER_TYPE_FREEZONE) {
            // 预付费记录
            if (order.getPaytype() == OrderEnum.Paytype.Company.key()) {
                accountInfo.setAccountaft(MathUtils.subtract(account.getAmount(), amount.doubleValue(), 2));
                accountInfo.setCashaft(account.getCash());

            } else if (order.getPaytype() == OrderEnum.Paytype.APP.key()) {
                accountInfo.setAccountaft(account.getAmount());
                accountInfo.setCashaft(MathUtils.subtract(account.getCash(), amount.doubleValue(), 2));

            }
        } else if (type == ACCOUNT_OPER_TYPE_CONSUME || type == ACCOUNT_OPER_TYPE_BACK) {
            // 消费记录

            // 退款金额
            BigDecimal backAmount = MathUtils.subtract(order.getAmount(), amount.doubleValue(), 2);
            // 消费记录
            if (order.getPaytype() == OrderEnum.Paytype.Company.key()) {
                // 企业帐户支付
                accountInfo.setCashaft(account.getCash());
                accountInfo.setAccountaft(MathUtils.add(account.getAmount(), backAmount.doubleValue(), 2));
            } else if (order.getPaytype() == OrderEnum.Paytype.APP.key()) {
                // 个人帐户支付
                accountInfo.setCashaft(MathUtils.add(account.getCash(), backAmount.doubleValue(), 2));
                accountInfo.setAccountaft(account.getAmount());
            }

            // 修改不可退 金额
            if (order.getPaytype() == OrderEnum.Paytype.APP.key()
                    && amount.doubleValue() > 0 && account.getNoRefundAmount().doubleValue() > 0) {
                BigDecimal noRefund = MathUtils.subtract(account.getNoRefundAmount(), amount.doubleValue(), 2);
                account.setNoRefundAmount(noRefund.doubleValue() > 0 ? noRefund : BigDecimal.ZERO);
            }
        } else {
            throw new BuzzException("帐户操作类型不支付");
        }
        accountInfo.setBalanceaft(MathUtils.add(accountInfo.getAccountaft(), accountInfo.getCashaft().doubleValue(), 2));
        //设置流水操作金额
//        accountInfo.setAmount(MathUtils.subtract(accountInfo.getBalancebef(), accountInfo.getBalanceaft().doubleValue(), 2).abs());
        accountInfo.setAmount(amount);

        account.setAmount(accountInfo.getAccountaft());
        account.setCash(accountInfo.getCashaft());
        account.setBalance(MathUtils.add(account.getAmount(), account.getCash().doubleValue(), 2));

        if (order.getPaytype() == OrderEnum.Paytype.APP.key()) {
            accountInfo.setPaytype(2);
        } else if (order.getPaytype() == OrderEnum.Paytype.Company.key()) {
            accountInfo.setPaytype(3);
        }

        accountInfoMapper.insertSelective(accountInfo);
        fAccountMapper.updateByPrimaryKey(account);
        return true;
    }


    /**
     * 添加现金优惠券使用日志
     *
     * @param couponsUser
     * @param settlement
     */
    public void updateOrderCoupons(FCouponsUser couponsUser, FOrderSettlement settlement) {
        if (couponsUser == null || settlement == null) {
            return;
        }

        couponsUserMapper.updateByPrimaryKey(couponsUser);

        FCouponsUserOrderLog orderLog = new FCouponsUserOrderLog();
        orderLog.setCouponUserId(couponsUser.getCouponsUserId());
        orderLog.setBefEleMoney(settlement.getOriginalEleAmount());
        orderLog.setBefServiceMoney(settlement.getOriginalServiceAmount());
        orderLog.setBefOrderAmount(settlement.getOriginalTotalAmount());
        orderLog.setSn(settlement.getSn());
        orderLog.setAftEleMoney(settlement.getEleAmount());
        orderLog.setAftServiceMoney(settlement.getServiceAmount());
        orderLog.setAftOrderAmount(settlement.getTotalAmount());
        couponsUserOrderLogMapper.insert(orderLog);

    }


}
