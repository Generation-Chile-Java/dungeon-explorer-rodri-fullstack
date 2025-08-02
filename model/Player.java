package dungeongame.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private List<GameObject> inventory;
    private boolean[] visitedRooms;

    public void useItem(String itemName) {
        for (GameObject item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                System.out.println("🔹 Usaste el objeto: " + item.getName());
                item.interact(this);  // activa su efecto nuevamente
                return;
            }
        }
        System.out.println("❌ No tienes ese objeto en tu inventario.");
    }


    public Player(String name, int health, int totalRooms) {
        this.name = name;
        this.health = health;
        this.inventory = new ArrayList<>();
        this.visitedRooms = new boolean[totalRooms];
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public boolean isAlive() { return health > 0; }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " recibió " + damage + " de daño. Vida restante: " + health);
    }

    public void heal(int amount) {
        health += amount;
        System.out.println(name + " recuperó " + amount + " puntos de vida. Vida actual: " + health);
    }

    public void addItem(GameObject item) {
        inventory.add(item);
        System.out.println(name + " recogió: " + item.getName());
    }

    public boolean hasItem(String itemName) {
        return inventory.stream().anyMatch(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public void showInventory() {
        System.out.println("Inventario de " + name + ":");
        for (GameObject item : inventory) {
            System.out.println("- " + item.getName());
        }
    }

    public void setRoomVisited(int index) {
        visitedRooms[index] = true;
    }

    public boolean[] getVisitedRooms() {
        return visitedRooms;
    }
}