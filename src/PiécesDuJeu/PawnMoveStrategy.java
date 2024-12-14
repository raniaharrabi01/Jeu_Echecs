package PiécesDuJeu;

import PlateauDeJeu.Position;

public class PawnMoveStrategy implements MovementStrategy {
    private String color;

    public PawnMoveStrategy(String color) {
        this.color = color;
    }

    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        int direction = (color.equals("White")) ? 1 : -1;

        // Déplacement d'une case en avant
        if (to.getCol() == from.getCol() && (to.getRow() == from.getRow() + direction) && board[to.getRow()][to.getCol()] == null) {
            return true;
        }

        // Capture en diagonale
        if (Math.abs(to.getCol() - from.getCol()) == 1 && to.getRow() == from.getRow() + direction) {
            Piece pieceAtDestination = board[to.getRow()][to.getCol()];
            if (pieceAtDestination != null && !pieceAtDestination.getColor().equals(color)) {
                return true;
            }
        }

        // Déplacement de deux cases à partir de la ligne initiale
        if (from.getRow() == (color.equals("White") ? 1 : 6) && to.getRow() == from.getRow() + 2 * direction &&
            from.getCol() == to.getCol() && board[to.getRow()][to.getCol()] == null && board[from.getRow() + direction][from.getCol()] == null) {
            return true;
        }

        return false;
    }
}
