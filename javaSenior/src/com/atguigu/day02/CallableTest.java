/**
 * @ClassName: CallableTest
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 17:22
 * @Blog: 暂无
 */

package com.atguigu.day02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @ClassName: CallableTest
 * @Description: 创建线程的第三种方式：实现callable接口
 * @author: 千山
 * @date: 2022-06-24 17:22
 * @Blog: 暂无
 */
public class CallableTest {
    public static void main(String[] args) {
        //1创建该实现callable类的对象
        MyCallable myCallable = new MyCallable();
        //2.创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        //3.创建线程对象
        Thread thread = new Thread(futureTask);
        //4.调用线程的start方法
        thread.start();
        //5.获取call方法的返回值
        try {
            System.out.println("总和："+(Integer)futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i%2 ==0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
