package com.twu.Administrator;


import com.twu.Trending.Trend;
import com.twu.TrendingSystem.Entrance;
import com.twu.User.UserInfo;

import java.util.List;

public class AdminAction {
    //检测登陆
    public static void AdminCheckIn(String Account, String Password, List<UserInfo> UserList, List<Trend> TrendingList)
    {
        AdminInfo admin =Admin.Login(Account, Password, UserList, TrendingList);
        if(admin != null) {
            System.out.println("登录成功");
            Entrance.AdminService(admin,UserList,TrendingList);
        } else {
            System.out.println("登录失败,回到上一级菜单");
            Entrance.AdminStart(UserList,TrendingList);
        }
    }

    //管理员账号初始化
    public static void init()
    {//初始化
        Admin.initAdmin();
    }
}
