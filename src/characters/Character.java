package characters;

public abstract class Character {
    protected CharacterData data;

    public void setData(CharacterData data) {
        this.data = data;
    }

    public CharacterData getData() {
        return data;
    }

    public String getId() {
        return data.getId();
    }

    public abstract String getName();


    public abstract String talk(Player player);

}
