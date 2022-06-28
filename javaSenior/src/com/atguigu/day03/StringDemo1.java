/**
 * @ClassName: StringDemo1
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 10:17
 * @Blog: 暂无
 */

package com.atguigu.day03;

import org.junit.Test;

/**
 *
 * @ClassName: StringDemo1
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 10:17
 * @Blog: 暂无
 */
public class StringDemo1 {
    @Test
    public void test1(){
        String s1 = "1aa234bb5";
        String string = reverseString2(s1, 1, 7);
        System.out.println(string);
    }

    public static String reverseString(String str,int beginIndex,int endIndex){
        if (str != null) {
       String strNew = str.substring(0,beginIndex);
        for (int i = endIndex; i >= beginIndex; i--) {
            strNew += str.charAt(i);
        }
        strNew += str.substring(endIndex+1);
        return strNew;
        }
        return null;
    }

    public static String reverseString1(String str,int beginIndex,int endIndex) {

        if (str != null) {
            StringBuilder sb = new StringBuilder(str.substring(0,beginIndex));
            for (int i = endIndex; i >= beginIndex; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(str.substring(endIndex+1));
            return sb.toString();
        }
        return null;
    }

    public static String reverseString2(String str,int beginIndex,int endIndex){
        char[] chars = str.toCharArray();
        int i = endIndex, j = beginIndex;
        for (;j < i;i--,j++){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

}
