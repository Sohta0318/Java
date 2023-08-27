public class Main {
    public static void main(String[] args) {
//        Car car = null; // = new Car();
        Car car = new Car();
//        car.make = "Porsche";
        car.setMake("Porsche");
//        car.setMake("Maserati");
//        car.model = "Carrera";
        car.setModel("Carrera");
//        car.color = "Red";
        car.setColor("black");
        car.setDoors(2);
        car.setConvertible(true);
        System.out.println("make = " + car.getMake());
        System.out.println("model = " + car.getModel());
        car.describeCar();

        Car targa = new Car();
        targa.setMake("Porsche");
        targa.setModel("Carrera");
        targa.setDoors(2);
        targa.setConvertible(false);
        targa.setColor("red");

        targa.describeCar();
    }
}
