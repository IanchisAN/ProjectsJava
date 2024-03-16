package isp.lab3.exercise2;

public class Rectangle {
    private int length;
    private int width;
    private String color;

    public Rectangle() {
        this.length = 2;
        this.width = 1;
        this.color = "red";
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.color = "red";
    }

    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public String getColor() {
        return this.color;
    }

    public int getPerimeter() {
        return 2 * (this.length + this.width);
    }

    public int getArea() {
        return this.length * this.width;
    }
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Rectangle x = new Rectangle();
        System.out.println(x.getWidth());
        System.out.println(x.getLength());
        System.out.println(x.getColor());
        System.out.println(x.getArea());
        System.out.println(x.getPerimeter());
    }

}
