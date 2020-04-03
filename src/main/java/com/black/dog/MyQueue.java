package com.black.dog;

import java.io.IOException;

public class MyQueue<E> {
    // 队列最大空间；
    private static final int QUEUE_MAX_SIZE = 100;

    // 数组实现循环队列；
    private Object[] queue = new Object[QUEUE_MAX_SIZE];

    // 队列头部标记；
    private int start = 0;

    // 队列尾部标记；
    private int end = 0;

    // 队列实际数据大小
    private int size = 0;

    public boolean push(E data) {
        // step1: 队列满，插入失败。
        if (size >0 && start == end) {
            System.out.println("The queue is full, can't push data.");
            return false;
        }

        queue[end] = data;
        end = (end + 1)%QUEUE_MAX_SIZE;
        size++;

        return true;
    }

    public E pop() throws IOException {
        if (size == 0) {
            System.out.println("The queue is empty.");
            throw new IOException("The queue is empty.");
        }

        E data = (E)queue[start];
        start = (start + 1)%QUEUE_MAX_SIZE;
        size--;

        return data;
    }

    public E peek() {
        if (size == 0) {
            System.out.println("The queue is empty.");
            return null;
        }

        E data = (E)queue[start];

        return data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
