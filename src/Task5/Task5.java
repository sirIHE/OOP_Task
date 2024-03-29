package Task5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Шаблон идентичен? "+ sameLetterPattern("AABC","BBAC"));
        System.out.println("Шаблон идентичен? "+ sameLetterPattern("ASDFA","AASDF"));
        System.out.println("Шаблон идентичен? "+ sameLetterPattern("QWE","QWERT "));
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(digitsCount(2145));
        String[] array1 = {"cat", "create", "sat"};
        System.out.println(totalPoints(array1, "caster"));
        System.out.println(longestRun(1, 2, 3, 5, 6, 7, 8, 9));
        System.out.println(longestRun(1, 2, 3, 10, 11, 15));
        System.out.println(longestRun(5, 4, 2, 1));
        System.out.println(longestRun(3, 5, 7, 10, 15));
        System.out.println(takeDownAverage("95%", "83%", "90%", "87%", "88%", "93%"));
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(rearrange("the4 t3o man5 Happ1iest of6 no7 birt2hday steel8!"));
        System.out.println(maxPossible(9328, 456));
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(312));
        System.out.println(isNew(123));
    }

    public static boolean sameLetterPattern(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        boolean obj1[] = new boolean[str1.length()];
        boolean obj2[] = new boolean[str1.length()];
        for(int i =0;i<str1.length()-1;i++){
            obj1[i] = str1.charAt(i) == str1.charAt(i + 1);
            obj2[i] = str2.charAt(i) == str2.charAt(i + 1);
            //Выход в случае не совпадения
            if(obj1[i]!=obj2[i]) return false;
        }
        return true;
    }

    public static int digitsCount(int num){
        if(num%10==num) return 1;
        //Складывание единиц с конца
        return digitsCount(num/10)+1;
    }

    public static int totalPoints(String[] array, String word) {
        int mainCount = 0;
        List<Character> checkList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            checkList.add(word.charAt(i));
        }

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            char[] character = array[i].toCharArray(); //Разбиения строки по буквам
            List<Character> copy = new ArrayList<Character>(checkList); // Копия исходного слова

            for (int q = 0; q < character.length; q++) {
                if (copy.contains(character[q])) {
                    count++;
                    copy.remove(copy.indexOf(character[q]));
                } else
                    count = 0;
            }
            copy.removeAll(copy); //Удаление всего из копии
            //Прибвляем к счетчику результат сравнения со строкой
            if (count == 3)
                mainCount += 1;
            else if (count == 4)
                mainCount += 2;
            else if (count == 5)
                mainCount += 3;
            else if (count == 6 && copy.isEmpty())
                mainCount += 54;
            else
                mainCount += 0;
        }
        return mainCount;
    }

    public static int longestRun(int... num) {
        int lon = 1, count = 1;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] == num[i + 1] - 1||num[i] == num[i + 1] + 1) {
                count++;
                if (lon < count) lon = count;
            }
            else count = 1;
        }
        return lon;
    }

    public static String takeDownAverage(String...s){
        int rez=0;
        for(int i =0;i<s.length;i++){
            rez+=Integer.parseInt(s[i].substring(0, s[i].indexOf('%'))) - 5; // Вычитаем 5 из каждого
        }
        rez = rez / s.length - 5 * s.length; //Складываем и вычитаем 5*кол-во
        return rez+"%";
    }

    public static String rearrange(String str){
        if(str ==null||"".equals(str.trim())) return str; // Проверка строки
        String[] words = str.split(" ");
        Pattern pattern=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher;
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i =0;i<words.length;i++) arrayList.add("a");
        String rez ="";
        for(int i = 0; i < words.length; i++){
            matcher = pattern.matcher(words[i]); // Спостовляем слово и патерн
            matcher.find(); // Находим цифру
            //Используем цифру - 1 как индекс, записываем слово заменяя цифры на пустое место
            arrayList.set(Integer.parseInt(matcher.group())-1,words[i].replaceAll("\\d", "")+" ");
        }

        for(String s:arrayList) rez+=s;
        return rez;
    }

    public static int maxPossible(int fnum, int snum){
        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        String rez = "";
        //Массиы цифер первого числа
        while (fnum>0){
            num1.add(fnum%10);
            fnum = fnum/10;
        }
        //Массиы цифер второго числа
        while (snum>0){
            num2.add(snum%10);
            snum = snum/10;
        }
        Collections.reverse(num1);

        for(int i =0;i<num1.size();i++){
            for(int j =0;j < num2.size();j++){
                if(num1.get(i)<num2.get(j)){
                    num1.set(i,num2.get(j));
                    num2.set(j,0);
                }
            }
        }
        for(int m=0;m<num1.size();m++){
            rez+=num1.get(m);
        };
        return Integer.parseInt(rez);
    }

    public static String timeDifference(String cityA, String dateA, String cityB){

        //Мапа часовых поясов
        Map<String, Double> map = new HashMap<>();
        map.put("Los Angeles", -8.0);
        map.put("New York",-5.0);
        map.put("Caracas", -4.5);
        map.put("Buenos Aires",-3.0);
        map.put("London",0.0);
        map.put("Rome", 1.0);
        map.put("Moscow",3.0);
        map.put("Tehran", 3.5);
        map.put("New Delhi",5.5);
        map.put("Beijing",8.0);
        map.put("Canberra",10.0);

        //Форматер
        SimpleDateFormat formater = new SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.US);
        GregorianCalendar LondonDate;
        Date d = new Date();

        //Дата
        try {
            d = formater.parse(dateA);
        }catch(ParseException e){
            e.printStackTrace();
        }
        System.out.println(d.toString());

        LondonDate = new GregorianCalendar();
        LondonDate.set(Calendar.YEAR, d.getYear() + 1900);
        LondonDate.set(Calendar.MONTH, d.getMonth());
        LondonDate.set(Calendar.DAY_OF_MONTH, d.getDate());
        LondonDate.set(Calendar.HOUR_OF_DAY, d.getHours());
        LondonDate.set(Calendar.MINUTE, d.getMinutes());

        //Часы минуты города 1
        int AHour = (int)map.get(cityA).doubleValue();
        double AMinute = (map.get(cityA).doubleValue() - (int)map.get(cityA).doubleValue());

        LondonDate.add(Calendar.HOUR_OF_DAY, -(AHour));
        LondonDate.add(Calendar.MINUTE, -(int)(60 * AMinute));

        //Часы минуты города 2
        int BHour = (int)map.get(cityB).doubleValue();
        double BMinute = (map.get(cityB).doubleValue() - (int)map.get(cityB).doubleValue());

        LondonDate.add(Calendar.HOUR_OF_DAY, BHour);
        LondonDate.add(Calendar.MINUTE, (int)(60 * BMinute));


        formater = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.US);

        return formater.format(LondonDate.getTime());


    }

    public static boolean isNew(int num) {
        if (num<0) return false;
        int i = (int)Math.ceil(Math.log10(num)); //Длинна числа
        int[] array = new int[i];
        while (num>0){
            array[i-1] = num%10;
            num=num/10;
            i-=1;
        }
        for (int a=0;a<array.length-1;a++){
            //Проверка строго восходящей последовательностью
            if(array[a]>array[a+1]&&array[a+1]!=0) return false;
        }
        return true;
    }

    public static String spiderVsFly(final String spider, final String fly){

        char sr = spider.charAt(0), sl = spider.charAt(1), fr = fly.charAt(0), fl = fly.charAt(1);
        char midRing = Math.abs(sr - fr) <= 2 || Math.abs(sr - fr) >= 6 ? (char)Math.min(sl,fl) : '0';
        String answer = ""+sr+sl+"-";
        while (sl > midRing) answer += (--sl == '0' ? "A0-" : ""+ sr + sl + "-");

        while (sl <= fl && midRing != '0') {
            if (sr == fr) break;
            if (6 <= Math.abs(sr -fr)) {
                if (sr > fr) { sr++; if (sr == 'I') sr = 'A';
                }else{ sr--; if (sr == '@') sr = 'H';}
            }
            else{
                if (sr < fr) sr++; else sr--;
            }
            answer += "" + sr + sl + "-";
        }

        while (sl++ < fl) answer += "" + fr + sl + "-";
        return answer.substring(0,answer.length()-1);
    }

}
