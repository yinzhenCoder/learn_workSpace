/**
 * @ClassName: StringBufferBuilderTest
 * @Description: 关于StringBufferStringBuilder的测试
 * @author: 千山
 * @date: 2022-06-27 14:48
 * @Blog: 暂无
 */

package com.atguigu.day03;

import org.junit.Test;
import sun.plugin2.util.SystemUtil;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @ClassName: StringBufferBuilderTest
 * @Description: 关于StringBufferStringBuilder的测试
 * @author: 千山
 * @date: 2022-06-27 14:48
 * @Blog: 暂无
 */

/*
StringBuffer的常用方法
Test1()

StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转
public int indexOf(String str)
public String substring(int start,int end)
public int length()
public char charAt(int n )
public void setCharAt(int n ,char ch)

方法总结
增 append
删 delete
改 replace setCharAt
查 charAt indexOf
插 insert
长度 length
遍历 for toString

 */
public class StringBufferBuilderTest {

    @Test
    public void test1(){
        StringBuffer stringBuffer = new StringBuffer("abc");
        int length = stringBuffer.length();
        System.out.println(length);

        stringBuffer.setCharAt(0,"m".charAt(0));
        System.out.println(stringBuffer);
    }

    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append("1");
        s1.append('1');
        System.out.println(s1);
        s1.delete(3,6);
        System.out.println(s1);
        s1.replace(2,100000,"hello");
        System.out.println(s1);
       String[] s5 = {" "," "," "};
        System.out.println(Arrays.toString(s5));

    }

    /**
     * 对比String，StringBuffer,StringBuilder
     */
    @Test
    public void test3(){
        long startTim = 0L;
        long endTim = 0L;
        String text = "";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        startTim = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text += i;
        }
        endTim = System.currentTimeMillis();
        System.out.println(endTim - startTim);

        startTim = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            stringBuffer.append(i);
        }
        endTim = System.currentTimeMillis();
        System.out.println(endTim - startTim);

        startTim = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            stringBuilder.append(i);
        }
        endTim = System.currentTimeMillis();
        System.out.println(endTim - startTim);

    }
}
