package com.twu.TrendingSystem;


import com.twu.Administrator.AdminAction;
import com.twu.Administrator.AdminInfo;
import com.twu.Trending.Trend;
import com.twu.Trending.TrendingAction;
import com.twu.Trending.TrendingInfo;
import com.twu.User.UserInfo;

import java.util.List;
import java.util.Scanner;

import static com.twu.TrendingSystem.UI.Welcome;


public class Entrance {

    static Scanner input = new Scanner(System.in);

    //用户首页
    public static void UserStart(UserInfo user, List<UserInfo> UserList, List<Trend> TrendingList) {

        System.out.println("你好，"+user.UserName+"，你可以：");
        System.out.println("1.查看热搜排行榜\n2.给热搜事件投票\n3.购买热搜\n4.添加热搜\n5.退出");
        String n= input.next();
        switch (n) {
            case "1":
                TrendingInfo.ListAll(user, UserList,TrendingList);
                break;
            case "2":
                TrendingAction.VoteTrending(user,UserList,TrendingList);
                break;
            case "3":
                TrendingAction.BuyTrending(user,UserList,TrendingList);
                break;
            case "4":
                TrendingAction.AddTrending(user,UserList,TrendingList);
                break;
            case "5":
                System.out.println("退出成功");
                Welcome(UserList,TrendingList);
                break;
            default:
                System.out.println("输入错误，请重新选择");
                UserStart(user,UserList,TrendingList);
        }
        }

    //管理员首页
    public static void AdminStart(List<UserInfo> UserList,List<Trend> TrendingList) {
        System.out.println("请输入您的昵称：");
        String name = input.next();
        System.out.println("请输入您的密码：");
        String password = input.next();
        AdminAction.AdminCheckIn(name, password, UserList,TrendingList);
    }

    //管理员选项页面
    public static void AdminService(AdminInfo admin, List<UserInfo> UserList,List<Trend> TrendingList) {
        System.out.println("您好,"+admin.getAdminAccount()+"，你可以：");
        System.out.println("1.查看热搜排行榜\n2.添加热搜\n3.添加超级热搜\n4.退出");
        String n= input.next();
        switch (n) {
            case "1":
                TrendingInfo.ListAll(admin,UserList,TrendingList);
                break;
            case "2":
                TrendingAction.AddTrending(admin, UserList, TrendingList);
                break;
            case "3":
                TrendingAction.AddSuperTrending(admin, UserList, TrendingList);
                break;
            case "4":
                System.out.println("退出成功");
                Welcome(UserList,TrendingList);
                break;
            default:
                System.out.println("输入错误，请重新选择");
                AdminService(admin,UserList,TrendingList);
        }
    }
}
