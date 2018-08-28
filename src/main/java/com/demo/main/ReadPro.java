package com.demo.main;

import com.demo.util.ReadPropUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @author： wangxs
 * @date：Create by 2018/8/21 14:15
 */
@Controller
@RequestMapping("/req")
public class ReadPro {
    @RequestMapping("/go")
    public void getReq() throws IOException {
        String addr = ReadPropUtil.getReqAddress("tag.UserId");
        System.out.println(addr);
    }

    public static void main(String[] args) {
//        String s = "12,16,17";
//        String[] chars = s.split(",");
//        for(int i=0;i<chars.length;i++){
//            System.out.println(chars[i]);
//        }


        String str = "aaaaaaaccccccccccccccccccccccaaaabb";
        int[] aa = new int[60];
        for(char temp:str.toCharArray()){
            if((temp>=65 && temp<=90)||(temp>=97 && temp<=122)){
                temp -= 65;
                aa[temp]++;
            }
        }
        int max = aa[0]; int position = 0;
        for(int i=0;i<aa.length;i++){
            if(aa[i]>max){
                max = aa[i]; position = i;
            }
        }
        System.out.println(max);
        System.out.println("字母"+(char)(position+65) + "出现" + max + "次");
    }
}
