package items;

import characters.Player;

public class EmptyBottle implements Item{
    @Override
    public String getName() {
        //TODO
        return "Prázdná lahvička";
    }

    @Override
    public String use(Player player) {
        if (player.getCurrentLocation().getId().equals("loc_lagoon")) {
            //System.out.println("");
            player.removeItem(this);
            player.addItem(new FilledBottle());
            return "Naplnil jsi lahvičku magickou vodou.";
        } else {
            //System.out.println("Nelze naplnit zde.");
            return "Zde lahvičku naplnit nemůžeš.";
        }

        //TODO
    }
    @Override
    public String getId() {
        return "item_empty_bottle";
    }
}
