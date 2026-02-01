package commands;

import characters.Player;
import quests.Quest;

import java.util.List;

public class QuestsCommand implements Command{

    private Player player;

    public QuestsCommand(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        // TODO
        return "ukoly";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Zobrazí aktuální úkoly hráče";
    }

    @Override
    public void execute(String args) {
        List<Quest> quests = player.getQuests();
        if (quests.isEmpty()) {
            System.out.println("Nemáš žádné aktivní úkoly.");
            return;
        }

        System.out.println("Aktuální úkoly:");
        for (Quest quest : quests) {
            String status = quest.isCompleted() ? "✓ dokončeno" : "• aktivní";
            System.out.println("- " + quest.getTitle() + " [" + status + "]");
        }

        // TODO
    }
}
