/**
 * @ClassName: Customer
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 10:15
 * @Blog: 暂无
 */

package com.atguigu.day01.Exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @ClassName: Customer
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 10:15
 * @Blog: 暂无
 */
public class Customer extends Thread {
    private Count count;

    public static ReentrantLock lock = new ReentrantLock(true);

    public Customer(){}
    public Customer(Count count){
        this.count = count;
    }


    public void deposit(double money){
        try
        {lock.lock();
            count.balance += money;
            System.out.println(getName()+"余额为："+count.balance);
        }finally {
            lock.unlock();
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            deposit(1000);
        }
    }


    public static void main(String[] args) {
        Count count = new Count();
        Customer c1 = new Customer(count);
        Customer c2 = new Customer(count);

        c1.setName("储户1");
        c2.setName("储户2");

        c1.start();
        c2.start();
    }
}

class Count{
    public static double balance;
}
