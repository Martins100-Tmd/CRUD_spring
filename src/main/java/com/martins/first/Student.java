package com.martins.first;

public class Student {
    private String name;
    private String email;
    private Long id;

    public Student(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id = id;
    };

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setid(Long id) {
        this.id = id;
    }

}
