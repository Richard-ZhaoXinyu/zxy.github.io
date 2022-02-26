package com.zxy.boot.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/24
 */
@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String formLayouts() {

        return "/form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
        @RequestParam("username") String username,
        @RequestPart("headerImg") MultipartFile headerImg,
        @RequestPart("photos") MultipartFile[] photos,
        HttpServletRequest request
    ) throws IOException {

        if (!headerImg.isEmpty()) {
            String filename = headerImg.getOriginalFilename();
            String substring = filename.substring(filename.lastIndexOf("."));
            filename = UUID.randomUUID().toString() + substring;

//            ServletContext servletContext = request.getSession().getServletContext();
//            log.info(String.valueOf(servletContext));
//            String realPath = servletContext.getRealPath(".");
//            log.info(realPath);

            //File会将路径转换为抽象路径保存在对象中，并不会文件
//            File file = new File(realPath+"/photo");
//            log.info(String.valueOf(file));
//            log.info(String.valueOf(file.exists()));

//            if (!file.exists()) {
//                file.mkdir();
//            }

//            log.info("保存在" + file);

//            headerImg.transferTo(new File(file + File.separator + filename));

            headerImg.transferTo(new File(
                "D:\\新建文件夹\\photos"
                    + File.separator + filename));
        }
        for (MultipartFile photo : photos) {

            String filename = headerImg.getOriginalFilename();
            String substring = filename.substring(filename.lastIndexOf("."));
            filename = UUID.randomUUID().toString() + substring;
            if (!photo.isEmpty()) {
                photo.transferTo(new File("D:\\新建文件夹\\photos" + File.separator + filename));
            }
        }

        return "main";
    }
}
