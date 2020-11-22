package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testStack(){
        Stack q = new Stack();
        for(int i =0;i<10;i++){
            q.push(i);
            assertEquals(i,q.peek());

        }
        for(int i=9;i>=0;i--){
            assertEquals(i,q.peek());
            assertEquals(i,q.pop());
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testError(){
        Stack q = new Stack();
        q.peek();
    }
    
}
