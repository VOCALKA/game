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

    public void executeCommand(String name, String args) {
        Command command = getCommand(name);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Neznámý příkaz: " + name);
        }
    }

    public void showCommands() {
        System.out.println("Dostupné příkazy:");
        for (Command cmd : commands.values()) {
            System.out.println("- " + cmd.getName() + ": " + cmd.getDescription());
        }
    }

}
