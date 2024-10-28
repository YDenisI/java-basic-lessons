package ru.gpncr.java.basic.lessons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    @Test
    void elementsAfterLastOneTest() {
        assertArrayEquals(new int[]{2, 2}, HomeWork.elementsAfterLastOne(new int[]{1, 2, 1, 2, 2}));
        assertThrows(RuntimeException.class, () -> HomeWork.elementsAfterLastOne(new int[]{2, 2, 2, 2}));
    }

    @Test
    void validateArrayTest() {
        assertTrue(HomeWork.validateArray(new int[]{1, 2}));
        assertFalse(HomeWork.validateArray(new int[]{1, 1}));
        assertFalse(HomeWork.validateArray(new int[]{1, 3}));
        assertTrue(HomeWork.validateArray(new int[]{1, 2, 2, 1}));
        assertFalse(HomeWork.validateArray(new int[]{3, 1, 2}));
    }
}