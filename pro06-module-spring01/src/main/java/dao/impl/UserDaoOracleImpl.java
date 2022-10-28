package dao.impl;

import dao.IUserDao;

public class UserDaoOracleImpl implements IUserDao {
    @Override
    public void getUser() {
        System.out.println("访问Oracle数据库");
    }
}
