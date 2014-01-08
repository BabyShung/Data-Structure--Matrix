package matrics;
import java.util.Random;


 
	public class booleanMatrix {

		private final int M; // number of rows
		private final int N; // number of columns
		private final boolean[][] data; // M-by-N array

		// create M-by-N booleanMatrix of 0's
		public booleanMatrix(int M, int N) {
			this.M = M;
			this.N = N;
			data = new boolean[M][N];
		}

		// create booleanMatrix based on 2d array
		public booleanMatrix(boolean[][] data) {
			M = data.length;
			N = data[0].length;
			this.data = new boolean[M][N];
			for (int i = 0; i < M; i++)
				for (int j = 0; j < N; j++)
					this.data[i][j] = data[i][j];
		}

		// copy constructor
		private booleanMatrix(booleanMatrix A) {
			this(A.data);
		}

		// create and return a random M-by-N booleanMatrix with values between 0 and 1
		public static booleanMatrix random(int M, int N) {
			booleanMatrix A = new booleanMatrix(M, N);
			Random rm = new Random();
			
			for (int i = 0; i < M; i++)
				for (int j = 0; j < N; j++)
					A.data[i][j] = rm.nextBoolean();
			return A;
		}
 
		 
		public void print(){
			for (int i = 0; i < M; i++){
				for (int j = 0; j < N; j++){
					System.out.print(data[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}

