package com.qa.dao;

import java.util.ArrayList;
import java.util.List;

public class UserAccountsDao {

    static UserAccounts userAccounts = new UserAccounts();
    static UserAccounts userAccountsOne = new UserAccounts();
    static UserAccounts userAccountsTwo = new UserAccounts();
    static UserAccounts userAccountsThree = new UserAccounts();

    static List<UserAccounts> userAccountsList = new ArrayList<>();

    static {
        initUserAccounts();
    }

    private static void initUserAccounts(){

        if (!checkUserAccount(userAccounts)) {
            userAccounts.setId(1);
            userAccounts.setFirstName("John");
            userAccounts.setLastName("Taylor");
            userAccounts.setAccountNumber("12345");
            userAccountsList.add(userAccounts);
        }
        if (!checkUserAccount(userAccountsOne)) {
            userAccountsOne.setId(2);
            userAccountsOne.setFirstName("Mary");
            userAccountsOne.setLastName("Williams");
            userAccountsTwo.setLastName("Peterson");
            userAccountsOne.setAccountNumber("23456");
            userAccountsList.add(userAccountsOne);

        }

        if (!checkUserAccount(userAccountsTwo)) {
            userAccountsTwo.setId(3);
            userAccountsTwo.setFirstName("Fred");
            userAccountsTwo.setLastName("Peterson");
            userAccountsTwo.setAccountNumber("45678");
            userAccountsList.add(userAccountsTwo);

        }
        if (!checkUserAccount(userAccountsThree)) {
            userAccountsThree.setId(4);
            userAccountsThree.setFirstName("Peter");
            userAccountsThree.setLastName("Bauer");
            userAccountsThree.setAccountNumber("98765");
            userAccountsList.add(userAccountsThree);

        }
    }
    public static boolean checkUserAccount(UserAccounts userAccounts){

        for(UserAccounts userAccountObject: userAccountsList){
            if(userAccountObject.getId() == userAccounts.getId()){
                System.out.println("Yes");
                return true;
            }
        }
        return false;
    }

    public static List<UserAccounts> getAllUserAccounts() {
        return userAccountsList;
    }


    public static void addAccounts(UserAccounts userAccounts){
        if(!UserAccountsDao.checkUserAccount(userAccounts)){
            userAccounts.setId(userAccountsList.size() + 1);
            userAccountsList.add(userAccounts);
        }

    }

    public static void deleteAccounts(UserAccounts userAccounts){
        if(UserAccountsDao.checkUserAccount(userAccounts)){
            userAccountsList.remove(userAccounts.getId());
        }

    }


}
