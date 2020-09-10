package com.twu.User;

import com.twu.Trending.Trend;
import com.twu.Trending.TrendingAction;
import com.twu.Trending.TrendingInfo;
import com.twu.TrendingSystem.Entrance;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.twu.Trending.TrendingAction.SearchTrending;

public class UserAction {

    static Scanner input = new Scanner(System.in);

    //给热搜投票
    public static void Vote(UserInfo user, String event, List<UserInfo> UserList,List<Trend> TrendingList) {
        int v = user.getUserVotes();
        int flag = SearchTrending(event, TrendingList);
        System.out.println("请输入你要投票的热搜票数： （你目前还有："+v+"票）");
        try {
            int n = input.nextInt();
            if (n > v || n == 0) {
                System.out.println("投票失败");
                Entrance.UserStart(user, UserList, TrendingList);
            } else {
                if (TrendingList.get(flag).getHotTrend()) {
                    TrendingList.get(flag).setVote(TrendingList.get(flag).getVote() + 2 * n);
                } else {
                    TrendingList.get(flag).setVote(TrendingList.get(flag).getVote() + n);
                }
                user.setUserVotes(v - n);
                System.out.println("投票成功");
                Entrance.UserStart(user, UserList, TrendingList);
            }
        }catch (InputMismatchException e) {
            System.out.println("输入的数字有误，请重新输入！");
            input.nextLine();
            Vote(user, event, UserList, TrendingList);
        }
    }

    //购买热搜
    public static void Buy(UserInfo user, String event, List<UserInfo> UserList,List<Trend> TrendingList) {
        int flag = SearchTrending(event, TrendingList);
        TrendingInfo.RankAll(TrendingList);
        try {
            System.out.println("请输入你要购买的热搜排名：");
            int n = input.nextInt();
            if (n > TrendingList.size()){
                System.out.println("超过现有热搜数量");
                Buy(user, event, UserList, TrendingList);
            }
            System.out.println("请输入你要购买的热搜金额：");
            int money = input.nextInt();
            int Ex =TrendingList.get(n-1).getPrice();
            if (money > Ex) {
                TrendingList.get(flag).setPrice(money);
                TrendingList.get(flag).setRanking(n);
                if (Ex > 0) {
                    TrendingList.remove(TrendingList.get(n - 1));
                }
                System.out.println("购买成功");
                Entrance.UserStart(user, UserList, TrendingList);
            } else {
                System.out.println("购买失败");
                Entrance.UserStart(user, UserList, TrendingList);
            }
        } catch (InputMismatchException e) {
            System.out.println("输入的数字有误，请重新输入！");
            input.nextLine();
            Buy(user, event, UserList, TrendingList);
        }
    }
}
