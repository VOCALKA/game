package items;

import characters.CharacterData;
import characters.Player;
import locations.Location;
import main.GameLoader;

public class Light implements Item{
    @Override
    public String getName() {
        return "Svetlo";
    }

    /**
     * Uses the light item in the current location.
     *
     * - In the fog location, it reveals the "Island Lord" NPC if not already present.
     * - Removes the item from the player's inventory once used successfully.
     * - In other locations, it does nothing significant.
     *
     * @param player the player using the item
     * @return a message describing the result of using the item
     */
    @Override
    public String use(Player player) {
        Location loc = player.getCurrentLocation();

        if (loc.getId().equals("loc_fog")) {
            String result;


            for (CharacterData cd : player.getGameData().characters) {
                if (cd.getId().equals("npc_island_lord")) {

                    boolean uzTuJe = loc.getNpcs().stream().anyMatch(n -> n.getId().equals(cd.getId()));

                    if (!uzTuJe) {
                        loc.addNpc(GameLoader.createCharacter(cd));
                        result = "Rozsvítila jsi lucernu... Její záře prořízla hustou mlhu.\n" +
                                "Z mlhy před tebou pomalu vystoupila vysoká postava Pána ostrova!";
                    } else {
                        result = "Pán ostrova tu už na tebe čeká.";
                    }
                    player.removeItem(this);
                    return result;
                }
            }
        } else {
            return "Tady je světla dost, lucernu netřeba pálit.";
        }
        return "";
    }
    @Override
    public String getId() {
        return "item_light";
    }
}
