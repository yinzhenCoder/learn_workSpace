/**
 * @ClassName: SailTicketTest02
 * @Description:
 * @author: 千山
 * @date: 2022-06-23 13:45
 * @Blog: 暂无
 */

package com.atguigu.day01;

/**
 *
 * @ClassName: SailTicketTest02
 * @Description:
 * @author: 千山
 * @date: 2022-06-23 13:45
 * @Blog: 暂无
 */
public class SailTicketTest02 {
    public static void main(String[] args){
        Window3 window3 = new Window3();
        Window3 window2 = new Window3();
        Window3 window1 = new Window3();
        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}
class Window3 extends Thread{
    private static int ticket = 1000;

    //private static Object p = new Object();

    @Override
    public void run() {

        /*
        synchronized(Window3.class){
        for (;  ticket>0; ) {
            try {
                //sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"--卖第"+ticket--+"票");
            }
        }
        */
            while (true){
                synchronized(Window3.class){
                if (ticket > 0 ){
                    try {
                        //sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"--卖第" + ticket-- +"票");
                }
            }
        }
    }
}
