package com.zhangzhan.bbs.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 切换数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 存储创建的数据源
     * 用户每次登录时需要清空
     */
    private Map<Object, Object> _targetDataSource;

    @Autowired
    private HttpSession httpSession;

    private static final Logger LOGGER = Logger.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String ds = DataSourceHolder.getCustomeType();
        //设置数据源
        this.selectDataSource(ds);
        LOGGER.info("Use dataSource name >>>>>>>>>>" + ds);
        DataSourceHolder.remove();
        return ds;
    }


    /**
     * 选择数据源
     * 如果数据源已存在，则不做处理
     */
    private void selectDataSource(String sourceName) {
        String getSourceName = DataSourceHolder.getCustomeType();
        //添加到缓存中
        Object source = this._targetDataSource.get(sourceName);
        if (source == null || !sourceName.equals(getSourceName)) {
            //获取数据源
            BasicDataSource basicDataSource = getBasicDataSource(sourceName);
            //设置数据源
            if (basicDataSource != null) {
                setDataSource(sourceName, basicDataSource);
            }
        }
    }

    /**
     * 切换数据源
     */
    public void setTargetDataSources(Map<Object, Object> targetDataSource) {
        this._targetDataSource = targetDataSource;
        super.setTargetDataSources(targetDataSource);
        afterPropertiesSet();
    }

    /**
     * 添加数据源
     */
    private void addDataSource(String key, BasicDataSource dataSource) {
        this._targetDataSource.put(key, dataSource);
        this.setTargetDataSources(this._targetDataSource);
    }

    /**
     *  设置数据源
     */
    private void setDataSource(String key, BasicDataSource dataSource) {
        addDataSource(key, dataSource);
        DataSourceHolder.setCustomeType(key);
    }


    /**
     * 根据数据源名称获取数据源
     *
     * @param sourceName 数据源名称
     * @return 数据源
     */
    private BasicDataSource getBasicDataSource(String sourceName) {
        BasicDataSource basicDataSource = new BasicDataSource();
        //从session中获取数据库中存储的配置，在用户登录时存储中Session中
        Map<String, String> configs = (Map<String, String>) httpSession.getAttribute("sysManage");
        String driverName = "", url = "", username = "", password = "";

        basicDataSource.setDriverClassName(driverName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }


    /**
     * 清空存储的数据源连接信息
     * 在用户登录的调用
     */
    public void clearDataSource() {
        if (_targetDataSource != null) {
            Map<Object, Object> tempMap = new HashMap<>();
            tempMap.put("gzz", _targetDataSource.get("gzz"));
            _targetDataSource.clear();
            _targetDataSource.putAll(tempMap);
        }
    }
}
