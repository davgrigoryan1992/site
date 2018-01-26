package FirstTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class FirstJavaClass {

    WebDriver driver;

    @Test
    public void PrintSomething() {

        final String FIRST_NAME = "//*[@id = 'u_0_e']";
        final String RADIOBUTTON_MALE = "//*[@id = 'u_0_c']";
        final String BUTTON_CREATE_ACCOUNT = "//*[contains(text(), 'Create Account')]";
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.facebook.com");


        WebElement firstName = driver.findElement(By.xpath(FIRST_NAME));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstName);
        actions.click();
        actions.sendKeys("Hello Guys!!!");
        actions.build().perform();



        setDate("month","May");
        setDate("day","22");
        setDate("year","2011");

        WebElement radio = driver.findElement(By.xpath(RADIOBUTTON_MALE));
        Actions radioactions = new Actions(driver);
        radioactions.moveToElement(radio);
        radioactions.click();
        radioactions.build().perform();


        WebElement createAccount = driver.findElement(By.xpath(BUTTON_CREATE_ACCOUNT));
        createAccount.click();
        createAccount.click();
        /*JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createAccount);*/

        System.out.println("Hello World!!!");
    }


    public void setDate(String id, String text) {
        WebElement mySelectElement = driver.findElement(By.id(id));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByVisibleText(text);
    }

}
