package com.suma.supermarket;

public class Phone {
    public static void main(String[] args) {
        PhoneMerchandise phoneMerchandise = new PhoneMerchandise(200,"999","手机",1499,1999,5.5,2100,12,512,"三星","Android");
        phoneMerchandise.describe();
        System.out.println("\n");
        String name = phoneMerchandise.getName();
        System.out.println(phoneMerchandise.getCount());
        System.out.println(name);
        System.out.println(phoneMerchandise.buy(6));
    }
}
