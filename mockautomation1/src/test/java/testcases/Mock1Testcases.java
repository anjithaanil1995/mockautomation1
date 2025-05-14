package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bases.Mock1Base;
import pages.SignupPage;

public class Mock1Testcases extends Mock1Base {
	
	SignupPage signupPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        initialization();
        signupPage = new SignupPage(driver);
        Thread.sleep(20); // Wait for redirect
    }

    @Test(priority = 1)
    public void testURLRedirection() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.facebook.com/", "URL redirection failed!");
    }

    @Test(priority = 2)
    public void testCreateAccountVisibility() {
        Assert.assertTrue(signupPage.isCreateAccountVisible(), "'Create new account' button not visible");
    }

    @Test(priority = 3)
    public void testAccountCreation() throws InterruptedException {
        signupPage.clickCreateAccount();
        Thread.sleep(10); 

        signupPage.fillForm("John", "Doe", "testemail@example.com");
        signupPage.enterNewPassword("Test@12345");
        signupPage.setDateOfBirth("10", "May", "1995");
        signupPage.selectGender("male");
        Thread.sleep(20);
        signupPage.clickSignup();
        
        System.out.println("Sign-up attempted.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
