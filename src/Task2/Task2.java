package Task2;

import java.util.Locale;

public class Task2 {
    public static int oppositeHouse (int number, int leg){
        return ((2*leg+1)-number);
    }
    public static String nameShuffle(String s){
        String[] words = s.split(" ");
        String rev = "";
        rev += words[1] + " ";
        rev += words[0];
        return rev;
    }
    public static double discount(int price, double percent){
        return ((price*(100-percent))/100);
    }
    public static int differenceMaxMin(int [] mas){
        int max = mas[0], min = mas[0];
       for (int i = 0; i < mas.length; i++){
           if (max < mas[i]) max = mas[i];
           if (min > mas[i]) min = mas[i];
       }
       return (max - min);
    }
    public static int equal(int one, int two, int three){
        if ((one == two) && (one == three)) return 3;
        else if ((one == two) || (one == three)) return 2;
        else if (two == three) return 2;
        else return 0;
    }
    public static String reverse(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }
    public static int programmers(int first, int second, int third){
        int max = 0, min = 0;
        max = Math.max(first,second);
        max = Math.max(max,third);
        min = Math.min(first,second);
        min = Math.min(min,third);
        return max - min;
    }
    public static boolean getXO (String s){
        int co = 0; int cx = 0;
        for (int i = 0; i < s.length(); i++){
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase("o")) co++;
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase("x")) cx++;
        }
        return co == cx;
    }
    public static String bomb(String s){
        if (s.toLowerCase(Locale.ROOT).contains("bomb")) return "ПРИГНИСЬ!";
        else return "Расслабься, бомбы нет";
    }
    public static boolean sameAscii (String first, String second){
        int sum1 = 0, sum2 = 0;
        sum1 = first.chars().sum();
        sum2 = second.chars().sum();
        return sum1 == sum2;
    }
}
