package lnpx;

public class User {

    private String username;
    private String password;
    private int adminLvl;
    private String firstName;
    private String lastName;
    private String email;

    public User(String username, String password, int adminLvl, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.adminLvl = adminLvl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAdminLvl() {
        return adminLvl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

}
