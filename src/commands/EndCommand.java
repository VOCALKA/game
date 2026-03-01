package commands;

public class EndCommand implements Command{


    /**
     * Returns the command name.
     * @return "konec"
     */
    @Override
    public String getName() {
        return "konec";
    }

    /**
     * Returns the command description.
     * @return "Ends the game"
     */
    @Override
    public String getDescription() {
        return "Ukončí hru";
    }
    private String message;
    private CommandManager manager;

    public EndCommand() {
        this.message = "Hra ukončena.";
    }

    /**
     * Constructor with manager and custom message.
     * @param manager the CommandManager controlling the game loop
     * @param message the message to display when the game ends
     */
    public EndCommand(CommandManager manager,String message) {
        this.manager = manager;
        this.message = message;
    }

    /**
     * Executes the end command.
     * Stops the game loop in CommandManager and returns the end message.
     * @param args ignored for this command
     * @return the end message to display
     */
    @Override
    public String execute(String args) {
        manager.stopGame();
        return message;
    }
}
