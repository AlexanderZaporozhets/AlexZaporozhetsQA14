package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateUserTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().whisFirstname(split[0]).whisLastname(split[1]).whisAddress(split[2]).whisMobile(split[3]).whisEmail(split[4]).whisBday(split[5]).whisBmonth(split[6]).whisByear(split[7]).whisGroup(split[8])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testCreateNewContact(ContactData contact) throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().goToAddNewContact();
        File photo = new File("src/test/resources/1.jpg");
        app.getContactHelper().addContactInformation(new ContactData().whisFirstname(contact.getFirstname()).whisLastname(contact.getLastname()).whisAddress(contact.getAddress()).whisMobile(contact.getMobile()).whisEmail(contact.getEmail()).whisBday(contact.getBday()).whisBmonth(contact.getBmonth()).whisByear(contact.getByear()).whisPhoto(contact.getPhoto()).whisGroup(contact.getGroup()));
        app.getContactHelper().submitContactCreation(By.xpath("(//input[@name='submit'])[2]"));
        int after = app.getContactHelper().getContactCount();
        org.testng.Assert.assertEquals(after, before+1);
    }
}
