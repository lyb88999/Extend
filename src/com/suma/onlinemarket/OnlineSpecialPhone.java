package com.suma.onlinemarket;

import com.suma.supermarket.*;

public class OnlineSpecialPhone extends PhoneMerchandise{
    public OnlineSpecialPhone(int count, String id, String name, double purchasePrise, double soldPrice, double screenSize, double cpuHZ, int memoryG, int storage, String brand, String os) {
        super(count, id, name, purchasePrise, soldPrice, screenSize, cpuHZ, memoryG, storage, brand, os);
        this.screenSize = 6;
        this.cpuHZ = 2100;
        // >> TODO 子类覆盖父类的方法,不可以用可见性更低的修饰符,但是可以用更高的修饰符
        // >> TODO protected -> private wrong!
    }
}
