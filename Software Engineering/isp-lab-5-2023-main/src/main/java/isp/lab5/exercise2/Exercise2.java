package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {


        Laptop laptop = new Laptop(30);
        System.out.println(laptop.getBatteryLevel());
        laptop.charge(60);
        System.out.println(laptop.getBatteryLevel());

        SmartPhone smartPhone = new SmartPhone(90);
        smartPhone.charge(60);
        System.out.println(smartPhone.getBatteryLevel());

        SmartWatch smartWatch = new SmartWatch(98);
        smartWatch.charge(20);
        System.out.println(smartWatch.getBatteryLevel());

    }
}
