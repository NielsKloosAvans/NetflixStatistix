package data;


public class Profile {
    private String profileName;
    private int age;
    private String email;


    //initialize the profile
    public Profile(String profileName, int age, String email) {
        this.profileName = profileName;
        this.age = age;
        this.email = email;
    }
    
    // setter of profileName
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    // getter of profileName
    public String getProfileName() {
        return profileName;
    }

    // setter of age
    public void setAge(int age) {
        this.age = age;
    }

    // getter of age
    public int getAge() {
        return age;
    }

    // setter of email
    public void setEmail(String email) {
        this.email = email;
    }

    // getter of email
    public String getEmail() {
        return email;
    }
}
