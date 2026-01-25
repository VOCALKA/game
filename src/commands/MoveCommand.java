package commands;

import characters.Player;
import locations.Location;

import java.util.Map;

public class MoveCommand implements Command{


    private Player player;
    private Map<String, Location> world;
    private String direction;

    public MoveCommand(Player player, Map<String, Location> world, String direction) {
        this.player = player;
        this.world = world;
        this.direction = direction;
    }


    @Override
    public String getName() {
        // TODO
        return null;
    }

    @Override
    public String getDescription() {
       return "Pohyb mezi lokacemi (jdi sever, jih, východ, západ)";
        // TODO
    }

    @Override
    public void execute() {
        String dirKey = switch (direction.toLowerCase()) {
            case "sever" -> "north";
            case "jih" -> "south";
            case "východ", "vychod" -> "east";
            case "západ", "zapad" -> "west";
            default -> null;
        };

        if (dirKey == null) {
            System.out.println("Neznámý směr: " + direction);
            return;
        }

        Location current = player.getCurrentLocation();
        Map<String, String> exits = current.getExits();

        if (!exits.containsKey(dirKey)) {
            System.out.println("Tímto směrem se nemůžeš pohnout.");
            return;
        }

        String nextId = exits.get(dirKey);
        Location nextLocation = world.get(nextId);

        if (nextLocation == null) {
            System.out.println("Lokace " + nextId + " neexistuje.");
            return;
        }

        player.setCurrentLocation(nextLocation);

        System.out.println("Přesunul ses do: " + nextLocation.getName());
        System.out.println(nextLocation.getDescription());
    }
        // TODO
    }
