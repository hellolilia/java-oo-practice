package com.twu.Administrator;

import com.twu.Trending.Trend;
import com.twu.TrendingSystem.UI;
import com.twu.User.UserInfo;

import java.util.List;

public class Admin {
    static AdminInfo[] Admin=new AdminInfo[1];
    private static int n=0;
    static int i=0;
    //设置管理员账号密码
    public static void initAdmin()
    {
        if(i == 0) {
            AdminInfo admin=new AdminInfo("admin", "admin123");
            Admin[0]=admin;
            n=1;
            i++;
        }
    }

    //判断管理员账号是否正确
    public static AdminInfo Login(String Account, String Password, List<UserInfo> UserList, List<Trend> TrendingList)
    {
        AdminInfo tempAdmin = null;
        for(int m = 0; m<n ;m++) {
            if(Admin[m].getAdminAccount().equals(Account)) {
                tempAdmin=Admin[m];
            }
        }
        if(tempAdmin==null) {
            UI.Error("登录失败,用户名不存在",UserList,TrendingList);
        } else {
            if(!tempAdmin.getAdminPassword().equals(Password)) {
                UI.Error("登录失败,密码错误",UserList,TrendingList);
            }
        }
        return tempAdmin;
    }
}
