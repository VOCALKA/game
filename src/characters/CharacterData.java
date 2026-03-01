package characters;

public class CharacterData {
    private String id;
    private String name;
    private String role;
    private String homeLocationId;
    private String notes;
    private boolean locked;

    public CharacterData(String npc1, String ss, String s) {
    }

    /**
     * Checks if the character is locked.
     * @return true if the character is locked, false otherwise
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Returns the unique ID of the character.
     * @return character ID as a String
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the character.
     * @return character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the home location of the character.
     * @return home location ID as a String
     */
    public String getHomeLocationId() {
        return homeLocationId;
    }

    /**
     * Returns the role of the character (e.g., PLAYER, NPC).
     * @return role as a String
     */
    public String getRole() {
        return role;
    }

    /**
     * Returns any additional notes associated with the character.
     * @return notes as a String
     */
    public String getNotes() {
        return notes;
    }
}
