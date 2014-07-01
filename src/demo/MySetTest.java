package demo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MySetTest {

	@Test
	public void testSizeEmpty() {
		MySet s = new MySet();
		Assert.assertEquals(0, s.size());
	}
	
	@Test
	public void testSizeOne() {
		MySet s = new MySet();
		Assert.assertEquals(0, s.size());
	}

}
