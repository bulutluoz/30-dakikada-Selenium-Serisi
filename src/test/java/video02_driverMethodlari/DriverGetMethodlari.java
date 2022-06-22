package video02_driverMethodlari;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethodlari {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        // 1- driver.get("url") --> yazdigimiz url'e gider
        driver.get("https://www.amazon.com");

        // 2- driver.getTitle() --> icinde oldugu sayfanin basligini döndürür
        System.out.println("sayfa title : " + driver.getTitle()); //Amazon.com. Spend less. Smile more.

        // 3- driver.getCurrentUrl() --> icinde oldugu sayfanin URL'ini döndürür
        System.out.println(driver.getCurrentUrl()); // https://www.amazon.com/

        // 4- driver.getPageSource(); --> icinde oldugu sayfanin kaynak kodlarini döndürür
        System.out.println("=====================================================");
        System.out.println(driver.getPageSource()); // arka planda calisan sayfa kodlarini yazdirir
        System.out.println("=====================================================");

        // 5- driver.getWindowHandle() --> icinde oldugu sayfanin UNIQUE hash kodunu döndürür
        System.out.println(driver.getWindowHandle()); // CDwindow-F4A35FD5413FE52C6DEB0B03CA6DFB9F

        // 6- driver.getWindowHandles() --> driver calisirken acilan tum sayfalarin UNIQUE hash kodunu döndürür

    }

}
