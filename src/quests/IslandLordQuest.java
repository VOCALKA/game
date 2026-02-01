package quests;

public class IslandLordQuest implements Quest{
    private boolean completed = false;

    @Override
    public String getTitle() {
        return "Zkouška Pána ostrova";
    }

    @Override
    public void start() {
        System.out.println("Pán ostrova tě zkouší otázkami...");
        //TODO
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void complete() {
        completed = true;
        System.out.println("Úkol dokončen! Pán ostrova tě odměnil.");
    }
}
