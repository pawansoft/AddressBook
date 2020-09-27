package com.addressBook.POJO;

import com.addressBook.Dao.AddressBookDAO;
import com.addressBook.Dao.FNameSorter;
import com.addressBook.Dao.SortByZipCode;
import com.addressBook.POJI.AddressBookPOJI;

import java.util.*;

public class AddressBookPOJO implements AddressBookPOJI {
    HashMap<String, AddressBookDAO> addressContainer=new HashMap<String, AddressBookDAO>();
    Scanner sc=new Scanner(System.in);
    @Override
    public HashMap<String, AddressBookDAO> save(String email,AddressBookDAO addressBookDAO) {
        try {
            addressContainer.put(email,addressBookDAO);
            return addressContainer;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
       return null;
    }
    @Override
    public void fetchAllDetails()
    {
        try
        {
            Set keys = addressContainer.keySet();
            Iterator it= keys.iterator();
            Collection getValues = addressContainer.values();
            it =getValues.iterator();
            while (it.hasNext())
            {
                System.out.println("Details are : "+it.next());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String deleteAddress(String key) {
        try
        {
            if(addressContainer.containsKey(key)==false)
            {
                System.out.println("Invalid Key !!!!!!!");
            }
            else {
                addressContainer.remove(key);

            }
            return "SuccessFully Deleted!!!!!";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public HashMap updateValue(String key, AddressBookDAO addressBookDAO) {
        try {
            if(addressContainer.containsKey(key) == false)
            {
                System.out.println("We do not found the key");
            }
            else if (addressContainer.containsKey(key)== true)
            {
                System.out.println("this is valid key");
                addressContainer.put(key, addressBookDAO);
            }
            return addressContainer;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public AddressBookDAO newAddressBook() {
        AddressBookDAO newAddressBookDAO=new AddressBookDAO();
        System.out.println("Enter the fName");
        String fName=sc.next();
        System.out.println("Enter the lName");
        String lName=sc.next();
        System.out.println("Enter The Address");
        String address=sc.next();
        System.out.println("Enter the city");
        String city=sc.next();
        System.out.println("Enter the state");
        String state=sc.next();
        System.out.println("Enter the zip Code");
        int zip=sc.nextInt();
        System.out.println("Enter the phone number");
        long phone = sc.nextLong();
        System.out.println("Enter your email Id");
        String email=sc.next();
        newAddressBookDAO.setfName(fName);
        newAddressBookDAO.setlName(lName);
        newAddressBookDAO.setAddress(address);
        newAddressBookDAO.setCity(city);
        newAddressBookDAO.setState(state);
        newAddressBookDAO.setZip(zip);
        newAddressBookDAO.setPhone(phone);
        newAddressBookDAO.setEmail(email);
        return newAddressBookDAO;
    }

    @Override
    public void fetchDetailById(String key) {
        try
        {
            if(addressContainer.containsKey(key)==false)
            {
                System.out.println("Email Id not found");
            }
            else
            {
                System.out.println("Found values are: ");
                System.out.println(addressContainer.get(key));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void shortByZipCode()
    {
        try {
            List <AddressBookDAO> valueList=new ArrayList<AddressBookDAO>(addressContainer.values());
            Collections.sort(valueList, new SortByZipCode());
            for (AddressBookDAO value : valueList)
            {
                System.out.println(value);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void ShortByFName()
    {
        try {
            List <AddressBookDAO> valueList=new ArrayList<AddressBookDAO>(addressContainer.values());
            Collections.sort(valueList, new FNameSorter());
            for (AddressBookDAO value : valueList)
            {
                System.out.println(value);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


