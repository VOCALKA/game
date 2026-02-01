package items;

public class ItemFactory {
    public static Item createItem(String id) {
        return switch (id) {
            case "item_empty_bottle" -> new EmptyBottle();
            case "item_filled_bottle" -> new FilledBottle();
            case "item_wood" -> new Wood();
            case "item_light" -> new Light();
            case "item_flying_boots" -> new FlyingBoots();
            default -> null;
        };
    }

}
