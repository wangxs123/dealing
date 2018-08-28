package com.demo.main;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/18 13:48
 */
public class Throwable {
    public static void main(String[] args) {
        int a = 0;
        int b = 5;
        int s = 0;
        try {
            s = b/a;
        } catch (Exception e) {
            System.out.println("详细信息"+e.getMessage());
            e.printStackTrace();
            System.out.println("toString方法："+e.toString());
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","tony");
            jsonObject.put("age","20");
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(1).put(3);
            jsonObject.put("a",jsonArray);
            System.out.println(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] array =  {1,2,3,4,5,9,77,88,96};
        int a1  = array[5];
        System.out.println(binarySerach(array,9));
        System.out.println(a1);
    }
    static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            }
            else if (array[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
