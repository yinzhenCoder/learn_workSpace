/**
 * @ClassName: StringNormalMethods
 * @Description: String常用方法
 * @author: 千山
 * @date: 2022-06-27 9:59
 * @Blog: 暂无
 */

package com.atguigu.day03;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

/**
 *
 * @ClassName: StringNormalMethods
 * @Description: String常用方法
 * @author: 千山
 * @date: 2022-06-27 9:59
 * @Blog: 暂无
 */

/*
Test1()
 int length()：返回字符串的长度： return value.length
 char charAt(int index)： 返回某索引处的字符return value[index]
 boolean isEmpty()：判断是否是空字符串：return value.length == 0
 String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 String trim()：返回字符串的副本，忽略前导空白和尾部空白
 boolean equals(Object obj)：比较字符串的内容是否相同
 boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
 String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
 int compareTo(String anotherString)：比较两个字符串的大小
 String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
 String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
    x = [15,20) 表示   15 <= x < 20
--------------------------------------------

Test2()
 boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

 boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true

 int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
 int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
注：indexOf和lastIndexOf方法如果未找到都是返回-1
--------------------------------------------

Test3()
 String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 String replaceAll(String regex, String replacement) ： 使 用 给 定 的replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 String replaceFirst(String regex, String replacement) ： 使 用 给 定 的replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
 String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
 String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
--------------------------------------------
 */
public class StringNormalMethods {
    @Test
    public void test01(){
        String s1 = new String("helloworld");
        int length = s1.length();
        //System.out.println("返回字符串的长度:"+length);

        char c = s1.charAt(0);
        System.out.println("返回某索引处的字符:"+c);

        String s2 = "";
        boolean empty = s2.isEmpty();
        //empty = s1.isEmpty();
        System.out.println("判断是否是空字符串:"+empty);

        String s3 = s1.toUpperCase();
        System.out.println("转换大写前："+ s1);
        System.out.println("转换大写后："+ s3);

        String s4 = s3.toLowerCase();
        System.out.println("转换小写前："+ s3);
        System.out.println("转换小写后："+ s4);

        String s5 = "  hell o world   ";
        String trim = s5.trim();
        System.out.println("忽略前导空白和尾部空白前"+s5);
        System.out.println("忽略前导空白和尾部空白后"+trim);

        boolean ignoreCase = s3.equalsIgnoreCase(s1);
        System.out.println("与equals方法类似，忽略大小写:"+ignoreCase);


        String ss1 = "abc";
        String def = ss1.concat("def");
        System.out.println("concat方法执行后的对象是否发生改变:"+ ss1 == ss1);
        System.out.println(def);
        String def1 = "abcdef";
        System.out.println("concat方法执行后的返回的对象是否在常量池中"+ def1==def);


        String ss2 = "helloworld";
        int i = ss1.compareTo(ss2);
        System.out.println("比较两个字符串的大小,找到不同的地方返回差值结束方法，不是求和多个不同值再返回"+i);

        String substring = ss2.substring(2);
        System.out.println("从beginIndex开始截取到最后的一个子字符串："+substring);
        String substring1 = ss2.substring(1, 5);
        System.out.println("从beginIndex开始截取到endIndex(不包含)的一个子字符串"+ substring1);


    }


    @Test
    public void test2(){
        String s1 = "helloworld";
        boolean world = s1.endsWith("World");
        boolean world1 = s1.endsWith("world");
        System.out.println( world == world1);
        System.out.println("测试此字符串是否以指定的前缀开始:"+s1.startsWith("hel"));
        System.out.println("测试此字符串从指定索引开始的子字符串是否以指定前缀开始:"+s1.startsWith("low", 3));

        boolean isIgnoreCase = s1.contains("He");
        boolean he = s1.contains("he");
        System.out.println("当且仅当此字符串包含指定的 char 值序列时，返回 true,(不能忽略大小写):" + he);

        System.out.println("返回指定子字符串在此字符串中第一次出现处的索引:"+s1.indexOf("ll"));
        System.out.println("返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始:"+s1.indexOf("l",4));

        int i = s1.lastIndexOf("l");
        System.out.println("返回指定子字符串在此字符串中最右边出现处的索引:"+ i);
        int lastIndexOf = s1.lastIndexOf("l",7);
        System.out.println("返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索:" + lastIndexOf);
    }

    @Test
    public void test3(){
        String s1 = "北京尚硅谷教育北北";
        System.out.println(s1.replace("北", "东"));
        System.out.println("替换后："+ s1);

        String replace = s1.replace("尚硅谷", "黑马程序员");
        System.out.println("使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串:" + replace );

        String s2 = " 尚硅谷  尚硅谷   尚硅谷 教育";
        //String s2re = s2.replaceAll("\\ +", "黑马程序员");
        String s2re = s2.replaceFirst("\\ +", "黑马程序员");
        System.out.println("替换此字符串匹配给定的正则表达式的第一个子字符串:" + s2re);

        String s3 = "123456..123";
        boolean matches = s3.matches("^\\d+(\\.+\\d+)?");
        System.out.println("告知此字符串是否匹配给定的正则表达式:" + matches);

        String s4 = "1,2,3,4,5";
        String[] split = s4.split("\\,+", 5);
        System.out.println(split.length);
        for (int i = split.length  ; i > 0; i--) {
            System.out.println(split[i - 1]);
            if (i - 1 != 0)
                System.out.print(" ");
        }

        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);
        String str1 = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches1 = str1.matches("\\d+");
        System.out.println(matches1);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
    }


    @Test
    public void exercise(){
        /**
         * 给定一个字符串，逐个翻转字符串中的每个单词。
         * 要求：输入字符串包括前导或者尾部空格时，反转后不能包括,如果两个单词间有多个空格，在反转字符串时，两个词之间的空格减少到一个。
         * 例如： 输入：" Mozi is a    technology company ", 输出："company technology a is Mozi"
         */

        String s = " Mozi is a    technology company ";
        String trim = s.trim();

        String[] split = trim.split("\\ +");
        for (int i = split.length  ; i > 0; i--) {
            System.out.print(split[i - 1]);
            if (i - 1 != 0)
                System.out.print(" ");
        }

        /*
        方法一：
        String s1 = trim.replaceAll("\\ +", ",");
        String[] split = s1.split(",");
        *//*
        java.lang.ArrayIndexOutOfBoundsException: 5
         *//*
        for (int i = split.length  ; i > 0; i--) {
            System.out.print(split[i-1]);
            if (i-1 == 0){

            }else {
                System.out.print(" ");
            }
        }*/
    }

}
