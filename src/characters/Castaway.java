package characters;

import quests.CastawayQuest;
import quests.Quest;



public class Castaway implements Character{

    private Quest quest = new CastawayQuest();

    @Override
    public String getName() {
        // TODO
        return "Ztroskotanec";
    }

    @Override
    public void talk(Player player) {
        if (!quest.isCompleted()) {
            System.out.println("ahoj");
        } else {
            System.out.println("ahoj");
        }

        // TODO
    }

    public Quest getQuest() {
        // TODO
        return quest;
    }
}
