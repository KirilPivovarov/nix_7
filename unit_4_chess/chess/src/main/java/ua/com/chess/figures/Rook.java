package ua.com.chess.figures;

public class Rook extends AbstractPiece {

	public Rook(boolean isWhite) {
		super(isWhite);
	}

	private static Boolean straightPath(int srcRow, int srcCol, int destRow, int destCol) {
		return !((srcRow != destRow) && (srcCol != destCol));
	}

	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("wR");
		} else {
			System.out.print("bR");
		}
	}

	@Override
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
		return straightPath(srcRow, srcCol, destRow, destCol);
	}

	@Override
	public int relativeValue() {
		return 5;
	}

}
