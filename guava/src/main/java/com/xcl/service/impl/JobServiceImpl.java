package com.xcl.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.xcl.mapper.JobMapper;
import com.xcl.pojo.JobBean;
import com.xcl.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private Cache<String,Object> guavaCache;

    @Autowired
    private JedisCluster jedis;

    @Autowired
    private JobMapper jobMapper;

    private static final String Cache_key="job:hot";

    @Override
    public List<JobBean> get() {
        List<JobBean> list = null;
        //先查缓存，缓存不存在差数据库，回填缓存
          Object obj = guavaCache.getIfPresent(Cache_key);
          //本地缓存不存在
          if (obj == null) {
              Object str = jedis.get(Cache_key);
              //分布式缓存中不存在
              if (str == null) {
                  System.out.println("---------------- 从数据源中获取数据---------------------");
                  list = jobMapper.get();
                  //将结果进行缓存
                  guavaCache.put(Cache_key,list);
                  jedis.setex(Cache_key,10,JSON.toJSONString(list));
              }else {
                  System.out.println("---------------从分布式缓存中获取数据--------------");
                  //将结果缓存进guava
                  guavaCache.put(Cache_key,str);
                  list = JSON.parseArray(str.toString(),JobBean.class);
              }
          }else {
              System.out.println("----------------从本地缓存中获取数据-----------------");
              list =  (List<JobBean>)obj;
          }
          return list;
    }
}
