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
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\seega\\OneDrive\\Desktop\\split-ends-close-up.jpg");
        Thread.sleep(500);
        driver.findElement(By.id("forward-button")).click();
        driver.findElement(By.id("forward-button")).click();

// https://elenta.lt/skelbimas/valdymas/1081164/7b242c58-8159-4185-99e2-9371be1d1f7d/
    }

    // public void addAdvert () { random name string
    // public void addInfo () { random words a lot

    //public void price () { random numbers many,
    //public void price2 () { numbers, letters
    //public void price3 () { -100

    //public void cityRegion () { Zarasai/Tumanas
    //public void cityRegion2 () { Zaaaaaaaaaaaaaaaaaaa

    //public void phoneNumber () { 3706353617 too short
    //public void phoneNumber2 () { 3706335361777 too long
    //public void phoneNumber3 () { +33363353617 other code
    //public void phoneNumber4 () { +333 63353617 with space
    //public void emailCheck () { gagag.com
    //public void emailCheck2 () { gaga@com
    // public void emailCheck3 () { gaga@.


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