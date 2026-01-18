package quests;

public interface Quest {
    String getTitle();
    void start();
    boolean isCompleted();
    void complete();
}
