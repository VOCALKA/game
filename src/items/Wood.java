package items;

import characters.Player;

public class Wood implements Item{

    @Override
    public String getName() {
        //TODO
        return "Dřevo";
    }

    @Override
    public void use(Player player) {
        //TODO
    }
    @Override
    public String getId() {
        return "item_wood";
    }
}
