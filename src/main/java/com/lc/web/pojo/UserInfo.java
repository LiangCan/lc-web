package com.lc.web.pojo;

import javax.persistence.*;

/**
 * Created by liangcan on 2018/8/26.
 */
@Entity
@Table(name = "t_user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid", length = 16)
    private Long uid;//日志ID

    @Column(name = "user_name", columnDefinition = " varchar(16) DEFAULT NULL   COMMENT '用户名' ")
    private String user_name;//请求KEY


    @Column(name = "user_qq", columnDefinition = " varchar(16) DEFAULT NULL   COMMENT 'qq' ")
    private String user_qq;


    @Column(name = "user_password", columnDefinition = " varchar(16) DEFAULT NULL   COMMENT '用户密码' ")
    private String user_password;


    @Column(name = "integral", columnDefinition = " bigint(16)  COMMENT '用户的积分' ")
    private Integer integral;


    @Column(name = "recommend_user", columnDefinition = " bigint(16)   COMMENT '推荐用户' ")
    private Long recommend_user;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Long getRecommend_user() {
        return recommend_user;
    }

    public void setRecommend_user(Long recommend_user) {
        this.recommend_user = recommend_user;
    }
}
