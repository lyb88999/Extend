package com.suma.supermarket;

import java.util.Objects;

public class Merchandise {
    private String name;
    private String id;
    private int count;
    private double soldPrice;
    private double purchasePrise;

    // >> TODO 静态变量使用 static 修饰符
    // >> TODO 静态变量如果不赋值，Java也会给它赋以其类型的初始值
    // >> TODO 静态变量一般使用全大写字母加下划线分割
    // >> TODO 所有代码都可以使用静态变量(类变量)

    public static double DISCOUNT_FOR_VIP = 0.8;
    public static int MAX_BUY_ONE_ORDER = 5;

    // >> TODO 除了没有this,静态方法的定义和成员方法一样,也有方法名,返回值和参数
    // >> TODO 静态方法没有this自引用,它不属于某个实例,调用的时候也无需引用,直接用类名调用
    // >> TODO 在静态方法里面可以自己创建对象或者通过参数获得对象的引用,进而调用方法和访问成员变量
    // >> TODO 静态方法只是没有this自引用的方法而已

    public static double getDiscountForVip(Merchandise merchandise) {
        return merchandise.DISCOUNT_FOR_VIP;
    }

    // >> TODO 静态代码块
    // >> TODO 使用某个静态变量的代码块必须在静态变量的后面
    // >> TODO 为数不多的和顺序有关的语法  clinit方法里
    static {
        DISCOUNT_FOR_VIP = 0.8;
        MAX_BUY_ONE_ORDER = 5;
    }

    // >> TODO 方法和属性的访问修饰符
    // >> TODO 可见性修饰符用在类、成员方法、构造方法、静态方法和属性上，其可见性的范围是一样的
    // >> TODO public : 全局可见 缺省 : 当前包可见 private : 当前类可见


    // >> TODO 成员变量应该都声明为private
    // >> TODO 如果要读写这些成员变量，最好使用get set方法，这些方法应该是public的
    // >> TODO 这样做的好处是，如果有需要，可以通过代码，检查每个属性值是否合法
    // >> TODO 非public的类，可以文件名和类不同名，但是不能在包外被使用


    // >> TODO hashCode 和equals是我们常覆盖的两个方法
    // >> TODO 覆盖的原则是,equal为true则hashCode就应该相等,这是一种约定俗成的规范
    // >> TODO 即equals为true是hashCode相等的充分非必要条件


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Merchandise)) return false;
        Merchandise that = (Merchandise) o;
        return getCount() == that.getCount() && Double.compare(that.getSoldPrice(), getSoldPrice()) == 0 && Double.compare(that.getPurchasePrise(), getPurchasePrise()) == 0 && getName().equals(that.getName()) && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getCount(), getSoldPrice(), getPurchasePrise());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrise() {
        return purchasePrise;
    }

    public void setPurchasePrise(double purchasePrise) {
        this.purchasePrise = purchasePrise;
    }

    public Merchandise(int count, String id, String name, double purchasePrise, double soldPrice) {
        this.count = count;
        this.id = id;
        this.name = name;
        this.purchasePrise = purchasePrise;
        this.soldPrice = soldPrice;
    }
    // >> TODO 在构造方法里才能调用重载的构造方法 语法为this(实参列表)
    // >> TODO 构造方法里不可以自己调用自己
    // >> TODO 在调用重载的构造方法时，不可以使用成员变量，因为此时对象还没有被初始化完成
    // >> TODO 在构造方法里才能调用重载的构造方法时，必须是方法的第一行，后面可以继续有代码

    /*
    public Merchandise(int count, String id, String name, double soldPrice) {
        this(count, id, name, soldPrice * 0.8, soldPrice);
    }

     */


    public void describe() {
        System.out.println("商品名是:" + name + "商品id是:" + id + "商品库存为:" + count + "商品毛利润为" + this.calculateProfit());
    }

    public double calculateProfit() {
        return soldPrice - purchasePrise;
    }

    // >> TODO 方法重载(overload)
    //    TODO 方法签名:方法名+依次参数类型 注意：返回值不属于方法签名,方法签名是一个方法在一个类中的唯一标识
    //    TODO 同一个类中方法可以重名,但是签名不可以重复 一个类中如果定义了名字相同,签名不同的方法,就叫做方法的重载


    // >> TODO 重载的方法可以调用别的重载的方法，当然也可以调用别的不重载的方法
    // >> TODO 实际上,像这种补充一些缺省的参数值,然后调用重载的方法,是重载的一个重要的使用场景

    // >> TODO 无论是否重载参数类型可以不完全匹配的规则是"实参数可以自动类型转换为形参类型"
    // >> TODO 重载的特殊之处是，参数满足自动类型转换的方法有好几个，重载的规则是选择最"近"的去调用

    public double buy() {
        return buy(1);
    }

    public double buy(int count) {
        return buy(count, false);
    }

    public double buy(int count, boolean isVIP) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * this.soldPrice;
        if (isVIP) {
            return totalCost * 0.95;
        } else {
            return totalCost;
        }
    }

    public static String getNameOf(Merchandise m){
        return m.getName();
    }
}
