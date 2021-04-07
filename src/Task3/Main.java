package Task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Task3.Task3.*;

public class Main {
    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        int point;

        while (true){
            System.out.println("Практические задачи: Блок 3" + "\n");
            System.out.println("Методы третьего блока:");
            System.out.println("1) Округление населения городов до ближайшего миллиона");
            System.out.println("2) Нахождение сторон в прямом треугольнике");
            System.out.println("3) Камень,ножницы,бумага");
            System.out.println("4) Война чисел");
            System.out.println("5) Обратный регистр букв");
            System.out.println("6) InatorInator");
            System.out.println("7) Вставка кирпича");
            System.out.println("8) Расход топлива");
            System.out.println("9) Среднее значение чисел");
            System.out.println("10) Четность числа и суммы его цифр");
            System.out.println("0) Выход");
            point = Integer.parseInt(vvod.nextLine());

            switch (point){
                case 1:
                    Map<String, Integer> citypop = new HashMap<>();
                    System.out.println("Введите название города и население: ");
                    while (true) {
                        String cp = vvod.nextLine();
                        if (cp.equals("")) break;
                        int popul = Integer.parseInt(cp.substring(cp.lastIndexOf(" ") + 1));
                        String city = cp.substring(0, cp.lastIndexOf(" "));
                        citypop.put(city, popul);
                    }
                    if (citypop.isEmpty()) return;
                    millionsRounding(citypop);
                    break;
                case 2:
                    System.out.println("Введите самую короткую сторону треугольника: ");
                    int size = Integer.parseInt(vvod.nextLine());
                    double [] massize = otherSides(size);
                    System.out.println("Стороны треугольника: " + massize[0] + ", "+ massize[1] + "\n");
                    break;
                case 3:
                    System.out.println("Введите ходы игроков: ");
                    String strturn = vvod.nextLine();
                    String[] turn = strturn.split(" ");
                    System.out.println("Результат игры: " + rps(turn) + "\n");
                    break;
                case 4:
                    System.out.println("Введите числа через пробел: ");
                    String strnum = vvod.nextLine();
                    String[] numbers = strnum.split(" ");
                    int [] intnum = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
                    System.out.println("Разница между суммой четных и нечетных: " + warOfNumbers(intnum) + "\n");
                    break;
                case 5:
                    System.out.println("Введите строку: ");
                    String words = vvod.nextLine();
                    System.out.println("Строка с обратными регистрами: " + reverseCase(words) + "\n");
                    break;
                case 6:
                    System.out.println("Введите строку: ");
                    String str = vvod.nextLine();
                    System.out.println("Измененная строка: " + inatorInator(str) + "\n");
                    break;
                case 7:
                    System.out.println("Введите через пробел высоту, ширину и глубину крипича и ширину с высотой отверстия: ");
                    String strsizes = vvod.nextLine();
                    String[] sizes = strsizes.split(" ");
                    int [] intsize = Arrays.stream(sizes).mapToInt(Integer::parseInt).toArray();
                    System.out.println("Поместится ли кирпич: " + doesBrickFit(intsize[0], intsize[1],intsize[2],intsize[3],intsize[4]) + "\n");
                    break;
                case 8:
                    System.out.println("Введите кол-во топлива: ");
                    double fuel = Double.parseDouble(vvod.nextLine());
                    System.out.println("Введите расход литров топлива на 100 км: ");
                    double consumption = Double.parseDouble(vvod.nextLine());
                    System.out.println("Введите кол-во пассажиров: ");
                    int passengers = Integer.parseInt(vvod.nextLine());
                    System.out.println("Введите наличие кондиционера: ");
                    boolean conditioning = Boolean.parseBoolean(vvod.nextLine());
                    System.out.println("Автомобиль проедет: " + totalDistance(fuel,consumption,passengers,conditioning) + "\n");
                    break;
                case 9:
                    System.out.println("Введите числа через пробел: ");
                    String strmas = vvod.nextLine();
                    String[] mas = strmas.split(" ");
                    int [] intmas = Arrays.stream(mas).mapToInt(Integer::parseInt).toArray();
                    System.out.println("Среднее значение чисел: " + mean(intmas) + "\n");
                    break;
                case 10:
                    System.out.println("Введите число: ");
                    int numbr = Integer.parseInt(vvod.nextLine());
                    System.out.println("Четно ли число и сумма его цифр: " + parityAnalysis(numbr) + "\n");
                    break;
                case 0:
                    return;
            }
        }
    }
}
