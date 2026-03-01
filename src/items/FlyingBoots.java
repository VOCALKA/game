package items;

import characters.Player;
import commands.CommandManager;
import commands.EndCommand;

public class FlyingBoots implements Item{
    CommandManager cmdManager;

    /**
     * Creates Flying Boots linked to a command manager.
     * @param cmdManager the command manager controlling the game
     */
    public FlyingBoots(CommandManager cmdManager) {
        this.cmdManager = cmdManager;
    }







    /**
     * Returns the display name of the item.
     * @return "Létající boty"
     */
    @Override
    public String getName() {
        //TODO
        //return "Létající boty";
        return "Letajici boty";
    }

    /**
     * Uses the flying boots.
     * Prints a victory message and ends the game immediately.
     *
     * Note: Currently uses System.exit(0) to end the program.
     * If you want a cleaner game loop exit, replace this with
     * cmdManager.stopGame() and handle ending logic in the main loop.
     *
     * @param player the player using the boots
     * @return an empty string (the message is printed directly)
     */
    @Override
    public String use(Player player) {
        //System.out.println("Vznesla ses do vzduchu! Vyhrál jsi.");
        player.removeItem(this);
        cmdManager.stopGame();
        //System.exit(0);
        return "Vznesla ses do vzduchu! Vyhrál jsi.";
    }


    /**
     * Returns the unique ID of this item.
     * @return "item_flying_boots"
     */
    @Override
    public String getId() {
        return "item_flying_boots";
    }

}
