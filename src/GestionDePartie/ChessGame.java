package GestionDePartie;

import java.util.ArrayList;
import java.util.List;
import IU.ChessBoardUI;
import Joueurs.Player;
import PlateauDeJeu.ChessBoard;
import PlateauDeJeu.Position;

public class ChessGame {
	
    private static ChessGame instance;
    ChessBoard board;  // Référence à la logique du jeu (ChessBoard)
    private ChessBoardUI ui;   // Référence à l'interface graphique
    private Player currentPlayer;
    
    // Constructeur privé pour le Singleton
    private ChessGame() {
        board = new ChessBoard();  // Logique du jeu
        ui = new ChessBoardUI(this);  // Interface graphique
        currentPlayer = new Player("White");
    }

    // Méthode pour obtenir l'instance unique de ChessGame
    public static ChessGame getInstance() {
        if (instance == null) {
            instance = new ChessGame();
        }
        return instance;
    }

    // Démarrer le jeu
    public void startGame() {
        System.out.println("Game started!");
        System.out.println("The white player starts playing");
        board.setupBoard();  // Initialisation des pièces sur le plateau
        ui.setBoard(board);   // Lier l'interface graphique avec le plateau de jeu
        ui.updateBoardUI();     // Affichage initial du plateau
        addObserver(ui);  // Ajouter l'interface graphique comme observateur
    }

  
    public void makeMove(Position from, Position to) {
        if (board.movePiece(from, to)) {
            notifyObservers("A move has been made!");
        }
    }

    private List<Observer> observers = new ArrayList<>();
    // Ajouter un observateur
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Notifier les observateurs
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public String getCurrentPlayer() {
       return currentPlayer.getPlayer();
    }

    public void switchPlayer() {
       currentPlayer.setPlayer(currentPlayer.getPlayer().equals("White") ? "Black" : "White");
       System.out.println("C'est au tour de : " + currentPlayer.getPlayer());
    }
}

