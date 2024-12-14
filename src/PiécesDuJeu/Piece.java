package PiécesDuJeu;

import PlateauDeJeu.Position;

public abstract class Piece {
    protected String color; // Couleur de la pièce (Blanc ou Noir)
    private MovementStrategy moveStrategy; // Stratégie de mouvement de la pièce

    // Constructeur de la pièce avec sa couleur
    public Piece(String color) {
        this.color = color;
    }

    // Getter pour la couleur
    public String getColor() {
        return color;
    }

    // Setter pour la stratégie de mouvement
    public void setMoveStrategy(MovementStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    // Getter pour la stratégie de mouvement
    public MovementStrategy getMoveStrategy() {
        return moveStrategy;
    }

    // Méthode abstraite pour valider le mouvement d'une pièce. Chaque sous-classe de Piece l'implémente.
    public abstract boolean isValidMove(Position from, Position to, Piece[][] board);
    
    @Override
    public String toString() {
        return color + " " + this.getClass().getSimpleName(); // Renvoie par exemple "White Pawn"
    }
}

