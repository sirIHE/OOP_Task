package Task6;

import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        int[] array = {1, 2, 3, 9, 4, 5, 15, 3};
        System.out.println(twoProduct(array, 45));
        System.out.println(isExact(6));
        System.out.println(isExact(24));
        System.out.println(fractions("0.(6)"));
        System.out.println(pilishString("33314444"));
        System.out.println(generateNonconsecutive(1));
        System.out.println(generateNonconsecutive(2));
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        int[] array2 = {1, 2, 3, 4, 5};
        System.out.println(sumsUp(array2));
    }

    public static String hiddenAnagram(String string, String substring) {
        string = string.toLowerCase().replaceAll("[^a-z]", "");
        substring = substring.toLowerCase().replaceAll(" ", "");
        for (int i = 0; i < string.length() - substring.length() + 1; i++) {
            if (substring.indexOf(string.charAt(i)) > -1) {
                String subT = string.substring(i, i + substring.length());
                if (isAnagram(subT, substring)) {
                    return subT;
                }
            }
        }
        return "noutfond";
    }

    private static Boolean isAnagram(String firstString, String secondString) {
        StringBuilder s = new StringBuilder(secondString);
        for (int i = 0; i < firstString.length(); i++) {
            int in = s.indexOf(String.valueOf(firstString.charAt(i)));
            if (in == -1) {
                return false;
            }
            s.setCharAt(in, '-');
        }
        return true;
    }

    public static String[] collect(String string, int n) {
        if (string.length() < n) return new String[0];
        String[] w = collect(string.substring(n), n);
        String[] v = new String[w.length + 1];
        v[0] = string.substring(0, n);
        for (int i = 0; i < w.length; i++) v[i + 1] = w[i];
        Arrays.sort(v);
        return v;
    }

    public static String nicoCipher(String string, String key) {
        int stringLength = string.length();
        int keyLength = key.length();
        int r = (stringLength - stringLength % keyLength) / keyLength;
        if (stringLength % keyLength != 0) r++;
        for (int i = stringLength; i < r * keyLength; i++)
            string += " ";
        char[][][] v = new char[r][keyLength][2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < keyLength; j++) {
                v[i][j][0] = string.charAt(i * keyLength + j);
                v[i][j][1] = key.charAt(j);
            }
            Arrays.sort(v[i], (a, b) -> (int) a[1] - (int) b[1]);
        }
        String eMessage = "";
        for (int i = 0; i < r; i++)
            for (int j = 0; j < keyLength; j++)
                eMessage += v[i][j][0];
        return eMessage;
    }

    public static int[] twoProduct(int[] array, int product) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] * array[i] == product) {
                    int[] result = new int[2];
                    result[0] = array[j];
                    result[1] = array[i];
                    return result;
                }
            }
        }
        int[] result = new int[1];
        return result;
    }

    public static int[] isExact(int n, int... f) {
        if (f.length < 2) return isExact(n, 1, 1);
        f[1] *= ++f[0];
        if (f[1] < n) {
            return isExact(n, f[0], f[1]);
        } else if (f[1] == n) {
            return new int[]{n, f[0]};
        } else {
            return new int[0];
        }
    }

    public static String pilishString(String string) {
        int[] pi = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        int i = 0;
        String str = "";
        while (i < 15 && string.length() >= pi[i]) {
            str += string.substring(0, pi[i]) + " ";
            string = string.substring(pi[i]);
            i++;
        }
        return string.isEmpty() || i == 15 ? str.trim() : str + string + String.format("%0" + (pi[i] - string.length()) + "d", 0).replace('0', string.charAt(string.length() - 1));
    }

    public static String generateNonconsecutive(int n) {
        String ans = "";
        for (int i = 0; i < Math.pow(2, n); i++) {
            String b = Integer.toBinaryString(i);
            while (b.length() < n) b = "0" + b;
            if (b.indexOf("11") < 0) ans += " " + b;
        }
        return ans.substring(1);
    }

    public static String isValid(String string) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < string.length(); i++) {
            char key = string.charAt(i);
            if (map.get(key) != null)
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        ArrayList<Integer> mapValues = new ArrayList(map.values());
        int max = (int) Collections.max(mapValues);
        int min = (int) Collections.min(mapValues);
        if (max == min)
            return "YES";
        int minСount = 0, maxСount = 0;
        for (int i = 0; i < mapValues.size(); i++) {
            if (mapValues.get(i) == max)
                maxСount++;
            else if (mapValues.get(i) == min)
                minСount++;
        }
        return (minСount == 1 || (maxСount == 1 && max == min + 1)) ? "YES" : "NO";
    }

    public static int[][] sumsUp(int[] array) {
        int[][] tempResult = new int[array.length][2];
        int resultCounter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] + array[j] == 8 && array[i] != 8 && array[j] != 8) {
                    if (array[i] < array[j]) {
                        tempResult[resultCounter][0] = array[i];
                        tempResult[resultCounter][1] = array[j];
                    } else {
                        tempResult[resultCounter][0] = array[j];
                        tempResult[resultCounter][1] = array[i];
                    }
                    resultCounter++;
                }
            }
        }
        int[][] result = new int[resultCounter][2];
        for (int i = 0; i < resultCounter; i++) {
            result[i][0] = tempResult[i][0];
            result[i][1] = tempResult[i][1];
        }
        return result;
    }

    public static String fractions(String decimal) {
        // Получаем первую часть числа
        long n1 = Long.parseLong(decimal.replaceAll("(.*)\\(.*", "$1").replace(".", ""));
        // Получаем вторую часть числа
        long n2 = Long.parseLong(decimal.replaceAll("[\\(\\)\\.]", ""));
        int exp1 = decimal.replaceAll("\\d+\\.(\\d*)\\(\\d+\\)", "$1").length();
        int exp2 = decimal.replaceAll("\\d+\\.(?=.*)", "").replaceAll("[\\(\\)]", "").length();
        // Считаем разницу между частями числа
        long num = n2 - n1;
        long div = (long) Math.pow(10, exp2) - (long) Math.pow(10, exp1);
        long gcdiv = gcd(num, div);
        num = num / gcdiv;
        div = div / gcdiv;
        return String.format("%d/%d", num, div);
    }

    private static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

}
