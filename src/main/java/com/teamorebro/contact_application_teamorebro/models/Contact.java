package com.teamorebro.contact_application_teamorebro.models;

public class Contact {

    private static int Id;
    private static String ContactName;
    private static String Mail;
    private static String PhoneNumber;


    public Contact(int id, String contactName, String mail, String phonenumber) {
        this.Id = id;
        this.ContactName = contactName;
        this.Mail = mail;
        this.PhoneNumber = phonenumber;
    }

    public Contact(String contactName, String mail, String phonenumber) {
        this.ContactName = contactName;
        this.Mail = mail;
        this.PhoneNumber = phonenumber;
    }

    public static int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }

    public static String getContactName() {
        return ContactName;
    }

    public static void setContactName(String contactName) {
        ContactName = contactName;
    }

    public static String getMail() {
        return Mail;
    }

    public static void setMail(String mail) {
        Mail = mail;
    }

    public static String getPhoneNumber() {
        return PhoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

}
