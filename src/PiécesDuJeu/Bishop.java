package PiécesDuJeu;

import PlateauDeJeu.Position;

public class Bishop extends Piece {
	
    public Bishop(String color) {
        super(color);
        setMoveStrategy(new BishopMoveStrategy());
    }

    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        return getMoveStrategy().isValidMove(from, to, board);
    }
    
    @Override
    public String toString() {
        return color.equals("White") ? "white_Bishop" : "black_Bishop";
    }

}

