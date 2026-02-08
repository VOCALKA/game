package commands;

import characters.CharacterData;
import characters.Player;
import items.Item;
import locations.Location;

import quests.Quest;
import main.GameData;
import quests.QuestData;


import java.util.Map;

public class UseItemCommand implements Command{

    private Player player;
    private String itemName;
    private Map<String, Location> world;
    private GameData gameData;

    public UseItemCommand(Player player) {
        this.player = player;

    }

    @Override
    public String getName() {
        // TODO
        return "pouzij";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Použije předmět z inventáře";
    }

    @Override
    public String execute(String args) {

        if (args.isEmpty()) return "Musíš zadat název předmětu.";

        Item item = player.getItemByName(args);
        if (item == null) return "Nemáš tento předmět v inventáři.";

        item.use(player);
        String itemName = item.getName();
        String itemId = item.getId();

        for (QuestData qd : player.getQuests()) {

            if (!"COMPLETED".equals(qd.status) && qd.requiredItems.contains(itemId)) {

                if (player.getCurrentLocation().getId().equals(qd.getTargetLocationId())) {


                    qd.status = "COMPLETED";
                    player.removeItemById(itemId);

                    if (qd.getUnlockCharacterId() != null) {
                        unlockNpcGlobally(qd.getUnlockCharacterId(), qd.getUnlockLocationId());
                    }

                    return "Použil jsi " + itemName + ".\n" + qd.getNpcResponse();
                }
            }
        }

        return "Použil(a) jsi: " + itemName + ", ale nic zvláštního se nestalo.";
    }

    private void unlockNpcGlobally(String npcId, String locationId) {

        Location loc = world.get(locationId);
        if (loc != null) {

            System.out.println("DEBUG: Odemčena postava " + npcId + " v lokaci " + locationId);
        }
    }
}
