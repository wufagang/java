package com.lambdaexpress;

import com.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * spring_annotation
 *
 * @Title: com.lambdaexpress
 * @Date: 2020/8/8 6:26
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class demo1 {


    public static void main(String[] args) {



        new Thread(new Runnable() {
            public void run() {
                System.out.println("java7  实现方式");
            }
        }).start();

        new Thread(() -> System.out.println("lambdaexpress")).start();


    }

    private List<Person> personLists = Arrays.asList(
            new Person("张三",23, 45f),
            new Person("李四",23, 45f),
            new Person("王五",23, 45f),
            new Person("赵六",23, 45f));
    @Test
    public void test1(){
        //personLists.stream().map(Person::getName).forEach(System.out::println);
        List<String> list = Arrays.asList("dd","bb");
        StringBuffer orderIdSb = new StringBuffer();
        list.forEach(orderid->orderIdSb.append(orderid).append(","));
        orderIdSb.deleteCharAt(orderIdSb.lastIndexOf(","));
        System.out.println(orderIdSb.toString());



    }

    /**
     * -> lambda 操作符
     * 左边参数列表
     * 右边功能实现
     */

    /**
     * 方式一: 无参数 无返回值
     * () -> System.out.println("dddd")
     */
    @Test
    public void test2(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("传统写法");
            }
        };
        runnable.run();

        System.out.println("============");
        Runnable r = () -> System.out.println("lambda express");
        r.run();
    }
    /**
     * 有一个参数 无返回值
     *
     */
    @Test
    public void test3(){
        Consumer<String> consumer = (p) -> System.out.println(p);
        consumer.accept("ddddd");
    }


    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("dd");
        list.add("aa");
        list.add("dd");
        list.add("aa");
        list.add("aa");
        List<String> psIdList =list.stream().distinct().collect(Collectors.toList());
        StringBuffer psIdSb=new StringBuffer("(");
        for (int i = 0; i < psIdList.size() ; i++) {
            psIdSb.append(psIdList.get(i));
            psIdSb.append(",");
        }
        System.out.println(psIdSb.toString());
        psIdSb.deleteCharAt(psIdSb.lastIndexOf(","));
        psIdSb.append(")");
        System.out.println(psIdSb.toString());
    }

}
