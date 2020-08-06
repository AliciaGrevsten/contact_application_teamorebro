package com.teamorebro.contact_application_teamorebro.models;

public class Contact {

    private static int Id;
    private static String Name;
    private static String Mail;
    private static String PhoneNumber;


    public Contact(int id, String name, String mail, String phonenumber) {
        this.Id = id;
        this.Name = name;
        this.Mail = mail;
        this.PhoneNumber = phonenumber;
    }

    public static int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
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
