package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {

    // 添加员工方法
    void addEmp(Emp emp);

    // 展示所有员工方法
    List<Emp> selectAll(Integer id);

    // 修改功能
    void updateEmp(Emp emp);
    // 展示所有回显功能
    Emp selectEmp(Integer id);

    // 删除功能
    void deleteEmp(Integer id);

}
