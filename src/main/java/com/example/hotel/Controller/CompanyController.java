package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.model.Company;
import com.example.hotel.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/api/getCompany")
    public ResultDTO getCompany(){
        ResultDTO resultDTO=new ResultDTO();
        try {
            Company company=companyService.selectAll();
            if(company==null){
                return resultDTO.fail();
            }
            return resultDTO.ok(company);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/back/editCompany")
    public ResultDTO editCompany(Company company){

        ResultDTO resultDTO=new ResultDTO();
        try {
            int flag=companyService.insertSelective(company);
            if(flag==0){
                return resultDTO.fail("插入失败");
            }
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }
}
