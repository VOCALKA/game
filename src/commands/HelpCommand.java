package commands;

public class HelpCommand implements Command{

    private CommandManager manager;

    public HelpCommand(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {

        return "pomoc";
    }

    @Override
    public String getDescription() {

        return "Zobrazí seznam dostupných příkazů";
    }

    @Override
    public String execute(String args) {
        return manager.showCommands();

    }
}
