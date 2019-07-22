package com.metacube.nqueen;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {

	@Test
    public void QueenTest() {
    	boolean expected = true;
    	int startingRow = 0;
        int sizeOfBoard = 4;
        int[][] array = new int[sizeOfBoard][sizeOfBoard];
    	assertEquals(expected, NQueen.nQueen(array,startingRow,sizeOfBoard));
    }
	//negative test case
    @Test
    public void QueenNegativeTest() {
    	boolean expected = false;
    	int startingRow = 0;
        int sizeOfBoard = 2;
        int[][] array = new int[sizeOfBoard][sizeOfBoard];
    	assertEquals(expected, NQueen.nQueen(array,startingRow,sizeOfBoard));
    }
}
