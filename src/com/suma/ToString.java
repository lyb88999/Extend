package com.suma;

import com.suma.supermarket.LittleSuperMarket;

public class ToString {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("世纪大道1号", "大卖场", 500);
        System.out.println(superMarket.toString());
    }
}
