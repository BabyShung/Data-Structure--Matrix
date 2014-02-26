package applications;

/**
 * check Sudoku valid or not:
 * 9*9 board
 * 1.each row has 1 to 9 appeared only once
 * 2.each column has 1 to 9 appeared only once
 * 3.each subsquare has 1 to 9 appeared only once
 * 
 * Solution comes from N00tc0d3r, beautiful
 * 
 */

import java.util.Arrays;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		if (board.length != 9)
			return false;
		if (board[0].length != 9)
			return false;

		// check rows
		for (int i = 0; i < 9; ++i) {
			char[] row = Arrays.copyOf(board[i], 9);
			if (!isValid(row))
				return false;
		}
		// check columns
		for (int i = 0; i < 9; ++i) {
			char[] column = new char[9];
			for (int j = 0; j < 9; ++j)
				column[j] = board[j][i];
			if (!isValid(column))
				return false;
		}
		// check box
		for (int i = 0; i < 3; ++i) {
			for (int k = 0; k < 9; k += 3) {
				char[] box = new char[9];
				for (int j = 0; j < 3; ++j)
					System.arraycopy(board[i * 3 + j], k, box, j * 3, 3);
				if (!isValid(box))
					return false;
			}
		}

		return true;
	}

	private boolean isValid(char[] block) {
		boolean[] numbers = new boolean[9];
		for (Character c : block) {
			if (c == '.')
				continue;
			if (!(c >= '1' || c <= '9') || numbers[c - '1'])
				return false;
			numbers[c - '1'] = true;
		}
		return true;
	}
}
