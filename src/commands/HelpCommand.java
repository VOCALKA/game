package commands;

public class HelpCommand implements Command{

    private CommandManager manager;

    /**
     * Constructor.
     * @param manager the CommandManager controlling the game
     */
    public HelpCommand(CommandManager manager) {
        this.manager = manager;
    }

    /**
     * Returns the command name.
     * @return "pomoc"
     */
    @Override
    public String getName() {

        return "pomoc";
    }

    /**
     * Returns the command description.
     * @return description of the command
     */
    @Override
    public String getDescription() {

        return "Zobrazí seznam dostupných příkazů";
    }

    /**
     * Executes the help command.
     * Retrieves the list of commands from the CommandManager.
     * @param args ignored for this command
     * @return the formatted list of available commands
     */
    @Override
    public String execute(String args) {
        return manager.showCommands();

    }
}
