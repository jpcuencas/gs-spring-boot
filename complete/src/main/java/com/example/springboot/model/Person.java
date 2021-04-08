package com.example.springboot.model;

import java.util.Objects;

public class Person {
    private  Integer idPerson;
    private String name;
    private Integer age;

    public Person(Integer idPerson, String name, Integer age) {
        this.idPerson = idPerson;
        this.name = name;
        this.age = age;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(idPerson, person.idPerson) &&
                Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
