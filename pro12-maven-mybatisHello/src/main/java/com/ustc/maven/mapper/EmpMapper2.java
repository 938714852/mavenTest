package com.ustc.maven.mapper;

import com.ustc.maven.pojo.Emp;
import org.apache.ibatis.annotations.Select;

/**
 * @author Miracle
 * @date 2023/2/19 20:43
 * @description EmpMapper2
 */
public interface EmpMapper2 {


    @Select("select * from emp where id = #{id}")
    Emp selectEmp(int id);

}
