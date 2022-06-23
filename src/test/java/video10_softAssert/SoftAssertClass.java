package video10_softAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SoftAssertClass {
    WebDriver driver;
    @Test
    public void testAssert() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        SoftAssert softAssert=new SoftAssert();
        //3. Verify that home page is visible successfully
        String expectedUrl="https://automationexercise.com/";
        String actualUrl= driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"URL test ");
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductYaziElementi= driver.findElement(By.xpath("//*[text()='All Products']"));
        softAssert.assertTrue(allProductYaziElementi.isDisplayed(),"All product sayfa testi");
        //6. The products list is visible
        List<WebElement> productList=driver.findElements(By.xpath("//*[text()='View Product']"));
        softAssert.assertTrue(productList.size()>0,"product list testi");
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
        //8. User is landed to product detail page
        WebElement productName= driver.findElement(By.xpath("(//h2)[3]"));
        softAssert.assertTrue(productName.isDisplayed(),"product name testi");
        //9. Verify that detail detail is visible: product name, category,
        WebElement categoryElement= driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        softAssert.assertTrue(categoryElement.isDisplayed(),"category testi");
        softAssert.assertAll();
        driver.close();
    }
}
