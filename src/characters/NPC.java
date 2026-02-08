package characters;

import quests.QuestData;

public class NPC extends Character {

    public NPC(CharacterData data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return data.getName();
    }


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
