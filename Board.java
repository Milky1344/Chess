import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class Board extends JComponent{
	public ArrayList<Piece> whitePieces;
	public ArrayList<Piece> blackPieces;
	private int turn = 1;
	private Square[][] squares;
	
	public void initializeGrid() {
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				squares[r][c] = new Square(r,c,null);
			}
		}
		
		for(int c = 0; c < 8; c++) {
			squares[6][c] = new Square(6,c,new Pawn(true));
		}
		squares[7][0] = new Square(7,0,new Rook(true));
		squares[7][1] = new Square(7,1,new Knight(true));
		squares[7][2] = new Square(7,2,new Bishop(true));
		squares[7][3] = new Square(7,3,new Queen(true));
		squares[7][4] = new Square(7,4,new King(true));
		squares[7][5] = new Square(7,5,new Bishop(true));
		squares[7][6] = new Square(7,6,new Knight(true));
		squares[7][7] = new Square(7,7,new Rook(true));
		
		for(int c = 0; c < 8; c++) {
			squares[1][c] = new Square(6,c,new Pawn(false));
		}
		squares[0][0] = new Square(0,0,new Rook(false));
		squares[0][1] = new Square(0,1,new Knight(false));
		squares[0][2] = new Square(0,2,new Bishop(false));
		squares[0][3] = new Square(0,3,new Queen(false));
		squares[0][4] = new Square(0,4,new King(false));
		squares[0][5] = new Square(0,5,new Bishop(false));
		squares[0][6] = new Square(0,6,new Knight(false));
		squares[0][7] = new Square(0,7,new Rook(false));
	}

	public void testPieceGrid() {
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				squares[r][c] = new Square(r,c,null);
			}
		}
		squares[4][3] = new Square(4,3,new Pawn(false));
		squares[3][3] = new Square(3,3,new Pawn(false));
		squares[4][4] = new Square(4,4,new Pawn(false));
		squares[4][5] = new Square(4,5,new Pawn(false));
		squares[5][4] = new Square(5,4,new Pawn(true));
		squares[4][0] = new Square(4,0,new Pawn(false));
		squares[4][2] = new Square(4,2,new Pawn(false));
		squares[5][1] = new Square(5,1,new Pawn(true));
		squares[6][3] = new Square(6,3,new Pawn(true));
		
		
		
		
		
	}
	public Board() {
		squares = new Square[8][8];
		whitePieces = new ArrayList();
		blackPieces = new ArrayList();
		
		initializeGrid();
		testPieceGrid();
		
		this.setPreferredSize(new Dimension(512,512));
        this.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(1000, 1000));
 
        this.setVisible(true);
        this.requestFocus();
        this.repaint();
	}
	
	public void refresh() {
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		boolean flip = true;
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(flip) {
					g.setColor(Color.blue);
				} else {
					g.setColor(Color.pink);
				}
				g.fillRect(r*64,c*64,64,64);
				flip = !flip;
			}
			flip = !flip;
		}
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(squares[r][c].getPiece() != null) {
					squares[r][c].getPiece().print(this, g, c*64, r*64);
				}
			}
		}
		
	}
	
	public Square getSquare(int rank, int file) {
		return squares[rank][file];
	}
}
