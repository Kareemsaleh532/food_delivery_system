public abstract class MenuItem {
    protected final String name;
    protected final double basePrice;

    public MenuItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double calculatePrice();

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
