package bases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mock1Base {
	
	public static WebDriver driver;
    public static Properties prop;

    public Mock1Base() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\ANJITHA\\Documents\\SeleniumMavenWorkspace\\mockautomation1\\src\\test\\resources\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            //System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // update this path
            driver = new ChromeDriver();
    		driver.get(prop.getProperty("url"));
    		
    		
        }

        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
    }

}
