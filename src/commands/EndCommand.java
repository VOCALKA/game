package commands;

public class EndCommand implements Command{


    @Override
    public String getName() {
        // TODO
        return "konec";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Ukončí hru";
    }
    private String message;
    private CommandManager manager;

    public EndCommand() {
        this.message = "Hra ukončena.";
    }

    public EndCommand(CommandManager manager,String message) {
        this.manager = manager;
        this.message = message;
    }

    @Override
    public String execute(String args) {
        manager.stopGame();
        return message;
    }
}
