package items;

import characters.Player;

public class FlyingBoots implements Item{
    @Override
    public String getName() {
        //TODO
        return "Létající boty";
    }

    @Override
    public void use(Player player) {
        System.out.println("Vznesla ses do vzduchu!");
        player.removeItem(this);
        //TODO
    }
    @Override
    public String getId() {
        return "item_flying_boots";
    }

}
