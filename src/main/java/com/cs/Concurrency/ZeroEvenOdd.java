package com.cs.Concurrency;

import java.util.function.IntConsumer;

/**
 * @program: Concurrency
 * @author: FreeThinking
 * @create: 2021-11-09 17:22
 * @description: 打印零与奇偶数
 **/
public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    }
}
