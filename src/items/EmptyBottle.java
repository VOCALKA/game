package items;

import characters.Player;

public class EmptyBottle implements Item{
    /**
     * Returns the display name of the item.
     * @return the string "Empty Bottle"
     */
    @Override
    public String getName() {
        //TODO
        return "Prázdná lahvička";
    }

    /**
     * Uses the empty bottle.
     * If the player is at the lagoon, the bottle is filled with magical water.
     * Otherwise, using it has no effect.
     *
     * @param player the player using the item
     * @return a message describing the result of using the item
     */
    @Override
    public String use(Player player) {
        if (player.getCurrentLocation().getId().equals("loc_lagoon")) {
            //System.out.println("");
            player.removeItem(this);
            player.addItem(new FilledBottle());
            return "Naplnil jsi lahvičku magickou vodou.";
        } else {
            //System.out.println("Nelze naplnit zde.");
            return "Zde lahvičku naplnit nemůžeš.";
        }

        //TODO
    }
    /**
     * Returns the unique ID of this item.
     * @return the string "item_empty_bottle"
     */
    @Override
    public String getId() {
        return "item_empty_bottle";
    }
}
