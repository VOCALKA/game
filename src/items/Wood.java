package items;

import characters.Player;

public class Wood implements Item{

    @Override
    public String getName() {
        //TODO
        return "Dřevo";
    }

    @Override
    public String use(Player player) {
        return null;
        //TODO
    }
    @Override
    public String getId() {
        return "item_wood";
    }
}
