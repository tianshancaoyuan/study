package com.black.dog;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheData<K, E> {
    private volatile boolean isValid = false;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private HashMap<K, E> cache = new HashMap<>();

    /**
     * 读取数据
     */
    public E processCachedData(K key) {
        readWriteLock.readLock().lock();

        E value = null;
        try {
            if (isValid == false) {
                // step1: 释放读锁，否则无法申请写锁；
                readWriteLock.readLock().unlock();

                // step2:加写锁，防止其他线程更改数据；
                readWriteLock.writeLock().lock();

                try {
                    if (isValid == false) {
                        isValid = true;
                    }

                    value = cache.get(key);
                } finally {
                    // step3：释放写锁，重新申请读锁；
                    readWriteLock.readLock().lock();
                    readWriteLock.writeLock().unlock();
                }
            }
        } finally {
            readWriteLock.readLock().unlock();
        }

        return value;
    }

    /**
     * 写数据
     */
    public void writeData(K key, E data) {
        try {
            // 加写锁，保证只有一个线程更改数据。
            readWriteLock.writeLock().lock();
            cache.put(key, data);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
