package com.demo.main;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class LambdaMain {
    public static void main(String[] args) {
//        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        Collections.sort(names, (String a, String b) -> {
//            return b.compareTo(a);
//        });
//        Collections.sort(names, (a, b) -> b.compareTo(a));
//        System.out.println(names.toString());
        Map<String, String> map = new HashMap<String, String>();
        map.put("qqq", "1212");
        map.put("qa", "34");
        map.put("zx", "233");
        map.put("se", "56");
        System.out.println("第一种：通过Map.keySet遍历key和value：");
        for (String in : map.keySet()) {
            //map.keySet()返回的是所有key的值
            String str = map.get(in);//得到每个key多对用value的值
            System.out.println(in + "     " + str);
        }
//        System.out.println("第二种：通过Map.entrySet使用iterator(迭代器)遍历key和value");
//        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, String> entry = it.next();
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//        }
//        //第三种推荐,尤其是容量大时
//        System.out.println("第三种：通过Map.keySet遍历key和value：");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            //Map.entry<String,String> 映射项（键-值对）  有几个方法：用上面的名字entry
//            //map.entrySet()  返回此映射中包含的映射关系的 Set视图
//            System.out.println("key=" + entry.getKey() + "------value=" + entry.getValue());
//        }
//        // 第四种：
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String startTime = sdf.format(new Date());
//        long st = System.currentTimeMillis();
//        String endTime = null;
//        for(int i = 1;i<1000;i++){
//            for(int j=1 ;j<=i;j++){
//                System.out.print(j+"*"+i+"="+i*j);
//            }
//            System.out.println();
//        }
//        endTime=sdf.format(new Date());
//        long et =System.currentTimeMillis();
//
//        System.out.println(String.valueOf(et-st));
//        System.out.println(replaceBlank("15811412491"));

    }
//    public static String replaceBlank(String str) {
//        String dest = "";
//        if (str!=null) {
//            Pattern p = compile("\\s*|\t|\r|\n");
//            Matcher m = p.matcher(str);
//            dest = m.replaceAll("");
//        }
//        return dest;
//    }
}
