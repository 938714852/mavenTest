package com.ustc.maven.mapper;

import com.ustc.maven.pojo.Emp;
import com.ustc.maven.pojo.QueryEmpDTO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public interface EmpMapper {
    List<Emp> QueryEmp(QueryEmpDTO queryEmpDTO);

    List<Emp> QueryEmp2(String deptName);

    List<Emp> QueryEmp3(@Param("usernames") String[] deptName);

    List<Emp> QueryEmp4(String username);
    Integer insert(Emp emp);

    Integer inserBatch(@Param("emps") List<Emp> emp);

}
