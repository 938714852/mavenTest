package com.ustc.maven.service;

import com.ustc.maven.entity.User;

/**
 * @author Miracle
 * @date 2023/2/13 20:45
 * @description IUserService
 */
public interface IUserService {
    User select(Integer id) throws Exception;
    void add(User user) throws Exception;
    void updata(User user) throws Exception;
    void delete(Integer id) throws Exception;
}
