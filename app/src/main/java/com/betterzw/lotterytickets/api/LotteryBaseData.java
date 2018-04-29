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
        public LotteryInfo lottery;

        public LotteryData(List<String> codeNumber, List<LotteryDetail> details, LotteryInfo lottery) {
            this.codeNumber = codeNumber;
            this.details = details;
            this.lottery = lottery;
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

    public class LotteryInfo{

        /**
         * drawNews :
         * fTime :
         * isAP : 1
         * ispool : 0
         * lType : 4
         * numSequence : 20 32 29 10 22-05 10（本期使用：第2套摇奖球）
         * numSequence_pool :
         * number : 10 20 22 29 32-05 10
         * number_pool :
         * openTime_fmt : 2018年04月23日
         * openTime_fmt1 : 20180423
         * pool : 5,268,370,217.12
         * sTime : 2018-04-21 20:25:00
         * status : 0
         * term : 18046
         * totalSales : 257,284,500
         * totalSales2 : 0
         * totlSaleNews :
         * verify : 0
         */

        private String drawNews;
        private String fTime;
        private int isAP;
        private int ispool;
        private int lType;
        private String numSequence;
        private String numSequence_pool;
        private String number;
        private String number_pool;
        private String openTime_fmt;
        private String openTime_fmt1;
        private String pool;
        private String sTime;
        private int status;
        private String term;
        private String totalSales;
        private String totalSales2;
        private String totlSaleNews;
        private int verify;

        public String getDrawNews() {
            return drawNews;
        }

        public void setDrawNews(String drawNews) {
            this.drawNews = drawNews;
        }

        public String getFTime() {
            return fTime;
        }

        public void setFTime(String fTime) {
            this.fTime = fTime;
        }

        public int getIsAP() {
            return isAP;
        }

        public void setIsAP(int isAP) {
            this.isAP = isAP;
        }

        public int getIspool() {
            return ispool;
        }

        public void setIspool(int ispool) {
            this.ispool = ispool;
        }

        public int getLType() {
            return lType;
        }

        public void setLType(int lType) {
            this.lType = lType;
        }

        public String getNumSequence() {
            return numSequence;
        }

        public void setNumSequence(String numSequence) {
            this.numSequence = numSequence;
        }

        public String getNumSequence_pool() {
            return numSequence_pool;
        }

        public void setNumSequence_pool(String numSequence_pool) {
            this.numSequence_pool = numSequence_pool;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getNumber_pool() {
            return number_pool;
        }

        public void setNumber_pool(String number_pool) {
            this.number_pool = number_pool;
        }

        public String getOpenTime_fmt() {
            return openTime_fmt;
        }

        public void setOpenTime_fmt(String openTime_fmt) {
            this.openTime_fmt = openTime_fmt;
        }

        public String getOpenTime_fmt1() {
            return openTime_fmt1;
        }

        public void setOpenTime_fmt1(String openTime_fmt1) {
            this.openTime_fmt1 = openTime_fmt1;
        }

        public String getPool() {
            return pool;
        }

        public void setPool(String pool) {
            this.pool = pool;
        }

        public String getSTime() {
            return sTime;
        }

        public void setSTime(String sTime) {
            this.sTime = sTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(String totalSales) {
            this.totalSales = totalSales;
        }

        public String getTotalSales2() {
            return totalSales2;
        }

        public void setTotalSales2(String totalSales2) {
            this.totalSales2 = totalSales2;
        }

        public String getTotlSaleNews() {
            return totlSaleNews;
        }

        public void setTotlSaleNews(String totlSaleNews) {
            this.totlSaleNews = totlSaleNews;
        }

        public int getVerify() {
            return verify;
        }

        public void setVerify(int verify) {
            this.verify = verify;
        }
    }



}
