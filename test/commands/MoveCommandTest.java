package commands;

import characters.Player;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    Player player;
    Location start;
    Location forest;
    MoveCommand moveCommand;
    Map<String, Location> world;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer", null);

        start = new Location("start", "Start");
        forest = new Location("forest", "Les");

        start.getExits().put("north", "forest");
        forest.getExits().put("south", "start");

        world = new HashMap<>();
        world.put("start", start);
        world.put("forest", forest);

        player.setCurrentLocation(start);

        moveCommand = new MoveCommand(player, world);
    }
    @Test
    void testMoveNorth() {
        String result = moveCommand.execute("sever");
        assertEquals(forest, player.getCurrentLocation());
        assertTrue(result.contains("Les"));
    }

    @Test
    void testMoveSouthFromStartFails() {
        String result = moveCommand.execute("jih");
        assertEquals(start, player.getCurrentLocation());
        assertTrue(result.contains("Do moře nejdu"));
    }

    @Test
    void testUnknownDirection() {
        String result = moveCommand.execute("nahoru");
        assertTrue(result.contains("Neznámý směr"));
        assertEquals(start, player.getCurrentLocation());
    }

    @Test
    void testEmptyCommand() {
        String result = moveCommand.execute("");
        assertTrue(result.contains("Musíš zadat směr"));
        assertEquals(start, player.getCurrentLocation());
    }
}