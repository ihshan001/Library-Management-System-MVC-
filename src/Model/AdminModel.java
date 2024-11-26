package Model;

public class AdminModel {

    private int AdminID;
    private String name;
    private String username;
    private String address;
    private String contactNo;
    private String password;
    private String confirmPassword;

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int ID) {
        this.AdminID = ID;
    }

   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

   
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

   
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

   
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    
}