package ua.com.chess.figures;

public class King extends AbstractPiece {

	public King(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("wK");
		} else {
			System.out.print("bK");
		}
	}

	@Override
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
		return Math.abs(destRow - srcRow) <= 1
				|| Math.abs(destCol - srcCol) <= 1;
	}

	@Override
	public int relativeValue() {
		return 0;
	}

}
