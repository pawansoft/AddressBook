package com.addressBook.Dao;

import java.util.Comparator;

public class SortByZipCode implements Comparator<AddressBookDAO> {
    @Override
    public int compare(AddressBookDAO o1, AddressBookDAO o2) {
        return o1.getZip() - o2.getZip();
    }
}
