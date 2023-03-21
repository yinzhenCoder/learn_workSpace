/**
 * @ClassName: StringUtils
 * @Description:
 * @author: 千山
 * @date: 2023-03-21 14:47
 * @Blog: 暂无
 */

package com.atguigu.security.demo.demo.utils;

/**
 *
 * @ClassName: StringUtils
 * @Description:
 * @author: 千山
 * @date: 2023-03-21 14:47
 * @Blog: 暂无
 */

public class StringUtils {
    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }
}

