/**
 * @Author:Awadhesh,Madhu
 * @Date:11-07-2022
 * @Time:18:39
 * @Project Name:Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
package com.armapp.controller;

import com.armapp.model.Talent;
import com.armapp.modelDTOs.TalentVO;
import com.armapp.service.ITalentService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TalentController {


//    @Autowired
//    public void setMapper(DozerBeanMapper mapper) {
//        this.mapper = mapper;
//    }




    private ITalentService iTalentService;

    @Autowired
    public void setiTalentService(ITalentService iTalentService) {
        this.iTalentService = iTalentService;
    }

    @GetMapping("talents/{keyword}")
    public ResponseEntity<List<TalentVO>> search(@PathVariable("keyword") String keyword) throws NullPointerException {
        List<Talent> talents = iTalentService.getByTalentNameLike(keyword);

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("desc", "Getting Talents by Name");
        List<TalentVO> talentsVOList = new ArrayList<TalentVO>();
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> myMappingFiles = new ArrayList<String>();
        myMappingFiles.add("dozerBeanMapping.xml");
        mapper.setMappingFiles(myMappingFiles);
        TalentVO talentsVO;
        for (Talent talent : talents) {
            talentsVO = mapper.map(talent, TalentVO.class);
                talentsVOList.add(talentsVO);
        }
        return new ResponseEntity<List<TalentVO>>(talentsVOList, httpHeaders, HttpStatus.OK);
    }


}
