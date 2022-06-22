package video02_driverMethodlari;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethodlari {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // 1- driver.manage().window() method'lari
        // 1 A - driver.manage().window().getSize() --> icinde oldugu sayfanin pixel olarak olculerini döndürür
        System.out.println(driver.manage().window().getSize()); // (1050, 832) pixel
        System.out.println(driver.manage().window().getSize().height); // 832

        // 1-B driver.manage().window().getPosition() --> icinde oldugu sayfanin pixel olarak konumunu döndürür
        System.out.println(driver.manage().window().getPosition()); // (10, 10)

        // 1-C driver.manage().window().setPosition(new Point(15,15));
        //     icinde oldugu sayfanin sol alt kosesini bizim yazacagimiz pixel noktasina tasir
        driver.manage().window().setPosition(new Point(15,15));
        // 1-D driver.manage().window().setSize(new Dimension(900,600));
        // icinde oldugu sayfanin sol alt kosesi sabit olarak bizim yazacagimiz olculere getirir
        driver.manage().window().setSize(new Dimension(900,600));

        // konumu ve boyutu yeniledikten sonra tekrar yazdirirsak
        System.out.println("yeni pencere olculeri : " + driver.manage().window().getSize()); //  (900, 600)
        System.out.println("yeni pencere konumu : " + driver.manage().window().getPosition()); // (15, 15)


        // 1-E driver.manage().window().maximize(); --> icinde oldugu sayfayi maximize yapar
        // 1-F driver.manage().window().fullscreen(); --> icinde oldugu sayfayi fullscreen yapar

        // farklarini gormek icin bu method'lari kullanip, baslangic noktalarini ve boyutlarini yazdiralim
        driver.manage().window().maximize();
        System.out.println("maximize konum : " + driver.manage().window().getPosition()); // (-8, -8)
        System.out.println("maximize boyut : " + driver.manage().window().getSize()); // (1616, 868)

        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum : " + driver.manage().window().getPosition()); // (0, 0)
        System.out.println("fullscreen boyut : " + driver.manage().window().getSize()); // (1600, 900)

        // 1-G driver.manage().window().minimize(); --> sayfayi simge durumunda kucultur
        driver.manage().window().minimize();

        // 2- driver.manage().timeouts() methodlari

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*      wait konusunu ilerde tek basina ele alacagiz
                ancak her class icin yapmamiz gereken bir ayar oldugu icin burada kisaca deginelim
                implicitlyWait : driver'a sayfanin yuklenmesi ve kullanacagimiz webelementlerin bulunmasi icin
                                 bekleyecegi maximum sureyi belirtir.
                                 driver bu sure icerisinde sayfa yuklenir/web element bulunursa
                                 beklemeden calismaya devam eder.
                                 bu sure bittigi halde sayfa yuklenememis/webElement bulunamamissa
                                 exception vererek calismayi durdurur

                Duration.ofSeconds(15) : Duration class'i Selenium-4 ile gelen zaman class'idir
                                         Yani driver'a ne kadar bekleyecegini soyler
                                         Duration.ofSeconds(15) yerine milis,minutes,hours da kullanilabilir
         */

        /* NOT :    Driver'in istedigimiz islemleri yaparken sorunla karsilasmamasi icin
                    driver.manage() method'larindan
                    maximize() ve implicitlyWait() method'larinin her test'te kullanilmasi
                    FAYDALI OLACAKTIR

         */

    }
}
