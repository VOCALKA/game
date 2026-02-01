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
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Musíš zadat název předmětu.");
            return;
        }
        Location loc = player.getCurrentLocation();
        Item item = loc.getItem(args);
        //Item item = location.getItem(itemName);
        if (item == null) {
            System.out.println("Takový předmět zde není.");
            return;
        }

        player.addItem(item);
        loc.removeItem(item);
        System.out.println("Sebral(a) jsi: " + item.getName());

        // TODO
    }
}
