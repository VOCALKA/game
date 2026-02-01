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
    public void execute(String args) {
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("Inventář je prázdný.");
            return;
        }

        System.out.println("Inventář:");
        for (Item item : inventory) {
            System.out.println("- " + item.getName());
        }
    }

        // TODO

}
