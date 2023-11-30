package com.example.sqliteapplication;

public class UserModel {
    private int id;
    private String name;
    private String passwd;
    private boolean isActive;

    public UserModel(int id, String name, String passwd, boolean isActive) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.isActive = isActive;
    }

    public UserModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
