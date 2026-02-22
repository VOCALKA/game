package commands;

import characters.Player;
import items.*;
import locations.Location;

public class PickUpCommand implements Command{

    private Player player;
    private Location location;
    private String itemName;

    /**
     * Constructor for PickUpCommand.
     * @param player the player who will pick up items
     */
    public PickUpCommand(Player player) {
        this.player = player;

    }

    @Override
    public String getName() {
        // TODO
        return "seber";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Sebere předmět v lokaci";
    }

    /**
     * Executes the pick-up command.
     * Checks if the item exists in the location and adds it to the player's inventory.
     * Removes the item from the location if picked up successfully.
     * @param args the name of the item to pick up
     * @return message describing the result of the pick-up attempt
     */
    @Override
    public String execute(String args) {
        if (args.isEmpty()) {

            return "Musíš zadat název předmětu.";
        }
        Location loc = player.getCurrentLocation();
        Item item = loc.getItem(args, player);

        if (item == null) {

            return "Takový předmět zde není.";
        }

        player.addItem(item);
        loc.removeItem(item);

        return "Sebral jsi: " + item.getName();

        // TODO
    }
}
