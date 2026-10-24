public class Drink extends MenuItem {
    private final boolean isLarge;

    public Drink(String name, double basePrice, boolean isLarge) {
        super(name, basePrice);
        this.isLarge = isLarge;
    }

    @Override
    public double calculatePrice() {
        return isLarge ? (basePrice + 1.0) : basePrice;
    }
}
