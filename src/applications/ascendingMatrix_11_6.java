package applications;

/**
 * 
 * Question:
 * Given a M*N matrix,with each row and col in a sorted ascending order,
 * write a method to find an element
 * 
 * sol1:
 * Since both row and col are sorted,we can use binary search to each row or col to find it
 * It will take O(mlogn) or O(nlogm), better compare m and n first
 * 
 * sol2:
 * linear search O(m+n)
 * 5 10 15 20 25 30 
   9 14 19 24 29 34 
   13 18 23 28 33 38 
   17 22 27 32 37 42 
   21 26 31 36 41 46 
 * 
 * let's say 30 the right top,
 * if we 
 * --to be continued
 * 
 */

import matrics.intMatrix;

public class ascendingMatrix_11_6 extends intMatrix{

	public ascendingMatrix_11_6(int M, int N) {

		super(M, N);
		// fill in random numbers
		randomSortedInit();
	}
	
	public boolean findElementLinearly(int ele){
		int[][] matrix = getMatric();
		int row = 0;
		int col = matrix[0].length-1;
		while(row<matrix.length && col>=0){
			
			if(matrix[row][col] == ele)
				return true;
			else if(matrix[row][col] > ele)
				col--;
			else
				row++;
		}
		return false;
	}
	
}
