package main;

import characters.Player;
import items.*;
import locations.Location;
import commands.MoveCommand;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameLoader {
    public void gameLoader() {
        GameData gameData = GameData.loadGameDataFromResources("/gameData.json");


        Map<String, Location> world = new HashMap<>();
        for (Location loc : gameData.locations) {
            world.put(loc.getId(), loc);
        }


        Player player = new Player("Pavla", world.get("loc_beach"));
        System.out.println("Začínáš na lokaci: " + player.getCurrentLocation().getName());
        System.out.println(player.getCurrentLocation().getDescription());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("konec")) {
                System.out.println("Hra ukončena.");
                break;
            }

            if (input.startsWith("jdi ")) {
                String direction = input.substring(4);


                MoveCommand moveCommand =
                        new MoveCommand(player, world, direction);

                moveCommand.execute();

            } else {
                System.out.println("Neznámý příkaz. Použij 'jdi <směr>' nebo 'konec'.");
            }
        }

        scanner.close();
    }
}
