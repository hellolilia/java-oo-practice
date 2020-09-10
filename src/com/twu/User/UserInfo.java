package com.twu.User;

import com.twu.Trending.Trend;

import java.util.List;

public class UserInfo {
    public String UserName;
    public int UserVotes;

    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserVotes(int UserVotes)
    {
        this.UserVotes = UserVotes;
    }

    public int getUserVotes() { return UserVotes; }

    // 创建新用户信息
    public static UserInfo NewUser(String username, List<UserInfo> UserList) {
        UserInfo user = new UserInfo();
        user.setUserVotes(10);
        user.setUserName(username);
        UserList.add(user);
        return user;
    }

    //提取老用户信息
    public static UserInfo OldUser(String username, List<UserInfo> UserList) {
        UserInfo user = new UserInfo();
        user.setUserName(username);
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getUserName().equals(username)) {
                user.setUserVotes(UserList.get(i).getUserVotes());
                break;
            }
        }
        return user;
    }
}
