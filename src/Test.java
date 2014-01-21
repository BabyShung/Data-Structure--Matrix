import applications.ascendingMatrix_11_6;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		ZeroCheckMatrix mzc = new ZeroCheckMatrix(4, 5);
//		mzc.checkZero();
//
//		RotateMatrix mr = new RotateMatrix(5, 3);
//		mr.rotate90leftF_rightT(false);
//		mr.rotate90leftF_rightT(true);

		ascendingMatrix_11_6 am = new ascendingMatrix_11_6(5,6);
		am.print();
		System.out.println(am.findElementLinearly(24));
	}

}
