package ru.netology;

public class PersonBuilder {
    String name;
    String surname;
    int age = -1;
    String address;

    public PersonBuilder setName(String name) throws IllegalStateException {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0 | age > 105) throw new IllegalArgumentException("Недопустимый возраст: " + age);
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException, IllegalArgumentException {
        if (this.name == null || this.name.isEmpty()) throw new IllegalStateException("Имя не заполнено");
        if (this.surname == null || this.surname.isEmpty()) throw new IllegalStateException("Фамилия не заполнена");
        try {
            if(age<0) {
                Person person = new Person(this.name, this.surname);
                person.setAddress(this.address);
                return person;
            }else {
                Person person = new Person(this.name, this.surname, this.age);
                person.setAddress(this.address);
                return person;
            }
                } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}