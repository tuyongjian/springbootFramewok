package com.tu.webapp.configura;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: tuyongjian
 * @Date: 2020/5/9 16:56
 * @Description:
 */
public class AtomicIntegerTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {

    AtomicText atomicText1 = new AtomicText();
    AtomicReference<AtomicText> atomicReference = new AtomicReference(atomicText1);


    for( int j = 0; j< 100;j++) {
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
               if (atomicReference.compareAndSet(atomicText1, atomicReference.get())) {
                    atomicText1.setAge(atomicText1.getAge()+1);
                   System.out.println("size:"+ atomicInteger.getAndIncrement());
                } else {
                    System.out.println("size:"+ atomicInteger.getAndIncrement());
                }
            }
        });
        t2.start();
    }

        Thread.sleep(10000);
        System.out.println(atomicText1.getAge());

    }
}
