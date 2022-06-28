/**
 * @ClassName: ThreadTest
 * @Description: 线程测试类
 * @author: 千山
 * @date: 2022-06-21 17:43
 * @Blog: 暂无
 */

package com.atguigu.day01;

/**
 *
 * @ClassName: ThreadTest
 * @Description: 线程测试类
 * @author: 千山
 * @date: 2022-06-21 17:43
 * @Blog: 暂无
 */
public class ThreadTest {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.setPriority(Thread.MIN_PRIORITY);
        myThread.start();
        try{
            //MyThread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            if (i%2==0)
                System.out.println("hello");
        }

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }.start();

    }
}

