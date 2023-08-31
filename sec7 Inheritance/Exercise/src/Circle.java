public class Circle {
    public double radius;

    public Circle(double radius){
        this.radius = radius < 0 ? 0 :radius;
    }

    public double getRadius(){
       return radius;
    }
    public double getArea(){
        return getRadius() * getRadius() * Math.PI;
    }
}
