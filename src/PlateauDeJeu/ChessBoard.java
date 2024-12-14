package PlateauDeJeu;

import PiécesDuJeu.Bishop;
import PiécesDuJeu.King;
import PiécesDuJeu.Knight;
import PiécesDuJeu.Pawn;
import PiécesDuJeu.Piece;
import PiécesDuJeu.Queen;
import PiécesDuJeu.Rook;

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];  // Plateau de 8x8
        setupBoard();
    }

    public void setupBoard() {
        // Initialiser des pièces blanches 
        board[0][0] = new Rook("White");
        board[0][1] = new Knight("White");
        board[0][2] = new Bishop("White");
        board[0][3] = new Queen("White");
        board[0][4] = new King("White");
        board[0][5] = new Bishop("White");
        board[0][6] = new Knight("White");
        board[0][7] = new Rook("White");
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("White");
        }
        // Initialiser des pièces noires
        board[7][0] = new Rook("Black");
        board[7][1] = new Knight("Black");
        board[7][2] = new Bishop("Black");
        board[7][3] = new Queen("Black");
        board[7][4] = new King("Black");
        board[7][5] = new Bishop("Black");
        board[7][6] = new Knight("Black");
        board[7][7] = new Rook("Black");
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("Black");
        }
    }
    
    public Piece getPieceAt(Position pos) {
        return board[pos.getRow()][pos.getCol()];
    }

        // Méthode pour déplacer une pièce
    public boolean movePiece(Position from, Position to) {
        Piece piece = board[from.getRow()][from.getCol()];
        if (piece == null) {
            System.out.println("Aucune pièce à déplacer");
            return false;  
        }
        
        if (!piece.isValidMove(from, to, board)) {
            System.out.println("Mouvement invalide pour la pièce");
            return false;  
        }
        
        board[to.getRow()][to.getCol()] = piece;
        board[from.getRow()][from.getCol()] = null;
        
        return true;  
    }
    
    public boolean isKingAlive(String color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece instanceof King && piece.getColor().equals(color)) {
                    return true;  // Le roi est encore sur le plateau
                }
            }
        }
        return false;  // Le roi est capturé
    }
}

