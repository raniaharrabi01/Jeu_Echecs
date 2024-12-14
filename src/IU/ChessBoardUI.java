package IU;

import javax.swing.*;

import GestionDePartie.ChessGame;
import GestionDePartie.Observer;
import PiécesDuJeu.Piece;
import PlateauDeJeu.ChessBoard;
import PlateauDeJeu.Position;

import java.awt.*;

public class ChessBoardUI extends JFrame implements Observer {
    private ChessBoard board;
    private ChessGame game;
    private JButton[][] buttons;

    // Variables pour la gestion des mouvements
    private Position selectedFrom = null;

    private static final String IMAGE_PATH = "ImagesPieces/";   // Chemin des images des pièces

    // Mappage des pièces vers leurs images correspondantes
    private static final String[] PIECE_IMAGES = {
        "white_rook.png", "white_knight.png", "white_bishop.png", "white_queen.png", 
        "white_king.png", "white_pawn.png", "black_rook.png", "black_knight.png", 
        "black_bishop.png", "black_queen.png", "black_king.png", "black_pawn.png"
    };

    public ChessBoardUI(ChessGame game) {
        this.game = game;
        setTitle("Jeu d'Echecs");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));

        buttons = new JButton[8][8];

        // Créer les boutons pour chaque case du plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 24));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> handleClick(new Position(row, col)));
                add(buttons[i][j]);
            }
        }
    }

    public void handleClick(Position pos) {
        if (selectedFrom == null) {
            Piece selectedPiece = board.getPieceAt(pos);
            if (selectedPiece == null || !selectedPiece.getColor().equals(game.getCurrentPlayer())) {
                JOptionPane.showMessageDialog(this, "Ce n'est pas votre tour !");
                return;
            }
            selectedFrom = pos;
            buttons[pos.getRow()][pos.getCol()].setBackground(Color.YELLOW);
        } else {
            boolean success = board.movePiece(selectedFrom, pos);
            if (success) {
                updateBoardUI();
                if (!board.isKingAlive("White")) {
                    JOptionPane.showMessageDialog(this, "Game Over! Les Noirs gagnent !");
                    System.exit(0);
                } else if (!board.isKingAlive("Black")) {
                    JOptionPane.showMessageDialog(this, "Game Over! Les Blancs gagnent !");
                    System.exit(0);
                }
                game.switchPlayer();  // Changer de joueur
            } else {
                JOptionPane.showMessageDialog(this, "Mouvement invalide !");
            }
            selectedFrom = null;
            resetButtonColors();
        }
    }

    // Méthode pour réinitialiser les couleurs des boutons
    public void resetButtonColors() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
            }
        }
    }

    // Méthode pour mettre à jour l'affichage du plateau avec des images
    public void updateBoardUI() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPieceAt(new Position(i, j));
                ImageIcon icon = getPieceIcon(piece);  // Récupérer l'icône de la pièce
                // Mettre à jour l'image du bouton correspondant à la case
                buttons[i][j].setIcon(icon);
            }
        }
    }

    // obtenir l'icône correspondant à une pièce
    public ImageIcon getPieceIcon(Piece piece) {
        if (piece == null) {
            return null;  // Si la case est vide
        }
        String pieceName = piece.toString().toLowerCase();  // Récupérer le nom de la pièce (ex : "white_pawn", "black_king")
        String imageFileName = getImageFileName(pieceName);  // Construire le nom du fichier image
        return new ImageIcon(getClass().getResource(IMAGE_PATH + imageFileName)); // Charger l'image
    }

    // obtenir le fichier image à partir du nom de la pièce
    public String getImageFileName(String pieceName) {
        switch (pieceName) {
            case "white_rook": return "white_rook.png";
            case "white_knight": return "white_knight.png";
            case "white_bishop": return "white_bishop.png";
            case "white_queen": return "white_queen.png";
            case "white_king": return "white_king.png";
            case "white_pawn": return "white_pawn.png";
            case "black_rook": return "black_rook.png";
            case "black_knight": return "black_knight.png";
            case "black_bishop": return "black_bishop.png";
            case "black_queen": return "black_queen.png";
            case "black_king": return "black_king.png";
            case "black_pawn": return "black_pawn.png";
            default: return "";  // Si la pièce n'est pas reconnue, retourner une chaîne vide
        }
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    @Override
    public void update(String message) {
        if (message.equals("A move has been made!")) {
        updateBoardUI();
    }
   }
}