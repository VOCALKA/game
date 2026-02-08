package commands;

import characters.Player;
import locations.Location;

public class ListenCommand implements Command{

    private Player player;

    private Location location;


    public ListenCommand(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        // TODO
        return "poslouchej";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Naslouchá prostředí v aktuální lokaci";
    }

    @Override
    public String execute(String args) {
        Location location = player.getCurrentLocation();
        String sound = location.getAmbientSound();
        if (sound == null || sound.isEmpty()) {

            return "Nic zvláštního neuslyšíš.";
        } else {
            return "Slyšíš: " + sound;
        }
    }
}
