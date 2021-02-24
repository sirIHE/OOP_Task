package Task1;

import static Task1.Task1.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        int point;

        while (true){
            System.out.println("Практические задачи: Блок 1" + "\n");
            System.out.println("Методы первого блока:");
            System.out.println("1) Перевод минут в секунды");
            System.out.println("2) Подсчет очков по матча баскетболу");
            System.out.println("3) Подсчет очков по команды футболу");
            System.out.println("4) Проверка делимости на 5");
            System.out.println("5) Логический оператор && (and)");
            System.out.println("6) Подсчет покраски стен");
            System.out.println("7) Исправленный код (квадрат)");
            System.out.println("8) Прибль");
            System.out.println("9) Подсчет кадров в минуту");
            System.out.println("10) Остаток от деления");
            System.out.println("0) Выход");
            point = vvod.nextInt();

            switch (point){
                case 1:
                    System.out.println("Введите кол-во минут: ");
                    int min = vvod.nextInt();
                    System.out.println("Кол-во секунд: " + convert(min) + "\n");
                    break;
                case 2:
                    System.out.println("Введите кол-во двух очковых бросков: ");
                    int two = vvod.nextInt();
                    System.out.println("Введите кол-во трех очковых бросков: ");
                    int three = vvod.nextInt();
                    System.out.println("Кол-во очков: " + points(two,three) + "\n");
                    break;
                case 3:
                    System.out.println("Введите кол-во побед: ");
                    int victory = vvod.nextInt();
                    System.out.println("Введите кол-во ничьих: ");
                    int draw = vvod.nextInt();
                    System.out.println("Введите кол-во поражений: ");
                    int defeat = vvod.nextInt();
                    System.out.println("Кол-во очков команды: " + footballPoints(victory,draw,defeat) + "\n");
                    break;
                case 4:
                    System.out.println("Введите число: ");
                    int numeric = vvod.nextInt();
                    System.out.println("Делится ли на 5: " + divisibleByFive(numeric) + "\n");
                    break;
                case 5:
                    System.out.println("Введите значение первой логической переменной (true/false): ");
                    boolean onebul = vvod.nextBoolean();
                    System.out.println("Введите значение второй логической переменной (true/false): ");
                    boolean twobul = vvod.nextBoolean();
                    System.out.println("Результат операции: " + and(onebul,twobul) + "\n");
                    break;
                case 6:
                    System.out.println("Введите кол-во квадратных метров, которые можно нарисовать: ");
                    int n = vvod.nextInt();
                    System.out.println("Введите ширину стены в метрах: ");
                    int w = vvod.nextInt();
                    System.out.println("Введите высоту стены в метрах: ");
                    int h = vvod.nextInt();
                    System.out.println("Кол-во стен: " + howManyWalls(n,w,h) + "\n");
                    break;
                case 7:
                    System.out.println("Введите число для возведения в квадрат: ");
                    int b = vvod.nextInt();
                    System.out.println("Результат: " + squared(b) + "\n");
                    break;
                case 8:
                    System.out.println("Введите значение prob: ");
                    float prob = vvod.nextFloat();
                    System.out.println("Введите значение prize: ");
                    int prize = vvod.nextInt();
                    System.out.println("Введите значение pay: ");
                    int pay = vvod.nextInt();
                    System.out.println("Результат: " + profitableGamble(prob,prize,pay) + "\n");
                    break;
                case 9:
                    System.out.println("Введите кол-во минут: ");
                    int min2 = vvod.nextInt();
                    System.out.println("Введите кол-во FPS: ");
                    int FPS = vvod.nextInt();
                    System.out.println("Кол-во очков: " + frames(min2,FPS) + "\n");
                    break;
                case 10:
                    System.out.println("Введите число, которое делится: ");
                    int onemod = vvod.nextInt();
                    System.out.println("Введите число, на которое делится: ");
                    int twomod = vvod.nextInt();
                    System.out.println("Остаток от деления: " + mod(onemod,twomod) + "\n");
                    break;
                case 0:
                    return;
            }
        }
    }
}
