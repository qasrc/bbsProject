package com.zhangzhan.bbs.aop;

import com.zhangzhan.bbs.annotation.DataSource;
import com.zhangzhan.bbs.datasource.DataSourceHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class DataSourceAspect {

	public void changeDateSource(JoinPoint jp) {
		try {
			String methodName = jp.getSignature().getName();
			Class<?> targetClass = Class.forName(jp.getTarget().getClass().getName());
			for (Method method : targetClass.getMethods()) {
				if (methodName.equals(method.getName())) {
					Class<?>[] args = method.getParameterTypes();
					if (args.length == jp.getArgs().length) {
						DataSource ds = method.getAnnotation(DataSource.class);
						//如果注解不为空
						if (ds != null) {
							DataSourceHolder.setCustomeType(ds.name());
						}
						//如果注解为空，根据方法名称的后缀获取
						else{
							//方法名是否已特定的后缀结束
							if (methodName.contains("_")) {
								//获取数据源的名称
								String sourceName = methodName.substring(methodName.lastIndexOf("_") + 1, methodName.length());
								//根据名称在数据库中获取对应的数据源
								if (StringUtils.isNotBlank(sourceName)) {
									DataSourceHolder.setCustomeType(sourceName);
								}else{
									DataSourceHolder.setCustomeType("gzz");
								}
							}else{
								DataSourceHolder.setCustomeType("gzz");
							}
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}