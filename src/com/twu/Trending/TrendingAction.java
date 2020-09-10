package com.twu.Trending;

import com.twu.Administrator.AdminInfo;
import com.twu.TrendingSystem.Entrance;
import com.twu.User.UserAction;
import com.twu.User.UserInfo;

import java.util.List;
import java.util.Scanner;


public class TrendingAction {
    static Scanner input = new Scanner(System.in);

    //用户给热搜投票
    public static void VoteTrending(UserInfo user, List<UserInfo> UserList, List<Trend> TrendingList) {
        if (TrendingList.size() == 0) {
            System.out.println("当前没有热搜，请添加热搜。");
            AddTrending(user, UserList, TrendingList);
        }
        System.out.println("请输入你要投票的热搜名称：");
        String event = input.next();
        int flag = SearchTrending(event, TrendingList);
        if (flag >= 0) {
            UserAction.Vote(user,event, UserList, TrendingList);
        } else {
            System.out.println("该热搜不存在");
            System.out.println("请按键选择下一步操作:");
            System.out.println("1.重新输入\n2.返回上个界面");
            String n = input.next();
            switch (n) {
                case "1":
                    VoteTrending(user, UserList, TrendingList);
                case "2":
                    Entrance.UserStart(user, UserList, TrendingList);
                default:
                    System.out.println("输入错误");
                    VoteTrending(user, UserList, TrendingList);
            }
        }
    }

    //用户购买热搜
    public static void BuyTrending(UserInfo user, List<UserInfo> UserList, List<Trend> TrendingList) {
        System.out.println("请输入你要购买的热搜名称：");
        String event = input.next();
        if (TrendingList.size() == 0) {
            System.out.println("当前没有热搜，请添加热搜。");
            AddTrending(user,UserList, TrendingList);
        } else {
            int flag = SearchTrending(event, TrendingList);
            if (flag >= 0) {
                UserAction.Buy(user,event, UserList, TrendingList);
            } else {
                System.out.println("该热搜不存在");
                System.out.println("请按键选择下一步操作:");
                System.out.println("1.重新输入\n2.返回上个界面");
                String n = input.next();
                switch (n) {
                    case "1":
                        BuyTrending(user, UserList, TrendingList);
                    case "2":
                        Entrance.UserStart(user, UserList, TrendingList);
                    default:
                        System.out.println("输入错误");
                        BuyTrending(user, UserList, TrendingList);
                }
            }
        }

    }

    //用户添加热搜
    public static void AddTrending(UserInfo user, List<UserInfo> UserList, List<Trend> TrendingList) {
        System.out.println("请输入你要添加的热搜事件的名字：");
        String event = input.next();
        int flag = SearchTrending(event, TrendingList);
        if (flag >= 0) {
            System.out.println("该热搜已存在。");
            System.out.println("请按键选择下一步操作:");
            System.out.println("1.重新添加\n2.返回上个界面");
            String n = input.next();
            switch (n) {
                case "1":
                    AddTrending(user, UserList, TrendingList);
                case "2":
                    Entrance.UserStart(user, UserList, TrendingList);
                default:
                    System.out.println("输入错误");
                    AddTrending(user, UserList, TrendingList);
            }
        } else {
            Trend trend = new Trend();
            trend.setEvent(event);
            trend.setVote(0);
            trend.setPrice(0);
            trend.setRanking(Integer.MAX_VALUE);
            trend.setHotTrend(false);
            TrendingList.add(trend);
            System.out.println("添加成功");
            Entrance.UserStart(user, UserList, TrendingList);
        }
    }

    //管理员添加热搜
    public static void AddTrending(AdminInfo admin, List<UserInfo> UserList, List<Trend> TrendingList) {
        System.out.println("请输入你要添加的热搜事件的名字：");
        String event = input.next();
        int flag = SearchTrending(event, TrendingList);
        if (flag >= 0) {
            System.out.println("该热搜已存在。");
            System.out.println("请按键选择下一步操作:");
            System.out.println("1.重新添加\n2.返回上个界面");
            String n = input.next();
            switch (n) {
                case "1":
                    AddTrending(admin, UserList, TrendingList);
                case "2":
                    Entrance.AdminService(admin, UserList, TrendingList);
                default:
                    System.out.println("输入错误");
                    AddTrending(admin, UserList, TrendingList);
            }
        } else {
            Trend trend = new Trend();
            trend.setEvent(event);
            trend.setVote(0);
            trend.setPrice(0);
            trend.setRanking(Integer.MAX_VALUE);
            trend.setHotTrend(false);
            TrendingList.add(trend);
            TrendingInfo.RankAll(TrendingList);
            System.out.println("添加成功");
            Entrance.AdminService(admin, UserList, TrendingList);
        }
    }

    //添加超级热搜
    public static void AddSuperTrending(AdminInfo admin, List<UserInfo> UserList, List<Trend> TrendingList) {
        System.out.println("请输入你要添加的超级热搜事件的名字：");
        String event = input.next();
        int flag = SearchTrending(event, TrendingList);
        if (flag >= 0) {
            System.out.println("该热搜已存在。");
            System.out.println("请按键选择下一步操作:");
            System.out.println("1.重新添加\n2.返回上个界面");
            String n = input.next();
            switch (n) {
                case "1":
                    AddSuperTrending(admin, UserList, TrendingList);
                case "2":
                    Entrance.AdminService(admin, UserList, TrendingList);
                default:
                    System.out.println("输入错误");
                    AddSuperTrending(admin, UserList, TrendingList);
            }
        } else {
            Trend trend = new Trend();
            trend.setEvent(event);
            trend.setVote(0);
            trend.setPrice(0);
            trend.setRanking(Integer.MAX_VALUE);
            trend.setHotTrend(true);
            TrendingList.add(trend);
            TrendingInfo.RankAll(TrendingList);
            System.out.println("添加成功");
            Entrance.AdminService(admin, UserList, TrendingList);
        }
    }

    //寻找输入热搜是否存在，存在返回热搜索引，不存在返回-1
    public static int SearchTrending(String event, List<Trend> TrendingList) {
        for (int i = 0; i < TrendingList.size(); i++) {
            if(TrendingList.get(i).getEvent().equals(event)) {
                return i;
            }
        }
        return -1;
    }


}
