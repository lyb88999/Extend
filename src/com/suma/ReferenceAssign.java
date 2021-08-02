package com.suma;
import com.suma.supermarket.*;

public class ReferenceAssign {
    public static void main(String[] args) {
        PhoneMerchandise  ph = new PhoneMerchandise(200,"Phone001","红米k40",
                1799,1999,6.5,2100,
                12,512,"XIAOMI","Android");

        // >> TODO 可以用子类的引用给父类的引用赋值，也就是说父类的引用可以指向子类的对象，反之不行

        Merchandise m  = ph;
        Merchandise  m2 = new PhoneMerchandise(200,"Phone001","红米k50",
                1799,1999,6.5,2100,
                12,512,"XIAOMI","Android");

        // >> TODO                     重点
        // >> TODO 因为子类继承了父类的方法和属性,所以父类的对象能做到的,子类对象肯定能做到
        //    TODO 换句话说,我们可以在子类的对象上,执行父类的方法
        // >> TODO 当父类的引用指向子类的实例,只能通过父类的引用,像父类一样操作子类的对象
        // >> TODO 引用的类型决定了能执行哪些操作

        System.out.println(ph.getBrand());
        // m.getBrand();  wrong!

        // >> TODO 确定的情况下可以进行强制类型转换
        PhoneMerchandise aPhone = (PhoneMerchandise)m;
        System.out.println(aPhone.getBrand());

    }


}
