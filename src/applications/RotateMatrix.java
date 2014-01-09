package applications;

import matrics.intMatrix;

public class RotateMatrix extends intMatrix {

	public RotateMatrix(int M, int N) {

		super(M, N);
		// fill in random numbers
		randomInit();
	}

	public void rotate90leftF_rightT(boolean LR) {

		print();
		int[][] matrix = getMatric();

		int M = getM();
		int N = getN();

		intMatrix newim = new intMatrix(N, M);
		int[][] newMatric = newim.getMatric();

		if (LR) {	//rotate right
			for (int i = 0; i < N; i++) {
				for (int j = M - 1, k = 0; j >= 0; j--, k++) {
					newMatric[i][k] = matrix[j][i];
				}
			}
		} else {	//rotate left
			for (int i = N - 1, k = 0; i >= 0; i--, k++) {
				for (int j = 0; j < M; j++) {
					newMatric[k][j] = matrix[j][i];
				}
			}
		}
		setMatric(newMatric);
		newim.print();
	}

}
