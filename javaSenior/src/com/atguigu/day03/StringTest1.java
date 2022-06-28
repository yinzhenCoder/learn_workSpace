/**
 * @ClassName: StringTest1
 * @Description: 涉及到String
 * @author: 千山
 * @date: 2022-06-27 11:29
 * @Blog: 暂无
 */

package com.atguigu.day03;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * @ClassName: StringTest1
 * @Description: 涉及到String与基本数据类型包装类之间的转换
 * @author: 千山
 * @date: 2022-06-27 11:29
 * @Blog: 暂无
 */
public class StringTest1 {

    /*
    String 和 byte[] 数组转换
    编码：String --> byte[]:调用String.getBytes()
    解码：byte[] --> String:

    编码：字符串 -->字节: 看的懂到看不懂的二进制数据
    解码：编码的逆过程，字节 -->字符串(看不懂的二进制数据 --> 看的懂)
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        System.out.println("**********编码**************");
        String s1  = "abc123中国";
        byte[] bytes = s1.getBytes();//使用默认的字符集
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("GBK");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));
        System.out.println("****************************\n\n\n");
        System.out.println("**********解码**************");
        String s3 = new String(bytes);
        System.out.println("默认编码集进行解码："+ s3);
        String s4 = new String(gbks);
        System.out.println("gbk进行编码，默认编码集进行解码："+ s4);
        String s5 = new String(gbks,"gbk");
        System.out.println("gbk进行编码，gbk编码集进行解码："+ s5);
    }



    /*
    String 和char[] 数组转换

    1.getChars() 方法将字符从字符串复制到目标字符数组。
    *语法
        public void getChars(int srcBegin, int srcEnd, char[] dst,  int dstBegin)
    *参数
        srcBegin -- 字符串中要复制的第一个字符的索引。
        srcEnd -- 字符串中要复制的最后一个字符之后的索引。
        dst -- 目标数组。
        dstBegin -- 目标数组中的起始偏移量。

    */
    @Test
    public void test2(){
        //String s1 = "0123";
        //char[] chars = s1.toCharArray();
        ////s1.getChars(0,2,chars,0);
        //for (char aChar : chars) {
        //    System.out.println(aChar);
        //}

        //char[] c1 = new char[]{'h','e','l','l','o'};
        //String s2 = new String(c1);
        //System.out.println(s2);

        String Str1 = new String("www.runoob.com");
        char[] Str2 = new char[8];

        try {
            Str1.getChars(4, 10, Str2, 2);
            System.out.print("拷贝的字符串为：" );
            System.out.println(Str2 );
        } catch( Exception ex) {
            System.out.println("触发异常...");
        }

        System.out.println(Arrays.toString(Str2));

    }




    @Test
    public void test1(){
        String s1 = "123";
        int i = Integer.valueOf(s1);
        System.out.println(i);

        String s = String.valueOf(i);
        System.out.println(s == s1);

    }
}
