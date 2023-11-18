package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void compareTo() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Denis","Moscow",30));
        personList.add(new Person("Slava","Saint-Petersburg",44));
        personList.add(new Person("Denis","Novosibirsk",23));
        personList.add(new Person("Denis","Moscow",30));
        personList.sort(Person::compareTo);
        Assertions.assertThat(personList.get(0).toString()).isEqualTo("Person{name='Denis', city='Moscow', age=30}");
        Assertions.assertThat(personList.get(3).toString()).isEqualTo("Person{name='Slava', city='Saint-Petersburg', age=44}");
    }

    @Test
    void testEquals() {
        Person person1 = new Person("Denis","Moscow",30);
        Person person2 = new Person("Slava","Saint-Petersburg",44);
        Person person3 = new Person("Denis","Novosibirsk",23);
        Person person4 = new Person("Denis","Moscow",30);

        assertTrue(person1.equals(person4));
        assertFalse(person2.equals(person3));
    }

    @Test
    void testHashCode() {
        Person person1 = new Person("Denis","Moscow",30);
        Person person2 = new Person("Slava","Saint-Petersburg",44);
        Person person3 = new Person("Denis","Novosibirsk",23);
        Person person4 = new Person("Denis","Moscow",30);

        Assertions.assertThat(person1.hashCode()).isEqualTo(person4.hashCode());
        Assertions.assertThat(person2.hashCode()).isNotEqualTo(person4.hashCode());
    }
}