package com.baizhi.action;

import com.baizhi.entity.Dep;
import com.baizhi.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/dep")
@Controller
public class DepAction {
    @Autowired
    private DepService depService;

    @RequestMapping("/selectAllDep")
    public String selectAllDep(Model model)throws Exception{
        List<Dep> deps = depService.selectAllDep();
        model.addAttribute("deps",deps);
        return "departments";
    }
    // 查询所有部门方法
    @RequestMapping("/ajax")
    @ResponseBody
    public List<Dep> ajax() throws Exception{
        List<Dep> list = depService.selectAllDep();
        return list;
    }

    // 添加部门方法
    @RequestMapping("/addDep")
    public String addDep(Dep dep)throws Exception{
        depService.addDep(dep);
        return "forward:/dep/selectAllDep";
    }

    // 修改部门方法
    @RequestMapping("/updateDep")
    public String updateDep(Dep dep)throws Exception{
        depService.editDep(dep);
        return "forward:/dep/selectAllDep";
    }
    // 回显部门方法
    @RequestMapping("/selectDep")
    public String selectDep(Integer id,Model model)throws Exception{
        Dep dep = depService.selectDep(id);
        model.addAttribute("dep",dep);
        return "updateDepartment";
    }



}
