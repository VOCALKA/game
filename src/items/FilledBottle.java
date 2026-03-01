package items;

import characters.Player;

public class FilledBottle implements Item{
    /**
     * Returns the display name of the item.
     * @return the string "Filled Bottle"
     */
    @Override
    public String getName() {
        return "Naplnena lahvicka";
    }

    /**
     * Uses the filled bottle.
     * Drinking the water can trigger effects in the game (currently only a message).
     *
     * @param player the player using the item
     * @return a message describing the result of using the item
     */
    @Override
    public String use(Player player) {

        return "Napil ses vody.";
    }
    /**
     * Returns the unique ID of this item.
     * @return the string "item_filled_bottle"
     */
    @Override
    public String getId() {
        return "item_filled_bottle";
    }
}
