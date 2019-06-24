package com.example.hotel.Controller;

import com.example.hotel.model.Essay;
import com.example.hotel.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Asseycontroller {
    @Autowired
    private EssayService essayService;
    //得到数据库中的文章
    @RequestMapping("/getessay")
    public List<Essay> getessay(){
        List<Essay> essay=essayService.selectAll();
        System.out.println();
        return essay;
    }
}
