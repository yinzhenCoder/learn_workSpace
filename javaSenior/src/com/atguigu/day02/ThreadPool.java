/**
 * @ClassName: ThreadPool
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 17:29
 * @Blog: 暂无
 */

package com.atguigu.day02;

import java.util.concurrent.*;

/**
 *
 * @ClassName: ThreadPool
 * @Description: 创建线程的第四种方式 线程池
 * @author: 千山
 * @date: 2022-06-24 17:29
 * @Blog: 暂无
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService s = Executors.newFixedThreadPool(10);
        Future<Integer> fu = s.submit(new MyCallable());
        Thread thread = new Thread((FutureTask)fu);
        thread.start();
        try {
            Integer integer = fu.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
