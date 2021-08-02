package com.suma;

import com.suma.supermarket.*;

public class OverloadTestAppMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号", "大卖场", 500);

        Merchandise m = superMarket.getMerchandiseOf(100);

        MerchandiseTest merchandiseTest = new MerchandiseTest();

        System.out.println("--------1---------");
        // >> TODO 重载调用哪个方法,和参数的引用类型相关,和引用实际指向的类型无关
        merchandiseTest.testMerchandiseOverload(m);
        merchandiseTest.testMerchandiseOverload((PhoneMerchandise) m);
        merchandiseTest.testMerchandiseOverload((ShellColorChangePhone) m);

        merchandiseTest.testMerchandiseOverload("hello");
        // >> TODO 确定调用哪个方法只需要引用的类型,这叫做静态多态,即在编译期就知道该调用哪个方法
        System.out.println("--------2---------");
        m = null;
        merchandiseTest.testMerchandiseOverload(m);
        merchandiseTest.testMerchandiseOverload((PhoneMerchandise) m);
        merchandiseTest.testMerchandiseOverload((ShellColorChangePhone) m);

        // >> TODO 如果引用类型没有完全匹配的,则会根据继承关系,沿着参数当前类型,向父类找
        System.out.println("--------3---------");
        merchandiseTest.testMerchandiseOverloadNotExactlyMatchType((ShellColorChangePhone) m);

        // >> TODO 重载总结:静态多态,调用的方法和参数实际指向的对象无关,只和引用本身的类型有关
        // >> TODO 因为调用时参数类型是确定的,所以在编译期间就可以明确地知道哪个方法会被调用
        // >> TODO 如果没有类型完全匹配的候选,则根据类型的继承关系向父类开始找,找到最贴近参数类型的那个方法
        // >> TODO 无论是静态方法,还是成员方法,重载寻找方法的顺序是一样的

        // >> TODO 动态多态:覆盖 能调用哪些方法,是引用决定的,具体执行哪个方法是引用指向的对象决定的
    }
}
