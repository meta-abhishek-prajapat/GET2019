package com.metacube.sparsematrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SparseMatrix {
	
	public final Integer ROW=0;
	public final Integer COL=1;
	public final Integer VAL=2;
	
	public final Integer[][] sparseMatrix;

	public static void main(String[] args) {
		SparseMatrix sparse=new SparseMatrix(new Integer[][]{{0,1},{2,0}});
		SparseMatrix sparse2=new SparseMatrix(new Integer[][]{{3,4},{0,0}});
		Integer rows=sparse.sparseMatrix.length;
		Integer cols=sparse.sparseMatrix[0].length;
		/*for(int row=0;row<rows;row++){
			System.out.println();
			for(int col=0;col<cols;col++){
				System.out.print(sparse.sparseMatrix[row][col]+" ");
			}
		}
		System.out.println("---------------");
		Integer[][] transpose=sparse.MultiplyTwoMatrix(sparse.sparseMatrix,sparse2.sparseMatrix);
		for(int row=0;row<rows;row++){
			System.out.println();
			for(int col=0;col<cols;col++){
				System.out.print(transpose[row][col]+" ");
			}
		}*/
		System.out.println("symmetrical??"+sparse.SymmetricalMatrix());
	
	
	}
	
	
	
	public SparseMatrix(Integer[][] sparseMatrix) {
		super();
		this.sparseMatrix = CreateSparseMatrix(sparseMatrix);
	}
	
	/**
	 * Create sparse matrix
	 * @param matrix 2-d array
	 * @return sparse matrix
	 */
	private Integer[][] CreateSparseMatrix(Integer[][] matrix) {
		// TODO Auto-generated method stub
		Integer rows = matrix.length;
		Integer cols = matrix[0].length;
		Integer countNonZero=0;
		Integer sparseMatrix[][];
		for(int row=0;row<rows;row++){
			for(int col=0;col<cols;col++){
				if(matrix[row][col]!=0)
					countNonZero++;
			}
		}
		sparseMatrix=new Integer[countNonZero][3];
		Integer loop=0;
		for(int row=0;row<rows;row++){
			for(int col=0;col<cols;col++){
				if(matrix[row][col]!=0){
					sparseMatrix[loop][ROW]=row;
					sparseMatrix[loop][COL]=col;
					sparseMatrix[loop][VAL]=matrix[row][col];
					loop++;
				}
					
			}
		}
		return sparseMatrix;
	}
	
	/**
	 * Transpose the Matrix
	 * @return 2-d array transpose of matrix
	 */
	public Integer[][] TransposeMatrix(){
		Integer rows=this.sparseMatrix.length;
		Integer cols=3;
		Integer transposeMatrix[][]=new Integer[rows][cols];
		for(int row=0;row<rows;row++){
				transposeMatrix[row][ROW]=this.sparseMatrix[row][COL];
				transposeMatrix[row][COL]=this.sparseMatrix[row][ROW];
				transposeMatrix[row][VAL]=this.sparseMatrix[row][VAL];
		}
		this.sortbyColumn(transposeMatrix);
		return transposeMatrix;
	}
	
	/**
	 * Check matrix is symmetric or not
	 * @return if matrix is symmetric return true else false
	 */
	public boolean SymmetricalMatrix(){
		Integer[][] transpose=this.TransposeMatrix();
		this.sortbyColumn(transpose);
		Integer rows=this.sparseMatrix.length;
		Integer cols=this.sparseMatrix[0].length;
		for(int row=0;row<rows;row++){
			System.out.println();
			for(int col=0;col<cols;col++){
				if(transpose[row][col]!=this.sparseMatrix[row][col])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Add two sparse matrix
	 * @param mat1 first matrix
	 * @param mat2 second matrix
	 * @return addition of first and second matrix
	 */
	public Integer[][] AddMatrix(Integer[][] mat1,Integer[][] mat2){
		Integer loop=0;
		Integer addition[][] = new Integer [mat1.length][mat1[0].length];
		for(int row=0;row<mat1.length;row++){
				if(mat1[row][ROW]==mat2[row][ROW] && mat1[row][COL]==mat2[row][COL]){
					addition[loop][0]=mat1[row][ROW];
					addition[loop][1]=mat1[row][COL];
					addition[loop][2]=mat1[row][VAL]+mat2[row][VAL];
					loop++;
			}
		}
		return addition;
		
	}
	
	/**
	 * Multiply two sparse matrix
	 * @param mat1 first matrix
	 * @param mat2 second matrix
	 * @return Multiplication of first and second matrix
	 */
	public Integer[][] MultiplyTwoMatrix(Integer[][] mat1,Integer[][] mat2){
		List<Integer[]> rcv= new ArrayList<Integer[]>();
		for(int rows=0;rows<mat1.length;rows++){
			for(int cols=0;cols<mat2.length;cols++){
				int sumValue=0;
				if(mat1[rows][COL]==mat2[cols][ROW]){
					sumValue=mat1[rows][VAL]*mat2[cols][VAL];	
					if(rows>0 && rcv.size()>0){
						int oldRow = rcv.get(rcv.size()-1)[ROW];															
						int oldCol = rcv.get(rcv.size()-1)[COL];
						if(mat1[rows][ROW]==oldRow && mat2[cols][COL] ==oldCol ){
							int oldValue = rcv.get(rcv.size()-1)[VAL];
							sumValue += oldValue;
							rcv.remove(rcv.size()-1);
							rcv.add(new Integer[]{mat1[rows][ROW],mat2[cols][COL],sumValue});
						}
						else{
							rcv.add(new Integer[]{mat1[rows][ROW],mat2[cols][COL],sumValue});
						}
					}
					else{
						rcv.add(new Integer[]{mat1[rows][ROW],mat2[cols][COL],sumValue});
					}
				}
				
			}
		}
		Integer result[][]=new Integer[rcv.size()][3];
		rcv.toArray(result);
		return result;
	}
	
	public void sortbyColumn(Integer arr[][]) { 
	       Arrays.sort(arr, new Comparator<Integer[]>() { 
	          @Override              
	           public int compare(Integer[] entry1, Integer[] entry2) {
	        	  System.out.println("entryyy1  ");
	        	  for(int loop=0;loop<entry1.length;loop++){
	        		  System.out.print(entry1[loop]+"  ");
	        	  }
	        	  System.out.println("entryyy2  ");
	        	  for(int loop=0;loop<entry2.length;loop++){
	        		  System.out.print(entry2[loop]+"  ");
	        	  }
	              if(entry1[0] == entry2[0]){
	                     return entry1[1] - entry2[1];
	              }
	              return entry1[0] - entry2[0];
	           }
	       });     
	    } 
	
	
}
