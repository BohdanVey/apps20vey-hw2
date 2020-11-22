package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import org.junit.Before;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList firstList;
    private ImmutableArrayList secondList;
    private ImmutableArrayList emptyList;
    private Object[] firstArr;
    private Object[] secondArr;
    private Object[] emptyArr;

    @Before
    public void setUp() throws Exception {
        firstArr = new Object[]{1};
        secondArr = new Object[]{1, 2, 3, 4, 5, 6};
        emptyArr = new Object[0];
        firstList = new ImmutableArrayList(firstArr);
        secondList = new ImmutableArrayList(secondArr);
        emptyList = new ImmutableArrayList();
    }

    public void checkArrays() {
        assertArrayEquals(firstList.toArray(), firstArr);
        assertArrayEquals(secondList.toArray(), secondArr);
        assertArrayEquals(emptyList.toArray(), emptyArr);
    }

    public void testAdd(ImmutableArrayList list, Object value) {
        ImmutableArrayList arr = (ImmutableArrayList) list.add(value);
        Object[] expected = new Object[list.size() + 1];
        for (int i = 0; i < list.size(); i++) {
            expected[i] = list.get(i);
        }
        expected[expected.length - 1] = value;
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(), expected.length);

    }

    @Test
    public void testAdd() {
        testAdd(firstList, 5);
        testAdd(secondList, 5);
        testAdd(emptyList, 5);
        checkArrays();
    }

    public void testAddIndex(ImmutableArrayList list, Object value, int index) {
        ImmutableArrayList arr = (ImmutableArrayList) list.add(index, value);

        Object[] expected = new Object[list.size() + 1];
        for (int i = 0; i < index; i++) {
            expected[i] = list.get(i);
        }
        expected[index] = value;
        for (int i = index; i < list.size(); i += 1)
            expected[i + 1] = list.get(i);
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);
    }

    @Test
    public void testAddIndex() {
        testAddIndex(firstList, 5, 0);

        testAddIndex(secondList, 5, 2);
        checkArrays();
    }

    public void testRemove(ImmutableArrayList list, int index) {
        ImmutableArrayList arr = (ImmutableArrayList) list.remove(index);
        Object[] expected = new Object[list.size() - 1];
        for (int i = 0; i < index; i++) {
            expected[i] = list.get(i);
        }
        for (int i = index; i < list.size() - 1; i++) {
            expected[i] = list.get(i + 1);
        }
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }

    @Test
    public void testRemove() {
        testRemove(firstList, 0);
        testRemove(secondList, 1);
        checkArrays();

    }
    public void testSet(ImmutableArrayList list, int index, Object value) {
        ImmutableArrayList arr = (ImmutableArrayList) list.set(index,value);
        Object[] expected = list.toArray();
        expected[index] = value;
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }
    @Test
    public void testSet() {
        testSet(firstList, 0, 3);
        testSet(secondList, 3, 6);
        checkArrays();
    }

    @Test
    public void testIndexOf(){
        assertEquals(firstList.indexOf(1),0);
        assertEquals(firstList.indexOf(3),-1);
        assertEquals(secondList.indexOf(3),2);
        assertEquals(secondList.indexOf(111),-1);
        assertEquals(emptyList.indexOf(111),-1);
        checkArrays();
    }

    @Test
    public void testSize(){
        assertEquals(firstList.size(),firstArr.length);
        assertEquals(secondList.size(),secondArr.length);
        assertEquals(emptyList.size(),0);
    }


    @Test
    public void testEmpty(){
        assertFalse(firstList.isEmpty());
        assertFalse(secondList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testString(){
        assertEquals(firstList.toString(),"1");
        assertEquals(secondList.toString(),"1, 2, 3, 4, 5, 6");
        assertEquals(emptyList.toString(),"");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetError() {
        emptyList.get(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetError2() {
        firstList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetError() {
        emptyList.set(0,4);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetError2() {
        firstList.set(1,4);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveError() {
        emptyList.remove(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveError2() {
        firstList.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddError() {
        emptyList.add(1,34);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddError2() {
        firstList.add(2,34);
    }

}
