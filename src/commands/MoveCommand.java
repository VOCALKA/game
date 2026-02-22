package commands;
import characters.Character;
import characters.Player;
import locations.Location;

import java.util.Map;

public class MoveCommand implements Command{


    private Player player;
    private Map<String, Location> world;
    private String direction;

    /**
     * Constructor for MoveCommand.
     * @param player the player who will move
     * @param world the game world containing all locations
     */
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

    /**
     * Executes the move command.
     * Checks if the direction is valid, whether the exit exists,
     * and whether the target location is locked. If successful,
     * moves the player to the new location.
     * @param args the direction to move (e.g., "sever", "jih")
     * @return a message about the result of the move attempt
     */
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
