
package Accounts;

/**
 *
 * @author Sachin Shinde
 */

// This is an interface for Account factory as  part of Factory method design pattern
public interface AccountCreator {
    public Account getAccount(String accountType);
}
