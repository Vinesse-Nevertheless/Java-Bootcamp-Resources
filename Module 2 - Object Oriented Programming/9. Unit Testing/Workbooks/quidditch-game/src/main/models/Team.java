package src.main.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";


/* FREQUENTLY ASKED QUESTIONS:
    
Question: the constants are final, so why can't we make them public? It's not possible for the caller to update them.
  Answer: Even if the constant is final, I prefer to expose a method instead of the variable. But if you want to expose the variable, that's also correct.

*/

    
     public static String getPositionChaser() {
         return POSITION_CHASER;
     }

     public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

     public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

    public Team(String house, String keeper, String seeker, String[] chasers) {

        checkParam(house);
        checkParam(keeper);
        checkParam(seeker);

        if(hasBlank(chasers) || hasNull(chasers)){
            throw new IllegalArgumentException("illegal chaser arguments");
        }

        if(chasers.length != 3){
            throw new IllegalArgumentException("illegal chaser arguments");
        }


        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public static boolean hasNull(String[] chasers){
         return Arrays.stream(chasers).anyMatch(Objects::isNull);
    }

    public static boolean hasBlank(String[] chasers) {
         return Arrays.stream(chasers).anyMatch(String::isBlank);
    }

    public void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null or blank");
        }
    }
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public String[] getChasers(){
         return Arrays.copyOf(chasers, chasers.length);
    }

    public void setChasers(String[] chasers){
        if(hasBlank(chasers) || hasNull(chasers) || chasers.length !=3){
            throw new IllegalArgumentException("illegal chaser arguments");
        }
       this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public String getChaser(int index) {
        return chasers[index];
    }

    public void setChaser(String[] chasers, int index) {
        if(hasBlank(chasers) || hasNull(chasers) || chasers.length !=3){
            throw new IllegalArgumentException("illegal chaser arguments");
        }
        this.chasers[index] = chasers[index];
    }

    public static String getPOSITION_CHASER() {
        return POSITION_CHASER;
    }

    public static String getPOSITION_SEEKER() {
        return POSITION_SEEKER;
    }

    public static String getPOSITION_KEEPER() {
        return POSITION_KEEPER;
    }

    @Override
    public String toString(){
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: "  + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return getHouse().equals(team.getHouse()) && getKeeper().equals(team.getKeeper()) && getSeeker().equals(team.getSeeker()) && Arrays.equals(getChasers(), team.getChasers());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getHouse(), getKeeper(), getSeeker());
        result = 31 * result + Arrays.hashCode(getChasers());
        return result;
    }
}
