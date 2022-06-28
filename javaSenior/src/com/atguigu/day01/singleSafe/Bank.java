/**
 * @ClassName: Bank
 * @Description:
 * @author: 千山
 * @date: 2022-06-23 14:36
 * @Blog: 暂无
 */

package com.atguigu.day01.singleSafe;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.print.DocFlavor;

/**
 *
 * @ClassName: Bank
 * @Description:
 * @author: 千山
 * @date: 2022-06-23 14:36
 * @Blog: 暂无
 */
public class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    public static Bank getInstance(){
        if (instance == null){
    //public synchronized static Bank getInstance(){
        synchronized(Bank.class){
        if (instance == null){
            instance = new Bank();
        }
    }
        }
        return instance;
    }


}
