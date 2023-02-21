package com.ustc.maven.pojo;

import java.util.List;

/**
 * @author Miracle
 * @date 2023/2/21 17:03
 * @description DeptEmpDTO
 */
public class DeptEmpDTO extends Dept{
    List<Emp> emps;

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tDeptEmpDTO{" +
                "emps=" + emps +
                "}\n";
    }
}
