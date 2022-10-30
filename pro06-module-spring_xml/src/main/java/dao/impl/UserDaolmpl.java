package dao.impl;

import dao.IUserDao;

public class UserDaolmpl implements IUserDao { //数据访问层
    @Override
    public void getUser() {
        //查询数据库
        System.out.println("查询数据库");
    }
}
