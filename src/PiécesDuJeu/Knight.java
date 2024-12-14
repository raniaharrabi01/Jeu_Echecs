package PiécesDuJeu;

import PlateauDeJeu.Position;

public class Knight extends Piece {
    public Knight(String color) {
        super(color);
        setMoveStrategy(new KnightMoveStrategy());
    }

    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        return getMoveStrategy().isValidMove(from, to, board);
    }
    
    @Override
    public String toString() {
        return color.equals("White") ? "white_Knight" : "black_Knight";
    }
}
