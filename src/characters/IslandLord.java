package characters;

import quests.IslandLordQuest;
import quests.Quest;

public class IslandLord implements Character{

    private Quest quest = new IslandLordQuest();

    @Override
    public String getName() {
        // TODO
        return "Pán ostrova";
    }

    @Override
    public void talk(Player player) {
        if (!quest.isCompleted()) {
            System.out.println("Pán ostrova: Zodpověz mé otázky a dostaneš odměnu!");
            quest.start();
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
