package commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndCommandTest {

    private CommandManager manager;

    @BeforeEach
    void setUp() {
        manager = new CommandManager();
    }

    @Test
    void testEndCommandDefaultMessage() {
        EndCommand endCommand = new EndCommand(manager, "Hra ukončena.");
        assertTrue(manager.isGameRunning(), "Game should initially be running");

        String result = endCommand.execute("");
        assertEquals("Hra ukončena.", result, "EndCommand should return the default message");
        assertFalse(manager.isGameRunning(), "Game should be stopped after execute");
    }

    @Test
    void testEndCommandCustomMessage() {
        EndCommand endCommand = new EndCommand(manager, "Konec hry!");
        assertTrue(manager.isGameRunning(), "Game should initially be running");

        String result = endCommand.execute("");
        assertEquals("Konec hry!", result, "EndCommand should return the custom message");
        assertFalse(manager.isGameRunning(), "Game should be stopped after execute");
    }

    @Test
    void testEndCommandViaManager() {
        EndCommand endCommand = new EndCommand(manager, "Hra ukončena.");
        manager.registerCommand(endCommand);

        assertTrue(manager.isGameRunning());
        String output = manager.executeCommand("konec", "");
        assertEquals("Hra ukončena.", output);
        assertFalse(manager.isGameRunning());
    }
}