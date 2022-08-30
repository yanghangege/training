package com.example.training;

import com.example.training.date.RetryDemoTask;
import com.github.rholder.retry.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.remoting.RemoteAccessException;

import java.util.concurrent.TimeUnit;

/**
 * @author yang han
 * @date 2022/8/30 9:29
 */
@Slf4j
public class GuavaRetryTest {

    @Test
    public void fun01(){
        // RetryerBuilder 构建重试实例 retryer,可以设置重试源且可以支持多个重试源，可以配置重试次数或重试超时时间，以及可以配置等待时间间隔
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean> newBuilder()
                .retryIfExceptionOfType(RemoteAccessException.class)//设置异常重试源
                .retryIfResult(res-> !res) //设置根据结果重试
                .retryIfException()
                .retryIfExceptionOfType(NullPointerException.class)
                .withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS)) //设置等待间隔时间
                .withStopStrategy(StopStrategies.stopAfterAttempt(3)) //设置最大重试次数
                .withRetryListener(new RetryListener() {
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        log.error("第【{}】次调用失败" , attempt.getAttemptNumber());
                    }
                })
                .build();

        try {
            retryer.call(() -> RetryDemoTask.retryTask("abc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
