package src.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.models.Game;
import src.main.models.Team;


public class GameTest {

    Game game;
    Team home;
    Team away;
    @BeforeEach
    public void setup() {
        home = new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[]{"Angelina", "Ginny", "Katie"});

        away = new Team("SLYTHERIN", "Vincent", "Draco",
                new String[]{"Bridget", "Harper", "Malcolm"});

        game = new Game(home, away);

    }

    @Test
    public void getPlaceholderTest() {
        assertEquals("chaser", game.getPlaceholder("<chaser> gets the next pass"));
    }
    @Test
    public void replacePlaceholderTest() {
        assertEquals("Katie gets the next pass",
                game.replacePlaceholder("<chaser> gets the next pass",
                        "chaser",
                        "Katie"));
    }

    @Test
    public void quaffleScoreTest(){
        game.quaffleScore(home);
        game.quaffleScore(home);
        assertEquals(Game.QUAFFLE_POINTS * 2, game.getScore(home));
    }

    @Test
    public void catchSnitchTest(){
        game.catchSnitch(away);
        assertEquals(Game.SNITCH_POINTS, game.getScore(away));
    }

}
