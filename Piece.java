import java.awt.*;

public abstract class Piece {
	private boolean white;
	private boolean killed = false;

	public Piece(boolean white) {
		this.setWhite(white);
	}
	
	public void setWhite(boolean white) {
		this.white = white;
	}
	public boolean isWhite() {
		return this.white;
	}
	
	public void setKilled(boolean killed) {
		this.killed = killed;
	}
	public boolean isKilled() {
		return this.killed;
	}
	
	public abstract void print(Component b, Graphics g, int x, int y);
	
	public boolean rightLine(Board board, Square start, Square end) {
		int startX = start.getFile();
		int startY = start.getRank();
		int endX = end.getFile();
		int endY = end.getRank();
		int deltaX = Math.abs(startX - endX);
		int deltaY = Math.abs(startY - endY);
		for(int )
	}
	
	public abstract boolean isValid(Board board, Square start, Square end);

	public boolean isValid(int rank, int file) {
		// TODO Auto-generated method stub
		return false;
	}
}