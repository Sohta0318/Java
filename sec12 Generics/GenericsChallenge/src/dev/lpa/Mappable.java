package dev.lpa;

import java.util.Arrays;
import java.util.List;

public interface Mappable {
    static double[] stringToLatLon(String location){
var splits = location.split(",");
double lat = Double.valueOf(splits[0]);
double lng = Double.valueOf(splits[1]);
return new double[]{lat, lng};
    }
    void render();
}

abstract class Point implements Mappable{
    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    private String location(){
return Arrays.toString(location);
    };
    @Override
    public void render() {
System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

}

abstract class Line implements Mappable{
    private double[][] locations;

    public Line(String ...locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for(var l : locations){
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

    private String locations(){
return Arrays.deepToString(locations);
    };

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");

    }
}


