/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sachin Shinde
 */

// This class acts as a factory for creating user accounts implementing the factory method design pattern
public class AccountFactory {
    String userId, userName, userRole, userEmail, userPhone;
    public AccountFactory(String userId, String userName, String userRole, String userEmail, String userPhone){
        this.userId=userId;
        this.userName=userName;
        this.userRole=userRole;
        this.userEmail=userEmail;
        this.userPhone=userPhone;
    }
    // This method creates user accounts
    public Account getAccount(String accountType){
      if(accountType == null){
         return null;
      }		
      if(accountType.equalsIgnoreCase("client")){
         return new Client(userId, userName, userRole, userEmail, userPhone);
         
      } else if(accountType.equalsIgnoreCase("faculty")){
         return new Faculty(userId, userName, userRole, userEmail, userPhone);
         
      }else if(accountType.equalsIgnoreCase("student")){
         return new Student(userId, userName, userRole, userEmail, userPhone);
      }else{
          // For future extensibility
          try {
              return Account.class.cast(Class.forName(accountType));
          } catch (ClassNotFoundException ex) {
              System.out.println("No such user profile");
              Logger.getLogger(AccountFactory.class.getName()).log(Level.SEVERE, null, ex);
              return null;
          }
      }
    }
}
