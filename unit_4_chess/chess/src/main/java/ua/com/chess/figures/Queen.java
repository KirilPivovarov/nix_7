package ua.com.chess.figures;

public class Queen extends AbstractPiece {

	public Queen(boolean isWhite) {
		super(isWhite);
	}

	private static Boolean diagonalPath(int srcRow, int srcCol, int destRow, int destCol) {
		return ((Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol)));
	}

	private static Boolean straightPath(int srcRow, int srcCol, int destRow, int destCol) {
		return !((srcRow != destRow) && (srcCol != destCol));
	}

	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("wQ");
		} else {
			System.out.print("bQ");
		}
	}

	@Override
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
		return (diagonalPath(srcRow, srcCol, destRow, destCol))
				|| straightPath(srcRow, srcCol, destRow, destCol);
	}

	@Override
	public int relativeValue() {
		return 9;
	}

}
