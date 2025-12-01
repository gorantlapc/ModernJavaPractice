package org.pc.util.generics;

public sealed class Person permits Employee, Student {
    private final String name;
    private final int age;

    private final String profession;

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
