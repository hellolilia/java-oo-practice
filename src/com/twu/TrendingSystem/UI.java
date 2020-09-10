package com.twu.TrendingSystem;

import com.twu.Administrator.AdminInfo;
import com.twu.Trending.Trend;
import com.twu.User.UserInfo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    static Scanner input = new Scanner(System.in);

    //初始界面
    public static void Welcome(List<UserInfo> UserList,List<Trend> TrendingList) {
        System.out.println("欢迎来到热搜排行榜，你是？");
        System.out.println("1.用户\n2.管理员\n3.退出");
        String n = input.next();
        switch (n) {
            case "1":
                AdminInfo.AdminFlag = false;
                System.out.println("请输入您的昵称：");
                String username = input.next();
                if (UserList.size() == 0) {
                    UserInfo user = UserInfo.NewUser(username,UserList);
                    Entrance.UserStart(user, UserList, TrendingList);
                } else {
                    List<String> collect = UserList.stream().map(UserInfo::getUserName).collect(Collectors.toList());
                    boolean flag = collect.contains(username);
                    UserInfo user = flag ? UserInfo.OldUser(username,UserList) : UserInfo.NewUser(username,UserList);
                    Entrance.UserStart(user, UserList, TrendingList);
                }
                break;
            case "2":
                AdminInfo.AdminFlag = true;
                Entrance.AdminStart(UserList, TrendingList);
                break;
            case "3":
                System.out.println("退出成功");
                System.exit(0);
            default:
                System.out.println("输入错误，请重新选择");
                Welcome(UserList,TrendingList);
        }
    }

    //报错界面
    public static void Error(String s, List<UserInfo> UserList,List<Trend> TrendingList) {
        System.out.println(s);
        System.out.println("请按键选择下一步操作:");
        System.out.println("1.返回上个界面\n2.返回初始界面");
        String n = input.next();
        switch (n) {
            case "1":
                Entrance.AdminStart(UserList, TrendingList);
                break;
            case "2":
                Welcome(UserList,TrendingList);
                break;
            default:
                System.out.println("输入错误，请重新选择");
                Error(s,UserList,TrendingList);
        }
    }
}
