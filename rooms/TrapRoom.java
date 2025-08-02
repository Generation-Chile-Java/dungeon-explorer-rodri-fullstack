package dungeongame.rooms;

import dungeongame.model.Player;

public class TrapRoom implements Room {
    private String description;
    private int damage;

    public TrapRoom(String description, int damage) {
        this.description = description;
        this.damage = damage;
    }

    @Override
    public void enter(Player player) {
        System.out.println("⚠️ Trampa activada: " + description);
        player.takeDamage(damage);
    }
}