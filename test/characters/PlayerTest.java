package characters;

import items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import items.ItemData;
import locations.Location;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {

    private Player player;
    private Location startLocation;

    @BeforeEach
    void setUp() {
        startLocation = new Location("start", "Start location");
        player = new Player("TestPlayer", startLocation);
    }

    @Test
    void addItem() {
        Item item = new EmptyBottle();
        player.addItem(item);
        assertTrue(player.getInventory().contains(item));
    }

    @Test
    void removeItem() {
        Item item = new EmptyBottle();
        player.addItem(item);
        player.removeItem(item);
        assertFalse(player.getInventory().contains(item));
    }

    @Test
    void getCurrentLocation() {
        assertEquals(startLocation, player.getCurrentLocation());
    }

    @Test
    void setCurrentLocation() {
        Location newLocation = new Location("c", "C");
        player.setCurrentLocation(newLocation);
        assertEquals(newLocation, player.getCurrentLocation());
    }

    @Test
    void hasItem() {
        Item item = new EmptyBottle();
        player.addItem(item);
        assertTrue(player.hasItem(item.getId()));
        assertFalse(player.hasItem("nonexistent_id"));
    }

    @Test
    void removeItemById() {
        Item item = new EmptyBottle();
        player.addItem(item);
        player.removeItemById(item.getId());
        assertFalse(player.hasItem(item.getId()));
    }
}