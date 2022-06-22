package video05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TestNotasyonu {
    // @Test notasyonu olmayan method'lar bugune kadar yaptigimiz gibi sadece cagrildiklarinda calisir
    // Ancak @Test eklendiginde bagimsiz calisabilir hale gelir

    @Test
    public void test01() {
        // Ayarlari yapalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");
        //2- arama cubuguna “Nutella” yazdirin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");
        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        aramaKutusu.submit();
        //4- Bulunan sonuc sayisini yazdirin.
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYaziElementi.getText());

        driver.close();
    }
}
