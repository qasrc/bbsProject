package com.zhangzhan.bbs.bean;

/**
 * 用户配置
 *
 * @author zhan
 * Created on 2017/09/22  18:43
 */
public class UserConfig {
    private String id;
    private Actor actor;
    private String configJson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getConfigJson() {
        return configJson;
    }

    public void setConfigJson(String configJson) {
        this.configJson = configJson;
    }
}
