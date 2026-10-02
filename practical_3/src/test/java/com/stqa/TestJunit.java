package com.stqa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJunit {

    @Test
    void testAddition() {
        int result = 10+20;
        assertEquals(30, result);
    }

}
