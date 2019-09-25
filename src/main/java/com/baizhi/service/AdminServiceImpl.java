package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public void addAdmin(Admin admin) {
        // 创建一个空对象
        Admin a = null;
        // 调用查询方法
        a = adminDAO.selectAdmin(admin.getUsername());
        // 如果a存在 说明表中有这个数据
        if(a!=null){
            throw new RuntimeException("对不起，此用户名已存在，请重新输入");
        }
        adminDAO.addAdmin(admin);
    }

    @Override
    public void loginAdmin(Admin admin) {
        Admin a = null;
        // 通过用户名查询返回一个admin对象
        a = adminDAO.selectAdmin(admin.getUsername());
        // 如果通过用户名查询的对象的密码和输入密码一样，则可以登录
        if (a == null) {
            throw new RuntimeException("该用户不存在");
        }
        // 如果存在于数据库中
        // 判断密码
        if(!a.getPassword().equals(admin.getPassword())){
            throw new RuntimeException("对不起，您输入的密码错误");
        }
    }

}
