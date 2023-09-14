public class AreaCalculator {
    public static void main(String[] args) {
double circle = area(3.24);
double rectangle = area(1.2,1.4);
System.out.println(circle);
System.out.println(rectangle);
    }

    public static double area(double radius){
        if(radius < 0){
            return -1.0;
        }
return radius * radius * Math.PI;
    }

    public static double area(double x, double y){
        if(x < 0 || y < 0){
            return -1.0;
        }
        return x * y;
    }
}
