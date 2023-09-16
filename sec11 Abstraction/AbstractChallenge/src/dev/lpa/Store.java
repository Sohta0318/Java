package dev.lpa;

import java.util.ArrayList;

public class Store {
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting", 1350, "Impressionistic work by ABF painted in 2010"));
        storeProducts.add(new ArtObject("Sculpture", 2000, "Bronze work by JFK, produced in 1950"));

        storeProducts.add(new Furniture("Desk", 500, "Mahogany Desk"));
        storeProducts.add(new Furniture("Lamp", 200, "Tiffany Lamp with Hummingbirds"));


        listProducts();

        System.out.println("\n Order1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1,1,2);
        addItemToOrder(order1,0,1);
        printOrder(order1);

        System.out.println("\n Order1");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2,3,5);
        addItemToOrder(order2,0,1);
        addItemToOrder(order2,2,1);
        printOrder(order2);

    }
    public static void listProducts(){
for(var item :storeProducts ){
    System.out.println("-".repeat(30));
    item.showDetails();
}
    }
    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }
    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for (var item: order){
            item.product().printPricedItem(item.quantity());
            salesTotal += item.product().getSalesPrice(item.quantity());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}

abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public void printPricedItem(int quantity) {
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n", quantity, price, type, description);
    }

    abstract void showDetails();
}

record OrderItem(int quantity, ProductForSale product) {
}
