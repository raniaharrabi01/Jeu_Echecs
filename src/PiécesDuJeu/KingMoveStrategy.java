package PiécesDuJeu;

import PlateauDeJeu.Position;

public class KingMoveStrategy implements MovementStrategy {
    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());

        return rowDiff <= 1 && colDiff <= 1; // une seule case dans toutes les directions
    }
    
}

