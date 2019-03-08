package com.cnippet.finalproject1_0;

public class User {
    String nam;
    String atte;
    String ptte;
    String roll;
    String date;

    public User(){

    }

    public User(String name,String ptte, String atte, String roll,String date) {
        this.nam = name;
        this.ptte=ptte;
        this.atte = atte;
        this.roll = roll;
        this.date=date;
    }


    public String getNam() {
        return nam;
    }

    public String getPtte(){
        return ptte;
    }

    public String getAtte() {
        return atte;
    }

    public String getRoll() {
        return roll;
    }

    public String getDate() {
        return date;
    }

}

