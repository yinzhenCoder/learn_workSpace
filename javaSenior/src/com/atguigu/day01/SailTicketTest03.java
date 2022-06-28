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
public class SailTicketTest03 {
    public static void main(String[] args){
        Window4 window3 = new Window4();
        Window4 window2 = new Window4();
        Window4 window1 = new Window4();
        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window4 extends Thread{
    private static int ticket = 1000;

    //private static Object p = new Object();

    @Override
    public void run() {
            while (true){
                show();
                /*synchronized (this){
                if (!(ticket >0)){
                    System.out.println("1111111111111");
                    break;
                }
                }*/
        }
    }

    public static synchronized void show(){
        if (ticket > 0 ){
            try {
                //sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName()+"--卖第" + ticket-- +"票");
        }
    }
}
