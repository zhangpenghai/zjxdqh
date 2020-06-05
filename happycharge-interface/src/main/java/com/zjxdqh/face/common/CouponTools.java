package com.zjxdqh.face.common;

import com.zjxdqh.face.enums.CouponEnum;
import com.zjxdqh.face.exception.BuzzException;
import com.zjxdqh.face.vo.FCouponsConfig;
import com.zjxdqh.tools.DateUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * 优惠券 配置信息 获取的工具类
 *
 * @author Yorking
 * @date 2019/10/29
 */
public class CouponTools {


    public static Date getCouponStartTime(List<FCouponsConfig> configs) {
        Map<String, List<FCouponsConfig>> configMap = convertConfigMap(configs);
        if (StringUtils.isEmpty(configMap)) {
            return null;
        }
        FCouponsConfig actTyp = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_TYPE);
        if (CouponEnum.ConfigActivateType.CURRENT_TIME.val().equalsIgnoreCase(actTyp.getCouponVal1())) {
            // 如果是即时生效
            return DateUtils.getNowDate();
        } else if (CouponEnum.ConfigActivateType.FIXED_TIME.val().equalsIgnoreCase(actTyp.getCouponVal1())) {
            // 如果是固定时间生效
            FCouponsConfig config = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_START_DELAY_TIME_VAL);
            return DateUtils.getDate(config.getCouponVal1(), DateUtils.YMD_HMS);
        } else if (CouponEnum.ConfigActivateType.DELAY_TIME.val().equalsIgnoreCase(actTyp.getCouponVal1())) {
            // 如果是 延时生效
            FCouponsConfig config = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_START_DELAY_TIME_TYPE);
            FCouponsConfig valConfig = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_START_DELAY_TIME_VAL);
            Instant now = DateUtils.getNowDate().toInstant();
            Double val = Double.parseDouble(valConfig.getCouponVal1());
            if (CouponEnum.ConfigActivateStartDelayTimeType.HOUR.val().equalsIgnoreCase(config.getCouponVal1())) {
                return new Date(now.plus(val.longValue(), ChronoUnit.HOURS).toEpochMilli());
            } else if (CouponEnum.ConfigActivateStartDelayTimeType.DAY.val().equalsIgnoreCase(config.getCouponVal1())) {
                return new Date(now.plus(val.longValue(), ChronoUnit.DAYS).toEpochMilli());
            } else if (CouponEnum.ConfigActivateStartDelayTimeType.MONTH.val().equalsIgnoreCase(config.getCouponVal1())) {
                return new Date(now.plus(val.longValue(), ChronoUnit.MONTHS).toEpochMilli());
            }
        }
        return null;
    }

    public static Date getCouponExpireTime(List<FCouponsConfig> configs, Date startDate) {
        if (startDate == null) {
            return null;
        }
        Map<String, List<FCouponsConfig>> configMap = convertConfigMap(configs);
        if (StringUtils.isEmpty(configMap)) {
            return null;
        }
        FCouponsConfig expireTyp = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_EXPIRE_TIME_TYPE);
        FCouponsConfig expireVal = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_EXPIRE_TIME_VAL);
        if (CouponEnum.ConfigActivateExpireTimeType.FIXED_TIME.val().equalsIgnoreCase(expireTyp.getCouponVal1())) {
            // 固定时间
            return DateUtils.getDate(expireVal.getCouponVal1(), DateUtils.YMD_HMS);
        } else if (CouponEnum.ConfigActivateExpireTimeType.DELAY_DAY.val().equalsIgnoreCase(expireTyp.getCouponVal1())) {
            // 如果是延时时间(单位：天）
            FCouponsConfig valConfig = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_EXPIRE_TIME_VAL);
            Double val = Double.parseDouble(valConfig.getCouponVal1());
            return new Date(startDate.toInstant().plus(val.longValue(), ChronoUnit.DAYS).toEpochMilli());
        } else if (CouponEnum.ConfigActivateExpireTimeType.DELAY_MONTH.val().equalsIgnoreCase(expireTyp.getCouponVal1())) {
            // 如果是延时时间(单位：月）
            FCouponsConfig valConfig = getConfig(configMap, CouponEnum.ConfigKey.ACTIVATE_EXPIRE_TIME_VAL);
            Double val = Double.parseDouble(valConfig.getCouponVal1());
            return new Date(startDate.toInstant().plus(val.longValue(), ChronoUnit.MONTHS).toEpochMilli());
        }
        return null;
    }

    private static FCouponsConfig getConfig(Map<String, List<FCouponsConfig>> configMap, CouponEnum.ConfigKey key) {
        List<FCouponsConfig> startVals = configMap.get(key.key());
        if (startVals == null || startVals.size() > 1) {
            throw new BuzzException("优惠券配置:" + key.key() + "异常");
        }
        return startVals.get(0);
    }

    private static List<FCouponsConfig> getConfigs(Map<String, List<FCouponsConfig>> configMap, CouponEnum.ConfigKey key) {
        List<FCouponsConfig> startVals = configMap.get(key.key());
        if (CollectionUtils.isEmpty(startVals)) {
            throw new BuzzException("优惠券配置:" + key.key() + "异常");
        }
        return startVals;
    }

    public static Map<String, List<FCouponsConfig>> convertConfigMap(List<FCouponsConfig> configs) {
        if (CollectionUtils.isEmpty(configs)) {
            return null;
        }
        Map<String, List<FCouponsConfig>> maps = new HashMap<>();
        for (FCouponsConfig config : configs) {
            maps.computeIfAbsent(config.getCouponKey(), k -> new ArrayList<>());
            maps.get(config.getCouponKey()).add(config);
        }
        return maps;
    }
}
