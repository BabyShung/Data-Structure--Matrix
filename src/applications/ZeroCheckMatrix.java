package applications;

import matrics.intMatrix;

/**
 * Question: if any cell is 0, then the corresponding row and column should all
 * set to 0
 * 
 * @author haozheng
 * 
 */

public class ZeroCheckMatrix extends intMatrix {

	public ZeroCheckMatrix(int M, int N) {

		super(M, N);
		// fill in random numbers
		randomInit();
	}

	public void checkZero() {

		print();
		int M = getM();
		int N = getN();

		boolean[] row = new boolean[M];
		boolean[] column = new boolean[N];
		int[][] matrix = getMatric();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (row[i] || column[j])
					matrix[i][j] = 0;
			}
		}

		print();

	}

}
