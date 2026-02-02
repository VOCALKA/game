package commands;

import characters.Player;
import items.Item;
import items.ItemData;
import main.GameData;
import locations.Location;


import java.util.ArrayList;
import java.util.Map;

public class HintCommand implements Command{

    private Player player;
    private GameData gameData;

    private String locationId;
    private String requiredItemId;
    private String text;

    public String getLocationId() {
        return locationId;
    }

    public String getRequiredItemId() {
        return requiredItemId;
    }

    public String getText() {
        return text;
    }

    public HintCommand(Player player, GameData gameData) {
        this.player = player;
        this.gameData = gameData;

    }
    @Override
    public String getName() {
        // TODO
        return "rada";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Zobrazí nápovědu";
    }

    @Override
    public void execute(String args) {

            if (!args.isEmpty()) {
                String searchedName = args.trim().toLowerCase();

                for (Item item : player.getInventory()) {


                    if (item.getName().toLowerCase().equals(searchedName)) {

                        ItemData data = gameData.findItemDataById(item.getId());

                        if (data != null && data.getText() != null && !data.getText().isEmpty()) {
                            System.out.println(": " + data.getText());
                        } else {
                            System.out.println("K tomuto předmětu žádná rada není.");
                        }
                        return;
                    }
                }

                System.out.println("Takový předmět v inventáři nemáš.");
                return;
            }


            Location currentLoc = player.getCurrentLocation();
            Location dataLoc = gameData.findLocation(currentLoc.getId());

            if (dataLoc != null && dataLoc.getText() != null && !dataLoc.getText().isEmpty()) {
                System.out.println(": " + dataLoc.getText());
                return;
            }

            System.out.println("Nic");
    }
}
