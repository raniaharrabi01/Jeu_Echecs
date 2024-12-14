package PiécesDuJeu;

import PlateauDeJeu.Position;

public class RookMoveStrategy implements MovementStrategy {
    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        if (from.getRow() == to.getRow()) {
            // Mouvement horizontal
            int direction = (to.getCol() > from.getCol()) ? 1 : -1;
            for (int col = from.getCol() + direction; col != to.getCol(); col += direction) {
                if (board[from.getRow()][col] != null) {
                    return false; // Il y a une pièce qui bloque le chemin
                }
            }
            return true;
        } else if (from.getCol() == to.getCol()) {
            // Mouvement vertical
            int direction = (to.getRow() > from.getRow()) ? 1 : -1;
            for (int row = from.getRow() + direction; row != to.getRow(); row += direction) {
                if (board[row][from.getCol()] != null) {
                    return false; // Il y a une pièce qui bloque le chemin
                }
            }
            return true;
        }
        return false; // Si le mouvement n'est ni horizontal, ni vertical
    }
}
