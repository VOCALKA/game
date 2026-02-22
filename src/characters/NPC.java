package characters;

import quests.QuestData;

public class NPC extends Character {

    /**
     * Creates a new NPC with the provided character data.
     * @param data the static data describing this NPC
     */
    public NPC(CharacterData data) {
        this.data = data;
    }

    /**
     * Returns the name of this NPC.
     * @return NPC's name
     */
    @Override
    public String getName() {
        return data.getName();
    }

    /**
     * Handles dialogue with the player.
     * Checks if the player has quests from this NPC and updates quest status if necessary.
     * @param player the player interacting with this NPC
     * @return dialogue text as a String
     */
    public String talk(Player player) {

        for (QuestData q : player.getQuests()) {
            if (q.giverCharacterId.equals(data.getId())) {

                if ("LOCKED".equalsIgnoreCase(q.status)) {
                    q.status = "ACTIVE";
                    return data.getName() + ": " + data.getNotes() + "\n[Nový úkol: " + q.getTitle() + "]";
                }
                if ("COMPLETED".equals(q.status)) {
                    return data.getName() + ": Děkuji ti za pomoc!";
                }

                return data.getName() + ": " + data.getNotes();
            }
        }
        return data.getName() + ": Zdravím tě";
    }

}
