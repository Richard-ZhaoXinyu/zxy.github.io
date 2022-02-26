package com.zxy.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.boot.bean.User;
import com.zxy.boot.service.UserService;
import java.util.List;
import javax.jws.soap.SOAPBinding.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/24
 */

@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basic_table")
    public String basicTable() {

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTable(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {

//        List<User> list = userService.list();
//        model.addAttribute("users",list);

        Page<User> userPage = new Page<>(pn,3);

        Page<User> page = userService.page(userPage);

        model.addAttribute("page",page);



        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable() {

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editableTable() {

        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricingTable(){

        return "table/pricing_table";
    }
}
