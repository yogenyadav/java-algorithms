package knightmoves;

import java.util.concurrent.Callable;

public class CalculateMoves implements Callable<Integer> {
	private static enum MOVE_TYPE {
		DDR, UUL, ULL, URR, DDL, DLL, DRR, UUR;
	}

	public static final int COLS = 5;
	public static final int ROWS = 4;

	public static final char[][] blocks = { 
			{ 'A', 'B', 'C', 'D', 'E' },
			{ 'F', 'G', 'H', 'I', 'J' }, 
			{ 'K', 'L', 'M', 'N', 'O' },
			{ ' ', '1', '2', '3', ' ' } 
			};

	public CalculateMoves(int row, int col, int seqlen) {
		this.row = row;
		this.col = col;
		this.seqlen = seqlen;
	}

	private void getNextKnightMove(String seq, int row, int col, MOVE_TYPE lastMoveType) {
		if (blocks[row][col] != ' ') {
			seq += blocks[row][col];

			if (seq.length() == seqlen) {
				seqCount++;
				//System.out.println(seq);
			} else {
				if (countVowels(seq)) {
					// see if UUL is valid - if last move was DDR then UUL is invalid
					// as it will cause wrapping
					if (row - 2 >= 0 && col - 1 >= 0
							&& MOVE_TYPE.DDR != lastMoveType) {
						getNextKnightMove(seq, row - 2, col - 1, MOVE_TYPE.UUL);
					}

					// see if ULL is valid - if last move was DRR then ULL is invalid
					// as it will cause wrapping
					if (row - 1 >= 0 && col - 2 >= 0
							&& MOVE_TYPE.DRR != lastMoveType) {
						getNextKnightMove(seq, row - 1, col - 2, MOVE_TYPE.ULL);
					}

					// see if UUR is valid - if last move was DDL then UUR is invalid
					// as it will cause wrapping
					if (row - 2 >= 0 && col + 1 < COLS
							&& MOVE_TYPE.DDL != lastMoveType) {
						getNextKnightMove(seq, row - 2, col + 1, MOVE_TYPE.UUR);
					}

					// see if URR is valid - if last move was DLL then URR is invalid
					// as it will cause wrapping
					if (row - 1 >= 0 && col + 2 < COLS
							&& MOVE_TYPE.DLL != lastMoveType) {
						getNextKnightMove(seq, row - 1, col + 2, MOVE_TYPE.URR);
					}

					// see if DDL is valid - if last move was UUR then DDL is invalid
					// as it will cause wrapping
					if (row + 2 < ROWS && col - 1 >= 0
							&& MOVE_TYPE.UUR != lastMoveType) {
						getNextKnightMove(seq, row + 2, col - 1, MOVE_TYPE.DDL);
					}

					// see if DLL is valid - if last move was URR then DLL is invalid
					// as it will cause wrapping
					if (row + 1 < ROWS && col - 2 >= 0
							&& MOVE_TYPE.URR != lastMoveType) {
						getNextKnightMove(seq, row + 1, col - 2, MOVE_TYPE.DLL);
					}

					// see if DDR is valid - if last move was UUL then DDR is invalid
					// as it will cause wrapping
					if (row + 2 < ROWS
							&& col + 1 < COLS
							&& MOVE_TYPE.UUL != lastMoveType) {
						getNextKnightMove(seq, row + 2, col + 1, MOVE_TYPE.DDR);
					}

					// see if DRR is valid - if last move was ULL then DRR is invalid
					// as it will cause wrapping
					if (row + 1 < ROWS
							&& col + 2 < COLS
							&& MOVE_TYPE.ULL != lastMoveType) {
						getNextKnightMove(seq, row + 1, col + 2, MOVE_TYPE.DRR);
					}
				}
			}
		}
	}

	private static boolean countVowels(String seq) {
		char[] seqArray = seq.toCharArray();

		int vowelCount = 0;
		for (char c : seqArray) {
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O') {
				vowelCount++;

				if (vowelCount > 2) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public Integer call() throws Exception {
		getNextKnightMove("", row, col, null);
		return seqCount;
	}

	private final int row;
	private final int col;
	private final int seqlen;
	private int seqCount = 0;
}
