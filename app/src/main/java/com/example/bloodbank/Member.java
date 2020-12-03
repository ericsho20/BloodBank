package com.example.bloodbank;

public class Member {
    private String Name;
    private String Gender;
    private String Address;
    private String City;
    private String Phone;
    private String Spinner;
    private String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSpinner() {return Spinner;}

    public void setSpinner(String spinner) {Spinner = spinner; }

    public String getPhone() {return Phone;}

    public void setPhone(String phone) {Phone = phone;}

    public Member(){}

    public String getAddress() {return Address;}

    public void setAddress(String address) {Address = address;}


    public String getCity() {return City;}

    public void setCity(String city){City = city;}


    public String getName(){return Name;}

    public void setName(String name){Name = name;}


    public String getGender(){return Gender;}

    public void setGender(String gender){Gender = gender;}
}
