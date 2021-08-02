package com.suma.supermarket;

public class ShellColorChangePhone extends PhoneMerchandise {
    private boolean enableShellColorChange;

    public ShellColorChangePhone(int count, String id, String name, double purchasePrise, double soldPrice, double screenSize, double cpuHZ, int memoryG, int storage, String brand, String os, boolean enableShellColorChange) {
        super(count, id, name, purchasePrise, soldPrice, screenSize, cpuHZ, memoryG, storage, brand, os);
        this.enableShellColorChange = enableShellColorChange;
    }

    public boolean isEnableShellColorChange() {
        return enableShellColorChange;
    }

    public void setEnableShellColorChange(boolean enableShellColorChange) {
        this.enableShellColorChange = enableShellColorChange;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("壳色随着屏幕色变的功能开启状态" + enableShellColorChange);
    }

    @Override
    public double calculateProfit() {
        // TODO 厂家提供10个点的返点
        return super.calculateProfit() + super.getPurchasePrise() * 0.1;
    }
}
