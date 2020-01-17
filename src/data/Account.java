package data;
import java.util.ArrayList;


public class Account {
    private String email;
    private String name;                                                                    //Create a new String called name.
    private String password;                                                                //Create a new String called password.
    private String address;
    private String city;                                                                     //Create a new String called password.

    public Account(String email, String name, String password, String address, String city) {             //Constructor for the Account class, requires an Arraylist of profiles, a name (String) and an address (Address object)
        //No more than five profiles can be linked to an account
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
        this.city = city;

    }





    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Accountname:" + this.getName() +
                "email:'" + this.email + '\'' +
                ", name:'" + name + '\'' +
                ", password:'" + password + '\'' +
                ", address:'" + address + '\'' +
                '}';
    }
}
