package com.baizhi.service;

import com.baizhi.dao.DepDAO;
import com.baizhi.entity.Dep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepServiceImpl implements DepService{
    @Autowired
    private DepDAO depDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dep> selectAllDep() {
        // 调用dao层展示所有部门方法
        List<Dep> deps = depDAO.selectAllDep();
        return deps;
    }
    // 添加部门
    @Override
    public void addDep(Dep dep) {
        depDAO.addDep(dep);
    }

    // 修改部门
    @Override
    public void editDep(Dep dep) {
        depDAO.editDep(dep);
    }
    // 回显功能
    @Override
    public Dep selectDep(Integer id) {
        Dep dep = depDAO.selectDep(id);
        return dep;
    }

}
