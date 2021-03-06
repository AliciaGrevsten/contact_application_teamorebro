package com.teamorebro.contact_application_teamorebro;

import com.teamorebro.contact_application_teamorebro.models.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
public class ContactApplicationTeamorebroApplication {

    private static String URL = "jdbc:sqlite::resource:Contact_Application_db.sqlite";
    private static Connection conn = null;

    public static void main(String[] args) {
        SpringApplication.run(ContactApplicationTeamorebroApplication.class, args);
    }

    public static ArrayList<Contact> searchContacts(String searchword){
        try {
            openConnection();
            ArrayList<Contact> contacts = readContacts();
            ArrayList<Contact> matchingContacts = new ArrayList<>();

            for (Contact c : contacts) {
                if (c.getContactName().toLowerCase().contains(searchword.toLowerCase())) {
                    matchingContacts.add(new Contact(
                            c.getId(),
                            c.getContactName(),
                            c.getMail(),
                            c.getPhoneNumber()
                    ));
                }
            }
            return  matchingContacts;
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return null;
    }

    public static void addContact(Contact contact) {
        try{
            openConnection();
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Contacts (ContactName, Mail, PhoneNumber) VALUES (?, ?, ?)");
            preparedStatement.setString(1, contact.getContactName());
            preparedStatement.setString(2, contact.getMail());
            preparedStatement.setString(3, contact.getPhoneNumber());
            preparedStatement.execute();

        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }

    public static void editContact(Contact contact) {
        try{
            openConnection();
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE Contacts SET ContactName = ?, Mail = ?, PhoneNumber = ?" +
                            "WHERE Id = ?");
            preparedStatement.setString(1, contact.getContactName());
            preparedStatement.setString(2, contact.getMail());
            preparedStatement.setString(3, contact.getPhoneNumber());
            preparedStatement.setInt(4, contact.getId());
            preparedStatement.execute();

        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }

    public static void deleteContact(int id) {
        try{
            openConnection();
            PreparedStatement preparedStatement =
                    conn.prepareStatement("DELETE FROM Contacts WHERE Id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }

    public static Contact fetchContact(int id){
        ArrayList<Contact> contacts = readContacts();
        Contact returnCustomer = null;
        for (Contact contact : contacts)
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

    public static ArrayList<Contact> readContacts(){
        try{
            openConnection();
            ArrayList<Contact> contacts = new ArrayList<>();
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
            return contacts;
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return null;
    }

    public static void openConnection(){
        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
    }
}
