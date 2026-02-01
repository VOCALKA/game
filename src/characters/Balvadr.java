package characters;

import quests.BalvadrQuest;
import quests.Quest;

public class Balvadr implements Character{

    private Quest quest = new BalvadrQuest();

    @Override
    public String getName() {
        // TODO
        return "Balvadr";
    }

    @Override
    public void talk(Player player) {
        if (!quest.isCompleted()) {
            System.out.println("Balvadr: Pomoz mi s kletbou! Potřebuji naplněnou lahvičku.");
        } else {
            System.out.println("Balvadr je osvobozen.");
        }
        // TODO
    }

    public Quest getQuest() {
        // TODO
        return quest;
    }
}
