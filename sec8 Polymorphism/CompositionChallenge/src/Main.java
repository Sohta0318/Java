public class Main {
    public static void main(String[] args) {
SmartKitchen kitchen = new SmartKitchen();

//kitchen.getDishWasher().setHasWorkToDo(true);
//kitchen.getBrewCoffee().setHasWorkToDo(true);
//kitchen.getIceBox().setHasWorkToDo(true);
//
//kitchen.getDishWasher().doDished();
//kitchen.getBrewCoffee().brewCoffee();
//kitchen.getIceBox().orderFood();

        kitchen.setKitchenState(true,true,true);
        kitchen.doKitchenWork();
    }
}
