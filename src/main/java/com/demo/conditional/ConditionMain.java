package com.demo.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/16 13:44
 */
public class ConditionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService service = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+"系统下列表的命令为："+service.showListCmd());
    }
}
