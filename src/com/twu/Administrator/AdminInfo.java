package com.twu.Administrator;

public class AdminInfo {
    private String AdminAccount;//管理员账号
    private String AdminPassword;//登录密码
    public static boolean AdminFlag;

    public AdminInfo(String AdminAccount, String AdminPassword) {
        setAdminAccount(AdminAccount);
        setAdminPassword(AdminPassword);
    }

    public void setAdminAccount(String AdminAccount)
    {
        this.AdminAccount = AdminAccount;
    }

    public String getAdminAccount()
    {
        return AdminAccount;
    }

    public void setAdminPassword(String AdminPassword)
    {
        this.AdminPassword = AdminPassword;
    }

    public String getAdminPassword()
    {
        return AdminPassword;
    }

}
