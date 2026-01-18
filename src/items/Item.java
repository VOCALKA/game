package items;

import characters.Player;

public interface Item {
    String getName();
    void use(Player player);
}
