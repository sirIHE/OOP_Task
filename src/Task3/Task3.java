package Task3;

import java.util.Map;

public class Task3 {
    public static void millionsRounding (Map<String,Integer> citypop){
        for (Map.Entry entry: citypop.entrySet()){
            int start = (int) entry.getValue();
            float population = (float) start / 1000000;
            int roundpopulation = Math.round(population);
            citypop.put((String) entry.getKey(), roundpopulation * 1000000);
        }
        System.out.println("Города с населением окгругленым до ближайшего миллиона");
        for (Map.Entry entry: citypop.entrySet()){
            System.out.println(entry);
        }
    }
    public static double [] otherSides (double x){
        double [] mas = {x*2 , x*Math.sqrt(3)};
        return mas;
    }
    public static String rps (String [] mas){
        if (mas[0].equals(mas[1])) return "TIE";
        else if (mas[0].equals("rock")) {
            if (mas[1].equals("paper")) return "Player 2 wins";
            else return "Player 1 wins";
        }
        else if (mas[0].equals("scissors")) {
            if (mas[1].equals("paper")) return "Player 1 wins";
            else return "Player 2 wins";
        }
        else {
            if (mas[1].equals("scissors")) return "Player 2 wins";
            else return "Player 1 wins";
        }
    }
    public static int warOfNumbers(int [] mas){
        int chetsum = 0;
        int nechetsum = 0;
        for(int i =0; i< mas.length; i++){
            if (mas[i] % 2 == 0) chetsum = chetsum+mas[i];
            else nechetsum = nechetsum+mas[i];
        }
        if (chetsum >= nechetsum) return chetsum - nechetsum;
        else  return nechetsum - chetsum;
    }
    public static String reverseCase (String words){
        String result = "";
        for (int i = 0; i < words.length(); i++){
            if (Character.isUpperCase(words.charAt(i)))
                result = result + Character.toLowerCase(words.charAt(i));
            else
                result = result + Character.toUpperCase(words.charAt(i));
        }
        return result;
    }
    public static String inatorInator (String words){
        String consonantsEnglish = "qwrtplkjhgfdszxcvbnmy";
        int leg = words.length();
        if (consonantsEnglish.indexOf(Character.toLowerCase(words.charAt(leg-1))) == -1)
            words = words + "-inator " + Integer.toString(leg) + "000";
        else
            words = words + "inator " + Integer.toString(leg) + "000";
        return words;
    }
    public static boolean doesBrickFit (int a, int b, int c, int w, int h){
        return (w*h >= a*b || w*h >= c*b || w*h >= a*c);
    }
    public static double totalDistance (double fuel, double consumption, int passengers, boolean conditioning){
        double percent = 1;
        if (conditioning){
            percent = 1.1;
        }
        return (fuel/(consumption/100*percent*(1+(passengers*0.05))));
    }
    public static double mean ( int [] mas){
        double sum = 0;
        for (int i = 0; i < mas.length; i++){
            sum += mas[i];
        }
        return sum/ mas.length;
    }
    public static boolean parityAnalysis(int number){
        int sum = 0;
        int copy = number;
        while (number != 0){
            sum+= (number%10);
            number /= 10;
        }
        return sum%2 == copy%2;
    }
}
