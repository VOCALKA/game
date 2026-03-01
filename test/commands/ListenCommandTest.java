package commands;

import characters.Player;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListenCommandTest {

    private Player player;
    private Location beach;
    private Location emptyLocation;
    private ListenCommand listenCommand;

    @BeforeEach
    void setUp() {
        player = new Player("Pavla", null);

        beach = new Location("loc_beach", "Plaz");
        beach.ambientSound = "ššš, frrrr, šmmm";

        emptyLocation = new Location("loc_x", "X");
        emptyLocation.ambientSound = "";

        listenCommand = new ListenCommand(player);
    }

    @Test
    void testListenWithSound() {
        player.setCurrentLocation(beach);
        String result = listenCommand.execute("");
        assertTrue(result.contains("ššš, frrrr, šmmm"));
    }

    @Test
    void testListenWithoutSound() {
        player.setCurrentLocation(emptyLocation);
        String result = listenCommand.execute("");
        assertEquals("Nic zvláštního neuslyšíš.", result);
    }

    @Test
    void testListenNoLocation() {
        player.setCurrentLocation(null);
        String result = listenCommand.execute("");
        assertEquals("Nejsi nikde!", result);
    }
}