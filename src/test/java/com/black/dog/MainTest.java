package com.black.dog;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    Solution solution = new Solution();

    @Test
    public void remin() {
        assertTrue(solution.remin() == 0);
    }
}