package items;

import characters.Player;

public class EmptyBottle implements Item{
    @Override
    public String getName() {
        //TODO
        return "Prázdná lahvička";
    }

    @Override
    public void use(Player player) {
        if (player.getCurrentLocation().getId().equals("loc_lagoon")) {
            System.out.println("");
            player.removeItem(this);
            player.addItem(new FilledBottle());
        } else {
            System.out.println("Nelze naplnit zde.");
        }

        //TODO
    }
    @Override
    public String getId() {
        return "item_empty_bottle";
    }
}
