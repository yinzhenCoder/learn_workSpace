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
public class Staff {
    public int productNum = 0;

    public Staff(int productNum) {
        this.productNum = productNum;
    }
    public Staff() {
    }

    public static void main(String[] args){
        Staff staff = new Staff();
        Customer customer = new Customer(staff);
        Producer producer = new Producer(staff);
        producer.setName("生产商1");
        customer.setName("消费者1");

        producer.start();
        customer.start();
    }
}

class Producer extends Thread{
    private Staff staff;

    public Producer(){

    }

    public Producer (Staff staff){
        this.staff = staff;
    }

    //生产商品
   public  void produce(){
        synchronized (staff){
       if (staff.productNum < 20){
           staff.productNum++;
           System.out.println(getName()+":"+"生产者生产第："+staff.productNum+"个产品");
           staff.notify();
       } else{
           try {
               staff.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("商品等待消费");
       }
    }
}

    @Override
    public void run() {
        while (true){
            produce();
        }
    }
}

class Customer extends Thread{
    private Staff staff;

    public Customer(){

    }

    public Customer (Staff staff){
        this.staff = staff;
    }

    @Override
    public void run() {
        while (true){
            consume();
        }
    }

    //消费商品
    public  void consume(){
        synchronized (staff){
        if (staff.productNum > 0){
            System.out.println(getName()+":"+"消费者消费第："+staff.productNum+"个产品");
            staff.productNum--;
            staff.notify();
        } else{
            System.out.println("商品等待生产");
            try {
                staff.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }}
}
