import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Rook extends Piece{
	private final ImageIcon WHITE_PIECE = new ImageIcon("whiteRook.png");
	private final ImageIcon BLACK_PIECE = new ImageIcon("blackRook.png");
	
	public Rook(boolean white) {
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
	public boolean isValid(Board board, Square start, Square end) {
		if()
	}

}
