package com.suma;

import com.suma.supermarket.LittleSuperMarket;
import com.suma.supermarket.Merchandise;
import com.suma.supermarket.PhoneMerchandise;
import com.suma.supermarket.ShellColorChangePhone;

public class ObjectEqualsAppMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号","大卖场",500);

        Merchandise t0 = new Merchandise(200, "ID" + 0, "商品" + 0,
                Math.random() * 200, (1 + Math.random()) * 200);

        PhoneMerchandise t10 = new PhoneMerchandise(200, "ID" + 10, "商品" + 10, 999, 1999,
                4.5, 2100, 8, 512, "SAMSUNG",
                "Android");

        ShellColorChangePhone t100 = new ShellColorChangePhone(
                200, "ID" + 100, "商品" + 100, 999, 1999,
                4.5, 2100, 8, 512, "XIAOMI",
                "Android", true);

        System.out.println(superMarket.findMerchandise(t0));
        System.out.println(superMarket.findMerchandise(t10));
        System.out.println(superMarket.findMerchandise(t100));
    }
}
