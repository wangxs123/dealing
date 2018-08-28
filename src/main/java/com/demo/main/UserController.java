package com.demo.main;

import com.demo.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： wangxs
 * @date：Create by 2018/8/2 10:15
 */
public class UserController {
    public static void main(String[] args) {
        List<UserBean> list = new ArrayList<>();
        for(int i=1;i<6;i++){
            UserBean userBean = new UserBean();
            UserBean userBean2 = new UserBean();
            userBean.setSex("nan");
            list.add(userBean);
            userBean2.setSex("nv");
            list.add(userBean2);
        }
//        List<UserBean> list2 = new ArrayList<>();
//        //list.add(userBean);
//        UserBean userBean2 = new UserBean();
//        for (UserBean vo :list) {
//            userBean2.setSex(vo.getSex());
//            list2.add(userBean2);
//        }
        System.out.println(list.toString());
    }
}
