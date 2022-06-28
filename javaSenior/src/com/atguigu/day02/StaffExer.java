/**
 * @ClassName: Staff
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 13:53
 * @Blog: 暂无
 */

package com.atguigu.day02;

/**
 *
 * @ClassName: Staff
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 13:53
 * @Blog: 暂无
 */
public class StaffExer {
    public int productNum = 0;

    public StaffExer(int productNum) {
        this.productNum = productNum;
    }

    public StaffExer() {
    }
    //生产商品
    public synchronized void produce(){

        if (productNum < 20){
            productNum++;
            System.out.println(Thread.currentThread().getName()+":"+"生产者生产第："+productNum+"个产品");
            notify();
        } else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("商品等待消费");


        }
    }

    //消费商品
    public synchronized void consume(){

        if (productNum > 0){
            System.out.println(Thread.currentThread().getName()+":"+"消费者消费第："+productNum+"个产品");
            productNum--;
            notify();
        } else{
            System.out.println("商品等待生产");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args){
        StaffExer staff = new StaffExer();
        Customer1 customer = new Customer1(staff);
        Producer1 producer = new Producer1(staff);
        producer.setName("生产商1");
        customer.setName("消费者1");

        producer.start();
        customer.start();
    }
}

class Producer1 extends Thread{
    private StaffExer staff;

    public Producer1(){

    }

    public Producer1 (StaffExer staff){
        this.staff = staff;
    }


    @Override
    public void run() {
        while (true){
            staff.produce();
        }
    }
}

class Customer1 extends Thread{
    private StaffExer staff;

    public Customer1(){

    }

    public Customer1 (StaffExer staff){
        this.staff = staff;
    }

    @Override
    public void run() {
        while (true){
            staff.consume();
        }
    }


}
