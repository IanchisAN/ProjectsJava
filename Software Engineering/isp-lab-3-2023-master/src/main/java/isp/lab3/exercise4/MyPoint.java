package isp.lab3.exercise4;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MyPoint {
    private int x, y, z;

    public MyPoint(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public MyPoint(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public void setZ(int z){
        this.z = z;
    }
    public int getZ(){
        return z;
    }
    public void setXYZ(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }
    public double distance(int x, int y, int z){
        double dist;
        dist = sqrt(pow((this.getX() - x), 2) + pow((this.getY() - y), 2) + pow((this.getZ() - z), 2));
        return dist;
    }
    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY(), another.getZ());
    }
    public static void main(String[] args){
        MyPoint p1 = new MyPoint(1,2,-5);
        MyPoint p2 = new MyPoint(4,6,7);

        double distance = p1.distance(p2);
        System.out.println("The distance between " + p1 + " and " + p2 + " is " + distance);
    }
}
