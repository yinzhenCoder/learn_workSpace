/**
 * @ClassName: MyThread
 * @Description:
 * @author: 千山
 * @date: 2022-06-21 18:19
 * @Blog: 暂无
 */

package com.atguigu.day01;

/**
 *
 * @ClassName: MyThread
 * @Description:
 * @author: 千山
 * @date: 2022-06-21 18:19
 * @Blog: 暂无
 */
 public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);
        }
    }
}