package testrunner;

import controller.User;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class userTestRunner extends Setup {
    User user;
    @Test(priority = 1)
    public void doLogin() throws ConfigurationException, IOException {
        user=new User();
        user.callLoginAPI();
        Assert.assertTrue(user.getMessage().contains("Login successfully"));
    }
    @Test(priority = 2)
    public  void  userSearchById() throws IOException, ConfigurationException {
        user=new User();
        String id= user.getUserList(100);
        user.userSearchById(id);
    }

    @Test(priority = 3)
    public void createUser() throws IOException, ConfigurationException {
        user=new User();
        user.createUser();
    }
}
