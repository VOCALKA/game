package commands;


import characters.Character;
import characters.Player;
import items.ItemData;
import locations.Location;

public class SearchCommand implements Command{
    private Player player;

    public SearchCommand(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return "prohledej";
    }

    @Override
    public String getDescription() {
        return "Prohledá aktuální lokaci a vypíše, co se zde nachází";
    }

    @Override
    public void execute(String args) {
        Location loc = player.getCurrentLocation();

        System.out.println("Rozhlížíš se kolem sebe...");


        if (loc.getNpcs() != null && !loc.getNpcs().isEmpty()) {
            System.out.print("Postavy zde: ");
            for (int i = 0; i < loc.getNpcs().size(); i++) {
                System.out.print(loc.getNpcs().get(i).getName());
                if (i < loc.getNpcs().size() - 1) System.out.print(", ");
            }
            System.out.println();
        } else {
            System.out.println("Nikdo tu není.");
        }


        if (loc.items != null && !loc.items.isEmpty()) {
            System.out.print("Předměty zde: ");
            for (int i = 0; i < loc.items.size(); i++) {
                System.out.print(loc.items.get(i).getName());
                if (i < loc.items.size() - 1) System.out.print(", ");
            }
            System.out.println();
        } else {
            System.out.println("Žádné předměty tu nevidíš.");
        }
    }
}
