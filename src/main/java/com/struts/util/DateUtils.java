package com.struts.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 日期转换工具类
 *
 * @Author：Haotian
 * @Date：2019/5/18 17:05
 */
public class DateUtils {
    /**
     * description: date -> LocalDate
     *
     * @param date 日期
     * @return java.util.Date
     */
    public static LocalDate DateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone( zoneId ).toLocalDate();
    }

    /**
     * description:LocalDate -> date
     *
     * @param localDate 线程安全日期
     * @return java.util.Date
     */
    public static Date LocalDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay( zoneId );
        return Date.from( zonedDateTime.toInstant() );
    }

    public static void main(String[] args) {
        System.out.println( LocalDateToDate( LocalDate.now() ) );
        System.out.println( DateToLocalDate( new Date() ) );
    }
}
