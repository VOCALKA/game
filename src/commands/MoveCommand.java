package commands;
import characters.Character;
import characters.Player;
import locations.Location;

import java.util.Map;

public class MoveCommand implements Command{


    private Player player;
    private Map<String, Location> world;
    private String direction;

    public MoveCommand(Player player, Map<String, Location> world) {
        this.player = player;
        this.world = world;
        //this.direction = direction;
    }


    @Override
    public String getName() {
        // TODO
        return "jdi";
    }

    @Override
    public String getDescription() {
       return "Pohyb mezi lokacemi (jdi sever, jih, východ, západ)";
        // TODO
    }
    
    @Override
    public String execute(String args) {
        if (args.isEmpty()) {

            return "Musíš zadat směr (sever, jih, východ, západ).";
        }

        String dirKey = switch (args.toLowerCase()) {
            case "sever" -> "north";
            case "jih" -> "south";
            case "východ", "vychod" -> "east";
            case "západ", "zapad" -> "west";
            default -> null;
        };

        if (dirKey == null) {

            return "Neznámý směr: " + args;
        }

        Location current = player.getCurrentLocation();
        Map<String, String> exits = current.getExits();

        if (!exits.containsKey(dirKey)) {

            return "Do moře nejdu!!!";
        }

        String nextId = exits.get(dirKey);
        Location nextLocation = world.get(nextId);

        if (nextLocation == null) {

            return "Lokace " + nextId + " neexistuje.";
        }

        if (nextLocation.isLocked()) {

            return "Ta skála je zazděná.";
        }


        player.setCurrentLocation(nextLocation);


        return "Přesunul ses do: " + nextLocation.getName() + "\n"
                + nextLocation.getDescription();

    }
}
