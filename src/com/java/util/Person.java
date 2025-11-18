package com.java.util;

public sealed class Person permits Employee, Student {
    private String name;
    private int age;

    private String profession;

    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
