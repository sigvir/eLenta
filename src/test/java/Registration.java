import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Registration {
    public static WebDriver driver;

    @Test
    public void signIn() throws InterruptedException {
        driver.get("https://elenta.lt/");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click(); //cookie approve
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"header-container-nav\"]/a[3]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[10]/td/p/a")).click(); //sukurti nauja

        String randomUserName = RandomStringUtils.randomAlphanumeric(10); //random UserName
        System.out.println(randomUserName);

        driver.findElement(By.id("UserName")).sendKeys(randomUserName);
        driver.findElement(By.name("Email")).sendKeys("seegah@gmail.com");//fill email

        String randomPassword = RandomStringUtils.randomAlphanumeric(10); //randomPasword
        System.out.println(randomPassword);

        driver.findElement(By.name("Password")).sendKeys(randomPassword);
        driver.findElement(By.name("Password2")).sendKeys(randomPassword);

        driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click(); //click signIn
        Thread.sleep(200);
        // *** addNewAdvert ***///

        driver.findElement(By.xpath("//*[@id=\"submit-new-ad-nav-button\"]")).click(); //addAdvert cick
        driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[4]/a")).click(); // pick category
        Thread.sleep(200);

        driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[20]/a")).click(); //click category
        driver.findElement(By.id("title")).sendKeys("Parduodu plaukų galiukus"); //fill add name
        driver.findElement(By.id("text")).sendKeys("Parduodu naujai nukirptus plaukų galiukus. Spalva originali, 30 cm ilgio");
        driver.findElement(By.name("price")).sendKeys("1000"); //price
        driver.findElement(By.name("location")).sendKeys("Zarasai");
        Thread.sleep(1000);
        driver.findElement(By.name("phone")).sendKeys("+37063353617");
        driver.findElement(By.name("email")).sendKeys("seegah@gmail.com");
        driver.findElement(By.id("submit-button")).click();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}