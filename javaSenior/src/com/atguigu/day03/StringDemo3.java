/**
 * @ClassName: StringDemo3
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 10:53
 * @Blog: 暂无
 */

package com.atguigu.day03;


import org.junit.Test;

import java.util.Arrays;

/**
 *
 * @ClassName: StringDemo3
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 10:53
 * @Blog: 暂无
 */
public class StringDemo3 {

    @Test
    public void test3(){
        String str1 = "abcwertcvhelloyuiodefabcwe";
        String str2 = "cvhellobnmabcwe";
        String[] lengthString = getLengthString(str1, str2);
        System.out.println(Arrays.toString(lengthString));
    }

    public static String[] getLengthString(String target, String str){
        StringBuilder sb = new StringBuilder();
        if (target.length() > str.length()){
            for (int i = 0; i <= str.length() ; i++) {
                for (int r = 0,j = str.length() - i;j<=str.length();r++,j++){
                    if (target.contains(str.substring(r,j))){
                        sb.append(str.substring(r,j)).append(",");
                    }
                }
                //只要里面有数据就停止大循环，输出数组
                if (sb.length() != 0 ){
                    String string = sb.toString();
                    String s = string.replaceAll("$,", "");
                    String[] split = s.split(",");
                    return split;
                }
            }
            return null;
        }
        return null;
    }
}
