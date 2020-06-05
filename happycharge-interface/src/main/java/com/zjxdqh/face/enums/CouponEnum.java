package com.zjxdqh.face.enums;

/**
 * 优惠券 常量枚举
 *
 * @author Yorking
 * @date 2019/09/11
 */
public interface CouponEnum {


    enum Typ {
        /**
         * 优惠券类型
         */
        CASH(1, "现金券"),
        DEDUCTION(2, "抵用券"),
        DISCOUNT(3, "折扣券"),
        MONEY_OFF(4, "满减券");

        private String desc;
        private int key;

        Typ(int ostat, String desc) {
            this.desc = desc;
            this.key = ostat;
        }

        public int key() {
            return this.key;
        }

    }

    enum Stat {
        /**
         * 优惠券状态
         */
        DISABLE(-1, "禁用"),
        SUSPENDED(0, "待用"),
        USING(1, "可使用"),
        USED(2, "已使用");

        private String desc;
        private int key;

        Stat(int key, String desc) {
            this.desc = desc;
            this.key = key;
        }

        public int key() {
            return this.key;
        }

    }

    enum ConfigValType {
        /**
         * 优惠券参数类型
         */
        STRING(0),
        INTEGER(1),
        DECIMAL(2),
        DATETIME(3),
        DATE(4),
        TIME(5);

        private int key;

        ConfigValType(int key) {
            this.key = key;
        }

        public int key() {
            return this.key;
        }

    }



    enum ConfigKey{
        /**
         * 优惠券 值 参数配置
         */
        EXPENSE_TYPE("EXPENSE_TYPE", "优惠费用 类型（电费，服务费等等）"),
        ACTIVATE_TYPE("ACTIVATE_TYPE", "优惠券激活时间方式（即时生效，延时生效，固定日期生效）"),
        ACTIVATE_START_DELAY_TIME_TYPE("ACTIVATE_START_DELAY_TIME_TYPE", "生效延时时间类型（小时，天，月，年）"),
        ACTIVATE_START_DELAY_TIME_VAL("ACTIVATE_START_DELAY_TIME_VAL", "生效延时数值"),
        ACTIVATE_EXPIRE_TIME_TYPE("ACTIVATE_EXPIRE_TIME_TYPE", "过期时间类型（固定时间，延时天，延时月）"),
        ACTIVATE_EXPIRE_TIME_VAL("ACTIVATE_EXPIRE_TIME_VAL", "过期时间值（固定时间，延时值）"),
        STATION("STATION", "场站ID（电费，服务费等等）"),
        PERIOD_HOURS("PERIOD_HOURS", "作用时段 (如9-10点，20-22点)");


        private String desc;
        private String  key;

        ConfigKey(String  key, String desc) {
            this.desc = desc;
            this.key = key;
        }
        public String key() {
            return this.key;
        }
    }


    enum ConfigActivateType{
        /**
         * 优惠券激活时间方式
         */
        CURRENT_TIME("0","即时生效"),
        DELAY_TIME("1","延时生效"),
        FIXED_TIME("2", "固定时间生效");

        private String  val;
        private String desc;

        ConfigActivateType(String key, String desc) {
            this.desc = desc;
            this.val = key;
        }
        public String  val() {
            return this.val;
        }
    }


    enum ConfigActivateStartDelayTimeType{
        /**
         * 生效延时时间类型
         */
        HOUR("0","延时小时"),
        DAY("1","延时天数"),
        MONTH("2","延时月数");

        private String  val;
        private String desc;

        ConfigActivateStartDelayTimeType(String key, String desc) {
            this.desc = desc;
            this.val = key;
        }
        public String  val() {
            return this.val;
        }
    }

    enum ConfigActivateExpireTimeType{
        /**
         * 过期时间类型
         */
        FIXED_TIME("0","固定时间"),
        DELAY_DAY("1","延时天数"),
        DELAY_MONTH("2","延时月数");

        private String  val;
        private String desc;

        ConfigActivateExpireTimeType(String key, String desc) {
            this.desc = desc;
            this.val = key;
        }
        public String  val() {
            return this.val;
        }
    }



    enum ConfigExpenseType {
        /**
         * 优惠费用使用类型
         */
        SERVICE_AMOUNT("1","服务费"),
        ELE_AMOUNT("2","电费"),
        ORDER_AMOUNT("3", "订单总费用");

        private String  val;
        private String desc;

        ConfigExpenseType(String key, String desc) {
            this.desc = desc;
            this.val = key;
        }
        public String  val() {
            return this.val;
        }
    }

}
