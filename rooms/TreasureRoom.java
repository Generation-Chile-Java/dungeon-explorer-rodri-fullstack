package dungeongame.rooms;

import dungeongame.model.GameObject;
import dungeongame.model.Player;

public class TreasureRoom implements Room {
    private GameObject treasure;
    private String description;

    public TreasureRoom(GameObject treasure, String description) {
        this.treasure = treasure;
        this.description = description;
    }

    public void enter(Player player) {
        System.out.println("Sala del tesoro: " + description);
        System.out.println("Encontraste un tesoro: " + treasure.getName());
        treasure.interact(player);
    }
}