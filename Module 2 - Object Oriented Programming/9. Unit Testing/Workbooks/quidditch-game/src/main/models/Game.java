package src.main.models;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Game {
    private HashMap<Team, Integer> scoreboard;

    public static final int QUAFFLE_POINTS = 10;
    public static final int SNITCH_POINTS = 150;
    private static int gameCount;

    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<>();
        scoreboard.put(new Team(home), 0);
        scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public Integer getScore(Team team) {
        return scoreboard.get(new Team(team));
    }

    public void setScore(Team team, Integer score) {
        if (score == null){
            throw new IllegalArgumentException("Score can't be null.");
        }
        scoreboard.put(new Team(team), score);
    }

    public static int getGameCount(){
        return gameCount;
    }

    public Team getTeam(String name) {
        return scoreboard.keySet()
                .stream()
                .filter(team -> team.getHouse().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Team not found"));
    }

    public String getPlaceholder(String play) {
        int begin = play.indexOf("<") + 1;
        int end = play.indexOf(">");
        return play.substring(begin, end);
    }

    public String replacePlaceholder(String play, String placeholder, String value) {
        play = play.replaceAll("[<>]", "");
        return play.replaceFirst(placeholder, value);
    }

    public void quaffleScore(Team team) {
        setScore(team, getScore(team) + QUAFFLE_POINTS);
    }

    public void catchSnitch(Team team) {
        setScore(team, getScore(team) + SNITCH_POINTS);
    }

    public String simulate(String play) {
        String positon = getPlaceholder(play);
        Team currentTeam = getRandomTeam();

        if (positon.equalsIgnoreCase(Team.getPOSITION_CHASER())) {
            quaffleScore(currentTeam);
            String chaser = currentTeam.getChaser(random(3));
            return replacePlaceholder(play, getPlaceholder(play), chaser);
        } else if (positon.equalsIgnoreCase(Team.getPOSITION_SEEKER())) {
            catchSnitch(currentTeam);
            String seeker = currentTeam.getSeeker();
            return replacePlaceholder(play, getPlaceholder(play), seeker);
        } else if (positon.equalsIgnoreCase(Team.getPOSITION_KEEPER())) {
            String keeper = currentTeam.getKeeper();
            return replacePlaceholder(play, getPlaceholder(play),keeper);
        }else
            return "";
    }

    public Team getRandomTeam() {
        return (Team) scoreboard.keySet().toArray()[random(scoreboard.size())];
    }

    public int random(int range) {
        return (int) (Math.random() * range);
    }
}
