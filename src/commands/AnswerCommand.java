package commands;

import characters.Player;

public class AnswerCommand implements Command{
    private Player player;

    public AnswerCommand(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        // TODO
        return "odpoved";
    }
    @Override
    public String getDescription() {
        // TODO
        return "Odpovídej na otázku nebo volbu";
    }
    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Musíš zadat svou odpověď.");
            return;
        }
        characters.Character currentNpc = player.getCurrentDialogueNpc();
        if (currentNpc == null) {
            System.out.println("Nejsi právě v dialogu s žádnou postavou.");
            return;
        }

        String npcName = currentNpc.getName();
        String playerAnswer = args.trim();
        //TODO
    }
}
