package ru.sberbank.edu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomDigitComparatorTest {
    @Test
    void compare() {
        CustomDigitComparator customDigitComparator = new CustomDigitComparator();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i< 10; i++){
            list.add(i);
        }
        list.sort(customDigitComparator);
        Integer[] resultList=new Integer[]{2,4,6,8,1,3,5,7,9};
        assertArrayEquals(list.toArray(),resultList);
    }
}