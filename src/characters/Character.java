package characters;

import quests.Quest;

public interface Character {
    String getName();
    void talk(Player player);
    Quest getQuest();
}
