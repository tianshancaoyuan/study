package com.black.dog;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MyQueueTest {
    MyQueue<Integer> queue = new MyQueue<>();

    @Test
    public void push() {
        assertTrue(queue.push(1) == true);
        assertTrue(queue.push(2) == true);
        assertTrue(queue.push(3) == true);
    }

    @Test
    public void pop() throws IOException {
        assertTrue(queue.push(1) == true);
        assertTrue(queue.push(2) == true);
        assertTrue(queue.push(3) == true);

        assertTrue(queue.pop() == 1);
        assertTrue(queue.pop() == 2);
        assertTrue(queue.pop() == 3);
    }

    @Test
    public void peek() {
        assertTrue(queue.push(1) == true);
        assertTrue(queue.push(2) == true);
        assertTrue(queue.push(3) == true);

        assertTrue(queue.peek() == 1);
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty() == true);

        assertTrue(queue.push(1) == true);
        assertTrue(queue.push(2) == true);
        assertTrue(queue.push(3) == true);

        assertTrue(queue.isEmpty() == false);
    }
}