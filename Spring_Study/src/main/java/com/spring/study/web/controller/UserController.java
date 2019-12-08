package com.spring.study.web.controller;

import com.spring.study.domain.Girl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/5 14:15
 * @Description: 前后端交互
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/save")
    public Girl save(Girl girl) {
        return Girl.builder().name( girl.getName() ).age( girl.getAge() ).leg( girl.getLeg() ).build();
    }

    @RequestMapping("/upload")
    public void upload(String username, MultipartFile[] uploadFile) throws IOException {
        for (MultipartFile multipartFile : uploadFile) {
            String filename = multipartFile.getOriginalFilename();
            multipartFile.transferTo( new File( "D:\\upload\\" + filename ) );
        }
    }

    @RequestMapping("/findAll")
    public List<Girl> findAll() {
        return girlService.findAll();
    }
}
