package com.teamorebro.contact_application_teamorebro;

import com.teamorebro.contact_application_teamorebro.models.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@SpringBootApplication
public class ContactApplicationTeamorebroApplication {

    private static String URL = "jdbc:sqlite::resource:Contact_Application_db.sqlite";
    private static Connection conn = null;
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(ContactApplicationTeamorebroApplication.class, args);
        readContacts();
    }

    public static void addContact(Contact contact) {
        openConnection();

        try{
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Contacts (ContactName, Mail, PhoneNumber) VALUES (?, ?, ?)");
            preparedStatement.setString(1, contact.getContactName());
            preparedStatement.setString(2, contact.getMail());
            preparedStatement.setString(3, contact.getPhoneNumber());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected==1) {
                System.out.println("<----------------------------- Added");
            } else {
                System.out.println("<----------------------------- What?");
            }

        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }

    public static Contact fetchContact(int id){
        Contact returnCustomer = null;
        for (Contact contact : ContactApplicationTeamorebroApplication.getContacts())
        {
            if (contact.getId() == id)
            {
                returnCustomer = contact;
            }
        }
        if(returnCustomer == null)
        {
            System.out.println(" --- CUSTOMER WAS NOT FOUND --- ");
        }
        return returnCustomer;
    }

    public static void readContacts(){
        openConnection();

        try{
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Id,ContactName,Mail,PhoneNumber FROM Contacts");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                contacts.add(
                        new Contact(
                                resultSet.getInt("Id"),
                                resultSet.getString("ContactName"),
                                resultSet.getString("Mail"),
                                resultSet.getString("PhoneNumber")
                        ));
            }

        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }

    public static void openConnection(){
        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {

        }
    }

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void setContacts(ArrayList<Contact> contacts) {
        ContactApplicationTeamorebroApplication.contacts = contacts;
    }
}
