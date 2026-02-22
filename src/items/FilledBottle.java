package items;

import characters.Player;

public class FilledBottle implements Item{
    @Override
    public String getName() {
        //TODO
        return "Naplněná lahvička";
    }

    @Override
    public String use(Player player) {
        //System.out.println("Napila ses vody.");
        //player.removeItem(this);
        return "Napil ses vody.";
        //TODO
    }
    @Override
    public String getId() {
        return "item_filled_bottle";
    }
}
