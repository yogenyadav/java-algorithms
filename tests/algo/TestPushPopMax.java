package algo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestPushPopMax {

	@Test
	public void test1() {
		PushPopMax ppm = new PushPopMax();
		assertFalse(ppm.pop().isPresent());
		assertFalse(ppm.getMax().isPresent());
	}
	
	@Test
	public void test2() {
		PushPopMax ppm = new PushPopMax();
		ppm.push(2);
		ppm.push(3);
		ppm.push(4);
		ppm.push(5);
		assertEquals(5, ppm.getMax().get().intValue());
		assertEquals(5, ppm.pop().get().intValue());
		assertEquals(4, ppm.getMax().get().intValue());
		assertEquals(4, ppm.pop().get().intValue());
		assertEquals(3, ppm.getMax().get().intValue());
		assertEquals(3, ppm.pop().get().intValue());
		assertEquals(2, ppm.getMax().get().intValue());
		assertEquals(2, ppm.pop().get().intValue());
		assertFalse(ppm.getMax().isPresent());
		assertFalse(ppm.pop().isPresent());
	}

	@Test
	public void test3() {
		PushPopMax ppm = new PushPopMax();
		ppm.push(5);
		ppm.push(4);
		ppm.push(3);
		ppm.push(2);
		assertEquals(5, ppm.getMax().get().intValue());
		assertEquals(2, ppm.pop().get().intValue());
		assertEquals(5, ppm.getMax().get().intValue());
		assertEquals(3, ppm.pop().get().intValue());
		assertEquals(5, ppm.getMax().get().intValue());
		assertEquals(4, ppm.pop().get().intValue());
		assertEquals(5, ppm.getMax().get().intValue());
		assertEquals(5, ppm.pop().get().intValue());
		assertFalse(ppm.getMax().isPresent());
		assertFalse(ppm.pop().isPresent());
	}
}
