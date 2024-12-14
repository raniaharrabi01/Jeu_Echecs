package PiécesDuJeu;

import javax.swing.JOptionPane;

import PlateauDeJeu.Position;

public class King extends Piece {
    public King(String color) {
        super(color);
        setMoveStrategy(new KingMoveStrategy());  // Assignation de la stratégie spécifique
    }

    @Override
    public boolean isValidMove(Position from, Position to, Piece[][] board) {
        // Vérification si le déplacement est valide selon la stratégie du roi
        boolean isValid = getMoveStrategy().isValidMove(from, to, board);
        // Si le mouvement est valide, on vérifie si le roi serait en échec après le mouvement
        if (isValid) {
            if (isKingInCheckAfterMove(from, to, board)) {
                JOptionPane.showMessageDialog(null, "Le roi est en échec dans cette emplacement !");
                return false;  // Si le roi serait en échec, le mouvement est invalide
            }
        }
        return isValid;
    }

    // Vérifie si le roi serait en échec après avoir effectué le mouvement
    private boolean isKingInCheckAfterMove(Position from, Position to, Piece[][] board) {
        // Sauvegarder l'état du plateau avant le mouvement
        Piece tempPiece = board[to.getRow()][to.getCol()];
        board[to.getRow()][to.getCol()] = board[from.getRow()][from.getCol()];
        board[from.getRow()][from.getCol()] = null;
        // Vérifie si le roi est en échec après le mouvement
        boolean isInCheck = isKingInCheck(board);
        // Restaure l'état du plateau après la simulation
        board[from.getRow()][from.getCol()] = board[to.getRow()][to.getCol()];
        board[to.getRow()][to.getCol()] = tempPiece;
        return isInCheck;
    }

    // Vérifie si le roi est en échec
    private boolean isKingInCheck(Piece[][] board) {
        Position kingPosition = findKingPosition(board);
        // Vérifie toutes les pièces adverses pour savoir si elles peuvent attaquer le roi
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece enemyPiece = board[i][j];
                if (enemyPiece != null && !enemyPiece.getColor().equals(this.getColor())) {
                    if (enemyPiece.isValidMove(new Position(i, j), kingPosition, board)) {
                        return true;  // Le roi est en échec
                    }
                }
            }
        }
        return false;  // Le roi n'est pas en échec
    }

    // Trouve la position du roi sur le plateau
    private Position findKingPosition(Piece[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece instanceof King && piece.getColor().equals(this.getColor())) {
                    return new Position(i, j);  // Retourne la position du roi
                }
            }
        }
        return null;  // Si le roi n'est pas trouvé 
    }

    @Override
    public String toString() {
        return color.equals("White") ? "white_King" : "black_King";
    }
}
