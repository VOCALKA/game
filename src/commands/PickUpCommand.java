package commands;

import characters.Player;
import items.*;
import locations.Location;

public class PickUpCommand implements Command{

    private Player player;
    private Location location;
    private String itemName;

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

    @Override
    public String execute(String args) {
        if (args.isEmpty()) {

            return "Musíš zadat název předmětu.";
        }
        Location loc = player.getCurrentLocation();
        Item item = loc.getItem(args);

        if (item == null) {

            return "Takový předmět zde není.";
        }

        player.addItem(item);
        loc.removeItem(item);

        return "Sebral jsi: " + item.getName();

        // TODO
    }
}
