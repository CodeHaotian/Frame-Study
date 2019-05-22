import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 线程安全的日期转换
 *
 * @Author：Haotian
 * @Date：2019/5/18 16:44
 */
public class DateTimeFormatterTest {
    //定义模式
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern( "yyyy/MM/dd" );

    @Test
    public void test() {
        String s = "2018/11/12";

        //将格式匹配的字符串转化为date格式
        LocalDate date = LocalDate.parse( s, FORMATTER );

        //将date转为指定格式的字符串
        String x = FORMATTER.format( date );

        System.out.println( x );
    }

}
