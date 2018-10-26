package User.UserSubClass;

import User.User;

public class Adress {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Adress(){
        this.street = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return this.street + ", " + this.city + ", " + this.state + ", " + this.zipCode;
    }
}
