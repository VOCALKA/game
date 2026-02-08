package commands;

import characters.Player;
import items.Item;

import java.util.List;

public class InventoryCommand implements Command{

    private Player player;

    public InventoryCommand(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        // TODO
        return "inventar";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Zobrazí aktuální inventář hráče";
    }

    @Override
    public String execute(String args) {
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            //System.out.println("Inventář je prázdný.");
            return "Inventář je prázdný.";
        }


        StringBuilder sb = new StringBuilder("Inventář:\n");
        for (Item item : inventory) {

            sb.append("- ").append(item.getName()).append("\n");
        }
        return sb.toString();
    }
}
