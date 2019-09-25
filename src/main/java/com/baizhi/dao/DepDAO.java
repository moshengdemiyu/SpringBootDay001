package com.baizhi.dao;

import com.baizhi.entity.Dep;

import java.util.List;

public interface DepDAO {
    // 展示所有部门
    List<Dep> selectAllDep();

    // 添加部门
    void addDep(Dep dep);

    // 修改部门
    void editDep(Dep dep);
    // 修改部门的回显功能
    Dep selectDep(Integer id);

}
