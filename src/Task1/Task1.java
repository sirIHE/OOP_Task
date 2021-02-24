package Task1;

public class Task1 {
    public static int convert (int min) {
        return min * 60;
    }
    public static int points(int two, int three) {
        return two*2 + three*3;
    }
    public static int footballPoints(int victory, int draw, int defeat) {
        return  victory*3 + draw*1 + defeat*0;
    }
    public static String divisibleByFive (int numeric) {
        if (numeric % 5 == 0) {
            return "true";
        }
        else {
            return "false";
        }
    }
    public static boolean and (boolean one, boolean two) {
        return one && two;
    }
    public static int howManyWalls (int n, int w, int h) {
        return n/(w*h);
    }
    public static int squared(int b){
        return b * b;
    }
    public static boolean profitableGamble(float prob, int prize, int pay){
        return (prob * prize) > pay;
    }
    public static int frames (int min, int FPS) {
        return min * 60 * FPS;
    }
    public static int mod (int one, int two){
        return one - ((one / two) * two);
    }
    //System.out.println(); //Принт в консоль
}
