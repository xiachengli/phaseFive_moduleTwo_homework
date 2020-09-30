package com.xcl.controller;

import com.xcl.pojo.JobBean;
import com.xcl.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("get")
    public String get(){
        try{
            List<JobBean> list = jobService.get();
            if (list != null){
                list.forEach(item -> System.out.println(item.toString()));
                return "true";
            }else {
                return "false";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
}
