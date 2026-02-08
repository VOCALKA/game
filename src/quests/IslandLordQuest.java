package quests;

import locations.Location;
import main.GameData;
import main.GameLoader;

import java.util.Map;

public class IslandLordQuest implements Quest{
    private boolean completed = false;
    private Map<String, Location> world;

    @Override
    public String getTitle() {
        return "Zkouška Pána ostrova";
    }

    @Override
    public void start() {
        System.out.println("Pán ostrova tě zkouší otázkami...");
        //TODO
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void complete() {
        completed = true;
        System.out.println("Úkol dokončen! Pán ostrova tě odměnil.");


        Location studna = world.get("loc_well");
        if (studna != null) {
            studna.setLocked(false);
            System.out.println("Cesta ke studni se odemkla!");
        }
    }
}
