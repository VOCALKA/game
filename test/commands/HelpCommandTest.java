package commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpCommandTest {

    private CommandManager manager;
    private HelpCommand helpCommand;

    @BeforeEach
    void setUp() {
        manager = new CommandManager();
        manager.registerCommand(new HelpCommand(manager));

        helpCommand = new HelpCommand(manager);
    }

    @Test
    void testExecuteShowsAllCommands() {
        String result = helpCommand.execute("");

        assertTrue(result.contains("pomoc: Zobrazí seznam dostupných příkazů"));
        assertTrue(result.startsWith("Dostupné příkazy:"));
    }

    @Test
    void testGetNameAndDescription() {
        assertEquals("pomoc", helpCommand.getName());
        assertEquals("Zobrazí seznam dostupných příkazů", helpCommand.getDescription());
    }
}