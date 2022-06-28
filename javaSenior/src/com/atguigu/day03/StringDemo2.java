/**
 * @ClassName: StringDemo2
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 10:36
 * @Blog: 暂无
 */

package com.atguigu.day03;

import org.junit.Test;

/**
 *
 * @ClassName: StringDemo2
 * @Description:
 * @author: 千山
 * @date: 2022-06-28 10:36
 * @Blog: 暂无
 */
public class StringDemo2 {
    @Test
    public void test1(){
        String str = "avbaaaavavvvvvb";
        String str2 = "av";

        int stringInCount = getStringInCount(str, str2);
        System.out.println(stringInCount);
    }

    public static int getStringInCount (String target,String str){
        if (target != null && str != null){
            int count = 0;
            int index = 0;
            while ((index = (target.indexOf(str)))!=-1){
                    count++;
                target = target.substring(index+str.length());
                }
            return count;
        }
        return 0;
    }
}
