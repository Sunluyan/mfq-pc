package com.mfq.task;

import com.mfq.task.base.DefaultTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by liuzhiguo1 on 16/1/15.
 */
@Component
public class OperationTask extends DefaultTask {

    private static final Logger logger = LoggerFactory.getLogger(OperationTask.class);

    @Override
    public String getTaskName() {
        return "OperationTask";
    }

    @Override
    public synchronized void doTask() throws Exception {

    }

    public static void main(String[] args) {

    }


}
















