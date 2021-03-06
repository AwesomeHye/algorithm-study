/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.hyein.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QueueUsingTwoStacksTest {



    @Test
     public void customQueueTest() {
        QueueUsingTwoStacks customQueue = new QueueUsingTwoStacks();

        System.out.println("INPUT " + customQueue.enqueue(1));
        System.out.println("INPUT " + customQueue.enqueue(2));

        assertEquals(1, customQueue.dequeue());

        System.out.println("INPUT " + customQueue.enqueue(3));
        System.out.println("INPUT " + customQueue.enqueue(4));

        assertEquals(2, customQueue.dequeue());
        assertEquals(3, customQueue.dequeue());

        System.out.println("INPUT " + customQueue.enqueue(5));
        assertEquals(2, customQueue.size());
    }

    @Test
    public void customQueueTest3() {
        QueueUsingTwoStacks customQueue = new QueueUsingTwoStacks();

        System.out.println("INPUT " + customQueue.enqueue(1));
        System.out.println("INPUT " + customQueue.enqueue(2));
        System.out.println("INPUT " + customQueue.enqueue(3));

        assertEquals(1, customQueue.dequeue());

        System.out.println("INPUT " + customQueue.enqueue(4));

        assertEquals(2,customQueue.dequeue());

        assertEquals(2, customQueue.size());
    }

    @Test
    public void customQueueTest2() {
        QueueUsingTwoStacks customQueue = new QueueUsingTwoStacks();

        System.out.println("INPUT " + customQueue.enqueue(1));
        System.out.println("INPUT " + customQueue.enqueue(2));
        System.out.println("INPUT " + customQueue.enqueue(3));

        assertEquals(1,customQueue.dequeue());
        assertEquals(2,customQueue.dequeue());

        System.out.println("INPUT " + customQueue.enqueue(4));

        assertEquals(3,customQueue.dequeue());

        System.out.println("INPUT " + customQueue.enqueue(5));
        System.out.println("INPUT " + customQueue.enqueue(6));
        System.out.println("INPUT " + customQueue.enqueue(7));

        assertEquals(4,customQueue.dequeue());

        assertEquals(3, customQueue.size());
    }

    @Test
    public void emptyTest() {
        QueueUsingTwoStacks customQueue = new QueueUsingTwoStacks();

        assertNull(customQueue.dequeue()); //empty stack

    }

    @Test
    public void removeErrorTest() {
        QueueUsingTwoStacks customQueue = new QueueUsingTwoStacks();

        System.out.println("INPUT " + customQueue.enqueue(1));
        System.out.println("INPUT " + customQueue.enqueue(2));

        assertEquals(1,customQueue.dequeue());
        assertEquals(2,customQueue.dequeue());
        assertNull(customQueue.dequeue());
    }

}
