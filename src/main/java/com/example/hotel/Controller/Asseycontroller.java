package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.model.Essay;
import com.example.hotel.service.EssayService;
import com.example.hotel.util.DateUtil;
import com.example.hotel.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.management.relation.Relation;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Asseycontroller {
    @Autowired
    private EssayService essayService;
    @RequestMapping("/api/selEssay")
    public ResultDTO selessay(int currPage,int pageSize){
        ResultDTO resultDTO=new ResultDTO();
        try {
            //创建当前页的分页对象，计算四个参数
            PageUtil peoplePageBean = new PageUtil(currPage, pageSize, essayService.selectCount());
            /*-------------------向数据库中查询当前页的数据-------------------*/
            Map<String, Integer> parameter = new HashMap<>(2);
            parameter.put("begin", peoplePageBean.getCurrPage() * peoplePageBean.getPageSize() - peoplePageBean.getPageSize());
            parameter.put("num", peoplePageBean.getPageSize());
            List<Essay> data = essayService.selectPage(parameter);
            if(data==null){
                return resultDTO.fail();
            }
            return resultDTO.ok(data);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

//    //得到数据库中的文章
//    @RequestMapping("/api/getEssay")
//    public ResultDTO getessay(){
//        ResultDTO resultDTO=new ResultDTO();
//        try {
//
//            List<Essay> essay=essayService.selectAll();
//            if(essay==null){
//                return resultDTO.fail();
//            }
//            return resultDTO.ok(essay);
//
//        }catch (Exception e){
//            return resultDTO.unkonwFail(e.toString());
//        }
//    }

    @RequestMapping("/api/back/putEssay")
    public ResultDTO putEssay(Essay essay){
        Date nowtime=new Date();
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(essay.getTitle()==null){
                return resultDTO.nothing();
            }
            essay.setCreateTime(DateUtil.change_str(nowtime));
            int flag=essayService.insertSelective(essay);
            if(flag==0){
                return resultDTO.fail("数据库插入失败");
            }
            return resultDTO.ok(null);
        }catch (org.springframework.dao.DuplicateKeyException e){
            return resultDTO.interFail("文章已存在");
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/back/alterEssay")
    public ResultDTO alterEssay(Essay essay){
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(essay.getAid()==null){
                return resultDTO.nothing();
            }
            int flag=essayService.updateByPrimaryKeySelective(essay);
            if(flag==0){
                return resultDTO.fail("数据库更新失败");
            }
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/back/deleteEssay")
    public ResultDTO deleteEssay(Integer aid){
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(aid==null){
                return resultDTO.nothing();
            }
            int flag=essayService.deleteByPrimaryKey(aid);
            if(flag==0){
                return resultDTO.fail("文章删除失败");
            }
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

}
