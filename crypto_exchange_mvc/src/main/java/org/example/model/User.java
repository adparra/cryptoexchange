package org.example.model;

public class User {
    protected String id;
    protected String name;
    protected String email;
    protected String password;

    public User(String id,String name,String email,String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }
}
