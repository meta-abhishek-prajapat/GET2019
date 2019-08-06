package Virat;

import static org.junit.Assert.*;

import org.junit.Test;

public class CricketTest {

	@Test
	public void testfindOrderOfBolres() throws Exception {
		
		assertArrayEquals(new int[] {1,1,2,1,2}, Cricket.findOrderOfBolres(5, 2, new int[] {3,2}));
		assertArrayEquals(new int[] {2,2,1,2,3}, Cricket.findOrderOfBolres(5, 3, new int[] {1,3,1}));
		assertArrayEquals(new int[] {2,2,1,2,1,2,3}, Cricket.findOrderOfBolres(7, 3, new int[] {2,4,1}));
		assertArrayEquals(new int[] {1,3,1,2,3,1,2,3,4}, Cricket.findOrderOfBolres(9, 4, new int[] {3,2,3,1}));
		assertArrayEquals(new int[] {2,2,3,7,1,2,3,4,5,6,7}, Cricket.findOrderOfBolres(11, 7, new int[] {1,3,2,1,1,1,2}));
		assertArrayEquals(new int[] {2,1,2,1,2}, Cricket.findOrderOfBolres(5, 2, new int[] {2,3}));
		assertArrayEquals(new int[] {1,1,3,1,3,1,2,3}, Cricket.findOrderOfBolres(8, 3, new int[] {4,1,3}));
		

	}


	@Test(expected=Exception.class)
	public void testfindOrderOfBolresNegative() throws Exception {
		assertArrayEquals(new int[] {2,3,4,1}, Cricket.findOrderOfBolres(13, 4, new int[] {1,6,3}));
		assertArrayEquals(new int[] {2,1,3}, Cricket.findOrderOfBolres(5, 2, new int[] {1,3,1}));
		assertArrayEquals(new int[] {2,1,3}, Cricket.findOrderOfBolres(50, 3, new int[] {2,4,1}));
		assertArrayEquals(new int[] {1,3,2,4}, Cricket.findOrderOfBolres(90, 4, new int[] {2,3,1}));
		assertArrayEquals(new int[] {2,3,7,1,4,5,6}, Cricket.findOrderOfBolres(10, 7, new int[] {1,3,2,1,1,1,2}));
		assertArrayEquals(new int[] {2,1}, Cricket.findOrderOfBolres(5, 2, new int[] {}));
		assertArrayEquals(new int[] {4,2,3,1}, Cricket.findOrderOfBolres(2, 4, new int[] {1,8,5,9}));
		assertArrayEquals(new int[] {1,4,2,3}, Cricket.findOrderOfBolres(21, 8, new int[] {10,3,2,6}));

	}
}