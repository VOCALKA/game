package commands;


import characters.Character;
import characters.CharacterData;
import characters.Player;
import items.ItemData;
import locations.Location;
import main.GameCharacter;

import java.util.ArrayList;

public class SearchCommand implements Command{
    private Player player;

    public SearchCommand(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return "prohledej";
    }

    @Override
    public String getDescription() {
        return "Prohledá aktuální lokaci a vypíše, co se zde nachází";
    }

    @Override
    public String execute(String args) {

        Location loc = player.getCurrentLocation();
        StringBuilder sb = new StringBuilder("Rozhlížíš se kolem sebe...\n");


        if (loc.getNpcs() != null && !loc.getNpcs().isEmpty()) {
            sb.append("Postavy zde: ");
            for (int i = 0; i < loc.getNpcs().size(); i++) {
                sb.append(loc.getNpcs().get(i).getName());
                if (i < loc.getNpcs().size() - 1) sb.append(", ");
            }
            sb.append("\n");
        } else {
            sb.append("Nikdo tu není.\n");
        }


        if (loc.items != null && !loc.items.isEmpty()) {
            sb.append("Předměty zde: ");
            for (int i = 0; i < loc.items.size(); i++) {
                sb.append(loc.items.get(i).getName());
                if (i < loc.items.size() - 1) sb.append(", ");
            }
        } else {
            sb.append("Žádné předměty tu nevidíš.");
        }

        if (loc.getId().equals("loc_lagoon")) {
            sb.append("\nNa hladině plave ").append(loc.getEnvironmentCount()).append(" větví.");
        } else if (loc.getId().equals("loc_forest")) {
            sb.append("\nKolem tebe roste ").append(loc.getEnvironmentCount()).append(" stromů.");
        } else if (loc.getId().equals("loc_cliff") || loc.getId().equals("loc_cave") || loc.getId().equals("loc_x")) {
            sb.append("\nNa zemi leží ").append(loc.getEnvironmentCount()).append(" velkých kamenů.");
        }

        return sb.toString().trim();
    }
}
