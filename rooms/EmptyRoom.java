package dungeongame.rooms;

import dungeongame.model.Player;

public class EmptyRoom implements Room {
    private String description;

    public EmptyRoom(String description) {
        this.description = description;
    }

    public void enter(Player player) {
        System.out.println("Sala vacía: " + description + ". ¡Volvemos corriendo al pasillo para seguir explorando!");
    }
}