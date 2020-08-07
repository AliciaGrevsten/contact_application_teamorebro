package com.teamorebro.contact_application_teamorebro.models;
public class Contact {
    private int Id;
    private String ContactName;
    private String Mail;
    private String PhoneNumber;

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
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getContactName() {
        return ContactName;
    }
    public void setContactName(String contactName) {
        ContactName = contactName;
    }
    public String getMail() {
        return Mail;
    }
    public void setMail(String mail) {
        Mail = mail;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
