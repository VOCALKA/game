package commands;

import characters.Player;
import items.Item;

public class UseItemCommand implements Command{

    private Player player;
    private String itemName;

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
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Musíš zadat název předmětu.");
            return;
        }
        Item item = player.getItemByName(args);

        if (item == null) {
            System.out.println("Nemáš tento předmět v inventáři.");
            return;
        }
        item.use(player);
        System.out.println("Použil(a) jsi: " + item.getName());

        // TODO
    }
}
