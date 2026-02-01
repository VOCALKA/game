package characters;

public class CharacterData {
    private String id;
    private String name;
    private String role;
    private String homeLocationId;
    private String notes;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeLocationId() {
        return homeLocationId;
    }
    public static Character createCharacter(CharacterData data) {

        switch (data.getId()) {

            case "npc_wandering_tree":
                return new WanderingTree();
            case "npc_island_lord":
                return new IslandLord();
            case "npc_balvadr":
                return new Balvadr();
            case "npc_castaway":
                return new Castaway();
            default:
                return null;
        }
    }
}
