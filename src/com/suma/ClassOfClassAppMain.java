package com.suma;

import com.suma.supermarket.LittleSuperMarket;
import com.suma.supermarket.Merchandise;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// >> TODO 变长参数
public class ClassOfClassAppMain {
    public static void dyncArgs(int a, String... args){}


    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号", "大卖场", 500);
        Merchandise m100 = superMarket.getMerchandiseOf(100);

        //object类里的getClass方法可以得到一个Class类
        Class clazz = m100.getClass();

        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        // >> TODO 通过一个类的Class实例,可以获取一个类的所有的信息,包括成员变量、方法等
        //Field countField = clazz.getField("name");
        //System.out.println(countField.getType());

        // >> TODO 变长参数的调用
        dyncArgs(1);
        dyncArgs(1, "abc", "bbb", "ccc");

        // >> TODO 变长参数和它的等价形式
        Method equalsMethod = clazz.getMethod("buy", int.class, boolean.class);
        System.out.println(equalsMethod.getParameters());


    }
}
