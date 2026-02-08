package main;

import characters.CharacterData;
import characters.Player;

import commands.*;
import items.*;
import locations.*;
import commands.MoveCommand;

import quests.Quest;
import quests.QuestData;


import java.util.*;

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

        Random rnd = new Random();
        for (Location loc : world.values()) {
            if (loc.getId().equals("loc_lagoon")) {
                loc.setEnvironmentCount(rnd.nextInt(10) + 1);
            } else if (loc.getId().equals("loc_forest")) {
                loc.setEnvironmentCount(rnd.nextInt(15) + 5);
            } else if (loc.getId().equals("loc_cliff") || loc.getId().equals("loc_cave") || loc.getId().equals("loc_x")) {
                loc.setEnvironmentCount(rnd.nextInt(6) + 1);
            }
        }

        for (CharacterData cd : gameData.characters) {

            if (cd.getRole() != null && cd.getRole().equalsIgnoreCase("PLAYER")) {
                continue;
            }
            characters.Character npc = createCharacter(cd);

            if (npc == null) continue;

            Location home = world.get(cd.getHomeLocationId());
            if (home == null) {
                System.out.println("Varování: Lokace " + cd.getHomeLocationId() +
                        " pro NPC " + cd.getName() + " neexistuje.");
                continue;
            }

            if (home.npcs == null) home.npcs = new ArrayList<>();

            if (!cd.isLocked()) {
                home.npcs.add(npc);
            }
        }





        Player player = new Player("Pavla", world.get("loc_beach"));
        player.setGameData(gameData);

        //player.addItem(items.ItemFactory.createItem("item_flying_boots"));





        CommandManager cmdManager = new CommandManager();
        cmdManager.registerCommand(new InventoryCommand(player));
        cmdManager.registerCommand(new ListenCommand(player));
        cmdManager.registerCommand(new EndCommand(cmdManager,"Pavla spáchá sebevraždu."));
        cmdManager.registerCommand(new HelpCommand(cmdManager));
        cmdManager.registerCommand(new QuestsCommand(player));
        cmdManager.registerCommand(new MoveCommand(player, world));
        cmdManager.registerCommand(new PickUpCommand(player));
        cmdManager.registerCommand(new UseItemCommand(player));
        cmdManager.registerCommand(new TalkCommand(player));
        //cmdManager.registerCommand(new AnswerCommand(player));
        cmdManager.registerCommand(new AnswerCommand(player, world, gameData));
        cmdManager.registerCommand(new HintCommand(player, gameData));
        cmdManager.registerCommand(new SearchCommand(player));


        if (gameData.quests != null) {
            player.getQuests().addAll(gameData.quests);
        }


        System.out.println("Začínáš na lokaci: " + player.getCurrentLocation().getName());
        System.out.println(player.getCurrentLocation().getDescription());

        Scanner scanner = new Scanner(System.in);

        while (cmdManager.isGameRunning()) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty())
                continue;

            String[] parts = input.split(" ", 2);
            String cmdName = parts[0];
            String args = parts.length > 1 ? parts[1] : "";



            String response = cmdManager.executeCommand(cmdName, args);
            System.out.println(response);
        }
        scanner.close();
        System.out.println("--- Scanner uzavřen, program ukončen ---");

    }
    private ItemData findItemDataById(GameData data, String id) {
        for (ItemData item : data.items) {
            if (item.id.equals(id)) return item;
        }
        return null;
    }
    private characters.Character findNpcById(String id, Map<String, Location> world) {
        for (Location loc : world.values()) {
            if (loc.getNpcs() != null) {
                for (characters.Character npc : loc.getNpcs()) {
                    if (npc.getName().equalsIgnoreCase(id)) {
                        return npc;
                    }
                }
            }
        }
        return null;
    }
    public static characters.Character createCharacter(CharacterData data) {

        return new characters.NPC(data);
    }
}
