package com.suma;

import com.suma.supermarket.LittleSuperMarket;
import com.suma.supermarket.Merchandise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAppMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号", "大卖场", 500);
        Merchandise m100 = superMarket.getMerchandiseOf(100);

        // >> TODO 另一种获得Class实例的方法,直接类名点
        Class clazz = Merchandise.class;

        // >> TODO 利用反射获取变量的值
        //Field countField = clazz.getField("count");
        //System.out.println(countField.get(m100));
        //System.out.println(m100.getCount());
        //countField.set(m100,999);

        // >> TODO 利用反射获取静态变量的值
        Field field = clazz.getField("DISCOUNT_FOR_VIP");
        System.out.println(field.get(null));

        printField(clazz);

        // >> TODO 利用反射调用方法
        Method desMethod = clazz.getMethod("describe");
        desMethod.invoke(superMarket.getMerchandiseOf(100));
        // m100.describe();
        // 符合多态的性质

        // >> TODO 利用反射调用静态方法
        Method StaticGetNameMethod = clazz.getMethod("getNameOf", Merchandise.class);
        String str = (String)StaticGetNameMethod.invoke(null,superMarket.getMerchandiseOf(10));
        // >> TODO 这里返回值是一个Object 利用强制类型转换将其转化为String
        System.out.println(str);

        // >> TODO test
        Method BuyMethod = clazz.getMethod("buy", int.class);
        BuyMethod.invoke(m100,10);
    }

    public static void printField(Class clazz){
        System.out.println(clazz.getName()+"里的field");
        for (Field field : clazz.getFields()) {
            System.out.println(field.getType() + " " + field.getName());
        }
    }
}
