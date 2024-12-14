package PiécesDuJeu;

import PlateauDeJeu.Position;

public class Pawn extends Piece {
    public Pawn(String color) {
        super(color);
        setMoveStrategy(new PawnMoveStrategy(color));  
    }

    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        return getMoveStrategy().isValidMove(from, to, board);
    }
    
    @Override
    public String toString() {
        return color.equals("White") ? "white_pawn" : "black_pawn";
    }
}

