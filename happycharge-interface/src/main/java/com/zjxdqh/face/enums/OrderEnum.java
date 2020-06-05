package com.zjxdqh.face.enums;

/**
 * @author Yorking
 * @date 2019/08/19
 */
public interface OrderEnum {

    enum Ostat {
        /**
         * 订单状态
         */
        FINISH(1, "完成"),
        CANCEL(-1, "失效"),
        CHARGING(0, "充电中"),
        READING(2, "准备中"),
        STARTING(3, "启动中"),
        SETTLE(4, "结算中"),
        PAYING(5, "支付中");

        private String desc;
        private int key;

        Ostat(int ostat, String desc) {
            this.desc = desc;
            this.key = ostat;
        }

        public int key() {
            return this.key;
        }

    }


    enum Paytype {
        /**
         * 订单状态
         */
        APP(0, "个人帐户支付"),
        Company(2, "企业帐户支付");

        private String desc;
        private int key;

        Paytype(int ostat, String desc) {
            this.desc = desc;
            this.key = ostat;
        }

        public int key() {
            return this.key;
        }

    }

}
