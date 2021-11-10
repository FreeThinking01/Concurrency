package com.cs.Concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;


/**
 * @program: Concurrency
 * @author: FreeThinking
 * @create: 2021-11-09 17:22
 * @description: 打印零与奇偶数
 *
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 **/
public class ZeroEvenOdd {

    private int n;
    Semaphore zeroSemaphore = new Semaphore(1); //0
    Semaphore evenSemaphore = new Semaphore(0); //奇数
    Semaphore oddSemaphore = new Semaphore(0);  //偶数

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);

            if (i % 2 == 0){
                oddSemaphore.release();
            }else {
                evenSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0){
                oddSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1){
                evenSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }
    }
}
