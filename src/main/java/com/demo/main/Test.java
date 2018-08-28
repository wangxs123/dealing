package com.demo.main;

import org.apache.tomcat.util.buf.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @author： wangxs
 * @date：Create by 2018/8/8 17:25
 */
public class Test {
    public static void main(String[] args) {
        TestBean bean = new TestBean();
        int[] ab = new  int[]{1,5,4};
        StringBuffer str = new StringBuffer();
        for(int i=0;i<ab.length;i++){
            if(i<ab.length-1){
                str = str.append(ab[i]+",");
            }else if(i == ab.length-1){
                str = str.append(ab[i]);
            }
        }
        LocalDateTime time = LocalDateTime.now();
        String pattern = "yyyy-MM-dd HH:mm:ss";
//        System.out.println(formatTime(time,pattern));
//        System.out.println(str.toString());
//        System.out.println("1,5,4");
        int[] intArray = new int[] { 1, 2, 3, 4, 5 };
        int[] ints = { 1, 2, 3 };
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now().format(formatter));

        String ad = Arrays.toString(ab).substring(1,Arrays.toString(ab).length()-1);
//        System.out.println(ad.trim());
//        System.out.println(Arrays.toString(ab).substring(1,Arrays.toString(ab).length()-1).trim());
//        String[] a = {"1","2","3"};
//        bean.setAge(a);
//        String b = StringUtils.join(bean.getAge());
//        String v = "4,5,6";
//        String[] d = v.split(",");
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(d));
    }
    public static String formatTime(LocalDateTime time, String pattern) {

        return time.format(DateTimeFormatter.ofPattern(pattern));

    }
}
