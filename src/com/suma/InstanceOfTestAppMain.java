package com.suma;

import com.suma.supermarket.LittleSuperMarket;
import com.suma.supermarket.Merchandise;
import com.suma.supermarket.PhoneMerchandise;

public class InstanceOfTestAppMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号", "大卖场", 500);

        // >> TODO instanceof 操作符可以判断一个引用指向的对象是否是某一个类型或者子类
        //    TODO 是返回true,否则返回false
        for (int i = 0; i < superMarket.merchandises.length; i++) {
            Merchandise m = superMarket.getMerchandiseOf(i);
            if (m instanceof PhoneMerchandise) {
                PhoneMerchandise ph = (PhoneMerchandise) m;
                System.out.println(ph.getBrand());
            }
        }
        // >> TODO 如果引用是null,则肯定返回false

    }
}
