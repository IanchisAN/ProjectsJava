package aut.isp.lab4.exercise2;


public class FishFeeder {
    //atributes

    private String manufacturer;
    private String model;
    private int meals;

    //constructor
    public FishFeeder(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    //methods

    public void feed(){
        if (meals > 0){
            meals--;
            System.out.println("Fish has been fed");
        }
        else{
            System.out.println("There are no meals left");
        }
    }

    public void fillUp(){
        meals = 14;
        System.out.println("Meals have been filled up");
    }

    public int getMeals() {
        return meals;
    }

    @Override
    public String toString(){
        return "FishFeeder{model = " + model + ", manufacturer " + manufacturer + ", meals " + meals + "}";
    }
}