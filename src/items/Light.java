package items;

import characters.CharacterData;
import characters.Player;
import locations.Location;
import main.GameLoader;

public class Light implements Item{
    @Override
    public String getName() {
        //TODO
        return "Světlo";
    }

    @Override
    public String use(Player player) {
        Location loc = player.getCurrentLocation();

        if (loc.getId().equals("loc_fog")) {
            //System.out.println("Rozsvítila jsi lucernu... Její záře prořízla hustou mlhu.");
            //return "Rozsvítila jsi lucernu... Její záře prořízla hustou mlhu.";
            String result;


            for (CharacterData cd : player.getGameData().characters) {
                if (cd.getId().equals("npc_island_lord")) {

                    boolean uzTuJe = loc.getNpcs().stream().anyMatch(n -> n.getId().equals(cd.getId()));

                    if (!uzTuJe) {
                        loc.addNpc(GameLoader.createCharacter(cd));
                        //System.out.println("Z mlhy před tebou pomalu vystoupila vysoká postava Pána ostrova!");
                        result = "Rozsvítila jsi lucernu... Její záře prořízla hustou mlhu.\n" +
                                "Z mlhy před tebou pomalu vystoupila vysoká postava Pána ostrova!";
                    } else {
                        //System.out.println("Pán ostrova tu už na tebe čeká.");
                        result = "Pán ostrova tu už na tebe čeká.";
                    }
                    player.removeItem(this);
                    return result;
                }
            }
        } else {
            //System.out.println("Tady je světla dost, lucernu netřeba pálit.");
            return "Tady je světla dost, lucernu netřeba pálit.";
        }
        return "";
    }
    @Override
    public String getId() {
        return "item_light";
    }
}
