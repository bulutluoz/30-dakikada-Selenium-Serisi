package video02_driverMethodlari;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethodlari {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        // 1- driver.navigate().to("url") --> istenen url'e gider
        //    driver.get("url") ile ayni islemi yapar ama forward ve back yapilmasina imkan tanir
        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.facebook.com");

        // 2- driver.navigate().back(); --> bir onceki sayfaya donus yapar
        driver.navigate().back(); // ornegimizde amazon'a donus yapacaktir

        // 3- driver.navigate().forward(); --> back() ile geldigi sayfaya yeniden gider
        driver.navigate().forward(); // ornegimizde facebook'a donus yapacaktir

        // 4- driver.navigate().refresh(); --> icinde oldugu sayfayi yeniler
        driver.navigate().refresh();

        // driver olusturuldugunda acilan sayfayi kapatmak istersek
        // driver.close();

        // driver calisirken birden fazla tab veya window actiysa tumunu kapatmak icin
         driver.quit();

    }
}
