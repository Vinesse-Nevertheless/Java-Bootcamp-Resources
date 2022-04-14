public class YourInitials {
    public static void main(String[] args) {

        String row1row4 = v3vr4();
        String row2row3 = v3vr3r();
        String row5 = "V   V  R R";
        String row6 = "V   V  R  R";
        String row7 = "  V    R   R";

        System.out.println(row1row4);
        System.out.println(row2row3);
        System.out.println(row2row3);
        System.out.println(row1row4);
        System.out.println(row5);
        System.out.println(row6);
        System.out.println(row7);
    }

    public static String v3vr4(){
        String pattern = "V   V  RRRR";
        return pattern;
    }

    public static String v3vr3r(){
        String pattern = "V   V  R   R";
        return pattern;
    }
}