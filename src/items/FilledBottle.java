package items;

import characters.Player;

public class FilledBottle implements Item{
    @Override
    public String getName() {
        //TODO
        return "Naplněná lahvička";
    }

    @Override
    public void use(Player player) {
        System.out.println("Napila ses vody.");
        player.removeItem(this);
        //TODO
    }
    @Override
    public String getId() {
        return "item_filled_bottle";
    }
}
