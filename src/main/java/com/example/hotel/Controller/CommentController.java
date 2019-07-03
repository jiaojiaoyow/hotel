package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.model.Essay;
import com.example.hotel.model.RoomOrder;
import com.example.hotel.service.RoomOrderService;
import com.example.hotel.util.DateUtil;
import com.example.hotel.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CommentController {

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/api/selComment")
    public ResultDTO selComment(int currPage,int pageSize){
        ResultDTO resultDTO=new ResultDTO();
        try {
            //创建当前页的分页对象，计算四个参数
            PageUtil peoplePageBean = new PageUtil(currPage, pageSize, roomOrderService.selectCount());
            /*-------------------向数据库中查询当前页的数据-------------------*/
            Map<String, Integer> parameter = new HashMap<>(2);
            parameter.put("begin", peoplePageBean.getCurrPage() * peoplePageBean.getPageSize() - peoplePageBean.getPageSize());
            parameter.put("num", peoplePageBean.getPageSize());
            List<RoomOrder> datas =roomOrderService.selectPage(parameter);
            List<String> comments=new ArrayList<String>();
            for (RoomOrder data:datas
                 ) {
                comments.add(data.getComment());
            }
            if(comments==null){
                return resultDTO.fail();
            }
            return resultDTO.ok(comments);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/writeComment")
    public ResultDTO writeComment(int orderid,String comment){
        Date nowtime=new Date();
        ResultDTO resultDTO=new ResultDTO();
        try {
            RoomOrder roomOrder=roomOrderService.selectByOrderid(orderid);
            if(roomOrder.getCid()==null){
                return resultDTO.fail();
            }
            //订单已使用并且还没有写评论的时候
            if(roomOrder.getOrderstatus()==4&& DateUtil.change_Date(roomOrder.getLeavetime()).getTime()<nowtime.getTime()&&roomOrder.getComment()==null){
                roomOrder.setComment(comment);
                int flag=roomOrderService.updateByPrimaryKeySelective(roomOrder);
                if(flag==0){
                    return resultDTO.fail("更新失败");
                }
                return resultDTO.ok(null);
            }
            return resultDTO.fail("已评论过或者还不可以评论");

        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }
}
