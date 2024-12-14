package PiécesDuJeu;

import PlateauDeJeu.Position;

public class KnightMoveStrategy implements MovementStrategy {
	
    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());

        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
