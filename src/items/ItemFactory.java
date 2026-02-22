package items;

import commands.CommandManager;

public class ItemFactory {
    /**
     * Creates an item instance based on its unique ID.
     *
     * @param id         the unique ID of the item to create
     * @param cmdManager the CommandManager to pass to items that need it (can be null for items that don't use it)
     * @return the created Item instance, or null if the ID is unknown
     */
    public static Item createItem(String id, CommandManager cmdManager) {
        return switch (id) {
            case "item_empty_bottle" -> new EmptyBottle();
            case "item_filled_bottle" -> new FilledBottle();
            case "item_wood" -> new Wood();
            case "item_light" -> new Light();
            case "item_flying_boots" -> new FlyingBoots(cmdManager);
            default -> null;
        };
    }

}
