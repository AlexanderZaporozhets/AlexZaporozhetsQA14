package com.telran.addressbook.tests;

import org.testng.annotations.Test;

public class CreateUserTest extends TestBase {

    @Test
    public void testCreateNewContact() throws Exception {
        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().addContactInformation("Alex", "Zaporozhets", "RishonLezion", "0586906455", "a.zaporozhets@mail.ru", "13", "July","1984");
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().addContactInformation("Elena", "Zaporozhets", "RishonLezion", "0586906456", "e.zaporozhets@mail.ru", "16", "March","1985");
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().addContactInformation("Mariya", "Zaporozhets", "RishonLezion", "0586906457", "m.zaporozhets@mail.ru", "2", "April","2010");
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();

    }
}
