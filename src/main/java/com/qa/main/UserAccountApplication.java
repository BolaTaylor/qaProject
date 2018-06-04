package com.qa.main;

import com.qa.dao.UserAccounts;
import com.qa.service.UserAccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping("/account-project/rest/account/json")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class UserAccountApplication {

    @GET
    @RequestMapping("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserAccounts(){
        UserAccountService userAccountService = new UserAccountService();
        return Response.ok(userAccountService.getUserAccounts()).build();
      }


    @POST
    @RequestMapping("add/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUserAccount(@PathVariable("id") String id, @RequestBody UserAccounts userAccount){
        UserAccountService userAccountService = new UserAccountService();
        userAccountService.addAccounts(userAccount);
        return Response.ok("account has been successfully added").build();
    }


    @DELETE
    @RequestMapping("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserAccount(@PathVariable("id") String id, @RequestBody UserAccounts userAccount){
        UserAccountService userAccountService = new UserAccountService();
        userAccountService.deleteAccounts(userAccount);
        return Response.ok("account has been successfully deleted").build();
    }


    public static void main(String[] args) throws Exception {
        UserAccountService userAccountService = new UserAccountService();
        SpringApplication.run(UserAccountApplication.class, args);
    }


}