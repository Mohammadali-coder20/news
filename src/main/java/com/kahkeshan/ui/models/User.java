package com.kahkeshan.ui.models;

public class User {
    private String name;
    private String family;
    private String userName;
    private String passWord;
    private boolean isAdmin;
    private int userID;
    private String role;

    public User(String name, String family, String userName, String passWord,String role) {
        this.name = name;
        this.family = family;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        setAdmin(role);
    }

    public User(String name, String family, String userName, String passWord, boolean isAdmin, int userID) {
        this.name = name;
        this.family = family;
        this.userName = userName;
        this.passWord = passWord;
        this.isAdmin = isAdmin;
        this.userID = userID;
    }

    public User(String name, String family, String userName, String passWord) {
        this.name = name;
        this.family = family;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(String role) {
        if (role.equalsIgnoreCase("admin"))
            this.isAdmin = true;
        else
            this.isAdmin = false;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
        if(admin)
            setRole("admin");
        else
            setRole("user");
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", isAdmin=" + isAdmin +
                ", userID=" + userID +
                '}';
    }
}
