package com.telran.addressbook.generator;

import com.telran.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s; %s; %s\n", contact.getFirstname(), contact.getLastname(), contact.getAddress(), contact.getMobile(), contact.getEmail(), contact.getBday(), contact.getBmonth(), contact.getByear(), contact.getGroup()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new ContactData().whisFirstname(String.format("Alex %s", i)).whisLastname(String.format("Zaporozhets %s", i)).whisAddress(String.format("RishonLezion %s", i)).whisMobile(String.format("0586906455 %s", i)).whisEmail(String.format("al.zaporozhets@mail.ru %s", i)).whisBday(String.format("13 %s", i)).whisBmonth(String.format("July %s", i)).whisByear(String.format("1984 %s", i)).whisGroup(String.format("1 %s", i)));
        }
        return groups;
    }
}
