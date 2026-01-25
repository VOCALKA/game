package locations;

import java.util.ArrayList;
import java.util.Map;

public class Location {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> neighbors;
    private ArrayList<String> lootTable;
    private Map<String, String> exits;


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
//
}
