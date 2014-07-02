package demo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MySetTest {

	@Test
	public void testSizeEmpty() {
		MySet s = new MySet();
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void testSizeOne() {
		MySet s = new MySet();
		s.add(1);
		assertEquals(1, s.size());
	}
	
	@Test
	public void testSize10K() {
		MySet s = new MySet();
		for (int i = 0; i < 10000; i++)
		{
			s.add(i);
			assertEquals(i+1, s.size());
		}
	}
	
	@Test
	public void testClear() {
		MySet s = new MySet();
		s.add(1);
		s.add(2);
		assertEquals(2, s.size());
		s.clear();
		assertEquals(0, s.size());
	}
	
	@Test
	public void testAdd() {
		MySet s = new MySet();
		s.add(1);
		assertEquals(1, s.size());
		assertEquals(false, s.add(1));
		assertEquals(1, s.size());
		assertEquals(true, s.add(2));
		assertEquals(2, s.size());
	}
	
	@Test
	public void testRemove() {
		MySet s = new MySet();
		s.add("Macklin");
		s.add("Luke");
		assertEquals(2, s.size());
		assertTrue(s.contains("Macklin"));
		assertTrue(s.remove("Luke"));
		assertFalse(s.contains("Luke"));
	}

}
