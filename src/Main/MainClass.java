package Main;

import GestionDePartie.ChessGame;
import IU.ChessBoardUI;
import Joueurs.Player;
import PlateauDeJeu.ChessBoard;

public class MainClass {
    public static void main(String[] args) {
        // Créer l'instance unique du jeu d'échecs
        ChessGame game = ChessGame.getInstance();
        
        // Créer des joueurs
        Player whitePlayer = new Player("White");
        Player blackPlayer = new Player("Black");

        // Ajouter les joueurs comme observateurs
        game.addObserver(whitePlayer);
        game.addObserver(blackPlayer);
        
        // Créer l'interface graphique et la rendre visible
        ChessBoardUI boardUI = new ChessBoardUI(game);
        ChessBoard board = new ChessBoard();
        boardUI.setBoard(board);  // Lier le plateau avec l'interface graphique
        boardUI.setVisible(true);  // Afficher la fenêtre

        // Démarrer le jeu
        game.startGame();
        
        // Exemple de mouvement
       // Position from = new Position(0, 1);  // Position initiale du Cavalier
       // Position to = new Position(2, 2);    // Nouvelle position du Cavalier
        //game.makeMove(from, to);
        
        // Mise à jour de l'affichage du plateau
        boardUI.updateBoardUI();
    }
}
