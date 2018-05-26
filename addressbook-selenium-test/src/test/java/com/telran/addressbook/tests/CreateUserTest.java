package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateUserTest extends TestBase {

    @Test
    public void testCreateNewContact() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().addContactInformation(new ContactData().whisFirstname("Alex").whisLastname("Zaporozhets").whisAddress("RishonLezion").whisMobile("0586906455").whisEmail("a.zaporozhets@mail.ru").whisBday("13").whisBmonth("July").whisByear("1984"));
        app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
        int after = app.getContactHelper().getContactCount();
        org.testng.Assert.assertEquals(after, before+1);
    }
}
