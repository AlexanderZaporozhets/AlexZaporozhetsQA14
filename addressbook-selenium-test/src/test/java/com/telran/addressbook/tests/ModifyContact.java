package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyContact extends TestBase {
    @Test
    public void contactModificationTests() {
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().goToAddNewContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initModifyContact();
        app.getGroupHelper().submitContactModification();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }

}
