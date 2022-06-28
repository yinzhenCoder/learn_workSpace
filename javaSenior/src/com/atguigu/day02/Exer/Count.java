/**
 * @ClassName: Count
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 15:38
 * @Blog: 暂无
 */

package com.atguigu.day02.Exer;

import java.util.Objects;

/**
 *
 * @ClassName: Count
 * @Description:
 * @author: 千山
 * @date: 2022-06-24 15:38
 * @Blog: 暂无
 */
public class Count {
    private String name;
    private double balance;

    public Count(){

    }

    public Count(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
      return count.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }

    @Override
    public String toString() {
        return "Count{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void drop(Count count,double money) {
        if (equals(count)){
            if (money<= balance){
                balance -= money;
            System.out.println(Thread.currentThread().getName()+"取了:"+money+"元，余额为："+balance);}
            else {System.out.println("余额不足");}
        }
    }

    public static void main(String[] args){
        Count count = new Count("小明",10000);
        Xiaoming xiaoming1 = new Xiaoming(count,"小明媳妇",5000);
        Xiaoming xiaoming = new Xiaoming(count,"小明",5000);
        xiaoming.start();
       xiaoming1.start();

    }
}

class Xiaoming extends Thread{

    private Count count;

    private double withdraw;

    private static Thread thread = null;

    public Xiaoming(Count count,String name,double money) {
        super(name);
        this.count = count;
        this.withdraw = money;
    }

    public Xiaoming(){
    }

    @Override
    public void run() {

            synchronized (count) {
                count.drop(count, withdraw);
            }

    }
}

