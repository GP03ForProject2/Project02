package com.qst.project02.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Log4jLog {
    public static void main(String[] args) {
        Random r = new Random();
        int i = r.nextInt(2);
        System.out.println(i);
//        Logger logger = LogManager.getLogger(Log4jLog.class);
//        //logger.debug("Debug Level");
//        logger.info("注册|用户名|年龄|职业|注册时间");
//        logger.info("登陆|用户名|年龄|职业|登陆时间");
//        logger.info("加入订单|用户名|年龄|职业|商品名称|商品价格");
//        logger.info("购买|用户名|年龄|职业|商品名称|商品价格|真实姓名|城市|电话号码");
        // logger.warn("Warn Level");
        //logger.error("Error Level");

    }
}
