package ru.sberbank.edu;

import java.util.Objects;

public class Person implements Comparable<Person>{

    String name;

    String city;

    int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        if (this.city.equals(other.city)) {
            return this.city.compareTo(other.city);
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || !this.getClass().equals(object.getClass()))
            return false;
        Person person = (Person) object;
        return Objects.equals(name.toLowerCase(), person.name.toLowerCase()) && Objects.equals(city.toLowerCase(), person.city.toLowerCase()) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
