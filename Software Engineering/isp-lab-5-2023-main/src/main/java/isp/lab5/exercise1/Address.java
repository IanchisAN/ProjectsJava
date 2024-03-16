package isp.lab5.exercise1;

public class Address {
    private String street;
    private String city;

    public Address(String street, String city){
        this.street = street;
        this.city = city;
    }

    public String getStreet(){
        return street;
    }
    public String getCity(){
        return city;
    }

    public void setStreet(){
        this.street = street;
    }
    public void setCity(){
        this.city = city;
    }
}
