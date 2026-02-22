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

    /**
     * Constructor for TalkCommand.
     * @param player the player who will talk to NPCs
     */
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

    /**
     * Executes the talk command.
     * Finds the NPC in the current location by name, sets it as the dialogue target,
     * and retrieves its dialogue text.
     *
     * @param args the name of the NPC to talk to
     * @return dialogue text from the NPC, or an error if the NPC isn't present
     */
    @Override
    public String execute(String args) {

        if (args.isEmpty()) {
            return "Musíš zadat jméno NPC, se kterým chceš mluvit.";
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
