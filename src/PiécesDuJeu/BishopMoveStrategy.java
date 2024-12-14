package PiécesDuJeu;

import PlateauDeJeu.Position;

public class BishopMoveStrategy implements MovementStrategy { 
	
    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        if (Math.abs(to.getRow() - from.getRow()) == Math.abs(to.getCol() - from.getCol())) {
            int rowDirection = (to.getRow() > from.getRow()) ? 1 : -1;
            int colDirection = (to.getCol() > from.getCol()) ? 1 : -1;
            int row = from.getRow() + rowDirection;
            int col = from.getCol() + colDirection;
            
            while (row != to.getRow() && col != to.getCol()) {
                if (board[row][col] != null) {
                    return false; // Il y a une pièce qui bloque le chemin
                }
                row += rowDirection;
                col += colDirection;
            }
            return true;
        }
        return false;
    }
}
