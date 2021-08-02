package com.suma;

import com.suma.supermarket.*;

public class RunLittleSuperMarket {
    public static void main(String[] args) {
        LittleSuperMarket littlesupermarket = new LittleSuperMarket("世纪大道666号", "有家超市", 200);
        littlesupermarket.run();
    }
}










/**
 * 测试方法重载
 *         double cost = littlesupermarket.merchandises[1].buy();
 *         System.out.println(cost);
 *         littlesupermarket.merchandises[1].describe();
 *         littlesupermarket.merchandises[1].buy(2);
 *         cost = littlesupermarket.merchandises[1].buy(2);
 *         System.out.println(cost);
 *         littlesupermarket.merchandises[1].describe();
 *         littlesupermarket.merchandises[1].buy(2,true);
 *         cost = littlesupermarket.merchandises[1].buy(2,true);
 *         System.out.println(cost);
 *         littlesupermarket.merchandises[1].describe();
 */


/**
 * 最大利润商品
 *         Merchandise m = littlesupermarket.getBiggestProfitMerchandise();
 *         m.describe();
 *         littlesupermarket.getBiggestProfitMerchandise().describe();
 */
