package com.struts.web.convert;

import com.struts.util.DateUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * 自定义的类型转换类
 *
 * @Author：Haotian
 * @Date：2019/5/18 15:41
 */
public class MyDateConverter extends StrutsTypeConverter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern( "yyyy/MM/dd" );

    /**
     * 把字符串转换为对象类型
     *
     * @param map
     * @param strings
     * @param aClass
     * @return
     */
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        //先判断有无数据
        if (strings == null || strings.length == 0) {
            return null;
        }
        //取出第一个元素
        String s = strings[0];
        //将字符串转化为date
        if (aClass == java.util.Date.class) {
            LocalDate date = LocalDate.parse( s, FORMATTER );
            return DateUtils.LocalDateToDate( date );
        }
        return null;
    }

    /**
     * 把对象类型转换成字符串类型
     *
     * @param map
     * @param o
     * @return
     */
    @Override
    public String convertToString(Map map, Object o) {
        return null;
    }
}
