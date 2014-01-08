import applications.MatrixRotate;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		//booleanMatrix bm = new booleanMatrix(3,2);
//		booleanMatrix bm = booleanMatrix.random(4, 5);
//		bm.print();
		
		
//		intMatrix im = intMatrix.random(4, 5);
//		im.print();
//		MatrixZeroCheck mzc = new MatrixZeroCheck(4,5);
//		mzc.checkZero();
		
		MatrixRotate mr = new MatrixRotate(5,3);
		mr.rotateRight90();
		mr.rotateLeft90();
		
		
	}

}
