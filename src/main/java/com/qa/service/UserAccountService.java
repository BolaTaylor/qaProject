package com.qa.service;

import com.qa.dao.UserAccounts;
import com.qa.dao.UserAccountsDao;

import java.util.ArrayList;
import java.util.List;

public class UserAccountService {

    private List<UserAccounts> userAccountsList = new ArrayList<>();

    public List<UserAccounts> getUserAccounts(){
        return UserAccountsDao.getAllUserAccounts();
    }


    public void addAccounts(UserAccounts userAccounts){
    if(!UserAccountsDao.checkUserAccount(userAccounts)){
        userAccounts.setId(userAccountsList.size() + 1);
        userAccountsList.add(userAccounts);
    }

    }

    public void deleteAccounts(UserAccounts userAccounts){
        if(!UserAccountsDao.checkUserAccount(userAccounts)){
            userAccountsList.remove(userAccounts);
        }

    }


}
