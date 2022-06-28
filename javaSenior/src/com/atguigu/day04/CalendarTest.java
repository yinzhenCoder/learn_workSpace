/**
 * @ClassName: CalendarTest
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 14:35
 * @Blog: 暂无
 */

package com.atguigu.day04;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @ClassName: CalendarTest
 * @Description: 日历类的使用
 * @author: 千山
 * @date: 2022-06-28 14:35
 * @Blog: 暂无
 */
public class CalendarTest {
    @Test
    public void test1(){
        Calendar instance = Calendar.getInstance();
        Class<? extends Calendar> aClass = instance.getClass();
        System.out.println(aClass);
        //实例化，两种
        //1.创建子类GregorianCalendar  2.调用静态方法获取实例

        //2.常用方法
        //get
        int month = instance.get(Calendar.DAY_OF_MONTH);
        int year = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println(month);
        System.out.println(year);

        //set
        instance.set(Calendar.DAY_OF_YEAR,1);

        //int year1 = instance.get(Calendar.DAY_OF_YEAR);
        //System.out.println(year1);

        //add
        instance.add(Calendar.DAY_OF_MONTH,1);
        int i = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);

        //getTime()
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(time);
        System.out.println(format);

        //setTime()
        Date date = new Date();
        instance.setTime(date);
        System.out.println(instance.get(Calendar.MONTH ));
    }
}
