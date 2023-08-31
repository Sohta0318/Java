public class Fish extends Animal{
    private int gills;
    private int fins;

    public Fish(String type, double weight, int gills, int fins) {
        super(type, "small", weight);
        this.gills = gills;
        this.fins = fins;
    }
    public void moveMuscle(){
        System.out.println("muscles moving ");
    }
    public void moveBackFin(){
        System.out.println("backFin moving ");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscle();
        if(speed == "fast"){
            moveBackFin();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }
}
