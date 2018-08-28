package com.demo.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/16 11:20
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledConfig.class);
        ScheduledTaskService service = context.getBean(ScheduledTaskService.class);
        service.reportCurrentTime();
        service.fixTimeExecution();

    }
}
