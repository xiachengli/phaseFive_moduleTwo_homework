package com.xcl.mapper;

import com.xcl.pojo.JobBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobMapper {

    @Select("select * from job")
    List<JobBean> get();
}
