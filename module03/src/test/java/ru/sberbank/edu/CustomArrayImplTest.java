package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayImplTest {

    CustomArrayImpl<Integer> customArray = new CustomArrayImpl<>(10);

    @Test
    void size() {
        Assertions.assertThat(customArray.size()).isEqualTo(0);
        for (int i = 0; i < 5; i++) {
            customArray.add(1);
        }
        Assertions.assertThat(customArray.size()).isEqualTo(5);

    }

    @Test
    void isEmpty() {
        Assertions.assertThat(customArray.isEmpty()).isTrue();
    }

    @Test
    void add() {
        Assertions.assertThat(customArray.size()).isEqualTo(0);
        for (int i = 0; i < 5; i++) {
            customArray.add(1);
        }
        Assertions.assertThat(customArray.size()).isEqualTo(5);
    }

    @Test
    void addAll() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);

        Assertions.assertThat(customArray.size()).isEqualTo(4);
    }

    @Test
    void testAddAll() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        Collection<Integer> testCollection = new ArrayList<>();
        testCollection.addAll(List.of(intTestData));
        customArray.addAll(testCollection);

        Assertions.assertThat(customArray.size()).isEqualTo(4);
        Assertions.assertThat(customArray.get(0)).isEqualTo(1);
    }

    @Test
    void testAddAllCollection() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        Integer[] testIndexItems = new Integer[]{99,33};
        customArray.addAll(intTestData);

        Collection<Integer> testCollection = new ArrayList<>();
        testCollection.addAll(List.of(intTestData));
        customArray.addAll(2,testIndexItems);
        Assertions.assertThat(customArray.size()).isEqualTo(6);
        Assertions.assertThat(customArray.get(2)).isEqualTo(99);

    }

    @Test
    void get() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        Assertions.assertThat(customArray.get(2)).isEqualTo(3);
    }

    @Test
    void set() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        customArray.set(2,15);
        Assertions.assertThat(customArray.get(2)).isEqualTo(15);
    }

    @Test
    void remove() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        customArray.remove(2);
        Assertions.assertThat(customArray.get(2)).isEqualTo(4);
    }

    @Test
    void testRemove() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        Integer value = 1;
        customArray.addAll(intTestData);
        customArray.remove(value);
        Assertions.assertThat(customArray.get(0)).isEqualTo(2);
    }

    @Test
    void contains() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        Assertions.assertThat(customArray.contains(1)).isTrue();
        Assertions.assertThat(customArray.contains(99)).isFalse();
    }

    @Test
    void indexOf() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        Assertions.assertThat(customArray.indexOf(3)).isEqualTo(2);
    }

    @Test
    void ensureCapacity() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        customArray.ensureCapacity(15);
        Assertions.assertThat(customArray.getCapacity()).isEqualTo(10);
    }

    @Test
    void getCapacity() {
        Assertions.assertThat(customArray.getCapacity()).isEqualTo(10);
    }

    @Test
    void reverse() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        customArray.reverse();
        Assertions.assertThat(customArray.get(0)).isEqualTo(4);
        Assertions.assertThat(customArray.get(3)).isEqualTo(1);
    }

    @Test
    void toArray() {
        Integer[] intTestData = new Integer[]{1,2,3,4};
        customArray.addAll(intTestData);
        Object[] array = customArray.toArray();
        Assertions.assertThat(array[0]).isEqualTo(1);
    }
}