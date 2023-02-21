package com.ustc.maven.dao.impl;

import com.ustc.maven.dao.IUserDao;
import com.ustc.maven.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author Miracle
 * @date 2023/2/13 20:46
 * @description UserDaoImpl
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public User select(Integer id) throws Exception {
        if(id == null){
            throw new Exception("id不能为null");
        }
        return new User();
    }

    @Override
    public void add(User user) throws Exception {
        if(user == null){
            throw new Exception("user不能为null");
        }

    }

    @Override
    public void updata(User user) throws Exception {
        if(user == null){
            throw new Exception("user不能为null");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == null){
            throw new Exception("id不能为null");
        }
    }
}
