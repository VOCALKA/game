package items;

import characters.Player;
import commands.CommandManager;
import commands.EndCommand;

public class FlyingBoots implements Item{
    CommandManager cmdManager;

    public FlyingBoots(CommandManager cmdManager) {
        this.cmdManager = cmdManager;
    }

    private boolean exit = false;





    @Override
    public String getName() {
        //TODO
        return "Létající boty";
    }

    @Override
    public String use(Player player) {
        System.out.println("Vznesla ses do vzduchu! Vyhrál jsi.");
        player.removeItem(this);
        System.exit(0);
        return "";
        //TODO Dát do string metody, změnit System.exit(0);
    }


    @Override
    public String getId() {
        return "item_flying_boots";
    }

}
