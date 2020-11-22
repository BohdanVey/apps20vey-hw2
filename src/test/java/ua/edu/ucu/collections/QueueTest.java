package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testQueue(){
        Queue q = new Queue();
        for(int i =0;i<10;i++){
            q.enqueue(i);
        }
        for(int i=0;i<10;i++){
            assertEquals(i,q.peek());
            assertEquals(i,q.dequeue());
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testError(){
        Queue q = new Queue();
        q.peek();
    }
}
