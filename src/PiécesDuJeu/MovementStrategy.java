package PiécesDuJeu;

import PlateauDeJeu.Position;

public interface MovementStrategy {
    boolean isValidMove(Position from, Position to, Piece[][] board);
}
