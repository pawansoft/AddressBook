package com.addressBook.Driver;

import com.addressBook.Dao.AddressBookDAO;
import com.addressBook.POJO.AddressBookPOJO;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        AddressBookDAO newAddressBookDAO=new AddressBookDAO();
        AddressBookPOJO addressBookPOJO = new AddressBookPOJO();
        System.out.println("Enter your Name :");
        String name=sc.next();
        boolean terminate=false;
        while(terminate != true)
        {
            System.out.println("Hello " +name + " Choose any one option:");
            System.out.println("1: For add new Address");
            System.out.println("2: For fetch all Address from database");
            System.out.println("3: For fetch address by email id");
            System.out.println("4: For update the existing address");
            System.out.println("5: For delete the Address by email");
            System.out.println("6: to sort the value by Zip Code");
            System.out.println("7: to short by First Name");
            System.out.println("0: For terminate the program");
            int option=sc.nextInt();
            switch (option)
            {
                //Adding new Address to Address Book
                case 1:
                    newAddressBookDAO=addressBookPOJO.newAddressBook();
                    System.out.println(addressBookPOJO.save(newAddressBookDAO.getEmail(), newAddressBookDAO));
                    break;
                //Fetching all the address books
                case 2:
                    addressBookPOJO.fetchAllDetails();
                    break;
                //Fetch address from address book by Email Id
                case 3:
                    System.out.println("Enter the Email to Search");
                    String email=sc.next();
                    addressBookPOJO.fetchDetailById(email);
                    break;
                //Updating existing detail of address book
                case 4:
                    System.out.println("enter the email to update");
                    String key=sc.next();
                    newAddressBookDAO=addressBookPOJO.newAddressBook();
                    addressBookPOJO.updateValue(key,newAddressBookDAO);
                    break;
                case 5:
                    System.out.println("Enter the email to delete address");
                    String emailForUpdate=sc.next();
                    addressBookPOJO.deleteAddress(emailForUpdate);
                    break;
                case 6:
                    addressBookPOJO.shortByZipCode();
                    break;
                case 7:
                    addressBookPOJO.ShortByFName();
                    break;
                case 0:
                    System.out.println(" Bye " +name+ " see you next time ");
                    terminate=true;

                default:
                    System.out.println("Please select valid option");
                    break;

            }

        }

    }
}
