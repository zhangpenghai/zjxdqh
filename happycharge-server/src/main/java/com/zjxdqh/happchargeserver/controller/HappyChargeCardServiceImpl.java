package com.zjxdqh.happchargeserver.controller;

import com.zjxdqh.face.service.HappyChargeCardService;
import com.zjxdqh.face.vo.CouponsUserVo;
import com.zjxdqh.face.vo.FCouponsUser;
import com.zjxdqh.face.vo.FPileChargCard;
import com.zjxdqh.face.vo.FPileChargCardVo;
import com.zjxdqh.happchargeserver.mapper.FPileChargCardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangqinmin
 * @date: 2019/9/19 15:38
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@RestController
@Log4j2
public class HappyChargeCardServiceImpl implements HappyChargeCardService {

    @Autowired
    private FPileChargCardMapper fPileChargCardMapper;

    /**
     * 账号卡详情查询
     *
     * @param pcstate    -1挂失 0-停用 1-正常
     * @param uid
     * @param activation 1-绑定 0-未绑定
     * @return
     */
    @Override
    public List<FPileChargCardVo> getChargeCards(Integer pcstate,Integer uid, Integer activation) {
        List<FPileChargCardVo> fPileChargCardVos = new ArrayList<>();
        if (uid == null) {
            return null;
        }
        Map<String, Object> param = new HashMap<>();
        param.put("userId", uid);
        if (pcstate != null) {
            param.put("pcstate", pcstate);
        }
        if (activation != null) {
            param.put("activation", activation);
        }
        if (uid != null) {
            param.put("uid", uid);
        }
        List<FPileChargCard> fPileChargCards = fPileChargCardMapper.getList(param);
        for (FPileChargCard fPileChargCard : fPileChargCards) {
            FPileChargCardVo fPileChargCardVo = new FPileChargCardVo();
            BeanUtils.copyProperties(fPileChargCard, fPileChargCardVo);
            fPileChargCardVos.add(fPileChargCardVo);
        }
        return fPileChargCardVos;
    }
}
