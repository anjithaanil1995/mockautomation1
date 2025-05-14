package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	
	 WebDriver driver;
	 WebDriverWait wait;

	    public SignupPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isCreateAccountVisible() {
	        return driver.findElement(By.xpath("//a[text()='Create new account']")).isDisplayed();
	    }

	    public void clickCreateAccount() {
	        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
	    }

	    public void fillForm(String firstName, String surname, String email) {
	        driver.findElement(By.name("firstname")).sendKeys(firstName);
	        driver.findElement(By.name("lastname")).sendKeys(surname);
	        driver.findElement(By.name("reg_email__")).sendKeys(email);
	        //driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
	        
	        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email_confirmation__"))).sendKeys(email);
	       // driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
	    }
	    
	    public void enterNewPassword(String password) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_passwd__"))).sendKeys(password);
	    }
	    public void setDateOfBirth(String day, String month, String year) {
	        new Select(driver.findElement(By.xpath("//select[@id='day']"))).selectByVisibleText(day);
	        new Select(driver.findElement(By.xpath("//select[@id='month']"))).selectByVisibleText(month);
	        new Select(driver.findElement(By.xpath("//select[@id='year']"))).selectByVisibleText(year);
	    }

	    /*public void selectGender(String gender) {
	        if (gender.equalsIgnoreCase("female")) {
	            driver.findElement(By.xpath("//label[text()='Female']")).click();
	        } else if (gender.equalsIgnoreCase("male")) {
	            driver.findElement(By.xpath("//label[text()='Male']")).click();
	        } else {
	            driver.findElement(By.xpath("//label[text()='Custom']")).click();
	        }
	    }*/
	    public void selectGender(String gender) {
	        //  1 = Female, 2 = Male, -1 = Custom
	        String value = gender.equalsIgnoreCase("female") ? "1" :
	                       gender.equalsIgnoreCase("male") ? "2" : "-1";

	        By radioBtn = By.xpath("//input[@name='sex' and @value='" + value + "']");
	        wait.until(ExpectedConditions.elementToBeClickable(radioBtn)).click();
	    }
        

	    public void clickSignup() {
	        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	    }

}
