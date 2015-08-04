package userActionsImplementor;

import Accounts.Account;

/**
 *
 * @author Sachin Shinde
 */

// This class mentions functionalities of a admin user
public class AdminUser extends LoggedInUser{
    
    
    public AdminUser(Account user){
        // Sets the user
        setLoggedInUserAccountDetails(user);
        
        // instantiates user actions
        userActions=new AdminActions();
    }
    // To get User account details
    @Override
    public Account getLoggedInUserAccountDetails() {
        return loggedInUser;
    }
    
    // To set the account details
    @Override
    public void setLoggedInUserAccountDetails(Account user) {
        loggedInUser = user;
    }
    
}
