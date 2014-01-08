package applications;
import matrics.intMatrix;


public class MatrixZeroCheck {

	private intMatrix im;
	private int M;
	private int N;
	
	
	
	public MatrixZeroCheck(int M,int N){
		
		this.M = M;
		this.N = N;
		im = intMatrix.random(M, N);
	}
	
	public void checkZero(){
		
		im.print();
		
		boolean[] row = new boolean[M];
		boolean[] column = new boolean[N];
		int[][] matrix = im.getMatric();
		
		for(int i = 0; i< M; i++){
			for(int j = 0; j< N; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i< M; i++){
			for(int j = 0; j< N; j++){
				if(row[i]||column[j])
					matrix[i][j] = 0;
			}
		}
		
		im.print();
		
	}
	
}
