package characters;

public class CharacterData {
    private String id;
    private String name;
    private String role;
    private String homeLocationId;
    private String notes;
    private boolean locked;

    public boolean isLocked() {
        return locked;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeLocationId() {
        return homeLocationId;
    }

    public String getRole() {
        return role;
    }
    public String getNotes() {
        return notes;
    }
}
