package com.java.controller;

import com.java.pojo.Student;
import com.java.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;
    //注册学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView view=new ModelAndView();
        String tips="注册失败";
        //调用service使用student
        int nums = service.addStudent(student);
        if (nums>0){
            //注册成功
            tips="学生【"+student.getName()+"】注册成功";
        }
        //添加数据
        view.addObject("tips",tips);
        //指定结果页面
        view.setViewName("result");
        return view;
    }
    //处理查询，相应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        //参数检查，简单的数据处理
        return service.findStudents();
    }
}
