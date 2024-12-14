package PiécesDuJeu;

import PlateauDeJeu.Position;

public class Queen extends Piece {
    public Queen(String color) {
        super(color);
        setMoveStrategy(new QueenMoveStrategy());  // Assignation de la stratégie spécifique
    }

    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        return getMoveStrategy().isValidMove(from, to, board);
    }
    
    @Override
    public String toString() {
        return color.equals("White") ? "white_Queen" : "black_Queen";
    }
}

