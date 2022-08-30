package com.example.training.date;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.remoting.RemoteAccessException;

import java.util.Random;

/**
 * @author yang han
 * @date 2022/8/30 9:27
 */
@Slf4j
public class RetryDemoTask {


    /**
     * 重试方法
     * @return
     */
    public static boolean retryTask(String param)  {
        log.info("收到请求参数:{}",param);

        int i = RandomUtils.nextInt(new Random(),11);
//        int i = 9;
        log.info("随机生成的数:{}",i);
        if (i < 2) {
            log.info("为0,抛出参数异常.");
            throw new IllegalArgumentException("参数异常");
        }else if (i < 5){
            log.info("为1,返回true.");
            return true;
        }else if (i < 7){
            log.info("为2,返回false.");
            return false;
        }else{
            //为其他
            log.info("大于2,抛出自定义异常.");
            throw new RemoteAccessException("大于2,抛出自定义异常");
        }
    }
}
