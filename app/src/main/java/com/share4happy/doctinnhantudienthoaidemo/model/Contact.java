package com.share4happy.doctinnhantudienthoaidemo.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public Contact(){
    }
    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
       return this.name+"\n"+this.phone;
    }
}
