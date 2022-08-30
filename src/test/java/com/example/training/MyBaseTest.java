package com.example.training;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yang han
 * @date 2022/8/30 11:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
@Slf4j
public class MyBaseTest {

    @Before
    public void init() {
        log.info("----------------测试开始---------------");
    }

    @After
    public void after() {
        log.info("----------------测试结束---------------");
    }
}
