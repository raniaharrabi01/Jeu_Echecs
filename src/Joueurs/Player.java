package Joueurs;

import GestionDePartie.Observer;

public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }
    
    public String getPlayer() {
    	return name;
    }
    
    public void setPlayer(String name) {
    	this.name=name;
    }
    

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}
