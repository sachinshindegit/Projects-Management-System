
package userActionsImplementor;

import Accounts.Account;

/**
 *
 * @author Sachin Shinde
 */

// This is the abstract class used to create abstraction for implementing Bridge Pattern

public abstract class LoggedInUser {
    public UserActions userActions;
    public Account loggedInUser;
    public abstract Account getLoggedInUserAccountDetails();
    public abstract void setLoggedInUserAccountDetails(Account user);
}
