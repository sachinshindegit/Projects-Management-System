/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 *
 * @author Sachin Shinde
 */
// This class defines faculty account
public class Faculty implements Account, LoggedInUser{
    private String userId;
    private String userName;
    private String userRole;
    private String userEmail;
    private String userPhone;

    
    public Faculty(String userId, String userName, String userRole, String userEmail, String userPhone){
        this.setUserId(userId);
        this.setUserName(userName);
        this.setUserRole(userRole);
        this.setUserPhone(userPhone);
        this.setUserEmail(userEmail);
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
