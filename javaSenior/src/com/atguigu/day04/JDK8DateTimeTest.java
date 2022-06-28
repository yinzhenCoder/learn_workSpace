/**
 * @ClassName: JDK8DateTimeTest
 * @Description: JDK8当中日期跟时间的测试
 * @author: 千山
 * @date: 2022-06-28 15:01
 * @Blog: 暂无
 */

package com.atguigu.day04;

import org.junit.Test;

import java.time.*;

/**
 *
 * @ClassName: JDK8DateTimeTest
 * @Description: JDK8当中日期跟时间的测试
 * @author: 千山
 * @date: 2022-06-28 15:01
 * @Blog: 暂无
 */
public class JDK8DateTimeTest {
    @Test
    public void test1(){
        //now 跟 of 两个静态方法
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 05, 16, 23, 22, 56);
        System.out.println(localDateTime1);

        int dayOfMonth = localDateTime1.getDayOfMonth();
        System.out.println(dayOfMonth);
        int monthValue = localDateTime1.getMonthValue();
        System.out.println(monthValue);
        int second = localDateTime1.getSecond();
        System.out.println(second);


        LocalDate localDate1 = localDate.withDayOfYear(1);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime1.plusDays(10);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime2.minusDays(60);
        System.out.println(localDateTime3);
    }

    /*
    Instant的使用
    类似于Date
     */
    @Test
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);

        Instant instant1 = Instant.ofEpochSecond(epochSecond);
        System.out.println(instant1);


    }
    /*
    DateTimeFormat 用来格式化和解析日期时间
    类似 SimpleDateFormat
     */
}
