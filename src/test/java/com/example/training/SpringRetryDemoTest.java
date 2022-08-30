package com.example.training;

import com.example.training.service.SpringRetryDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yang han
 * @date 2022/8/30 11:12
 */
@Component
@Slf4j
public class SpringRetryDemoTest extends MyBaseTest {

    @Autowired
    private SpringRetryDemo springRetryDemo;

    @Test
    public void retry(){
        boolean abc = springRetryDemo.call("abc");
        log.info("--结果是:{}--",abc);
    }

}
