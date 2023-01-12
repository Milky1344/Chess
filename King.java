import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class King extends Piece{
	private final ImageIcon WHITE_PIECE = new ImageIcon("whiteKing.png");
	private final ImageIcon BLACK_PIECE = new ImageIcon("blackKing.png");
	
	public King(boolean white) {
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
		int rank1 = start.getRank();
		int file1 = start.getFile();
		int rank2 = end.getRank();
		int file2 = end.getFile();
		
		//up
		if(rank2 == rank1 + 1 && (file2 == file1 + 1 || file2 == file1 || file2 == file1 - 1))
			return true;
		//down
		else if (rank2 == rank1 - 1 && (file2 == file1 + 1 || file2 == file1 || file2 == file1 - 1))
			return true;
		//left & right
		else if (rank2 == rank1 && (file2 == file1 + 1 || file2 == file1 - 1))
			return true;

		return false;
	}

}
