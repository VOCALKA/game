package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {

    private final Map<String, Command> commands = new HashMap<>();

    public void registerCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    public Command getCommand(String name) {
        return commands.get(name.toLowerCase());
    }

    public String executeCommand(String name, String args) {
        Command command = getCommand(name);
        if (command != null) {
           return command.execute(args);
        } else {
            return "Neznámý příkaz: " + name;
        }
    }

    private boolean gameRunning = true;

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void stopGame() {
        this.gameRunning = false;
    }

    public String showCommands() {

        StringBuilder sb = new StringBuilder("Dostupné příkazy:\n");
        for (Command cmd : commands.values()) {
            sb.append("- ").append(cmd.getName()).append(": ").append(cmd.getDescription()).append("\n");
        }
        return sb.toString();
    }

}
