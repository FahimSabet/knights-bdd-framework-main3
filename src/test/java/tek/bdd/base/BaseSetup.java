package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {

    //Encapsulation Concept of Java
    private static WebDriver driver;
    private final String APP_URL = "https://qa.insurance.tekschool-students.com/";
    private final String BROWSER_TYPE = "edge";

    public void openBrowser() {
        //Targeting Chrome Browser.
        //Creating instance of Browser and navigate for Tek Insurance APP.

        // Steps to read a property file
        // Step 1) the absolute file path to the property file.

        String configFilePath= System.getProperty("user.dir") +
                "/Users/fahimsabet/Downloads/knights-bdd-framework-main 3/src/test/resources/configs/qa_env_config.properties";


        // Step 2) Create object from properties class in Java library
        Properties properties = new Properties();

        // Step 3) Load config file to proprieties object
        // And we need file input stream file java. which reads files in java.


        try {
            FileInputStream configFile = new FileInputStream(configFilePath);
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // step 4) read a value from property file using the property key

      String baseURL =  properties.getProperty("ui.url");
        String browserType = properties.getProperty("ui.browser.type");





        if (BROWSER_TYPE.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");


            driver = new ChromeDriver(options);

        } else if (BROWSER_TYPE.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (BROWSER_TYPE.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("Wrong browser type" );
        }






        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(APP_URL);
    }

    public void driverQuit() {
        if (driver != null)
            driver.quit();
    }

    //Ready only Getter to read get Driver instance.
    //Java Encapsulation Concept.
    public WebDriver getDriver() {
        return driver;
    }

}
