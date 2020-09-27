package com.addressBook.POJI;

import com.addressBook.Dao.AddressBookDAO;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookPOJI {
    public HashMap save(String email, AddressBookDAO addressBookDAO);
    public void fetchAllDetails();
    public String deleteAddress(String key);
    public  HashMap updateValue(String key, AddressBookDAO addressBookDAO);
    public AddressBookDAO newAddressBook();
    public void fetchDetailById(String key);
    public void shortByZipCode();
    public void ShortByFName();
}
