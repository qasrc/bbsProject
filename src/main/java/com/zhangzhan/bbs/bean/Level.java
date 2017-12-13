package com.zhangzhan.bbs.bean;

/**
 * 用户等级
 *
 * @author zhan
 * Created on 2017/09/22  18:40
 */
public class Level {
    private String id;
    private String point;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
