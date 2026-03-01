package commands;

import characters.Player;
import items.Item;
import items.ItemData;
import main.GameData;
import locations.Location;

public class HintCommand implements Command{

    private Player player;
    private GameData gameData;

    private String locationId;
    private String requiredItemId;
    private String text;

    /**
     * Returns the ID of the location associated with this hint.
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * Returns the ID of the item associated with this hint.
     */
    public String getRequiredItemId() {
        return requiredItemId;
    }

    /**
     * Returns the hint text.
     */
    public String getText() {
        return text;
    }

    /**
     * Constructor for the HintCommand.
     * @param player the player requesting hints
     * @param gameData the game's data repository containing items and locations
     */
    public HintCommand(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;

    }
    /**
     * Returns the command name.
     * @return "rada"
     */
    @Override
    public String getName() {
        return "rada";
    }

    /**
     * Returns the command description.
     * @return a short description of the command
     */
    @Override
    public String getDescription() {
        return "Zobrazí nápovědu";
    }

    /**
     * Executes the hint command.
     * If an item name is provided, searches the player's inventory
     * for that item and returns its associated hint if available.
     * Otherwise, returns a hint for the current location if available.
     * @param args the item name (optional)
     * @return the hint text or an error message
     */
    @Override
    public String execute(String args) {

        if (!args.isEmpty()) {
            String searchedName = args.trim().toLowerCase();
            for (Item item : player.getInventory()) {
                if (item.getName().toLowerCase().equals(searchedName)) {
                    ItemData data = gameData.findItemDataById(item.getId());
                    return (data != null && data.getText() != null) ? data.getText() : "K tomuto předmětu žádná rada není.";
                }
            }
            return "Takový předmět v inventáři nemáš.";
        }
        Location currentLoc = player.getCurrentLocation();
        Location dataLoc = gameData.findLocation(currentLoc.getId());

        if (dataLoc != null && dataLoc.getText() != null && !dataLoc.getText().isEmpty()) {
            return ": " + dataLoc.getText();
        }
        return "Nic.";
    }
}
