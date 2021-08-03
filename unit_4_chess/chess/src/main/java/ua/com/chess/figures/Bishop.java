package ua.com.chess.figures;

public class Bishop extends AbstractPiece {

	public Bishop(boolean isWhite) {
		super(isWhite);
	}

	private static Boolean diagonalPath(int srcRow, int srcCol, int destRow, int destCol) {
		return ((Math.abs(srcRow - destRow) == Math.abs(srcCol
				- destCol)));
	}

	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("wB");
		} else {
			System.out.print("bB");
		}
	}

	@Override
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
		return diagonalPath(srcRow, srcCol, destRow, destCol);
	}

	@Override
	public int relativeValue() {
		return 3;
	}

}
