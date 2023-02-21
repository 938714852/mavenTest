package com.ustc.maven.pojo;

/**
 * @author Miracle
 * @date 2023/2/21 15:39
 * @description EmpDTO
 */
public class EmpDeptDTO extends Emp{
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return super.toString() + "EmpDTO{" +
                "dept=" + dept +
                "}\n";
    }
}
