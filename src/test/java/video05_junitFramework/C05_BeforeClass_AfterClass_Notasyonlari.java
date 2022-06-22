package video05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeClass_AfterClass_Notasyonlari {
    // Olusturdugumuz test class'inin icindeki test method'lari
    // hep ayni web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
    // ve her method icin bu driver'i kapatmaya gerek yoktur
    // Class'in basinda bir kere setup calisip, en sonda kapansa olur
    // dersek BeforeClass ve AfterClass kullaniriz
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // amazon ana sayfaya gidelim
        driver.get("https:www.amazon.com");
    }
    @Test @Ignore
    public void test02() {
        // title yazdiralim
        System.out.println(driver.getTitle());
    }
    @Test
    public void test03() {
        // url yazdiralim
        System.out.println(driver.getCurrentUrl());
    }
}
