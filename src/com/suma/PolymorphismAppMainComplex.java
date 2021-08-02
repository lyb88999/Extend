package com.suma;

import com.suma.supermarket.LittleSuperMarket;

public class PolymorphismAppMainComplex {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号","大卖场",500);
        superMarket.getMerchandiseOf(0).describe();
        System.out.println();
        superMarket.getMerchandiseOf(10).describe();
        System.out.println();
        superMarket.getMerchandiseOf(100).describe();

        // >> TODO 总结:无论一个方法是使用哪个引用被调用的,"它都是在实际的对象上执行的",执行的任何一个方法,都是这个对象所属的类的方法
        //    TODO 如果没有,就去父类找,再没有就依次往上找
    }
}
