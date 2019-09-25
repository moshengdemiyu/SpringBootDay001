package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.DepDAO;
import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Dep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestDAO {

    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private EmpDAO empDAO;
    @Autowired
    private DepDAO depDAO;

    @Test
    public void test1(){
//        adminDAO.addAdmin(new Admin(null,"张三","章三","123456","男"));

        for(int i =0;i<=10;i++){
            List<Dep> deps = depDAO.selectAllDep();
            System.out.println(deps);
        }
    }
}
