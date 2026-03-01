package items;

import characters.Player;

public class Wood implements Item{

    @Override
    public String getName() {
        return "Drevo";
    }

    @Override
    public String use(Player player) {
        return null;
    }
    @Override
    public String getId() {
        return "item_wood";
    }
}
