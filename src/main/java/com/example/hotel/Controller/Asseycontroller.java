package com.example.hotel.Controller;

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
    @RequestMapping("/getessay")
    public List<Essay> getessay(){
        List<Essay> essay=essayService.selectAll();
        System.out.println();
        return essay;
    }

//    @RequestMapping(value = "saveimg")
//    public Object searchMember( HttpServletRequest request,
//                                @RequestParam("relationid")Long relationid){
//
//        GenericResult result = new GenericResult();// 得到文件
//        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
//
//        FilterRelationCondition filterRelationCondition = new FilterRelationCondition();
//        filterRelationCondition.setId(relationid);
//        Relation relation = relationMapper.filterRelation(filterRelationCondition).get(0);
//        try {
//            byte[] data;
//            data = file.getBytes();
//            BaseRelationShipPhoto photo = new BaseRelationShipPhoto();
//            photo.setEmployeeId(relation.getEmployeeId().toString());
//            photo.setRelationshipId(relation.getId());
//            photo.setPhoto(data);
//            relationMapper.insertRelationPhoto(photo);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        result.success("上传成功");
//        return result;
//    }

}
