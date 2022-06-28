/**
 * @ClassName: SailTicket
 * @Description:
 * @author: 千山
 * @date: 2022-06-23 11:00
 * @Blog: 暂无
 */

package com.atguigu.day01;
import java.lang.String;
import com.sun.org.apache.xpath.internal.operations.*;
/**
 *
 * @ClassName: 练习
 * @Description:
 * @author: 千山
 * @date: 2022-06-23 11:00
 * @Blog: 暂无
 */
public class SailTicket {
    public static void main(String[] args) {
        Window2 window2 = new Window2();
        Thread thread1 = new Thread(window2);
        Thread thread2 = new Thread(window2);
        Thread thread3 = new Thread(window2);
        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();


    }

}

class Window1 extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        for (;  ticket>0; ) {
            System.out.println(getName()+"--卖第"+ticket--+"票");
        }
    }
}

class Window2 implements Runnable{

    private int ticket = 100;

    boolean[] b = new boolean[5];
    @Override
    public void run() {
        synchronized(b){
        for (;  ticket>0; ) {
            try {
                //Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--卖第"+ticket--+"票");
        }
        }
    }
}
