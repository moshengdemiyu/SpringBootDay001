package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminAction {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/add")
    public String addAdmin(Admin admin, Model model)throws Exception{
        // 调用Service层添加方法
        try {
            adminService.addAdmin(admin);
            return "login";
        }catch (Exception e){
            String message=e.getMessage();
            model.addAttribute("message",message);
            // 如果用redirect 忽略视图解析器
            return "regist";
        }
    }
    // 登录功能
    @RequestMapping("/login")
    public String login(Admin admin, Model model, HttpSession session)throws Exception{
        // 调用登录功能
        try {
            adminService.loginAdmin(admin);
            session.setAttribute("admin",admin);
            // 登录成功，跳入展示所有界面
            return "forward:/dep/selectAllDep";
        }catch (Exception e){
            String message=e.getMessage();
            model.addAttribute("message",message);
            // 登录失败，跳转回登录界面
            return "login";
        }
    }


}
