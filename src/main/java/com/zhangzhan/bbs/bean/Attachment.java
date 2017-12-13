package com.zhangzhan.bbs.bean;

import java.util.Date;

/**
 * 附件
 *
 * @author zhan
 * Created on 2017/09/22  18:28
 */
public class Attachment {
    private String id;
    private String path;
    private String type;
    private Date sysDate;
    private boolean isValide;

    public boolean isValide() {
        return isValide;
    }

    public void setValide(boolean valide) {
        isValide = valide;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getSysDate() {
        return sysDate;
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }
}
