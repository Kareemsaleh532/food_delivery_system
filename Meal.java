public class Meal extends MenuItem {
    private final int extraToppingsCount;

    public Meal(String name, double basePrice, int extraToppingsCount) {
        super(name, basePrice);
        this.extraToppingsCount = extraToppingsCount;
    }

    @Override
    public double calculatePrice() {
        return basePrice + (extraToppingsCount * 1.5);
    }
}
