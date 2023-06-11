package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;


public class Driver {

    private Driver(){
    }
    private static WebDriver driver;

    /*
              Driver'i her çağırdığında yeni bir pencere açılmasının önüne geçmek için
          if bloğu içinde Eğer driver'a değer atanmamışsa(driver doluysa) değer ata, Eğer değer atanmışsa Driver'i aynı
          sayfada RETURN et. Bunun sadece yapmamız gereken if(driver==null) kullanmak
           */

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {//driver adeger atanmissa
            driver.close();//kapat
            driver = null;//make the driver null so when we call getDriver, we can open the driver again
        }
    }
    public static void quitDriver() {
        if (driver != null) {//driver adeger atanmissa
            driver.quit();//kapat
            driver = null;//make the driver null so when we call getDriver, we can open the driver again
        }
    }
}
