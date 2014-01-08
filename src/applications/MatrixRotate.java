package applications;

import matrics.intMatrix;

public class MatrixRotate {

	private intMatrix im;

	public MatrixRotate(int M, int N) {

		im = intMatrix.random(M, N);
	}

	public void rotateRight90() {

		im.print();
		int[][] matrix = im.getMatric();

		int M = im.getM();
		int N = im.getN();

		intMatrix newim = new intMatrix(N, M);

		int[][] newMatric = newim.getMatric();

		for (int i = 0; i < N; i++) {
			for (int j = M - 1, k = 0; j >= 0; j--, k++) {
				newMatric[i][k] = matrix[j][i];
			}
		}
		im.setMatric(newMatric);

		newim.print();

	}
	
	public void rotateLeft90() {

		im.print();
		int[][] matrix = im.getMatric();

		int M = im.getM();
		int N = im.getN();

		intMatrix newim = new intMatrix(N, M);

		int[][] newMatric = newim.getMatric();

		for (int i = N-1,k=0; i >=0 ; i--,k++) {
			for (int j = 0; j <M; j++) {
				newMatric[k][j] = matrix[j][i];
			}
		}
		im.setMatric(newMatric);

		newim.print();

	}
}
