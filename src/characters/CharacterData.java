package characters;

public class CharacterData {
    private String id;
    private String name;
    private String role;
    private String homeLocationId;
    private String notes;
    private boolean locked;

    public CharacterData(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.notes = "";
        this.homeLocationId = null;
        this.locked = false;
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
     * Returns the role of the character (PLAYER, NPC).
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setHomeLocationId(String homeLocationId) {
        this.homeLocationId = homeLocationId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
