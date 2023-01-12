import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Bishop extends Piece{
	private final ImageIcon WHITE_PIECE = new ImageIcon("whiteBishop.png");
	private final ImageIcon BLACK_PIECE = new ImageIcon("blackBishop.png");
	
	public Bishop(boolean white) {
		super(white);
	}

	@Override
	public void print(Component b, Graphics g, int x, int y) {
		if(this.isWhite()) 
			WHITE_PIECE.paintIcon(b,g,x,y);
		else 
			BLACK_PIECE.paintIcon(b,g,x,y);
	}

	@Override
	public boolean isValid(int rank, int file) {
		return false;
	}

}
