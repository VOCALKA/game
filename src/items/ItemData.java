package items;

import characters.Player;

public class ItemData {
    public String id;
    public String name;
    public String type;
    public String description;

    public String text;

    public String getText() {
        return text;
    }

    public ItemData(String id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getDescription() { return description; }

    public void use(Player player) {
    }
}
