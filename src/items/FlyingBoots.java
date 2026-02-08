package items;

import characters.Player;
import commands.CommandManager;
import commands.EndCommand;

public class FlyingBoots implements Item{
    CommandManager cmdManager;

    @Override
    public String getName() {
        //TODO
        return "Létající boty";
    }

    @Override
    public void use(Player player) {
        System.out.println("Vznesla ses do vzduchu!");
        //new EndCommand(cmdManager, "Gratuluji! Vyhrál jsi hru!").execute("");
        System.exit(0);
        player.removeItem(this);
        //TODO Dát do string metody, změnit System.exit(0);
    }
    @Override
    public String getId() {
        return "item_flying_boots";
    }

}
