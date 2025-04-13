package org.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SharedObjectWithLockTest {

    @Test
    void givenMultiThread_whenBlockSyncWithLock() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedObjectWithLock sharedObjectWithLock = new SharedObjectWithLock();

        IntStream.range(0, 1000)
            .forEach(count ->
                service.submit(sharedObjectWithLock::perform));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, sharedObjectWithLock.counter);
    }


    @Test
    void givenMultiThread_whenBlockSyncWithTryLock() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedObjectWithLock sharedObjectWithLock = new SharedObjectWithLock();

        IntStream.range(0, 1000)
            .forEach(count ->
                service.submit(sharedObjectWithLock::performTryLock));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, sharedObjectWithLock.counter);
    }

}