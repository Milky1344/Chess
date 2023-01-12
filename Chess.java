import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Chess extends JFrame{
	private Board board;
	int x1, x2, y1, y2;
	int col1, col2, row1, row2;
	Square selectedSquare;
	Square endSquare;

	public Chess() {
		this.setTitle("Chess");
		board = new Board();
		this.add(board);
		this.addMouseListener(mouseAdapter);
		this.setLocation(10,10);
		this.pack();
		this.setVisible(true);
	}
	private MouseAdapter mouseAdapter = new MouseAdapter() {
		int turn = 1;
		public void mousePressed(MouseEvent e) {
			
			switch (turn) {
				case 1:
					x1 = e.getX() - 8;
					y1 = e.getY() - 31;
					col1 = (int) (x1 / 64.0);
					row1 = (int) (y1 / 64.0);
					selectedSquare = board.getSquare(row1, col1);
					if(selectedSquare.getPiece() != null && selectedSquare.getPiece().isWhite()) {
						System.out.print("White selected: (" + row1 + "," + col1 + ")     ");
						System.out.println("SelectedPiece: " + selectedSquare.getPiece());
						turn = 2;
					} else 
						turn = 1;
					break;
				case 2:
					x2 = e.getX() - 8;
					y2 = e.getY() - 31;
					col2 = (int) (x2 / 64.0);
					row2 = (int) (y2 / 64.0);
					endSquare = board.getSquare(row2, col2);
					if(row2 == row1 && col2 == col1) {
						System.out.println("Reselecting");
						turn = 1;
						break;
					} else if (endSquare.getPiece() != null && endSquare.getPiece().isWhite()){
						System.out.println("Selected new Piece");
						selectedSquare = endSquare;
						break;
					}
					System.out.println("Moved square was: " + "(" + row2 + "," + col2 + ")");
					if (selectedSquare.getPiece().isValid(board, selectedSquare, endSquare)) {
						endSquare.setPiece(null);
						endSquare.setPiece(selectedSquare.getPiece());
						selectedSquare.setPiece(null);
						System.out.println(selectedSquare.getRank() + "," + selectedSquare.getFile() + " " + selectedSquare.getPiece());
						System.out.println(endSquare.getRank() + "," + endSquare.getFile() + " " + endSquare.getPiece());
						board.repaint();
					} else {
						System.out.println("Try again");
					}
					turn = 1;
					break;
					}
					e = null;
			}
		};
	
	public static void main(String[] args) {
		Chess chess = new Chess();
	}
	
	public enum GameState {
		WHITE_TURN,
		BLACK_TURN,
	}
}
