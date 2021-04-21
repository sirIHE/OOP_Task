package Task4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Результаты первого задания");
        int [] num1 = {1,2 ,3 , 6, 878};
        System.out.println(sevenBoom(num1));
        int [] num12 = {8, 6, 33, 100};
        System.out.println(sevenBoom(num12));
        int [] num13 = {2, 55, 60, 97, 86};
        System.out.println(sevenBoom(num13));
        System.out.println("Результаты второго задания");
        int [] num2 = {5, 1, 4, 3, 2};
        System.out.println(cons(num2));
        int [] num22 = {5, 1, 4, 3, 2, 8};
        System.out.println(cons(num22));
        int [] num23 = {5, 6, 7, 8, 9, 9};
        System.out.println(cons(num23));
        System.out.println("Результаты третьего задания");
        System.out.println(unmix("123456"));
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println(unmix("badce"));
        System.out.println("Результаты четвертого задания");
        System.out.println(noYelling("What went wrong?????????"));
        System.out.println(noYelling("Oh my goodness!!!"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println("Результаты пятого задания");
        System.out.println(xPronounce("Inside the box was a xylophone"));
        System.out.println(xPronounce("The x ray is excellent"));
        System.out.println(xPronounce("OMG x box unboxing video x D"));
        System.out.println("Результаты шестого задания");
        int [] num6 = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
        System.out.println(largestGap(num6));
        int [] num62 = {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        System.out.println(largestGap(num62));
        int [] num63 = {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9};
        System.out.println(largestGap(num63));
        System.out.println("Результаты седьмого задания");
        System.out.println(difsort(832));
        System.out.println(difsort(51));
        System.out.println(difsort(7977));
        System.out.println("Результаты восьмого задания");
        System.out.println(commonLastVowel("Hello World!"));
        System.out.println(commonLastVowel("Watch the characters dance!"));
        System.out.println(commonLastVowel("OOI UUI EEI AAI"));
        System.out.println("Результаты девятого задания");
        System.out.println(memeSum(26,39));
        System.out.println(memeSum(122,81));
        System.out.println(memeSum(1222,30277));
        System.out.println("Результаты десятого задания");
        System.out.println(unrepeated("teshahset"));
        System.out.println(unrepeated("hello"));
        System.out.println(unrepeated("aaaaa"));
    }
    public static String sevenBoom(int [] mas) {
        String rez = "";
        for (int i = 0; i < mas.length; i++) {
            rez += mas[i];
        }
        if (rez.contains("7")) return "Boom!";
        else return "there is no 7 in the array";
    }
    public static boolean cons (int [] mas){
        int [] sort = Arrays.stream(mas).sorted().toArray();
        boolean rez = true;
        int one = sort[0];
        for (int i = 0; i < sort.length; i++){
            if (sort[i] != one)
                rez = false;
            one ++;
        }
        return rez;
    }
    public static String unmix(String rts) {
        String str = "";
        for (int i = 0; i < rts.length(); i += 2) {
            if (i == rts.length() - 1)
                str += String.valueOf(rts.charAt(i));
            else {
                str += String.valueOf(rts.charAt(i + 1));
                str += String.valueOf(rts.charAt(i));
            }
        }
        return str;
    }
    public static String noYelling(String str){
        char [] refer = str.toCharArray();
        String rez = "";
        for (int i = refer.length - 1; i > 0; i --){
            if((refer[i] != '?') && (refer[i] != '!'))
                break;
            if(refer[i] == refer[i-1])
                refer[i] = 0;
        }
        for (int i = 0; i < refer.length; i++){
            if (refer[i]!= 0)
                rez += refer[i];
        }
        return rez;
    }
    public static String xPronounce (String str){
        String [] line = str.split(" ");
        String rez = "";
        for (String i: line){
            if (i.equalsIgnoreCase("x"))
                rez += "ecks" + " ";
            else if (i.charAt(0) == 'x')
                rez += i.replace('x','z') + " ";
            else {
                char [] sim = i.toCharArray();
                for (char j: sim){
                    if ( j == 'x')
                        rez += "cks";
                    else
                        rez += j;
                }
                rez += " ";
            }
        }
        return rez;
    }
    public static int largestGap (int [] mas){
        Arrays.sort(mas);
        int max = 0;
        for (int i = 0; i < mas.length - 1; i++){
            if (mas[i + 1] - mas [i] > max)
                max = mas[i + 1] - mas [i];
        }
        return max;
    }
    public static int difsort(int number){
        String num = Integer.toString(number);
        int [] mas = new int [num.length()];
        for (int i = 0; i < mas.length; i++){
                mas [i] = (number%10);
                number /= 10;
        }
        Arrays.sort(mas);
        String sort = "";
        for (int i = 0; i < mas.length; i++){
            sort += mas[i];
        }
        return Integer.valueOf(num) - Integer.valueOf(sort);
    }

    public static String commonLastVowel(String str)
    {
        Map<String, Integer> vowelsCount = new HashMap<>();
        String vowelsEng = "aeiouy";
        String [] line = str.split(" ");
        for (int i = 0; i < vowelsEng.length(); i++)
        {
            vowelsCount.put(String.valueOf(vowelsEng.charAt(i)), 0);
        }
        for (String j: line)
        {
            for(int i = j.length() - 1; i > 0; i--)
            {
                if(vowelsEng.indexOf(j.toLowerCase().charAt(i)) >= 0)
                {
                    String key = String.valueOf(j.toLowerCase(Locale.ROOT).charAt(i));
                    int prevVal = vowelsCount.get(key);
                    vowelsCount.put(key, prevVal + 1);
                    break;
                }
            }
        }
        String mostCommon = null;
        int maxCount = 0;
        for (Map.Entry entry: vowelsCount.entrySet())
        {
            int count = (Integer)entry.getValue();
            if (mostCommon == null || count > maxCount)
            {
                mostCommon = (String)entry.getKey();
                maxCount = count;
            }
        }
        return mostCommon;
    }

    public static int memeSum(int one, int two){
        String num1 = Integer.toString(one);
        String num2 = Integer.toString(two);
        int leg = 0;
        int raz = 0;
        String str = "";
        if (one > two) {
            leg = num1.length();
            raz = num1.length() - num2.length();
            for (int i = 0; i < leg; i++){
                if (i < raz)
                    str += String.valueOf(num1.charAt(i));
                else
                    str += Integer.toString(Integer.parseInt(String.valueOf(num1.charAt(i))) + Integer.parseInt(String.valueOf(num2.charAt(i - raz))));
            }
        }
        else {
            leg = num2.length();
            raz = num2.length() - num1.length();
            for (int i = 0; i < leg; i++){
                if (i < raz)
                    str += String.valueOf(num2.charAt(i));
                else
                    str += Integer.toString(Integer.parseInt(String.valueOf(num2.charAt(i))) + Integer.parseInt(String.valueOf(num1.charAt(i - raz))));
            }
        }
        return Integer.valueOf(str);
    }

    public static String unrepeated(String reference)
    {
        String result = "";
        for (int i = 0; i < reference.length(); i++)
        {
            if (!result.contains(String.valueOf(reference.charAt(i))))
                result += String.valueOf(reference.charAt(i));
        }
        return result;
    }
}
