package dq1.core;

/** Dependency-free smoke tests for the quest progression system. */
public final class QuestSmokeTest {
    private QuestSmokeTest() { }

    public static void main(String[] args) {
        String id = "ci-smoke-quest";
        Quest.addQuest(id, "CI Smoke Quest", "Verify quest progression.");
        Quest.QuestData quest = Quest.getQuest(id);
        check(quest != null, "quest is registered");
        check(!Quest.isCompleted(id), "new quest starts incomplete");

        Quest.addObjective(id, "Find the old bridge");
        Quest.addReward(id, "100 gold");
        check(quest.objectives.size() == 1, "objective is recorded");
        check("Find the old bridge".equals(quest.objectives.get(0)), "objective text is retained");
        check(quest.rewards.size() == 1, "reward is recorded");

        Quest.addObjective("missing-quest", "ignored safely");
        Quest.addReward("missing-quest", "ignored safely");
        Quest.completeQuest("missing-quest");
        check(!Quest.isCompleted("missing-quest"), "unknown quest is not completed");

        Quest.completeQuest(id);
        check(Quest.isCompleted(id), "quest can be completed");
        check(Quest.getAllQuests().stream().anyMatch(q -> id.equals(q.id)),
                "quest appears in the quest listing");
        System.out.println("QuestSmokeTest: all assertions passed.");
    }

    private static void check(boolean condition, String description) {
        if (!condition) {
            throw new AssertionError("Failed: " + description);
        }
    }
}
