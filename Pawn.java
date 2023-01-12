import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Pawn extends Piece{
	private final ImageIcon WHITE_PIECE = new ImageIcon("whitePawn.png");
	private final ImageIcon BLACK_PIECE = new ImageIcon("blackPawn.png");
	private boolean atStart = true;
	private boolean atEnd = true;
	
	public Pawn(boolean white) {
		super(white);
	}

	@Override
	public void print(Component b, Graphics g, int x, int y) {
		if(this.isWhite()) 
			WHITE_PIECE.paintIcon(b,g,x,y);
		else 
			BLACK_PIECE.paintIcon(b,g,x,y);
	}
	
	public void moved() {
		this.atStart = false;
	}
	
	public boolean isAtStart() {
		return this.atStart;
	}

	@Override
	public boolean isValid(Board board, Square start, Square end) {
		int rank1 = start.getRank();
		int file1 = start.getFile();
		int rank2 = end.getRank();
		int file2 = end.getFile();
		//Stores the pieces directly in front, 2 squares in front, 
		Piece pieceInFront;
		Piece piece2InFront;
		Piece pieceFrontRight;
		Piece pieceFrontLeft;
		if(this.isWhite()) {
			pieceInFront = board.getSquare(rank1 - 1,file1).getPiece();
			if(pieceInFront == null && file2 == file1) {
				piece2InFront = board.getSquare(rank1 - 2,file1).getPiece();
				if(rank2 == rank1 - 1 && !this.isAtStart()) {
					return true;
					
				} else if(this.isAtStart() && (rank2 == rank1 - 1 || rank2 == rank1 - 2 && piece2InFront == null)) {
					this.moved();
					return true;
				}

			} else {
				System.out.println("Is taking");
				pieceFrontRight = board.getSquare(rank1 - 1,file1 + 1).getPiece();
				pieceFrontLeft = board.getSquare(rank1 - 1,file1 - 1).getPiece();
				
				if(pieceFrontRight != null && !pieceFrontRight.isWhite() && file2 == file1 + 1) {
					this.moved();
					return true;
					
				} else if(pieceFrontLeft != null && !pieceFrontLeft.isWhite() && file2 == file1 - 1) {
					this.moved();
					return true;
				}
			}
		} else {
			pieceInFront = board.getSquare(rank1 + 1,file1).getPiece();
			if(pieceInFront == null && file2 == file1) {
				piece2InFront = board.getSquare(rank1 + 2,file1).getPiece();
				if(rank2 == rank1 + 1 && !this.isAtStart()) {
					return true;
					
				} else if(this.isAtStart() && (rank2 == rank1 + 1 || rank2 == rank1 + 2 && piece2InFront == null)) {
					this.moved();
					return true;
				}

			} else {
				System.out.println("Is taking");
				pieceFrontRight = board.getSquare(rank1 + 1,file1 + 1).getPiece();
				pieceFrontLeft = board.getSquare(rank1 + 1,file1 - 1).getPiece();
				
				if(pieceFrontRight != null && !pieceFrontRight.isWhite() && file2 == file1 + 1) {
					this.moved();
					return true;
					
				} else if(pieceFrontLeft != null && !pieceFrontLeft.isWhite() && file2 == file1 - 1) {
					this.moved();
					return true;
				}
			}
		}
		return false;
	}
}
