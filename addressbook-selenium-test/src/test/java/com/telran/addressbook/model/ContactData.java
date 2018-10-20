package com.telran.addressbook.model;

import java.io.File;

public class ContactData {
    private String firstname;
    private String lastname;
    private String address;
    private String mobile;
    private String email;
    private String bday;
    private String bmonth;
    private String byear;
    private File photo;
    private String group;

    public String getGroup() {
        return group;
    }

    public ContactData whisGroup(String group) {
        this.group = group;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData whisPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactData whisFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    public ContactData whisLastname(String lastname){
        this.lastname = lastname;
        return this;
    }
    public ContactData whisAddress(String address){
        this.address = address;
        return this;
    }
    public ContactData whisMobile(String mobile){
        this.mobile = mobile;
        return this;
    }
    public ContactData whisEmail(String email){
        this.email = email;
        return this;
    }
    public ContactData whisBday(String bday){
        this.bday = bday;
        return this;
    }
    public ContactData whisBmonth(String bmonth){
        this.bmonth = bmonth;
        return this;
    }
    public ContactData whisByear(String byear){
        this.byear = byear;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", bday='" + bday + '\'' +
                ", bmonth='" + bmonth + '\'' +
                ", byear='" + byear + '\'' +
                //", photo=" + photo +
                ", group='" + group + '\'' +
                '}';
    }
}
