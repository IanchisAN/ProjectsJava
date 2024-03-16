package isp.lab5.exercise1;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    Address address;

    public Customer(String customerId, String name,String phone){
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void sendTo(Address address){
        System.out.println(address.getStreet() + ", " + address.getCity());
    }
}
