package com.addressBook.Dao;

import java.util.Comparator;

public class FNameSorter implements Comparator<AddressBookDAO> {

    @Override
    public int compare(AddressBookDAO o1, AddressBookDAO o2) {
        return o1.getfName().compareTo((o2.getfName()));
    }
}
