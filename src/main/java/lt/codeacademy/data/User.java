package lt.codeacademy.data;

public class User {
    private UserType userType;
    private String email;
    private String password;

    public User() {
    }

    public User(UserType userType, String email, String password) {
        this.userType = userType;
        this.email = email;
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
