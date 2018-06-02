package appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void goToAddNewContact() {
        click(By.linkText("add new"));
    }

    public void addContactInformation(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());
        if(isElementPresent(By.name("new_group"))){
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }
        //type(By.name("bday"), contactData.getBday());
        //type(By.name("bmonth"), contactData.getBmonth());
        //type(By.name("byear"), contactData.getByear());
    }

    public void submitContactCreation(By locator) {
        click(locator);
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactDeletion() {
        click(By.xpath("//html//div[2]/input[1]"));
    }

    public void initModifyContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}
