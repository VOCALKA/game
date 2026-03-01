package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {

    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Registers a new command in the manager.
     * @param command the command to register
     */
    public void registerCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    /**
     * Retrieves a command by name.
     * @param name the name of the command
     * @return the Command object, or null if it doesn't exist
     */
    public Command getCommand(String name) {
        return commands.get(name.toLowerCase());
    }

    /**
     * Executes a command by its name with optional arguments.
     * @param name the command name
     * @param args arguments for the command
     * @return the output string from the command, or a "unknown command" message
     */
    public String executeCommand(String name, String args) {
        Command command = getCommand(name);
        if (command != null) {
           return command.execute(args);
        } else {
            return "Neznámý příkaz: " + name;
        }
    }

    private boolean gameRunning = true;

    /**
     * Checks whether the game is currently running.
     * @return true if the game is running, false otherwise
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Stops the game by setting the gameRunning flag to false.
     */
    public void stopGame() {
        this.gameRunning = false;
    }

    /*public void setGameRunning(boolean running) {
        this.gameRunning = running;
    }*/

    /**
     * Returns a formatted string listing all registered commands and their descriptions.
     * @return string with all commands
     */
    public String showCommands() {

        StringBuilder sb = new StringBuilder("Dostupné příkazy:\n");
        for (Command cmd : commands.values()) {
            sb.append("- ").append(cmd.getName()).append(": ").append(cmd.getDescription()).append("\n");
        }
        return sb.toString();
    }



}
