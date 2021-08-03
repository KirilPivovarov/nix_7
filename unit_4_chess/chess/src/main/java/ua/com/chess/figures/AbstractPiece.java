package ua.com.chess.figures;

public abstract class AbstractPiece {

	public boolean isWhite;

	public AbstractPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public abstract void draw();

	public abstract boolean isMoveValid(int srcRow, int srcCol, int destRow,
										int destCol);

	public abstract int relativeValue();

}
