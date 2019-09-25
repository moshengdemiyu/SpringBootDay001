package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDAO {

    // 管理员注册方法
    void addAdmin(Admin admin);

    // 查询admin方法
    Admin selectAdmin(String username);

}
