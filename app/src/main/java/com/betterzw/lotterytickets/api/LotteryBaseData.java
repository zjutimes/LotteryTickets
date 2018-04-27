package com.betterzw.lotterytickets.api;

import java.util.List;

/**
 * Created by zhengwu on 4/27/18.
 */
public class LotteryBaseData {

    public List<LotteryData> mdata;

    public LotteryBaseData(List<LotteryData> mdata) {
        this.mdata = mdata;
    }

    public class LotteryData {
        public List<String> codeNumber;
        public List<LotteryDetail> details;

        public LotteryData(List<String> codeNumber, List<LotteryDetail> details) {
            this.codeNumber = codeNumber;
            this.details = details;
        }
    }

    public class LotteryDetail {

    /*{
        "allmoney":"30,000,000",
            "level":"一等奖",
            "money":"10,000,000",
            "num":401,
            "piece":"3",
            "sendPrize":"2,777,777"
    }*/

        public String allmoney;
        public String level;
        public String money;
        public int num;
        public String piece;
        public String sendPrize;

        public LotteryDetail(String allmoney, String level, String money, int num, String piece, String sendPrize) {
            this.allmoney = allmoney;
            this.level = level;
            this.money = money;
            this.num = num;
            this.piece = piece;
            this.sendPrize = sendPrize;
        }

    }

}
