package util;

import org.apache.commons.lang3.StringUtils;

/**
 * 工具类
 *
 * @author zhan
 * Created on 2017/08/14  19:32
 */
public class StringUtil {
    public static boolean isNum(String str) {
        return StringUtils.isNumeric(str);
    }
}
