package commands;

import characters.Player;
import items.ItemData;
import items.ItemFactory;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PickUpCommandTest {

    private Player player;
    private Location location;
    private PickUpCommand pickUpCommand;

    @BeforeEach
    void setUp() {
        player = new Player("Pavla", null);

        location = new Location("loc_test", "TestLocation");

        location.items.add(new ItemData("item_flying_boots", "Letajici boty", "KEY",
                "Magické boty umožňující létání."));

        player.setCurrentLocation(location);

        pickUpCommand = new PickUpCommand(player);
    }

    @Test
    void testPickUpExistingItem() {
        String result = pickUpCommand.execute("Letajici boty");

        assertEquals(1, player.getInventory().size());
        assertEquals("Letajici boty", player.getInventory().get(0).getName());

        assertTrue(location.items.isEmpty());

        assertTrue(result.contains("Sebral jsi"));
    }

    @Test
    void testPickUpNonExistingItem() {
        String result = pickUpCommand.execute("Neexistujici");

        assertEquals(0, player.getInventory().size());
        assertEquals("Takový předmět zde není.", result);
    }

    @Test
    void testPickUpEmptyName() {
        String result = pickUpCommand.execute("");

        assertEquals(0, player.getInventory().size());
        assertEquals("Musíš zadat název předmětu.", result);
    }
}