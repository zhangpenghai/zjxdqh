package com.zjxdqh.face.service;

import com.github.pagehelper.PageInfo;
import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.exception.BuzzException;
import com.zjxdqh.face.param.ChargeStateParam;
import com.zjxdqh.face.param.DeviceStatusParam;
import com.zjxdqh.face.param.StartChargeParam;
import com.zjxdqh.face.param.StationStatsInfoParam;
import com.zjxdqh.face.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@FeignClient(name = "happyService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface HappyService {

    /**
     * 查询订单充电结束采集信息
     * @param orderNo
     * @return
     */
    @PostMapping("getBChargeEndInfo")
    @ResponseBody
    BChargeEndInfo getBChargeEndInfo(@RequestParam("orderNo") String orderNo);

    @GetMapping("getPile")
    @ResponseBody
    PileSite getPileSite(@RequestParam("sid") Integer sid);

    /**
     * 查询所有需要推送的状态到监管平台的设备
     * @return
     */
    @GetMapping("getEvcsPushPile")
    @ResponseBody
    List<EvcsPushPile> getEvcsPushPile();

    @PostMapping("getPileByPNum")
    @ResponseBody
    FPile getPileByNum(@RequestParam("pilenum") String pilenum);


    @PostMapping("getSuperviseSite")
    @ResponseBody
    PageInfo<FPileSite> getSuperviseSite(@RequestParam("operatorId") String  operatorId, @RequestParam(value = "uptTime", required = false)Date uptTime, @RequestParam("pageNo")int pageNo, @RequestParam("pageSize")int pageSize);

    /**
     * 充电状态接口：数据库一定能返回的数据
     *
     * @param chargeStateParam
     * @return
     */
    @PostMapping("query_charge_state_base_vo")
    @ResponseBody
    ChargeStateBaseVo queryChargeStateBaseVo(@RequestBody ChargeStateParam chargeStateParam);


    /**
     * 充电状态接口：充电成功后，返回部分数据
     *
     * @param chargeStateParam
     * @return
     */
    @PostMapping("query_charge_success_state_vo")
    @ResponseBody
    ChargeSuccessStateVo queryChargeSuccessStateVo(@RequestBody ChargeStateParam chargeStateParam);


    /**
     * <p>
     * 此查询用于定期获取每个充电站，在某个周期内的统计信息。
     * </p>
     * 使用方法：由充电运营商方实现此接口，数据需求方调用。
     *
     * @param stationStatsInfoParam
     */
    @PostMapping("query_station_stats")
    @ResponseBody
    List<StationStatsInfo> queryStationStats(@RequestBody StationStatsInfoParam stationStatsInfoParam);


    /**
     * 根据充电站id查询所有桩列表
     *
     * @param stationID
     * @return
     */
    @GetMapping("getPilesByStationId")
    @ResponseBody
    List<PileStatusInfoVo> getPilesByStationId(@RequestParam("stationID") String stationID);

    /**
     * 获取充停止充电结果
     */
    @GetMapping("getStopChargeResult")
    @ResponseBody
    StopChargeResultVo getStopChargeResult(@RequestParam("orderNo") String orderNo);


    /**
     * 根据桩号和枪号查询充电设备接口状态
     *
     * @param statusParam
     * @return
     */
    @PostMapping("getPilesByPilegnum")
    @ResponseBody
    PileStatusInfoVo getPilesByPilegnum(@RequestBody DeviceStatusParam statusParam);


    /**
     * 根据 对接方 组织代码查询 密钥信息
     *
     * @param operatorId
     * @return
     */
    @GetMapping("getSupersiveInfo")
    @ResponseBody
    SupersiveInfo getSupersiveInfo(@RequestParam("operatorId") String operatorId);

    /**
     * 根据 主键 查询 密钥信息
     *
     * @param superviseId
     * @return
     */
    @GetMapping("getSupersiveInfoById")
    @ResponseBody
    SupersiveInfo getSupersiveInfoById(@RequestParam("superviseId") String superviseId);

    /**
     * 根据 桩编号 查询 密钥信息
     * @param pileNum
     * @return
     */
    @GetMapping("getSupersiveInfoByPilenum")
    @ResponseBody
    List<SupersiveInfo> getSupersiveInfoByPilenum(@RequestParam("pileNum")String pileNum);


    /**
     * 根据 场站编号  查询 密钥信息
     * @param sid
     * @return
     */
    @PostMapping("getSupersiveInfoBySid")
    @ResponseBody
    List<SupersiveInfo> getSupersiveInfoBySid(@RequestParam("sid")String sid);

    /**
     * 启动充电（创建订单）
     *
     * @param param
     * @return
     */
    @PostMapping("startCharge")
    @ResponseBody
    StartChargeResult startCharge(@RequestBody StartChargeParam param) throws BuzzException;

    /**
     * 查询业务策略信息结果
     *
     * @param PileNum
     * @return
     */
    @GetMapping("getPolicyInfos")
    @ResponseBody
    List<PolicyInfo> getPolicyInfos(@RequestParam("PileNum") String PileNum);

    /**
     * 订单超时退款
     * @param orderNo
     * @return
     */
    @PostMapping("backOrder")
    @ResponseBody
    int backOrder(@RequestParam("sn") String orderNo);


    /**
     * 补贴标准接口调整：
     *
     * 查询可以进行补贴的桩
     * @param supersiveId
     * @return
     */
    @GetMapping("notificationRecordsAmountInfo")
    @ResponseBody
    List<Subsidy> notificationRecordsAmountInfo(@RequestParam("supersiveId") String supersiveId);


    /**
     * 获取当前电压 、 电流
     * @param StartChargeSeq
     * @return
     */
    @GetMapping("getVoltageCurrent")
    @ResponseBody
    ChargeDataTemp getVoltageCurrent(@RequestParam("StartChargeSeq") String StartChargeSeq);

    /**
     * 获取分时段的充电明细体
     * @param StartChargeSeq
     * @return
     */
    @GetMapping("getFOrderSettlementDetailBySn")
    @ResponseBody
    List<FOrderSettlementDetail> getFOrderSettlementDetailBySn(@RequestParam("StartChargeSeq") String StartChargeSeq);

    /**
     * 根据订单号查询order表实体信息
     * @param oderSn
     * @return
     */
    @GetMapping("findFOderBySn")
    @ResponseBody
    FOrder findFOderBySn(@RequestParam("oderSn")String oderSn);

    /**
     * 根据第三方查询order表实体信息
     * @param superviseSn
     * @return
     */
    @GetMapping("findFOderBysuperviseSn")
    @ResponseBody
    FOrder findFOderBysuperviseSn(@RequestParam("superviseSn")String superviseSn);


}
