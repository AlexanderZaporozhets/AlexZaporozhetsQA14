package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected WebDriver driver;
    private GroupHelper groupHelper;

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        openAddressBook("http://localhost/addressbook/addressbook/");
        login("admin", "secret");
    }

    public void goToGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void login(String user, String pwd) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void openAddressBook(String url) {
        driver.get(url);
    }

    public void stop() {
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

    public void goToAddNewContact() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void addContactInformation(String firstname, String lastname, String address, String mobile, String email, String bday, String bmonth, String byear) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("bday")).click();
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(bday);
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bmonth")).click();
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(bmonth);
        driver.findElement(By.name("bmonth")).click();
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(byear);
    }

    public void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void initContactDeletion() {
        driver.findElement(By.xpath("//html//div[2]/input[1]")).click();
    }
    public void initModifyContact(){
        driver.findElement(By.xpath("//img[@alt='Edit']")).click();
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
