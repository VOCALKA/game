package items;

import characters.Player;

public interface Item {
    String getName();
    String use(Player player);
    String getId();
}
