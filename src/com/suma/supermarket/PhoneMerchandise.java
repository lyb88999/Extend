package com.suma.supermarket;

// >> TODO 子类对象里藏着一个父类对象
// >> TODO 理解组合和继承的区别
// >> TODO 继承不只是为了简单地拿来父类的属性和方法!

// >> TODO 若用final修饰类,则该类不能被继承
public class PhoneMerchandise extends Merchandise {

    // >> TODO protected访问修饰符相当于包内可见,子类可见,即 default+对子类可见

    // >> TODO 若用final修饰成员变量,则该成员变量必须被赋值且只能被赋值一次
    protected double screenSize;
    protected double cpuHZ;
    private int memoryG;
    private int storage;
    private String brand;
    private String os;

    // >> TODO 若用final修饰静态变量,则该成员变量必须被赋值且只能被赋值一次


    // >> TODO 构造方法不能用final修饰
    public PhoneMerchandise(int count, String id, String name, double purchasePrise, double soldPrice, double screenSize, double cpuHZ, int memoryG, int storage, String brand, String os) {
        // >> TODO 使用super调用父类的构造方法,必须是子类的第一个语句
        // >> TODO 可以使用表达式
        // >> TODO super调用构造方法,不可以使用super访问父类的属性和方法,不可以使用子类的成员变量和方法
        // >> TODO 可以使用静态变量和方法
        // >> TODO 都是<init>方法
        super(count, id, name, purchasePrise, soldPrice);
        this.screenSize = screenSize;
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storage = storage;
        this.brand = brand;
        this.os = os;

        this.setCount(count);
        this.setId(id);
        this.setName(name);
        this.setPurchasePrise(purchasePrise);
        this.setSoldPrice(soldPrice);
    }

    // >> TODO super是子类和父类沟通的桥梁,但并不是父类的引用
    // >> TODO 所以,super和this自引用不一样,不是简单可模拟的 使用super必须有.操作符

    // >> TODO 覆盖(override) 子类通过覆盖替换其中不适合子类的方法(继承的终极奥义)


    // >> TODO final修饰形参或局部变量则其不能再二次赋值
    public double buy(int count) {
        if (count > MAX_BUY_ONE_ORDER) {
            System.out.println("购买失败,手机一次最多只能买" + MAX_BUY_ONE_ORDER);
            return -2;
        }
        return super.buy(count);
    }

    // >> TODO final修饰方法,则方法不能被覆盖
    public void describe() {
        System.out.println("此手机商品属性如下:");
        super.describe();
        System.out.println("手机厂商为:" + brand + "系统为:" + os + "硬件配置如下:" +
                "屏幕" + screenSize + "寸\n" +
                "cpu主频:" + cpuHZ + "GHz\n" +
                "内存" + memoryG + "Gb\n" +
                "存储空间" + storage + "Gb");
    }
    // >> TODO final修饰引用(***)注意理解

    public double getScreenSize() {
        return screenSize;
    }

    public double getCpuHZ() {
        return cpuHZ;
    }

    public int getMemoryG() {
        return memoryG;
    }

    public int getStorage() {
        return storage;
    }

    public String getBrand() {
        return brand;
    }

    public String getOs() {
        return os;
    }

    public String getName() {
        return this.brand + ":" + this.os + ":" + super.getName();
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setCpuHZ(double cpuHZ) {
        this.cpuHZ = cpuHZ;
    }

    public void setMemoryG(int memoryG) {
        this.memoryG = memoryG;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
