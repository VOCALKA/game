package commands;

import characters.CharacterData;
import characters.NPC;
import characters.Player;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quests.QuestData;

import static org.junit.jupiter.api.Assertions.*;

class TalkCommandTest {
    private Player player;
    private Location location;
    private TalkCommand talkCommand;

    @BeforeEach
    void setUp() {
        player = new Player("Pavla", null);

        location = new Location("loc_test", "TestLocation");
        player.setCurrentLocation(location);

        talkCommand = new TalkCommand(player);

        CharacterData npcData = new CharacterData("npc1", "Pepa", "NPC");
        npcData.setNotes("Ahoj, mám pro tebe úkol!");
        npcData.setName("Pepa");

        NPC npc = new NPC(npcData);
        location.addNpc(npc);
    }


    @Test
    void testTalkWithActiveQuest() {

        QuestData quest = new QuestData();
        quest.giverCharacterId = "npc1";
        quest.status = "LOCKED";
        quest.setTitle("Najdi artefakt");
        player.getQuests().add(quest);

        String result = talkCommand.execute("Pepa");

        assertTrue(result.contains("Pepa: Ahoj, mám pro tebe úkol!"));
        assertTrue(result.contains("[Nový úkol: Najdi artefakt]"));
        assertEquals("ACTIVE", quest.status);
    }

    @Test
    void testTalkNonExistingNpc() {
        String result = talkCommand.execute("Neexistujici");

        assertNull(player.getCurrentDialogueNpc());
        assertEquals("Nikdo jménem 'Neexistujici' tu není.", result);
    }

    @Test
    void testTalkEmptyName() {
        String result = talkCommand.execute("");

        assertNull(player.getCurrentDialogueNpc());
        assertEquals("Musíš zadat jméno NPC, se kterým chceš mluvit.", result);
    }
}