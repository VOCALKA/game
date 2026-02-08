package quests;

import items.Item;
import items.ItemData;
import items.ItemFactory;
import locations.Location;

import java.util.ArrayList;

public class QuestData {
    public String id;
    public String title;
    public String giverCharacterId;
    public ArrayList<String> requiredItems;
    public String rewardItem;
    public String status;
    public String unlockCharacterId;
    public String unlockLocationId;
    public String npcResponse;
    public String targetLocationId;
    public String action;
    public ArrayList<String> correctLocationIds;

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getGiverCharacterId() { return giverCharacterId; }
    public ArrayList<String> getRequiredItems() { return requiredItems; }
    public String getRewardItem() { return rewardItem; }
    public String getStatus() { return status; }

    public String getUnlockCharacterId() {
        return unlockCharacterId;
    }

    public String getUnlockLocationId() {
        return unlockLocationId;
    }

    public String getNpcResponse() {
        return npcResponse;
    }

    public String getTargetLocationId() {
        return targetLocationId;
    }

    public String getAction() {
        return action;
    }
}
