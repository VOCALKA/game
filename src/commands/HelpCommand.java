package commands;

public class HelpCommand implements Command{

    private CommandManager manager;

    public HelpCommand(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        // TODO
        return "pomoc";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Zobrazí seznam dostupných příkazů";
    }

    @Override
    public void execute(String args) {
        manager.showCommands();
        // TODO
    }
}
