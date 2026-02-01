package commands;

import characters.Character;
import characters.Player;
import locations.Location;
import main.GameCharacter;

public class TalkCommand implements Command{

    private Character npc;
    private Player player;

    public TalkCommand(Player player) {
        //this.npc = npc;
        this.player = player;
    }


    @Override
    public String getName() {
        // TODO
        return "mluv";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Zahájí rozhovor s NPC";
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Musíš zadat jméno NPC, se kterým chceš mluvit.");
            return;
        }


        Character npc = null;
        for (Character c : player.getCurrentLocation().getNpcs()) {
            if (c.getName().equalsIgnoreCase(args)) {
                npc = c;
                break;
            }
        }

        if (npc == null) {
            System.out.println("Takové NPC zde není.");
            return;
        }
        player.setCurrentDialogueNpc(npc);
        npc.talk(player);
        // TODO
    }
}
