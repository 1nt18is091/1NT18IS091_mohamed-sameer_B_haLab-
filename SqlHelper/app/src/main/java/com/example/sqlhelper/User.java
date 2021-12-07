package com.example.sqlhelper;

public class User {
    private String userName;
    private String userPassword;
    private String fullName;
    public User(){
    }
    public User(String userName,String userPassword,String fullName){
        this.userName=userName;
        this.userPassword=userPassword;
        this.fullName=fullName;
    }
    public String getUserName(){
        return userName;
    }

    public String getUserPassword(){
        return userPassword;
    }
    public String getFullName(){
        return fullName;
    }
    public void setUserName(){
        this.userName=userName;
    }

    public void setUserPassworde(){
        this.userPassword=userPassword;
    }
    public void setFullName(){
        this.fullName=fullName;
    }

}

