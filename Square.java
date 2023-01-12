
public class Square {
	private Piece piece = null;
	private int rank;
	//Rank means row or Y
	private int file;
	//File means column or X
	
	public Square(int rank, int file, Piece piece) {
		this.setPiece(piece);
		this.setRank(rank);
		this.setFile(file);
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getRank() {
		return rank;
	}
	
	public void setFile(int file) {
		this.file = file;
	}
	public int getFile() {
		return file;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public Piece getPiece() { 
		return this.piece;
	}
}
