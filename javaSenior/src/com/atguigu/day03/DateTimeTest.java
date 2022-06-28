/**
 * @ClassName: DateTimeTest
 * @Description:
 * @author: 千山
 * @date: 2022-06-27 16:20
 * @Blog: 暂无
 */

package com.atguigu.day03;

import org.junit.Test;

import java.util.Date;

/**
 *
 * @ClassName: DateTimeTest
 * @Description: jdk8之前的日期类型测试
 * @author: 千山
 * @date: 2022-06-27 16:20
 * @Blog: 暂无
 */
public class DateTimeTest {
    /*
    System类中的currentTimeMillis()方法，获取从现在到1970年一月一日零时零分零秒的毫秒值，可用于时间戳。
     */
    @Test
    public void test1(){
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    @Test
    public void test2(){
        //date两个构造器，两个方法
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);

        java.sql.Date date1 = new java.sql.Date(time);
        System.out.println(date1);
        Long long1 = date1.getTime();
        System.out.println(long1);

        //两种类型间转换 java.util.date 转为 java.sql.date
        java.util.Date date2 = new Date();
        java.sql.Date date3 = new java.sql.Date(date2.getTime());
        System.out.println(date3);
    }
}
