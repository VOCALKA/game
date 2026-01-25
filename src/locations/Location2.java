package locations;

public interface Location2 {
    String getName();
    String getDescription();
    void onEnter();
    void listen();
    boolean canEnter();
}
