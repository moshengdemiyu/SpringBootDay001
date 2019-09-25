package com.baizhi.action;

import com.baizhi.entity.Emp;
import com.baizhi.service.DepService;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpAction {
    @Autowired
    private EmpService empService;
    @Autowired
    private DepService depService;

    // 调用添加员工方法
    @RequestMapping("/addEmp")
    public String addEmp(Emp emp , MultipartFile upload, HttpSession session, Model model)throws Exception{
        // 获取upload（目标文件夹）路径
        ServletContext servletContext = session.getServletContext();
        // 获取upload对应的路径
        String realPath = servletContext.getRealPath("/img");
        // 把上传文件 输出到/upload文件夹中    文件名字
        // 在upload文件夹中创建了与上传文件同名的文件             空文件
        File file = new File(realPath + "/" + upload.getOriginalFilename());
        // 把上传的文件内容转换到空文件中
        upload.transferTo(file);
        emp.setPicture(upload.getOriginalFilename());
        empService.addEmp(emp);
        return "redirect:/dep/selectAllDep";
    }

    // 调用展示所有员工方法
    @RequestMapping("/selectAllEmp")
    public String selectAllEmp(HttpSession session,Integer did)throws Exception{
        List<Emp> emps = empService.selectAll(did);
        session.setAttribute("emps",emps);
        return "emplist";
    }

    // 展示员工功能
    @RequestMapping("selectEmp")
    public  String selectEmp(Integer id,Model model)throws Exception{
        Emp emp = empService.selectEmp(id);
        model.addAttribute("emp",emp);
        return "updateEmp";
    }
    // 修改员工功能
    @RequestMapping("/updateEmp")
    public String updateEmp(Emp emp,HttpSession session,MultipartFile upload,Integer did)throws Exception{
        if(upload.getOriginalFilename()!=null&&!upload.getOriginalFilename().equals("")){
            // 获取upload（目标文件夹）路径
            ServletContext servletContext = session.getServletContext();
            // 获取upload1对应的路径
            String realPath = servletContext.getRealPath("/img");
            // 把上传文件 输出到/upload文件夹中    文件名字
            // 在upload文件夹中创建了与上传文件同名的文件             空文件
            File file = new File(realPath + "/" + upload.getOriginalFilename());
            // 把上传的文件内容转换到空文件中
            upload.transferTo(file);
//            String picture=upload.getOriginalFilename();
            emp.setPicture(upload.getOriginalFilename());
        }
        empService.updateEmp(emp);
        return "forward:/emp/selectAllEmp?did="+did;
    }

    // 删除员工方法
    @RequestMapping("/deleteEmp")
    public String deleteEmp(Integer id,Integer depid)throws Exception{
        empService.deleteEmp(id);
        return "forward:/emp/selectAllEmp?did="+depid;
    }
}
