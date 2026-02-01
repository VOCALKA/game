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

    @Override
    public void execute(String args) {
        System.out.println("Hra ukončena.");
        System.exit(0);
        // TODO
    }
}
