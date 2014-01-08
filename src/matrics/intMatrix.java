package matrics;
import java.util.Random;


public class intMatrix {


		private int M; // number of rows
		private int N; // number of columns
		private int[][] data; // M-by-N array
		
		public int[][] getMatric(){
			return data;
		}
		
		public void setMatric(int[][] matric){
			this.data = matric;
			this.M = matric.length;
			this.N = matric[0].length;
		}
		
		public int getM(){
			return M;
		}
		public int getN(){
			return N;
		}
		
		
		// create M-by-N intMatrix of 0's
		public intMatrix(int M, int N) {
			this.M = M;
			this.N = N;
			data = new int[M][N];
		}

		// create intMatrix based on 2d array
		public intMatrix(int[][] data) {
			M = data.length;
			N = data[0].length;
			this.data = new int[M][N];
			for (int i = 0; i < M; i++)
				for (int j = 0; j < N; j++)
					this.data[i][j] = data[i][j];
		}

		// copy constructor
		private intMatrix(intMatrix A) {
			this(A.data);
		}

		// create and return a random M-by-N intMatrix with values between 0 and 1
		public static intMatrix random(int M, int N) {
			intMatrix A = new intMatrix(M, N);
			Random rm = new Random();
			
			for (int i = 0; i < M; i++)
				for (int j = 0; j < N; j++)
					A.data[i][j] = rm.nextInt(2);
			return A;
		}
 
		 
		public void print(){
			for (int i = 0; i < M; i++){
				for (int j = 0; j < N; j++){
					System.out.print(data[i][j]+" ");
				}
				System.out.println();
			}
			
			System.out.println("------------");
		}
		
	}


