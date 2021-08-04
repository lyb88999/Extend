package com.suma.supermarket;

// >> TODO enum继承自enum类,故不能再继承其他类
public enum Category {

    // >> TODO 必须在开始的时候以这种形式,创建所有的枚举对象
    FOOD(1),
    COOK(3),
    SNACK(5),
    CLOTHES(7),
    ELECTRIC(9);

    // >> TODO 可以有属性
    private int id;

    // >> TODO 构造方法必须是private的,不写也是private的,因为其有几个对象已经被枚举好了,不能在外变调用构造方法了

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }
}

