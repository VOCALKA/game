package locations;

public interface Location {
    String getName();
    String getDescription();
    void onEnter();
    void listen();
    boolean canEnter();
}
