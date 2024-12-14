package PiécesDuJeu;

import PlateauDeJeu.Position;

public class QueenMoveStrategy implements MovementStrategy {
    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        RookMoveStrategy rookStrategy = new RookMoveStrategy();
        BishopMoveStrategy bishopStrategy = new BishopMoveStrategy();

        // Si le mouvement est valide comme une Tour ou comme un Fou
        return rookStrategy.isValidMove(from, to, board) || bishopStrategy.isValidMove(from, to, board);
    }
}
