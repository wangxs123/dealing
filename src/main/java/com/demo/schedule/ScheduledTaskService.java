package com.demo.schedule;

import javafx.scene.input.DataFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/16 11:05
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒钟执行一次："+format.format(new Date()));
    }
    @Scheduled(cron = "0 23 * * * ? ")
    public void fixTimeExecution(){
        System.out.println("指定时间执行："+format.format(new Date()));
    }
}
