package com.meta.junit.test;

public class ArrOperation {
	
	/**
	 * Find the size of the largest mirror section in array
	 * @param arr array of positive integer
	 * @return length of largest mirror section
	 */
	public static Integer MaxMirror(Integer arr[]){
		if(arr.length<1){
			throw new AssertionError("Array is empty");
		}
		Integer length=arr.length;
		Integer maxMirror=0,tempMax=0;
		Integer upper,lower;
		Integer lastIndex=length-1;
		for(int loop=0;loop<length;loop++){
			
			for(int innerLoop=lastIndex;innerLoop>=loop;innerLoop--){
				if(arr[loop]==arr[innerLoop]){
					tempMax=0;
					upper=loop;
					lower=innerLoop;
					
					while(upper<=lastIndex && lower>=0 && arr[upper]==arr[lower]){
						tempMax++;
						upper++;
						lower--;
						
					}
					if(maxMirror<tempMax)
						maxMirror=tempMax;
				}
			}
		}
		return maxMirror;
	}
	
	/**
	 * Find the numner of clumps in the array
	 * @param arr array as input
	 * @return count of clumps in array
	 */
	public static Integer CountClumps(Integer arr[]){
		if(arr.length<1){
			throw new AssertionError("Array is empty");
		}
		Integer length=arr.length-1;
		Integer count=0;
		Integer loop=0;
		while(loop<length){
			if(arr[loop]==arr[loop+1]){
				count++;
				while(loop<length && arr[loop]==arr[loop+1]){
					loop++;
				}
			}
			loop++;
		}
		return count;
	}
	
	
	/**
	 * Solve XY problem in array y should be just after x
	 * @param arr array as input 
	 * @param x x input
	 * @param y y input
	 * @return array after solving XY problem
	 */
	public static Integer[] fixXY(Integer arr[],Integer x,Integer y){
		
		if(arr.length<1){
			throw new AssertionError("Array is empty");
		}
		Integer lastIndex=arr.length-1;
		if(arr[lastIndex]==x){
			throw new AssertionError("X cannot be at last index");
		}
		Integer countx=0,county=0;
		for(int loop=0;loop<=lastIndex;loop++){
			if(arr[loop]==x)
				countx++;
			if(arr[loop]==y)
				county++;
			
		}
		if(countx!=county){
			throw new AssertionError("X and Y are unequal in number");
		}
		for(int loop=0;loop<lastIndex;loop++){
			if(arr[loop]==x && arr[loop+1]==x){
				throw new AssertionError("X cant be after X");
			}
		}
		Integer tempIndex,temp;
		for(int loop=0;loop<lastIndex;loop++){
			if(arr[loop]==x && arr[loop+1]!=y){
				tempIndex=getYIndex(arr,x,y);
				temp=arr[tempIndex];
				arr[tempIndex]=arr[loop+1];
				arr[loop+1]=temp;
			}
		}
		return arr;
	}
	
	public static Integer getYIndex(Integer arr[],Integer x,Integer y){
		Integer lastIndex=arr.length-1;
		if(arr[0]==y)
			return 0;
		for(int loop=1;loop<=lastIndex;loop++){
			if(arr[loop]==y && arr[loop-1]!=x)
				return loop;
		}
		return 0;
	}
	
	/**
	 * Split the array into two parts so that their sum is equal
	 * @param arr array as input
	 * @return index number if sum is equal otherwise return -1
	 */
	public static Integer splitArray(Integer arr[]){
		if(arr.length<1){
			throw new AssertionError("Array is empty");
		}
		Integer totalsum=0;
		
		Integer lastIndex=arr.length-1;
		for(int loop=0;loop<=lastIndex;loop++)
			totalsum+=arr[loop];
		if(totalsum%2!=0)
			return -1;
		Integer sum;
		for(int loop=0;loop<=lastIndex;loop++){
			sum=0;
			for(int innerloop=0;innerloop<=loop;innerloop++){
				sum+=arr[innerloop];
			}
			if(sum==(totalsum-sum)){
				return loop+1;
			}
		}
		
		return -1;
	}
}
