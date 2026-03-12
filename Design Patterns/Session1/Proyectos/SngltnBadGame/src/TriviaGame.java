import java.util.HashMap;
import java.util.Map;

class TriviaGame {
    private static TriviaGame instance;   // única instancia

    private int round = 1;
    private final Map<String, Integer> score = new HashMap<>();

    private TriviaGame() {
    }

    public static TriviaGame getInstance() {
        if (instance == null) {
            instance = new TriviaGame();
        }
        return instance;
    }

    public void answerCorrect(String player) {
        score.put(player, score.getOrDefault(player, 0) + 10);
    }

    public void nextRound() {
        round++;
    }

    public int getRound() {
        return round;
    }

    public int getScore(String player) {
        return score.getOrDefault(player, 0);
    }
}

class PlayerService {
    private TriviaGame game;

    public PlayerService() {
        game = TriviaGame.getInstance();
    }

    public void submitCorrectAnswer(String player) {
        game.answerCorrect(player);
    }
}

class AdminService {
    private TriviaGame game;

    public AdminService() {
        game = TriviaGame.getInstance();
    }

    public void advanceRound() {
        game.nextRound();
    }
}

class ScoreboardService {
    private TriviaGame game;

    public ScoreboardService() {
        game = TriviaGame.getInstance();
    }

    public int scoreOf(String player) {
        return game.getScore(player);
    }

    public int currentRound() {
        return game.getRound();
    }
}