package com.demo.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/16 9:11
 */
public enum EnumMain {
    /**
     * 通知类
     */
    SCE_NOTIFY(0,"通知类"),

    /**
     * 交互类
     */
    SCE_INTER(1,"交互类");

    /**
     * 键
     */
    private int key;
    /**
     * 描述
     */
    private String desc;

    EnumMain(final int key, final String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static void main(String[] args) {
        enum2List();
    }
    public static void enum2List() {
        EnumMain[] values = EnumMain.values();
        for (EnumMain app : values){
            System.out.println(app.key+"==="+app.desc);
        }
    }
}
