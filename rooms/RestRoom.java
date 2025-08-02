package dungeongame.rooms;

import dungeongame.model.Player;

public class RestRoom implements Room {
    private String description;
    private int healing;

    public RestRoom(String description, int healing) {
        this.description = description;
        this.healing = healing;
    }

    @Override
    public void enter(Player player) {
        System.out.println("😌 Sala de descanso: " + description);
        player.heal(healing);
    }
}