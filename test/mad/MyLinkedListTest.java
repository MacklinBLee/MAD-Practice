package mad;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTest extends TestCase {

    private List myList;

    /**
     * This method will initialize a new MyLinkedList before each test is run
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myList = new MyLinkedList();
    }

    public void testSize() throws Exception {
        assertEquals(0, myList.size());
        myList.add("item");
        assertEquals(1, myList.size());
    }

    public void testIsEmpty() throws Exception {
        assertTrue(myList.isEmpty());
        myList.add("item");
        assertFalse(myList.isEmpty());
    }

    public void testContains() throws Exception {
        String item = "item";
        assertFalse(myList.contains(item));
        myList.add(item);
        assertTrue(myList.contains(item));
        
        myList.add(null);
        assertTrue(myList.contains(null));
    }

    public void testAdd() throws Exception {
        assertTrue(myList.add("item"));
        assertEquals(1, myList.size());
        assertTrue(myList.add("item2"));
        assertEquals(2, myList.size());
        assertTrue(myList.add("item"));
        assertEquals(3, myList.size());
        assertTrue(myList.add("another item"));
        assertEquals(4, myList.size());
        assertTrue(myList.add(null));
        assertEquals(5, myList.size());
    }

    public void testTenThousand() throws Exception {
        for(int i = 0; i < 10000; i++) {
            assertTrue(myList.add(Integer.toString(i)));
        }
        assertFalse(myList.isEmpty());
        assertEquals(10000, myList.size());
        for(int i = 0; i < 10000; i++) {
            assertTrue(myList.contains(Integer.toString(i)));
        }
        for(int i = 0; i < 10000; i++) {
            assertTrue(myList.remove(Integer.toString(i)));
        }
        assertTrue(myList.isEmpty());
        assertEquals(0, myList.size());
    }

    public void testRemove() throws Exception {
        myList.add("item");
        assertTrue(myList.remove("item"));

        myList.add("item2");
        assertEquals("item2", myList.remove(0));

        myList.add("a");
        myList.add("b");
        assertEquals("b", myList.remove(1));
        assertTrue(myList.contains("a"));
    }

    public void testClear() throws Exception {
        myList.add("a");
        myList.add("b");
        myList.clear();
        assertTrue(myList.isEmpty());
    }

    public void testGet() throws Exception {
        myList.add("a");
        myList.add("b");
        assertEquals("a", myList.get(0));
        assertEquals("b", myList.get(1));
        try {
            myList.get(2);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // pass
        }
    }

    public void testSet() throws Exception {
        myList.add("a");
        myList.add("b");
        myList.set(0, "c");
        myList.set(1, "d");
        assertEquals("c", myList.get(0));
        assertEquals("d", myList.get(1));
        try {
            myList.set(2, "e");
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // pass
        }
    }

    public void testAddIndex() throws Exception {
        myList.add("a"); // index 0
        myList.add("b"); // index 1
        myList.add("d"); // index 2
        myList.add(2, "c");
        assertEquals("a", myList.get(0));
        assertEquals("b", myList.get(1));
        assertEquals("c", myList.get(2));
        assertEquals("d", myList.get(3));
    }

    public void testRemoveObject() throws Exception {
        myList.add("a"); // index 0
        myList.add("b"); // index 1
        myList.add("c"); // index 2
        assertEquals(3, myList.size());
        assertTrue(myList.remove("b"));
        assertEquals(2, myList.size());
        assertFalse(myList.contains("b"));
        assertTrue(myList.remove("c"));
        assertEquals(1, myList.size());
        assertFalse(myList.remove("d"));
        assertEquals(1, myList.size());
    }

    public void testIndexOf() throws Exception {
        myList.add("a"); // index 0
        myList.add("b"); // index 1
        myList.add("c"); // index 2
        myList.add("d"); // index 3
        assertEquals(3, myList.indexOf("d"));
        assertEquals(2, myList.indexOf("c"));
        assertEquals(1, myList.indexOf("b"));
        assertEquals(0, myList.indexOf("a"));
        assertEquals(-1, myList.indexOf("e"));
    }

    public void testLastIndexOf() throws Exception {
        myList.add("a"); // index 0
        myList.add("b"); // index 1
        myList.add("c"); // index 2
        myList.add("d"); // index 3
        myList.add("a"); // index 4
        assertEquals(4, myList.lastIndexOf("a"));
    }

    public void testSubList() throws Exception {
        myList.add("a"); // index 0
        myList.add("b"); // index 1
        myList.add("c"); // index 2
        myList.add("d"); // index 3
        myList.add("e"); // index 4
        List subList = myList.subList(1, 3);
        assertEquals(5, myList.size());
        assertEquals(2, subList.size());
        assertFalse(subList.contains("a"));
        assertTrue(subList.contains("b"));
        assertTrue(subList.contains("c"));
        assertFalse(subList.contains("d"));
        assertFalse(subList.contains("e"));

        subList = myList.subList(1, 1);
        assertTrue(subList.isEmpty());
    }

}