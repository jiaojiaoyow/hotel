package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.model.Essay;
import com.example.hotel.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.management.relation.Relation;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Asseycontroller {
    @Autowired
    private EssayService essayService;

    //得到数据库中的文章
    @RequestMapping("/api/getEssay")
    public ResultDTO getessay(){
        ResultDTO resultDTO=new ResultDTO();
        try {
            List<Essay> essay=essayService.selectAll();
            if(essay==null){
                return resultDTO.fail();
            }
            return resultDTO.ok(essay);

        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }

    }

    @RequestMapping("/putEssay")
    public ResultDTO putEssay(Essay essay){
        ResultDTO resultDTO=new ResultDTO();
        try {
            int flag=essayService.insertSelective(essay);
            if(flag==0){
                return resultDTO.fail("数据库插入失败");
            }
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

}
