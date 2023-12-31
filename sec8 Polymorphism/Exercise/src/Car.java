public class Car {
    public static void main(String[] args) {
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }
    private boolean engine = true;
    private int cylinders;
    private String name;
    private int wheels = 4;
    public Car(int cylinders, String name){
        this.cylinders = cylinders;
        this.name = name;
    }
    public String  startEngine(){
        return this.getClass().getSimpleName() + " -> startEngine()";
    }
    public String accelerate(){
        return this.getClass().getSimpleName() +" -> accelerate()";
    }
    public String brake(){
        return this.getClass().getSimpleName() +" -> break()";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

//    @Override
//    public String startEngine() {
//        return super.startEngine();
//    }
//
//    @Override
//    public String accelerate() {
//        return super.accelerate();
//    }
//
//    @Override
//    public String brake() {
//        return super.brake();
//    }
}

class Holden extends Car{
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

//    @Override
//    public String startEngine() {
//        return super.startEngine();
//    }
//
//    @Override
//    public String accelerate() {
//        return super.accelerate();
//    }
//
//    @Override
//    public String brake() {
//        return super.brake();
//    }
}

class Ford extends Car{
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

//    @Override
//    public String startEngine() {
//        return super.startEngine();
//    }
//
//    @Override
//    public String accelerate() {
//        return super.accelerate();
//    }
//
//    @Override
//    public String brake() {
//        return super.brake();
//    }
}



