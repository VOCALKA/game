package commands;

import characters.Character;
import characters.NPC;
import characters.Player;
import locations.Location;
import main.GameCharacter;
import quests.QuestData;

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
    public String execute(String args) {

        if (args.isEmpty()) {
            return "Musíš zadat jméno NPC, se kterým chceš mluvit (např. 'mluv Balvadr').";
        }


        Character targetNpc = player.getCurrentLocation().getNpcByName(args);

        if (targetNpc == null) {
            return "Nikdo jménem '" + args + "' tu není.";
        }


        player.setCurrentDialogueNpc(targetNpc);

        if (targetNpc instanceof NPC genericNpc) {
            return genericNpc.talk(player);
        }

        return "Postava " + targetNpc.getName() + " ti nemá co říct.";
    }
}
