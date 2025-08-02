package dungeongame;

import dungeongame.model.Player;
import dungeongame.model.Enemy;
import dungeongame.model.Treasure;
import dungeongame.rooms.Room;
import dungeongame.rooms.EmptyRoom;
import dungeongame.rooms.EnemyRoom;
import dungeongame.rooms.TreasureRoom;
import dungeongame.rooms.TrapRoom;
import dungeongame.rooms.RestRoom;

import java.util.Scanner;

public class DungeonGame {
    public static Room[] rooms;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al mundo de Stranger Things. Serás Once y tienes 100 puntos de vida.");
        System.out.println("¿Te gustaría recibir las instrucciones del juego? (sí/no)");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("no")) {
            System.out.println("Has decidido no recibir instrucciones. Juego finalizado.");
            return;
        } else if (!respuesta.equals("sí")) {
            System.out.println("Respuesta no reconocida. Juego finalizado.");
            return;
        }

        System.out.println("--- Instrucciones ---");
        System.out.println("Explora salas icónicas del Upside Down.");
        System.out.println("Algunas están vacías, otras contienen enemigos, trampas, tesoros o zonas de descanso.");
        System.out.println("Puedes usar comandos como 'ir [número]', 'inventario' o 'salir'.");
        System.out.println("Sobrevive y explora todo lo que puedas. ¡Buena suerte!");
        System.out.println("----------------------");

        rooms = new Room[] {
                new EmptyRoom("Hawkins High School"),
                new EnemyRoom(new Enemy("Demogorgon", 30), "Casa de los Byers"),
                new TreasureRoom(new Treasure("Waffles Eggo"), "Bosque Mirkwood"),
                new TrapRoom("Pasillo de la secundaria con trampas ocultas", 20),
                new EnemyRoom(new Enemy("Vecna", 50), "Laboratorio Nacional de Hawkins"),
                new TreasureRoom(new Treasure("Walkman de Max"), "Sótano de Mike"),
                new RestRoom("Refugio en la cabaña de Hopper", 25),
                new TreasureRoom(new Treasure("Mapa de Will"), "Casa de Dustin"),
                new EnemyRoom(new Enemy("Mind Flayer", 35), "Piscina Municipal"),
                new EmptyRoom("Túneles del Upside Down"),
                new EnemyRoom(new Enemy("Billy poseído", 30), "Teatro abandonado"),
                new TreasureRoom(new Treasure("Caja de Dungeons & Dragons"), "Mansión Creel")
        };

        Player player = new Player("Once", 100, rooms.length);

        while (player.isAlive()) {
            System.out.println("\nEstado actual: Vida de " + player.getName() + ": " + player.getHealth());
            System.out.println("Salas inexploradas:");
            boolean[] visitadas = player.getVisitedRooms();
            for (int i = 0; i < visitadas.length; i++) {
                if (!visitadas[i]) {
                    System.out.println((i + 1) + ". " + getRoomName(i));
                }
            }

            System.out.println("\nEscribe 'ir [número]', 'inventario' o 'salir':");
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("salir")) {
                System.out.println("¡Gracias por jugar!");
                break;
            } else if (input.equals("inventario")) {
                player.showInventory();
            } else if (input.startsWith("usar ")) {
                String itemName = input.substring(5).trim();
                player.useItem(itemName);
            }
            else if (input.startsWith("ir ")) {
                try {
                    int num = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (num >= 0 && num < rooms.length) {
                        if (!player.getVisitedRooms()[num]) {
                            player.setRoomVisited(num);
                            rooms[num].enter(player);
                        } else {
                            System.out.println("Ya has explorado esta sala.");
                        }
                    } else {
                        System.out.println("Número de sala inválido.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada no válida.");
                }
            } else {
                System.out.println("Comando no reconocido.");
            }

            boolean todasExploradas = true;
            for (boolean v : player.getVisitedRooms()) {
                if (!v) {
                    todasExploradas = false;
                    break;
                }
            }
            if (todasExploradas) {
                System.out.println("\n¡Felicidades, exploraste todas las salas y sobreviviste al Upside Down!");
                player.showInventory();
                break;
            }
        }

        if (!player.isAlive()) {
            System.out.println("\nHas perdido todos tus puntos de vida. Fin del juego.");
        }
    }

    public static String getRoomName(int index) {
        String[] nombres = {
                "Hawkins High School",
                "Casa de los Byers",
                "Bosque Mirkwood",
                "Pasillo con trampas",
                "Laboratorio Nacional de Hawkins",
                "Sótano de Mike",
                "Cabaña de Hopper",
                "Casa de Dustin",
                "Piscina Municipal",
                "Túneles del Upside Down",
                "Teatro abandonado",
                "Mansión Creel"
        };
        return nombres[index];
    }
}
