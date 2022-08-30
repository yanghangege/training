package com.example.training.test;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobContext;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author yang han
 * @date 2022/8/30 14:52
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class XxlJobTest {


    @XxlJob("xxlJobTest")
    public ReturnT<String> xxlJobTest(String date) {
        XxlJobContext xxlJobContext = XxlJobContext.getXxlJobContext();
        String jobParam = xxlJobContext.getJobParam();
        log.info("---------xxlJobTest定时任务执行成功--------{}",jobParam);
        return ReturnT.SUCCESS;
    }

}
