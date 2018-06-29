package com.fadila.android.tourguide;

import java.util.Locale;

public class dbfirebase {
    private String Name;
    private String Address;
    private String Category;
    private String MoreInfo;

    public dbfirebase() {

    }

    public dbfirebase(String Name, String Address, String Category, String MoreInfo) {
        this.Name = Name;
        this.Address = Address;
        this.Category = Category;
        this.MoreInfo = MoreInfo;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getCategory() {
        return Category;
    }

    public String getMoreInfo() {
        return MoreInfo;
    }
}
