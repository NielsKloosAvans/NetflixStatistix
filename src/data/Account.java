package data;
import java.util.ArrayList;


public class Account {
    private String email;
    private ArrayList<Profile> profiles;                                                    //Create a new ArrayList that stores Profile objects.
    private String name;                                                                    //Create a new String called name.
    private String password;                                                                //Create a new String called password.
    private String address;                                                                 //Create a new String called password.

    public Account(String email, ArrayList<Profile> profiles, String name, String password, String address) {             //Constructor for the Account class, requires an Arraylist of profiles, a name (String) and an address (Address object)
        //No more than five profiles can be linked to an account
        if (profiles.size() > 5) {                                                          //Check if the size of ArrayList profiles is greater than 5.
            throw new IllegalArgumentException();                                           //If yes, throw an IllegalArgumentException
        }
        this.email = email;
        this.profiles = profiles;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    //hallo dit is een test
    public ArrayList<Profile> getProfiles() {
        return this.profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        if (profiles.size() > 5){
            throw new IllegalArgumentException();
        }
        this.profiles = profiles;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Accountname:" + this.getName() +
                "email:'" + this.email + '\'' +
                ", profiles:" + this.getProfiles() +
                ", name:'" + name + '\'' +
                ", password:'" + password + '\'' +
                ", address:'" + address + '\'' +
                '}';
    }
}
