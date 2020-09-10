package com.twu;

import com.twu.Administrator.AdminAction;
import com.twu.Trending.Trend;
import com.twu.User.UserInfo;

import java.util.ArrayList;
import java.util.List;

import static com.twu.TrendingSystem.UI.Welcome;

public class Main {

    public static void main(String[] args) {
        List<UserInfo> UserList = new ArrayList<UserInfo>();
        List<Trend> TrendingList = new ArrayList<Trend>();
        AdminAction.init();
        Welcome(UserList,TrendingList);
    }
}
