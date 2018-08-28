package com.demo.main;

import com.demo.thread.AsyncTaskService;
import com.demo.thread.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/16 10:49
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService service = context.getBean(AsyncTaskService.class);
        for (int i = 0; i<10;i++){
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
        context.close();
        String s =null;
    }
}
