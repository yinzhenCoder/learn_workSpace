/**
 * @ClassName: Exer1
 * @Description:
 * @author: 千山
 * @date: 2022-06-23 10:41
 * @Blog: 暂无
 */

package com.atguigu.day01;

/**
 *
 * @ClassName: Exer1
 * @Description: 练习一：创建两个分线程，一个输出100以内的偶数，一个输出100以内的奇数
 * @author: 千山
 * @date: 2022-06-23 10:41
 * @Blog: 暂无
 */
public class Exer1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 thread = new MyThread2();
        Thread myThread2 = new Thread(thread);

        myThread1.start();
        myThread2.start();
        try {
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if (i%2==0){
                System.out.println(getName()+"["+i+"]");
            }
        }
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+"["+i+"]");
            }
        }
    }
}
