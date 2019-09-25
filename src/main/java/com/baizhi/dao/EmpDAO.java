package com.baizhi.dao;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpDAO {

    // 添加员工方法
    void addEmp(Emp emp);

    // 查询所有功能
    List<Emp> selectAll(Integer id);

    // 删除功能
    void deleteEmp(Integer id);

    // 修改功能
    void updateEmp(Emp emp);
    Emp selectEmp(Integer id);

}
