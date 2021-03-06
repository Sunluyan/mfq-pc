package com.mfq.task;

import com.mfq.task.base.DefaultTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderCloseTask extends DefaultTask {
    
	private static final Logger logger = LoggerFactory.getLogger(OrderCloseTask.class);
	
    @Override
    public String getTaskName() {
        return "Order_Close_Task";
    }

    @Override
    public void doTask() throws Exception {
    	logger.info("task  start....");
    }
}