/**
 * @ClassName: DateTimeTest
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 13:59
 * @Blog: 暂无
 */

package com.atguigu.day04;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @ClassName: DateTimeTest
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 13:59
 * @Blog: 暂无
 */
public class DateTimeTest {
    //simpleDateFormat

    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);

        // 格式化 日期 --> 字符串
        String format = simpleDateFormat.format(date);
        System.out.println(format);


        // 解析  字符串 --> 日期
        Date parse = simpleDateFormat.parse("22-6-28 下午25:06");
        System.out.println(parse);

        //=================带参构造器============
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf.format(date);
        System.out.println(format1);

        Date parse1 = sdf.parse("2029-08-32 19:25:33");
        System.out.println(parse1);
    }

    @Test
    public void test2() throws ParseException {
        String date = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date1 = new java.sql.Date(sdf.parse(date).getTime());
        System.out.println(date1);

    }
}
