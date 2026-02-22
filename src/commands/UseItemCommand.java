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

    /**
     * Constructor for UseItemCommand.
     * @param player the player who will use items
     * @param world the map of all locations in the game
     */
    public UseItemCommand(Player player, Map<String, Location> world) {
        this.player = player;
        this.world = world;

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

    /**
     * Executes the "use item" command.
     * Finds the item in the player's inventory, uses it, and checks for quest interactions.
     *
     * @param args the name of the item to use
     * @return the result of using the item, or an error message if the item is not available
     */
    @Override
    public String execute(String args) {

        if (args.isEmpty()) return "Musíš zadat název předmětu.";

        Item item = player.getItemByName(args);
        if (item == null) return "Nemáš tento předmět v inventáři.";

        //item.use(player);
        String itemResult = item.use(player);
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

        //return "Použil jsi: " + itemName + ", ale nic zvláštního se nestalo.";
        return itemResult;
    }

    /**
     * Unlocks a specific NPC in a given location globally.
     * @param npcId the ID of the NPC to unlock
     * @param locationId the location ID where the NPC should appear
     */
    private void unlockNpcGlobally(String npcId, String locationId) {

        Location loc = world.get(locationId);
        if (loc != null) {

            System.out.println(": Odemčena postava " + npcId + " v lokaci " + locationId);
        }
    }
}
