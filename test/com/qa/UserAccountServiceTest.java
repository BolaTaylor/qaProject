package com.qa;

import com.qa.dao.UserAccounts;
import com.qa.service.UserAccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserAccountServiceTest {

    @Mock
    private UserAccountService userAccountService;
    @Mock
    private List<UserAccounts> userAccountsList = new ArrayList<>();
    @Mock
    private UserAccounts userAccounts;

    @Mock
    private UserAccounts userAccountsOne;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(userAccountService.getUserAccounts()).thenReturn(userAccountsList);
       }

    @Test

    public void testNullGetUserAccount() {
        userAccountsList = userAccountService.getUserAccounts();
        assertNotEquals(userAccountsList, null);
    }

    @Test

    public void testInvalidGetUserAccount() {
        userAccountsList = userAccountService.getUserAccounts();
        assertNotEquals(userAccountsList, new String("Test String"));
    }

    @Test
    public void testEqualsGetUserAccountSize(){

        userAccountsList = userAccountService.getUserAccounts();
        assertEquals( userAccountsList.size(), 0);
        }

    @Test

    public void testAddUserAccount() {
        userAccountService.deleteAccounts(userAccounts);
        assertNotEquals(userAccountsList, null);
    }



    @Test
    public void testDeleteUserAccount() {
        userAccountService.deleteAccounts(userAccounts);
        assertNotEquals(userAccounts, null);
    }




}
