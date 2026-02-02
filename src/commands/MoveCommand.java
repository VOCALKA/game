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
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Musíš zadat směr (sever, jih, východ, západ).");
            return;
        }

        String dirKey = switch (args.toLowerCase()) {
            case "sever" -> "north";
            case "jih" -> "south";
            case "východ", "vychod" -> "east";
            case "západ", "zapad" -> "west";
            default -> null;
        };

        if (dirKey == null) {
            System.out.println("Neznámý směr: " + args);
            return;
        }

        Location current = player.getCurrentLocation();
        Map<String, String> exits = current.getExits();

        if (!exits.containsKey(dirKey)) {
            //System.out.println("Tímto směrem se nemůžeš pohnout.");
            System.out.println("Do moře nejdu!!!");
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
