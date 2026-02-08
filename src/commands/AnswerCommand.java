package commands;

import characters.CharacterData;
import characters.Player;

import locations.Location;
import main.GameData;
import main.GameLoader;
import quests.Quest;
import quests.QuestData;

import java.util.Map;

public class AnswerCommand implements Command {
    private Player player;
    private Map<String, Location> world;
    private GameData gameData;

    public AnswerCommand(Player player, Map<String, Location> world, GameData gameData) {
        this.player = player;
        this.world = world;
        this.gameData = gameData;
    }

    @Override
    public String getName() {
        // TODO
        return "odpoved";
    }

    @Override
    public String getDescription() {
        // TODO
        return "Odpovídej na otázku nebo volbu";
    }

    @Override
    public String execute(String args) {

        Location currentLoc = player.getCurrentLocation();


        characters.Character currentNpc = player.getCurrentDialogueNpc();
        if (currentNpc == null) return "Nejsi v dialogu s žádnou postavou.";


        String npcId = currentNpc.getData().getId();

        String playerInput = args.toLowerCase().trim();

        for (quests.QuestData qData : player.getQuests()) {


            if (qData.giverCharacterId.equalsIgnoreCase(npcId) && !"COMPLETED".equals(qData.status)) {

                if (qData.getId().equals("q_island_lord_trial")) {
                    if (args.isEmpty()) return currentNpc.getName() + ": Musíš mi říct tři čísla oddělená mezerou!";


                    int v_laguna = world.get("loc_lagoon").getEnvironmentCount();
                    int s_les = world.get("loc_forest").getEnvironmentCount();
                    int k_suma = world.get("loc_cliff").getEnvironmentCount() +
                            world.get("loc_cave").getEnvironmentCount() +
                            world.get("loc_x").getEnvironmentCount();

                    String expectedAnswer = v_laguna + " " + s_les + " " + k_suma;

                    if (playerInput.equals(expectedAnswer)) {

                        if (world.get("loc_well") != null) {
                            world.get("loc_well").setLocked(false);
                        }
                        return finishQuest(qData, currentNpc);
                    } else {
                        //return "Pán ostrova: Tvá čísla (" + playerInput + ") jsou lživá! Správně mělo být (" + expectedAnswer + "). Zůstaneš tu navždy.";
                        System.out.println("Pán ostrova: Tvá čísla (" + playerInput + ") jsou lživá! Správně mělo být (" + expectedAnswer + "). Zůstaneš tu navždy.");
                        System.exit(0);
                        return "";
                        //TODO opravit zpět na return a command end, vymazat system.exit

                    }
                }


                if (qData.correctLocationIds != null && !qData.correctLocationIds.isEmpty()) {
                    if (args.isEmpty()) return currentNpc.getName() + ": Musíš mi říct názvy těch lokací!";


                    boolean allFound = true;

                    for (String locId : qData.correctLocationIds) {
                        Location targetLoc = world.get(locId);
                        if (targetLoc == null) {
                            System.out.println("[DEBUG]: Lokace s ID " + locId + " neexistuje v mapě world!");
                            allFound = false;
                            break;
                        }


                        String expectedName = targetLoc.getName().toLowerCase().trim();


                        System.out.println("[DEBUG]: Hledám '" + expectedName + "' v tvé odpovědi '" + playerInput + "'");

                        if (!playerInput.contains(expectedName)) {
                            allFound = false;
                            break;
                        }
                    }

                    if (allFound) {
                        return finishQuest(qData, currentNpc);
                    }
                }


                if (qData.requiredItems != null && !qData.requiredItems.isEmpty()) {
                    boolean hasEverything = true;
                    for (String reqId : qData.requiredItems) {
                        if (!player.hasItem(reqId)) {

                            hasEverything = false;
                            break;
                        }
                    }

                    if (hasEverything) {

                        for (String reqId : qData.requiredItems) {
                            player.removeItemById(reqId);
                        }
                        return finishQuest(qData, currentNpc);
                    }
                }
            }
        }
        return currentNpc.getName() + ": To mi nepomůže. Musíš odpovědět správně nebo mi dát, co potřebuji.";
    }


    private String finishQuest(QuestData qData, characters.Character currentNpc) {
        qData.status = "COMPLETED";


        if (qData.getUnlockCharacterId() != null) {
            unlockNpcGlobally(qData.getUnlockCharacterId(), qData.getUnlockLocationId());
        }


        if (qData.getRewardItem() != null) {
            giveReward(qData.getRewardItem());
        }

        player.setCurrentDialogueNpc(null);
        return currentNpc.getName() + ": " + qData.npcResponse;
    }

    private void giveReward(String itemId) {

        items.Item reward = items.ItemFactory.createItem(itemId);

        if (reward != null) {
            player.addItem(reward);
            System.out.println("[SYSTÉM]: Do inventáře přidáno: " + reward.getName());
        } else {
            System.out.println("[DEBUG]: ItemFactory nenašla předmět s ID: " + itemId);
        }
    }

    private void unlockNpcGlobally(String npcId, String locationId) {
        Location loc = world.get(locationId);
        if (loc != null) {
            for (CharacterData cd : gameData.characters) {
                if (cd.getId().equals(npcId)) {

                    characters.Character newNpc = GameLoader.createCharacter(cd);


                    if (loc.getNpcs() == null) {
                        loc.npcs = new java.util.ArrayList<>();
                    }


                    loc.addNpc(newNpc);

                    loc.setLocked(false);

                    System.out.println("[DEBUG]: Postava " + cd.getName() + " přidána do " + loc.getName());
                    break;
                }
            }
        } else {
            System.out.println("[DEBUG]: Lokace " + locationId + " nebyla nalezena!");
        }
    }
}