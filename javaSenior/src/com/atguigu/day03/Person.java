/**
 * @ClassName: Person
 * @Description:
 * @author: 千山
 * @date: 2022-06-27 9:45
 * @Blog: 暂无
 */

package com.atguigu.day03;

/**
 *
 * @ClassName: Person
 * @Description:
 * @author: 千山
 * @date: 2022-06-27 9:45
 * @Blog: 暂无
 */
public class Person {
    String name;
}
class StringTest01{
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "abc";

        System.out.println(person.name == "abc");
    }
}
