package com.fadila.android.tourguide;


public class Restaurant {

    private String mRestaurantName; //penentuan tipe data tiap variabel
    private String mRestaurantDescription;
    private int mRestaurantImageResourceId;
    private String mRestaurantUrl;

    public Restaurant (String restaurantName, String restaurantDescription, int restaurantImageResourceId, String restaurantUrl) {
        mRestaurantName = restaurantName; //inisiasi tiap variabel yang memiliki nilai
        mRestaurantDescription = restaurantDescription;
        mRestaurantImageResourceId = restaurantImageResourceId;
        mRestaurantUrl = restaurantUrl;
    }
    
    public String getRestaurantName() {
        return mRestaurantName;
    } //memanggil variabel yang memiliki nilai masing-masing
    
    public String getRestaurantDescription() {
        return mRestaurantDescription;
    }

    public int getRestaurantImageResourceId() {
        return mRestaurantImageResourceId;
    }

    public String getRestaurantUrl() {
        return mRestaurantUrl;
    }

    @Override
    public String toString() { //menentukan letak nama restaurant, deskripsi, dan images terkait
        return "Restaurant{" +
                " mRestaurantName= '" + mRestaurantName + "', " +
                " mRestaurantDescription= '" + mRestaurantDescription + "', " +
                " mRestaurantRestaurantImageResourceId= '" + mRestaurantImageResourceId +
                " mRestaurantUrl= '" + mRestaurantUrl + "'.";
    }
}
