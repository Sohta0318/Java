public class SmartKitchen {
    private CoffeeMaker brewCoffee;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(){
        this.brewCoffee = new CoffeeMaker();
        this.dishWasher = new DishWasher();
        this.iceBox = new Refrigerator();
    }

    public void setKitchenState(boolean coffeeFlag, boolean fridgeFlag, boolean dishWasherFlag){
        brewCoffee.setHasWorkToDo(coffeeFlag);
        iceBox.setHasWorkToDo(fridgeFlag);
        dishWasher.setHasWorkToDo(dishWasherFlag);
    }
    public void doKitchenWork(){
        brewCoffee.brewCoffee();
        iceBox.orderFood();
        dishWasher.doDished();
    }
}
class CoffeeMaker {
    private boolean hasWorkToDo;
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void brewCoffee(){
        if(hasWorkToDo){
            System.out.println("Refrigerator's work done");
            hasWorkToDo = false;
        }
    }
}
class Refrigerator {
    private boolean hasWorkToDo;
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void orderFood(){
        if(hasWorkToDo){
            System.out.println("Refrigerator's work done");
            hasWorkToDo = false;
        }
    }
}
class DishWasher {
    private boolean hasWorkToDo;
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void doDished(){
        if(hasWorkToDo){
            System.out.println("Refrigerator's work done");
            hasWorkToDo = false;
        }
    }

}


