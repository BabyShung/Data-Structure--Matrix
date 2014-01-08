package matrics;
public class doubleMatrix {

	private final int M; // number of rows
	private final int N; // number of columns
	private final double[][] data; // M-by-N array

	// create M-by-N matrix of 0's
	public doubleMatrix(int M, int N) {
		this.M = M;
		this.N = N;
		data = new double[M][N];
	}

	// create matrix based on 2d array
	public doubleMatrix(double[][] data) {
		M = data.length;
		N = data[0].length;
		this.data = new double[M][N];
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				this.data[i][j] = data[i][j];
	}

	// copy constructor
	private doubleMatrix(doubleMatrix A) {
		this(A.data);
	}

	// create and return a random M-by-N matrix with values between 0 and 1
	public static doubleMatrix random(int M, int N) {
		doubleMatrix A = new doubleMatrix(M, N);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				A.data[i][j] = Math.random();
		return A;
	}

	// create and return the N-by-N identity matrix
	public static doubleMatrix identity(int N) {
		doubleMatrix I = new doubleMatrix(N, N);
		for (int i = 0; i < N; i++)
			I.data[i][i] = 1;
		return I;
	}

	// swap rows i and j
	private void swap(int i, int j) {
		double[] temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// create and return the transpose of the invoking matrix
	public doubleMatrix transpose() {
		doubleMatrix A = new doubleMatrix(N, M);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				A.data[j][i] = this.data[i][j];
		return A;
	}

	// return C = A + B
	public doubleMatrix plus(doubleMatrix B) {
		doubleMatrix A = this;
		if (B.M != A.M || B.N != A.N)
			throw new RuntimeException("Illegal matrix dimensions.");
		doubleMatrix C = new doubleMatrix(M, N);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				C.data[i][j] = A.data[i][j] + B.data[i][j];
		return C;
	}

	// return C = A - B
	public doubleMatrix minus(doubleMatrix B) {
		doubleMatrix A = this;
		if (B.M != A.M || B.N != A.N)
			throw new RuntimeException("Illegal matrix dimensions.");
		doubleMatrix C = new doubleMatrix(M, N);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				C.data[i][j] = A.data[i][j] - B.data[i][j];
		return C;
	}

	// does A = B exactly?
	public boolean eq(doubleMatrix B) {
		doubleMatrix A = this;
		if (B.M != A.M || B.N != A.N)
			throw new RuntimeException("Illegal matrix dimensions.");
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				if (A.data[i][j] != B.data[i][j])
					return false;
		return true;
	}

	// return C = A * B
	public doubleMatrix times(doubleMatrix B) {
		doubleMatrix A = this;
		if (A.N != B.M)
			throw new RuntimeException("Illegal matrix dimensions.");
		doubleMatrix C = new doubleMatrix(A.M, B.N);
		for (int i = 0; i < C.M; i++)
			for (int j = 0; j < C.N; j++)
				for (int k = 0; k < A.N; k++)
					C.data[i][j] += (A.data[i][k] * B.data[k][j]);
		return C;
	}

	// return x = A^-1 b, assuming A is square and has full rank
	public doubleMatrix solve(doubleMatrix rhs) {
		if (M != N || rhs.M != N || rhs.N != 1)
			throw new RuntimeException("Illegal matrix dimensions.");

		// create copies of the data
		doubleMatrix A = new doubleMatrix(this);
		doubleMatrix b = new doubleMatrix(rhs);

		// Gaussian elimination with partial pivoting
		for (int i = 0; i < N; i++) {

			// find pivot row and swap
			int max = i;
			for (int j = i + 1; j < N; j++)
				if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i]))
					max = j;
			A.swap(i, max);
			b.swap(i, max);

			// singular
			if (A.data[i][i] == 0.0)
				throw new RuntimeException("Matrix is singular.");

			// pivot within b
			for (int j = i + 1; j < N; j++)
				b.data[j][0] -= b.data[i][0] * A.data[j][i] / A.data[i][i];

			// pivot within A
			for (int j = i + 1; j < N; j++) {
				double m = A.data[j][i] / A.data[i][i];
				for (int k = i + 1; k < N; k++) {
					A.data[j][k] -= A.data[i][k] * m;
				}
				A.data[j][i] = 0.0;
			}
		}

		// back substitution
		doubleMatrix x = new doubleMatrix(N, 1);
		for (int j = N - 1; j >= 0; j--) {
			double t = 0.0;
			for (int k = j + 1; k < N; k++)
				t += A.data[j][k] * x.data[k][0];
			x.data[j][0] = (b.data[j][0] - t) / A.data[j][j];
		}
		return x;

	}

	// print matrix to standard output
	public void show() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.printf("%9.4f ", data[i][j]);
			System.out.println();
		}
	}

	// test client
	public static void main(String[] args) {
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		doubleMatrix D = new doubleMatrix(d);
		D.show();
		System.out.println();

		doubleMatrix A = doubleMatrix.random(5, 5);
		A.show();
		System.out.println();

		A.swap(1, 2);
		A.show();
		System.out.println();

		doubleMatrix B = A.transpose();
		B.show();
		System.out.println();

		doubleMatrix C = doubleMatrix.identity(5);
		C.show();
		System.out.println();

		A.plus(B).show();
		System.out.println();

		B.times(A).show();
		System.out.println();

		// shouldn't be equal since AB != BA in general
		System.out.println(A.times(B).eq(B.times(A)));
		System.out.println();

		doubleMatrix b = doubleMatrix.random(5, 1);
		b.show();
		System.out.println();

		doubleMatrix x = A.solve(b);
		x.show();
		System.out.println();

		A.times(x).show();

	}
}
