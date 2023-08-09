package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String adress;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.adress = null;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

    }


    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return adress != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        if (this.hasAddress()) {
            return this.adress;
        } else {
            System.out.println("Адресс отсутствует");
            return null;
        }
    }

    public void setAddress(String address) {
        this.adress = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        return " Имя '" + getName() + "'" +
                " Фамилия '" + getSurname() + "'" +
                " Возраст '" + getAge().getAsInt() + "'" +
                " Адресс '" + getAddress() + "'";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, adress);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(adress);
    }

}