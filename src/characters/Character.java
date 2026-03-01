package characters;

public abstract class Character {

    /**
     * Character data (name, ID, role, etc.)
     */
    protected CharacterData data;

    /**
     * Sets the character data.
     * @param data an instance of CharacterData containing information about the character
     */
    public void setData(CharacterData data) {
        this.data = data;
    }

    /**
     * Returns the character data.
     * @return an instance of CharacterData
     */
    public CharacterData getData() {
        return data;
    }

    /**
     * Returns the unique ID of the character (e.g., for locating in the world or quests).
     * @return character ID as a string
     */
    public String getId() {
        return data.getId();
    }

    /**
     * Returns the name of the character.
     * @return character's name
     */
    public abstract String getName();

    /**
     * Defines what the character says when the player talks to them.
     * @param player the player instance interacting with this character
     * @return text that the character says to the player
     */
    public abstract String talk(Player player);

}
