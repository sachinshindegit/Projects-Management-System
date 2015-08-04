package userActionsImplementor;

import Accounts.Account;
import userActionsImplementor.LoggedInUser;

/**
 *
 * @author Sachin Shinde
 */

// This class mentions functionalities of a admin user
public class StudentUser extends LoggedInUser{
    
    public StudentUser(Account user){
        // Sets the user
        setLoggedInUserAccountDetails(user);
        
        // instantiates user actions
        userActions=new StudentActions();
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
