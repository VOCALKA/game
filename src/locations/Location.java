package locations;

import items.*;
import characters.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Location {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> neighbors;
    public ArrayList<String> lootTable;
    private Map<String, String> exits;
    public String ambientSound;
    public List<ItemData> items = new ArrayList<>();
    public List<Character> npcs = new ArrayList<>();

    public String text;

    public String getText() {
        return text;
    }

    private boolean locked = false;

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private int environmentCount;
    public int getEnvironmentCount() { return environmentCount; }
    public void setEnvironmentCount(int count) {
        this.environmentCount = count;
    }



    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", neighbors=" + neighbors +
                ", lootTable=" + lootTable +
                '}';
    }
//
    public Map<String, String> getExits() {
        return exits;
    }
//
    public String getDescription() {
        return description;
    }

    public Item getItem(String itemName) {
        if (items == null)
            return null;

        for (ItemData data : items) {
            if (data.getName().equalsIgnoreCase(itemName)) {
                return ItemFactory.createItem(data.getId());
            }
        }
        return null;
    }

    public void removeItem(Item item) {

            if (items == null) return;
            items.removeIf(data -> data.getId().equalsIgnoreCase(item.getId()));
    }

    public String getAmbientSound() {
        return ambientSound;
    }
    public List<Character> getNpcs() {
        return npcs;
    }

    public void addNpc(Character npc) {
        if (!npcs.contains(npc)) {
            npcs.add(npc);
        }
    }

    public void removeNpc(Character npc) {
        npcs.remove(npc);
    }

    public characters.Character getNpcByName(String name) {
        if (this.npcs == null) {
            return null;
        }

        for (characters.Character npc : this.npcs) {

            if (npc.getName().equalsIgnoreCase(name)) {
                return npc;
            }
        }

        return null;
    }
}
