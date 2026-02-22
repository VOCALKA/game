package commands;

import characters.Player;
import quests.Quest;
import quests.QuestData;

import java.util.List;

public class QuestsCommand implements Command{

    private Player player;

    /**
     * Constructor for QuestsCommand.
     * @param player the player whose quests will be displayed
     */
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

    /**
     * Executes the command to list all current quests of the player.
     * Filters out quests with status "LOCKED" and shows whether each quest is active or completed.
     * @param args any extra arguments (ignored for this command)
     * @return a string listing all visible quests or a message if none are available
     */
    @Override
    public String execute(String args) {

        List<QuestData> quests = player.getQuests();
        if (quests == null || quests.isEmpty()) return "Nemáš žádné úkoly.";

        StringBuilder sb = new StringBuilder("Aktuální úkoly:\n");
        boolean hasVisibleQuest = false;

        for (QuestData qData : quests) {

            if (!"LOCKED".equalsIgnoreCase(qData.status)) {
                String statusIndicator = "COMPLETED".equalsIgnoreCase(qData.status) ? " [hotovo]" : " [aktivní]";
                sb.append("- ").append(qData.getTitle()).append(statusIndicator).append("\n");
                hasVisibleQuest = true;
            }
        }

        if (!hasVisibleQuest) return "Zatím nemáš žádné aktivní úkoly. Zkus si promluvit s lidmi na ostrově.";
        return sb.toString().trim();

        // TODO
    }
}
