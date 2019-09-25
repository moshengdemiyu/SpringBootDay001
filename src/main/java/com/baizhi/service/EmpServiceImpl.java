package com.baizhi.service;

import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDAO empDAO;

    @Override
    public void addEmp(Emp emp) {
        empDAO.addEmp(emp);
    }

    // 展示所有员工方法
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> selectAll(Integer id) {
        List<Emp> emps = empDAO.selectAll(id);
        return emps;
    }

    // 修改员工功能
    @Override
    public void updateEmp(Emp emp) {
        empDAO.updateEmp(emp);
    }
    // 展示所有员工功能，回显
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Emp selectEmp(Integer id) {
        Emp emp = empDAO.selectEmp(id);
        return emp;
    }

    // 删除员工方法
    @Override
    public void deleteEmp(Integer id) {
        empDAO.deleteEmp(id);
    }
}
