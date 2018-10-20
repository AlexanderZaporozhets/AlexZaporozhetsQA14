
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.*;

public class FirstClass {
  private EventFiringWebDriver driver;

  public static class MyListener extends AbstractWebDriverEventListener{
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + "found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
    }
  }

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new EventFiringWebDriver(new ChromeDriver());
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.register(new MyListener());
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @Test(enabled = true)
  public void searchWebDriverInChrome() throws Exception {
    driver.get("https://www.google.com/");
    driver.findElement(By.id("lst-ib")).click();
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("webDriver");
    driver.findElement(By.id("lst-ib")).sendKeys(ENTER);
  }
  @Test
  public void elementsTest(){
    driver.get("https://www.google.com/");
    WebElement settings = driver.findElement(By.id("fsettl"));
    settings.click();
    driver.navigate().refresh();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
    }
