package com.mfq.task;

import com.mfq.dataservice.context.SpringWrapper;
import com.mfq.task.base.DefaultTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class FinanceTask extends DefaultTask {
    
    private static final Logger logger = LoggerFactory.getLogger(FinanceTask.class);

    public String getTaskName() {
        return "FinanceTask";
    }

    @Override
    public void doTask() throws Exception {
        @SuppressWarnings("deprecation")
		int hour = new Date().getHours();
        if (hour > 5 || hour < 3) {// 限定任务在凌晨3.4.5点范围内执行
            logger.warn("Task {} passed, current time can't do clearTask....", getTaskName());
            return;
        }

    }

}
