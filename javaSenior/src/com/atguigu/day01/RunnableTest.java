/**
 * @ClassName: RunnableTest
 * @Description:
 * @author: 千山
 * @date: 2022-06-22 14:48
 * @Blog: 暂无
 */

package com.atguigu.day01;

/**
 *
 * @ClassName: RunnableTest
 * @Description:
 * @author: 千山
 * @date: 2022-06-22 14:48
 * @Blog: 暂无
 */

public class RunnableTest{
    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableDemo());
        Thread thread2 = new Thread(new RunnableDemo());
        Thread thread3 = new Thread(new RunnableDemo());
        thread1.start();
        thread2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"hello"+i);
            if (i ==20){
                try {
                    //join方法是当前运行线程只有在调用线程任务执行完才能开始执行，进入阻塞状态
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }






    }


}
class RunnableDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName()+"不复习等于不学习！"+i);
        }
    }
}

