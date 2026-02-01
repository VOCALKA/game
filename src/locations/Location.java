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
    public List<ItemData> items;
    public List<Character> npcs;

    public String text;

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

//
}
