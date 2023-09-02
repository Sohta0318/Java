public class Item {
    private String name;
    private String type;
    private double price;
    private String size = "MEDIUM";

    public Item(String name, String type, double price) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.price = price;
    }

    public String getName() {
        if (type.equals("SIDE") || type.equals("DRINK")) {
            return size + " " + name;
        }
        return name;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice() {
        return switch (size) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size;
    }

    public static void printItem(String name, double price) {
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }
}

class Burger extends Item {
    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String name, double price) {
        super(name, "Burger", price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice() + ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) + ((extra2 == null) ? 0 : extra2.getAdjustedPrice()) + ((extra3 == null) ? 0 : extra3.getAdjustedPrice());
    }

    public double getExtraTopping(String toppingName) {
        return switch (toppingName.toUpperCase()) {
            case "AVOCADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }

    public void addToppings(String extra1, String extra2, String extra3) {
        this.extra1 = new Item(extra1, "TOPPING", getExtraTopping(extra1));
        this.extra2 = new Item(extra2, "TOPPING", getExtraTopping(extra2));
        this.extra3 = new Item(extra3, "TOPPING", getExtraTopping(extra3));
    }

    public void printItemizedList() {
        printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }
        if (extra2 != null) {
            extra2.printItem();
        }
        if (extra3 != null) {
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}

class MealOrder {
    private Burger burger;
    private Item drink;
    private Item side;
    public MealOrder(){
        this("regular", "coke", "fries");
    }

    public MealOrder(String burgerType, String drinkType, String sideType) {
        if(burgerType.equalsIgnoreCase("deluxe")){
            this.burger = new DeluxeBurger(burgerType, 8.5);
        }else {
            this.burger = new Burger(burgerType, 4.0);
        }
            this.drink = new Item(drinkType, "drink", 1.00);
            this.side = new Item(sideType, "side", 1.50);

    }

    public double getTotalPrice(){
        if(burger instanceof DeluxeBurger){
            return burger.getAdjustedPrice();
        }
        return side.getAdjustedPrice() + drink.getAdjustedPrice() + burger.getAdjustedPrice();
    }


    public void printItemizedList() {
        burger.printItem();
        if(burger instanceof DeluxeBurger){
            Item.printItem(drink.getName(), 0);
            Item.printItem(side.getName(), 0);
        }else {
            drink.printItem();
            side.printItem();
        }
System.out.println("-".repeat(30));
Item.printItem("TOTAL PRICE", getTotalPrice());
    }
    public void addBurgerToppings(String extra1, String extra2, String extra3){
        burger.addToppings(extra1,extra2,extra3);
    }
    public void addBurgerToppings(String extra1, String extra2, String extra3, String extra4, String extra5){
        if(burger instanceof DeluxeBurger db){
            db.addToppings(extra1, extra2, extra3, extra4,extra5);
        }else {
            burger.addToppings(extra1, extra2, extra3);
        }
    }
    public void setDrinkSize(String size){
        drink.setSize(size);
    }
}

class DeluxeBurger extends Burger{
    Item deluxe1;
    Item deluxe2;

    public DeluxeBurger(String name, double price) {
        super(name, price);
    }

    public void addToppings(String extra1, String extra2, String extra3, String extra4, String extra5) {
        super.addToppings(extra1, extra2, extra3);
        this.deluxe1 = new Item("TOPPING", extra1, 0.0);
        this.deluxe2 = new Item("TOPPING", extra5, 0.0);
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if(deluxe1 != null){
            deluxe1.printItem();
        }
        if(deluxe2 != null){
            deluxe2.printItem();
        }
    }

    @Override
    public double getExtraTopping(String toppingName) {
        return 0;
    }
}
