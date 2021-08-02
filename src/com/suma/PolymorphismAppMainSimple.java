package com.suma;

import com.suma.supermarket.LittleSuperMarket;
import com.suma.supermarket.Merchandise;
import com.suma.supermarket.PhoneMerchandise;

public class PolymorphismAppMainSimple {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号","大卖场",500);
        // >> TODO 虽然是用父类的引用指向不同类型的对象,调用getName方法时,实际执行的方法取决于对象的类型,而非引用的类型
        // >> TODO 也就是说,能调用哪些方法,是引用决定的,具体执行哪个方法是引用指向的对象决定的
        //    TODO 这就是覆盖的精髓 覆盖是多态的一种,是最重要的一种
        System.out.println(superMarket.getMerchandiseOf(0).getName());
        System.out.println(superMarket.getMerchandiseOf(10).getName());
        System.out.println(superMarket.getMerchandiseOf(100).getName());

        // >> TODO 如果子类里没有覆盖这个方法,就去父类里找,父类里没有就去父类的父类找,反正只要能让一个引用指向这个对象

    }
}
