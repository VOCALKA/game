package main;
import characters.CharacterData;
import characters.Player;
import characters.WanderingTree;
import commands.*;
import items.*;
import locations.*;
import commands.MoveCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameLoader {
    public void gameLoader() {
        GameData gameData = GameData.loadGameDataFromResources("/gameData.json");


        Map<String, Location> world = new HashMap<>();
        for (Location loc : gameData.locations) {
            world.put(loc.getId(), loc);

            if (loc.lootTable != null && !loc.lootTable.isEmpty()) {
                loc.items = new ArrayList<>();

                for (String itemId : loc.lootTable) {
                    ItemData data = findItemDataById(gameData, itemId);
                    if (data != null) {
                        loc.items.add(data);
                    }
                }
            } else {
                loc.items = new ArrayList<>();
            }
        }

        for (CharacterData cd : gameData.characters) {
            //characters.Character npc = CharacterData.createCharacter(cd);
            characters.Character npc = CharacterData.createCharacter(cd);

            if (npc == null) continue;

            Location home = world.get(cd.getHomeLocationId());
            if (home == null) {
                System.out.println("Varování: Lokace " + cd.getHomeLocationId() + " pro NPC " + cd.getName() + " neexistuje.");
                continue;
            }

            if (home.npcs == null) home.npcs = new ArrayList<>();
            home.npcs.add(npc);
        }


        Player player = new Player("Pavla", world.get("loc_beach"));

        CommandManager cmdManager = new CommandManager();
        cmdManager.registerCommand(new InventoryCommand(player));
        cmdManager.registerCommand(new ListenCommand(player));
        cmdManager.registerCommand(new EndCommand());
        cmdManager.registerCommand(new HelpCommand(cmdManager));
        cmdManager.registerCommand(new QuestsCommand(player));
        cmdManager.registerCommand(new MoveCommand(player, world));
        cmdManager.registerCommand(new PickUpCommand(player));
        cmdManager.registerCommand(new UseItemCommand(player));
        cmdManager.registerCommand(new TalkCommand(player));
        cmdManager.registerCommand(new AnswerCommand(player));
        cmdManager.registerCommand(new HintCommand(player, gameData));
        cmdManager.registerCommand(new SearchCommand(player));


        System.out.println("Začínáš na lokaci: " + player.getCurrentLocation().getName());
        System.out.println(player.getCurrentLocation().getDescription());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty())
                continue;

            String[] parts = input.split(" ", 2);
            String cmdName = parts[0];
            String args = parts.length > 1 ? parts[1] : "";

            cmdManager.executeCommand(cmdName, args);
        }

    }
    private ItemData findItemDataById(GameData data, String id) {
        for (ItemData item : data.items) {
            if (item.id.equals(id)) return item;
        }
        return null;
    }
}
