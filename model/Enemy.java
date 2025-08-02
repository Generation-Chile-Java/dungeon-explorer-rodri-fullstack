package dungeongame.model;

public class Enemy implements GameObject {
    private String name;
    private int damage;

    public Enemy(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() { return name; }

    public void interact(Player player) {
        if (name.equalsIgnoreCase("Vecna") && player.hasItem("Walkman de Max")) {
            System.out.println("Usaste el Walkman de Max y escapaste del ataque de Vecna sin daño!");
        } else {
            player.takeDamage(damage);
        }
    }
}