import applications.RotateMatrix;
import applications.ZeroCheckMatrix;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ZeroCheckMatrix mzc = new ZeroCheckMatrix(4, 5);
		mzc.checkZero();

		RotateMatrix mr = new RotateMatrix(5, 3);
		mr.rotate90leftF_rightT(false);
		mr.rotate90leftF_rightT(true);

	}

}
