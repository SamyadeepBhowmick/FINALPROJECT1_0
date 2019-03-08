package com.cnippet.finalproject1_0;

public class UserDate {
    String atte;
    String roll;
    String name;

    public UserDate() {
    }

    public UserDate(String name,String atte,String roll)
    {
        this.name=name;
        this.atte = atte;
        this.roll=roll;
    }

    public String getname() {
        return name;
    }

    public String getatte() {
        return atte;
    }

    public String getroll() {
        return roll;
    }


}

