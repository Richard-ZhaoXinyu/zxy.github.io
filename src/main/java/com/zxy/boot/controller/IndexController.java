package com.zxy.boot.controller;

import com.zxy.boot.bean.Student;
import com.zxy.boot.bean.User;
import com.zxy.boot.service.StudentService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/24
 */

@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, Model model, HttpSession session) {

        if ("admin".equals(user.getUsername()) && "admin123".equals(user.getPassword())) {
            //把登陆成功的用户保存起来，保存到session域中
            session.setAttribute("loginUser", user);
            //登陆成功重定向到main.html 防止表单重复提交
            return "redirect:/main.html";
        } else {
            //登陆失败时有提示信息
            model.addAttribute("error", "用户名或密码输入错误");
            //登陆失败返回重新登陆
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session) {
        //换浏览器登陆时需要重新登录
        if (session.getAttribute("loginUser") != null) {
            return "main";
        } else {
            return "login";
        }
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
        return aLong.toString();
    }

    @ResponseBody
    @GetMapping("/stu")
    public Student getStudentById(@RequestParam("id") Integer id) {

        return studentService.getStuById(id);
    }

    @ResponseBody
    @GetMapping("/add")
    public String addStudent(){

        Student student = new Student(17,"王五","7777@77.com",22);
        studentService.addStudent(student);
        return student.toString();
    }
}
