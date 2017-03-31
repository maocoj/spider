package com.gongzuochong.controller;

import com.gongzuochong.dao.GanjiQzRepository;
import com.gongzuochong.dao.JobRepository;
import com.gongzuochong.entity.JobEntity;
import com.gongzuochong.entity.mongo.GanjiQzJob;
import com.gongzuochong.enums.Published;
import com.gongzuochong.service.GanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by marco on 2017/3/25.
 */
@RestController
@RequestMapping("/spider/test")
public class MainController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private GanjiQzRepository ganjiQzRepository;
    @Autowired
    private GanjiService ganjiService;
    @GetMapping("/mysql/get")
    public JobEntity testMysql(){
        JobEntity one = jobRepository.findOne(100007L);
        return one;
    }

    @GetMapping("/mongo/get")
    public List<GanjiQzJob> testMongo(){
        String id = "58cbb780528e43c8ee8c464f";
        List<GanjiQzJob> list = ganjiQzRepository.findTop10ByIdGreaterThanOrderById("21853350");
        return list;
    }

    @GetMapping("/mongo/save")
    public Boolean saveMongo(){
        String id = "58cbb780528e43c8ee8c464f";
        GanjiQzJob one = ganjiQzRepository.findOne(id);
        one.setPublished(Published.Yes.getCode());
        //GanjiQzJob save = ganjiQzRepository.save(one);
        //return ganjiService.updatePublishedById("23722074");
        ganjiService.doStartQz();
        return null;
    }
}
