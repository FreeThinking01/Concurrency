package com.cs.Concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Concurrency
 * @author: FreeThinking
 * @create: 2021-11-09 16:20
 * @description: 按序打印
 * 
 * 三个不同的线程 A、B、C 将会共用一个Foo实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 **/
public class Foo {

    public Foo() {

    }


    //设置同步保证三个方法按序执行
    
    //1. 使用信号量 atomicInteger
    AtomicInteger firstSemaphore = new AtomicInteger(-1);
    AtomicInteger secondSemaphore = new AtomicInteger(-1);
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstSemaphore.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (firstSemaphore.get() != 0){}
        printSecond.run();
        secondSemaphore.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (secondSemaphore.get() != 0){}
        printThird.run();
    }

    //2. 使用信号量
    Semaphore semaphore1 = new Semaphore(0);
    Semaphore semaphore2 = new Semaphore(0);
    public void first1(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore1.release();
    }

    public void second1(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        semaphore1.acquire();
        printSecond.run();
        semaphore2.release();
    }

    public void third1(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        semaphore2.acquire();
        printThird.run();
    }

}





















