package com.ustc.maven.dao;

import com.ustc.maven.entity.User;

/**
 * @author Miracle
 * @date 2023/2/13 20:46
 * @description IUserDao
 */
public interface IUserDao {
    User select(Integer id) throws Exception;
    void add(User user) throws Exception;
    void updata(User user) throws Exception;
    void delete(Integer id) throws Exception;
}
