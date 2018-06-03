package com.qa.service;

import com.qa.dao.UserAccounts;

import java.util.ArrayList;
import java.util.List;

public class UserAccountService {


    private List<UserAccounts> userAccountsList = new ArrayList<>();
    private UserAccounts userAccounts  = new UserAccounts();
    private UserAccounts userAccountsOne = new UserAccounts();
    private UserAccounts userAccountsTwo = new UserAccounts();
    private UserAccounts userAccountsThree = new UserAccounts();

    public UserAccountService(){
       if(!checkUserAccount(userAccounts)) {
           userAccounts.setId(1);
           userAccounts.setFirstName("John");
           userAccounts.setLastName("Taylor");
           userAccounts.setAccountNumber("12345");
           userAccountsList.add(userAccounts);
       }
       if(!checkUserAccount(userAccountsOne)) {
           userAccountsOne.setId(2);
           userAccountsOne.setFirstName("Mary");
           userAccountsOne.setLastName("Williams");
           userAccountsTwo.setLastName("Peterson");
           userAccountsOne.setAccountNumber("23456");
           userAccountsList.add(userAccountsOne);

       }

       if(!checkUserAccount(userAccountsTwo)) {
           userAccountsTwo.setId(3);
           userAccountsTwo.setFirstName("Fred");
           userAccountsTwo.setLastName("Peterson");
           userAccountsTwo.setAccountNumber("45678");
           userAccountsList.add(userAccountsTwo);

       }
       if(!checkUserAccount(userAccountsThree)) {
           userAccountsThree.setId(4);
           userAccountsThree.setFirstName("Peter");
           userAccountsThree.setLastName("Bauer");
           userAccountsThree.setAccountNumber("98765");
           userAccountsList.add(userAccountsThree);

       }


   }

    public List<UserAccounts> getUserAccounts(){
        return this.userAccountsList;
    }


    public void addAccounts(UserAccounts userAccounts){
    if(!checkUserAccount(userAccounts)){
        userAccounts.setId(userAccountsList.size() + 1);
        userAccountsList.add(userAccounts);
    }

    }

    public void deleteAccounts(UserAccounts userAccounts){
        if(!checkUserAccount(userAccounts)){
            userAccountsList.remove(userAccounts);
        }

    }

    private boolean checkUserAccount(UserAccounts userAccounts){

    for(UserAccounts userAccountObject: userAccountsList){
        if(userAccountObject.getId() == userAccounts.getId()){
            return true;
        }
    }
    return false;
    }

}
