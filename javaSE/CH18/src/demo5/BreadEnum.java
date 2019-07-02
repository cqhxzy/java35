package demo5;

/**
 * 面包的枚举
 */
public enum BreadEnum {
    BreadWithMeat("肉松面包",10),
    BreadWithFruit("水果面包",8),
    Toast("吐司面包",12),
    BreadWithMilk("奶油面包",5);
    private String name;//面包名称
    private double price;//面包的指导价格

    BreadEnum(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
