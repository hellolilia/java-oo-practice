package com.twu.Trending;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.twu.Administrator.AdminInfo;
import com.twu.TrendingSystem.Entrance;
import com.twu.User.UserInfo;

public class TrendingInfo {


    //列出当前所有热搜（用户）
    public static void ListAll(UserInfo user, List<UserInfo> UserList, List<Trend> TrendingList) {
        if (TrendingList.size() == 0) {
            System.out.println("当前无热搜");
            Entrance.UserStart(user, UserList, TrendingList);
        }
        RankAll(TrendingList);
        for (int i = 0; i < TrendingList.size(); i++) {
            System.out.println(i + 1 + " " + TrendingList.get(i).Event + " " + TrendingList.get(i).Vote);
        }
        Entrance.UserStart(user, UserList, TrendingList);
    }

    //列出当前所有热搜（管理员）
    public static void ListAll(AdminInfo admin, List<UserInfo> UserList, List<Trend> TrendingList) {
        if (TrendingList.size() == 0) {
            System.out.println("当前无热搜");
            Entrance.AdminService(admin, UserList, TrendingList);
        }
        RankAll(TrendingList);
        for (int i = 0; i < TrendingList.size(); i++) {
            System.out.println(i + 1 + " " + TrendingList.get(i).Event + " " + TrendingList.get(i).Vote);
        }
        Entrance.AdminService(admin, UserList, TrendingList);
    }

    //热搜排序
    public static void RankAll(List<Trend> TrendingList) {

        for (int i = 0; i < TrendingList.size(); i++) {
            int r = TrendingList.get(i).getRanking();
            if (r != Integer.MAX_VALUE) {
                if (i != r - 1) {
                    Trend e = TrendingList.get(r - 1);
                    TrendingList.set(r - 1, TrendingList.get(i));
                    TrendingList.set(i, e);
                }
            }
        }
        Collections.sort(TrendingList, new Comparator<Trend>() {
            @Override
            public int compare(Trend o1, Trend o2) {
                if (o1.getRanking() == o2.getRanking()) {
                    return o1.getVote() > o2.getVote() ? -1 : (o1.getVote() == o2.getVote() ? 0 : 1);
                } else {
                    return 0;
                }
            }
        });
    }
}