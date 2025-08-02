package dungeongame.rooms;

import dungeongame.model.GameObject;
import dungeongame.model.Player;

public class EnemyRoom implements Room {
    private GameObject enemy;
    private String description;

    public EnemyRoom(GameObject enemy, String description) {
        this.enemy = enemy;
        this.description = description;
    }

    public void enter(Player player) {
        System.out.println("Sala enemiga: " + description);
        System.out.println("¡Un enemigo aparece!: " + enemy.getName());
        enemy.interact(player);
    }
}