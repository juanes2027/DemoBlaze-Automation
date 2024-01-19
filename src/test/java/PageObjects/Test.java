package PageObjects;
import Utilities.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;

public class Test extends BaseClass {

    private static Test instance;
    WebDriverWait wait = new WebDriverWait(driver, 30);
    private JavascriptExecutor js;
    boolean acceptNextAlert = true;
    private String randomString ;
    private WebElement userA;
    private WebElement signinBut;
    private WebElement signinPass;
    private WebElement signinAccept;
    private WebElement loginB;
    private WebElement loginUser;
    private WebElement loginPass;
    private WebElement loginAccept;
    private WebElement logout;
    private WebElement signinClose;

    private WebElement loginClose;
    private WebElement celButton;
    private WebElement cel1;
    private WebElement addCar;
    private WebElement homeButton;
    private WebElement cel2;
    private WebElement carButton;
    private WebElement Delete;



    public Test(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        initializeElements();
    }
    public static Test getInstance(WebDriver driver, WebDriverWait wait) {
        if (instance == null) {
            instance = new Test(driver, wait);

        }
        return instance;
    }

    public void initializeElements() {


        userA = driver.findElement(By.id("sign-username"));
        signinBut = driver.findElement(By.id("signin2"));
        signinPass = driver.findElement(By.id("sign-password"));
        signinAccept = driver.findElement(By.xpath("//div[@id='signInModal']/div/div/div[3]/button[2]"));
        loginB = driver.findElement(By.id("login2"));
        loginUser = driver.findElement(By.id("loginusername"));
        loginPass = driver.findElement(By.id("loginpassword"));
        loginAccept = driver.findElement(By.xpath("//div[@id='logInModal']/div/div/div[3]/button[2]"));
        logout = driver.findElement(By.id("logout2"));
        loginClose= driver.findElement(By.xpath("//div[@id='logInModal']/div/div/div[3]/button"));
        celButton = driver.findElement(By.id("itemc"));
        randomString = generateRandomString(10);
        cel1 =  driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/div/h4/a"));
        addCar=driver.findElement(By.xpath("//div[@id='tbodyid']/div[2]/div/a"));
        cel2= driver.findElement(By.xpath("//div[@id='tbodyid']/div[2]/div/a/img"));
        carButton = driver.findElement(By.id("cartur"));
        Delete=driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Samsung galaxy s6'])[1]/following::a[1]"));
        homeButton =  driver.findElement(By.xpath("//li/a"));
        signinClose = driver.findElement(By.xpath("//div[@id='signInModal']/div/div/div[3]/button"));
    }




    public void signin() throws InterruptedException {

        // Generate and send random character

        Thread.sleep(2000);
        signinBut.click();
        userA.clear();
        userA.sendKeys(randomString);
        signinPass.sendKeys("12345678");
        signinAccept.click();

    }
        public void signinAlert()  {
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Sign up successful.", closeAlertAndGetItsText());
    }

    public void login()  {

        loginB.click();
        loginUser.clear();
        loginUser.sendKeys("Juan osorio");
        loginPass.clear();
        loginPass.sendKeys("12345678");
        loginAccept.click();

    }
    public void logout() {

        logout.click();
    }

    public void validateExist()  {

        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This user already exist.", closeAlertAndGetItsText());
        signinClose.click();

    }

    public void noUser() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login2")));

        loginB.click();
        loginUser.sendKeys("hdkshflsj osorio");
        loginPass.sendKeys("12345678");
        loginAccept.click();
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("User does not exist.", closeAlertAndGetItsText());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='signInModal']/div/div/div[3]/button")));
        loginClose.click();


    }

    public void buyPhone() throws InterruptedException {

        js.executeScript("window.scrollBy(0, 500)");
        cel1.click();
        addCar.click();
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Product added.", closeAlertAndGetItsText());
        homeButton.click();
        cel2.click();
        addCar.click();
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Product added.", closeAlertAndGetItsText());
        carButton .click();
        Delete.click();
        // These were not defined above because they are only used once.
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[2]/button")).click();
        driver.findElement(By.id("name")).sendKeys("eew");
        driver.findElement(By.id("country")).sendKeys("ere");
        driver.findElement(By.id("city")).sendKeys("erer");
        driver.findElement(By.id("card")).sendKeys("23423113");
        driver.findElement(By.id("month")).sendKeys("24");
        driver.findElement(By.id("year")).sendKeys("2233");
        driver.findElement(By.xpath("//div[@id='orderModal']/div/div/div[3]/button[2]")).click();

    }

    public void validatePurchase() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Thank you for your purchase!'])[1]/following::p[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
    }

    public void validateCategories(){

        driver.findElement(By.id("cat")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("itemc")));
        celButton.click();
        js.executeScript("window.scrollBy(0, 500)");
        // These were not defined above because they are only used once.
        driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/div")).click();
        js.executeScript("window.scrollBy(0, 500)");
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[2]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[3]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[3]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[3]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[3]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[4]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[5]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[6]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[7]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='contcont']/div/div/div/a[3]")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[2]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[3]/div/div/p")).click();
        js.executeScript("window.scrollBy(0, 500)");
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[4]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[5]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[6]/div/div/p")).click();
        driver.findElement(By.id("next2")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[2]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[3]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[4]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[5]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[6]/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='contcont']/div/div/div/a[4]")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/div/p")).click();
        driver.findElement(By.xpath("//div[@id='tbodyid']/div[2]/div/div/p")).click();
    }




    private String closeAlertAndGetItsText() {

        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    private static String generateRandomString(int length) {
        // Generate random string
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return sb.toString();
    }
}

