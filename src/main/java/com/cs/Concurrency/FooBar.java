package com.cs.Concurrency;

import java.util.concurrent.Semaphore;

/**
 * @program: Concurrency
 * @author: FreeThinking
 * @create: 2021-11-09 16:53
 * @description: 交替打印FooBar
 **/
public class FooBar {

    //1. Semaphore
    private int n;
    Semaphore semaphoreFoo = new Semaphore(1);
    Semaphore semaphoreBar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();
        }
    }

    //2. CyclicBarrier



    //3. Thread.yield()

    //4. ReentrantLock

    //5. BlockingQueue

    //6. synchronized

    //7. LockSupport





}
