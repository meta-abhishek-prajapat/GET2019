package com.metacube.search;

import java.util.Arrays;

public class Search {
	
	/**
	 * Find value in array by Linear Search
	 * @param array Given Array
	 * @param svalue Search Value
	 * @return if found return index of value else return -1 
	 */
	public static Integer linearSearch(Integer[] array,Integer svalue) {
		Integer length=array.length;
		if(array.length <= 0){
			return -1;
		}else if(array[length-1]==svalue) {
			return length-1;
		}
		Integer[] array2 = Arrays.copyOfRange(array, 0, length-1);
		return linearSearch(array2,svalue);
	}
	/**
	 * Find value in array by Binary Search
	 * @param array Given Array
	 * @param svalue Search Value
	 * @return if found return index of value else return -1 
	 */
	public static Integer binarySearch(Integer[] array,Integer svalue){
		Integer length = array.length;
		if(length<=0 || svalue<array[0] || svalue>array[length-1]){
				return -1;
		}
		
		Integer mid = (length-1)/2;
		if(array[mid]==svalue){
			return mid;
		}
		else if(array[mid]>svalue){
			Integer[] array2 = Arrays.copyOfRange(array, 0, mid);
			return binarySearch(array2,svalue);   
		}
		else{
			Integer[] array2 = Arrays.copyOfRange(array,mid+1,length-1);
			return binarySearch(array2,svalue);
		}

	}
}
