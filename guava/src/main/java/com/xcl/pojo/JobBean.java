package com.xcl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class JobBean implements Serializable {
    //主键
    private long id;
    //职位名称
    private String name;
    //标签，如：电商、游戏、测试
    private String type;
    //薪酬范围
    private BigDecimal lowSalary;
    private BigDecimal highSalary;
    //详情链接
    private String url;
    //所属公司
    private long companyId;
    private String companyName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getLowSalary() {
        return lowSalary;
    }

    public void setLowSalary(BigDecimal lowSalary) {
        this.lowSalary = lowSalary;
    }

    public BigDecimal getHighSalary() {
        return highSalary;
    }

    public void setHighSalary(BigDecimal highSalary) {
        this.highSalary = highSalary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "JobBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", lowSalary=" + lowSalary +
                ", highSalary=" + highSalary +
                ", url='" + url + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
