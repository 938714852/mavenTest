package com.ustc.maven.mapper;

import com.ustc.maven.pojo.Emp;

/**
 * @author Miracle
 * @date 2023/2/20 10:09
 * @description EmpMapper
 *  mapper 文件中同一个命名空间只能有一个唯一的id。 所以就导致接口中也只能有唯一的方法名，虽然在java语法中是没有问题的，但是mybatis不支持。
 */
public interface EmpMapper {
    Emp selectEmp(int id);
}
