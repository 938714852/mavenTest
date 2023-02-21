package com.ustc.maven.mapper;

import com.ustc.maven.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Miracle
 * @date 2023/2/19 19:51
 * @description Empmapper
 */
public interface Empmapper {
    Emp selectEmp(int id);

    void insertEmp(Emp emp);

}
