package characters;

import quests.Quest;
import quests.TreeQuest;

public class WanderingTree implements Character{

    private Quest quest = new TreeQuest();

    @Override
    public String getName() {
        // TODO
        return "Bludný strom";
    }

    @Override
    public void talk(Player player) {
        if (!quest.isCompleted()) {
            System.out.println("");
        } else {
            System.out.println("");
        }
        // TODO
    }

    public Quest getQuest() {
        // TODO
        return quest;
    }
}
