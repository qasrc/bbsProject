import com.zhangzhan.bbs.util.StringUtil;
import org.junit.Test;

/**
 * @author zhan
 * Created on 2017/08/14  19:38
 */
public class StringUtilTest {
    @Test
    public void test() {
        String s = "23";
        System.out.println(StringUtil.isNum(s));
    }
}
