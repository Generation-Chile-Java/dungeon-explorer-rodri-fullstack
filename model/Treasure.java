package dungeongame.model;

import dungeongame.DungeonGame;

public class Treasure implements GameObject {
    private String name;

    public Treasure(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void interact(Player player) {
        player.addItem(this);
        if (name.equalsIgnoreCase("Waffles Eggo")) {
            player.heal(30);
        } else if (name.equalsIgnoreCase("Caja de Dungeons & Dragons")) {
            System.out.println("Sientes una nueva energía ofensiva...");
        } else if (name.equalsIgnoreCase("Mapa de Will")) {
            System.out.println("¡El Mapa de Will revela las salas con tesoros por 30 segundos! Memorízalas:");
            for (int i = 0; i < DungeonGame.rooms.length; i++) {
                if (DungeonGame.rooms[i] instanceof dungeongame.rooms.TreasureRoom) {
                    System.out.println("- Sala " + (i + 1));
                }
            }
            try { Thread.sleep(10000); } catch (InterruptedException e) {}
            System.out.println("El Mapa de Will se desvanece...");
        }
    }
}