package com.demo.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/16 11:19
 */
@Configuration
@ComponentScan("com.demo.schedule")
@EnableScheduling
public class ScheduledConfig {
}
