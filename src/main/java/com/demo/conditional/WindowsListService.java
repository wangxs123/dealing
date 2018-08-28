package com.demo.conditional;

import org.springframework.stereotype.Service;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/16 13:36
 */
@Service
public class WindowsListService implements ListService{
    @Override
    public String showListCmd() {
        return "dir";
    }
}
