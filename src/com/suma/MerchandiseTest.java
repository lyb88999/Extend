package com.suma;

import com.suma.supermarket.Merchandise;
import com.suma.supermarket.PhoneMerchandise;
import com.suma.supermarket.ShellColorChangePhone;

public class MerchandiseTest {
    // >> TODO 之前重载的时候,参数是用的自定义类型,现在理解了父类和子类的引用赋值关系,重载又多了一层复杂性

    public void testMerchandiseOverload(Merchandise me){
        System.out.println("参数为Merchandise的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(PhoneMerchandise ph){
        System.out.println("参数为PhoneMerchandise的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(ShellColorChangePhone shellColorChangePhone){
        System.out.println("参数为ShellColorChangePhone的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(String str){
        System.out.println("参数为str的testMerchandiseOverload 被调用了");
    }
    public void testMerchandiseOverloadNotExactlyMatchType(Merchandise me){
        System.out.println("参数为Merchandise的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }


    public void testMerchandiseOverloadNotExactlyMatchType(PhoneMerchandise ph){
        System.out.println("参数为PhoneMerchandise的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }


    public void testMerchandiseOverloadNotExactlyMatchType(String str){
        System.out.println("参数为string的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }

}
