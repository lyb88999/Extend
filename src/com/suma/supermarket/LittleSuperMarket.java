package com.suma.supermarket;

import com.suma.person.Customer;

import java.util.Arrays;
import java.util.Scanner;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;

    @Override
    public String toString() {
        return "LittleSuperMarket{" +
                "superMarketName='" + superMarketName + '\'' +
                ", address='" + address + '\'' +
                ", parkingCount=" + parkingCount +
                ", incomingSum=" + incomingSum +
                ", merchandises=" + Arrays.toString(merchandises) +
                ", merchandiseSold=" + Arrays.toString(merchandiseSold) +
                '}';
    }

    // >> TODO 构造方法和类同名，且无返回值，构造方法无法被点操作符或在普通方法里调用
    public LittleSuperMarket(String address, String superMarketName, int parkingCount) {
        this.address = address;
        this.superMarketName = superMarketName;
        this.parkingCount = parkingCount;
        this.merchandises = new Merchandise[200];
        this.merchandiseSold = new int[this.merchandises.length];
        Merchandise[] all = this.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = null;
            if (i > 0 && i % 100 == 0) {
                m = new ShellColorChangePhone(
                        200, "ID" + i, "商品" + i, 999, 1999,
                        4.5, 2100, 8, 512, "XIAOMI",
                        "Android", true);
            } else if (i > 0 && i % 10 == 0) {
                m = new PhoneMerchandise(200, "ID" + i, "商品" + i, 999, 1999,
                        4.5, 2100, 8, 512, "SAMSUNG",
                        "Android");
            } else {
                m = new Merchandise(200, "ID" + i, "商品" + i,
                        Math.random() * 200, (1 + Math.random()) * 200);
            }
            all[i] = m;
        }
    }

    public void run() {
        Merchandise[] all = this.merchandises;
        System.out.println("超市开门啦!");
        boolean open = true;
        Scanner scanner = new Scanner(System.in);
        while (open) {
            System.out.println("本店名为:" + this.superMarketName);
            System.out.println("本店地址:" + this.address);
            System.out.println("共有停车位:" + this.parkingCount + "个");
            System.out.println("今天的营业额为:" + this.incomingSum);
            System.out.println("共有商品:" + this.merchandises.length + "种");

            Customer customer = new Customer();
            customer.name = "顾客编号" + (int) (Math.random() * 1000);
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;
            if (customer.isDrivingCar) {
                if (this.parkingCount > 0) {
                    this.parkingCount--;
                    System.out.println("欢迎" + customer.name + "驾车而来，本店为您安排了车位，停车免费");
                } else {
                    System.out.println("不好意思，车位已满，欢迎下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }
            double totalCost = 0;
            while (true) {
                System.out.println("本次您共带了" + customer.money + "元 欢迎选购👏");
                System.out.println("本店提供" + all.length + "种商品，欢迎选购。请输入商品编号");
                int index = scanner.nextInt();
                if (index < 0) {
                    break;
                }
                if (index >= all.length) {
                    System.out.println("本店没有这种商品,请输入编号在0到" + (all.length - 1) + "之内的商品编号");
                    continue;
                }
                Merchandise m = all[index];
                //m.describe();
                System.out.println("您选购的商品名字是:" + m.getName() + ",单价是:" + m.getSoldPrice() + "。请问您要购买多少个?");
                int numToBuy = scanner.nextInt();
                if (numToBuy <= 0) {
                    System.out.println("不买看看也好,欢迎继续挑选");
                    continue;
                }
                if (numToBuy > m.getCount()) {
                    System.out.println("本店此商品库存没有这么多，欢迎继续挑选");
                    continue;
                }
                if (numToBuy * m.getSoldPrice() + totalCost > customer.money) {
                    System.out.println("您带的钱不够，欢迎继续挑选");
                    continue;
                }
                totalCost += numToBuy * m.getSoldPrice();
                m.setCount(m.getCount() - numToBuy);
                this.merchandiseSold[index] += numToBuy;
            }
            customer.money -= totalCost;
            if (customer.isDrivingCar) {
                this.parkingCount++;
            }
            System.out.println("顾客" + customer.name + "共消费了" + totalCost + "元");
            this.incomingSum += totalCost;
            System.out.println("还需要营业吗？");
            open = scanner.nextBoolean();
        }
        System.out.println("超市关门了！");
        System.out.println("今天总的营业额为" + this.incomingSum + "营业情况如下:");
        for (int i = 0; i < this.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = this.merchandiseSold[i];
            if (numSold > 0) {
                double incoming = m.getSoldPrice() * numSold;
                double netIncoming = (m.getSoldPrice() - m.getPurchasePrise()) * numSold;
                System.out.println(m.getName() + "售出了" + numSold + "个;" + "销售额为:" + incoming + "净收入为:" + netIncoming);
            }
        }
    }

    public Merchandise getBiggestProfitMerchandise() {
        Merchandise curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null) {
                curr = m;
            } else {
                if (curr.calculateProfit() < m.calculateProfit()) {
                    curr = m;
                }
            }
        }
        return curr;
    }

    public Merchandise getMerchandiseOf(int MerchandiseIndex) {
        return merchandises[MerchandiseIndex];
    }

    public boolean findMerchandise(Merchandise target) {
        int i = 0;
        for (Merchandise m : merchandises) {
            boolean match = m.equals(target);
            if (match) {
                System.out.println("找到了商品,位置在" + i);
                return true;
            }
            i++;
        }
        return false;
    }
}


