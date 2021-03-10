package Task2;

import static Task2.Task2.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        int point;

        while (true){
            System.out.println("Практические задачи: Блок 2" + "\n");
            System.out.println("Методы второго блока:");
            System.out.println("1) Номер дома на противоположной стороне улицы");
            System.out.println("2) Замена имени и фамили местами");
            System.out.println("3) Цена после скидки");
            System.out.println("4) Разница между наибольшим и наименьшим элементами массива");
            System.out.println("5) Кол-во целых чисел с одинаковым значением");
            System.out.println("6) Строка в обратном порядке");
            System.out.println("7) Разница между наибольшей и наименьшей зарпатой из трех");
            System.out.println("8) Наличие одинакового кол-ва 'o' и  'x' в строке");
            System.out.println("9) Наличие слова 'бомба' в строке");
            System.out.println("10) Одинакова ли сумма ASCII в строках");
            System.out.println("0) Выход");
            point = Integer.parseInt(vvod.nextLine());

            switch (point){
                case 1:
                    System.out.println("Введите номер дома: ");
                    int num = Integer.parseInt(vvod.nextLine());
                    System.out.println("Введите длинну улицы: ");
                    int leg = Integer.parseInt(vvod.nextLine());
                    System.out.println("Этот дом стоит напротив дома с номером: " + oppositeHouse(num,leg) + "\n");
                    break;
                case 2:
                    System.out.println("Введите имя и фамилию: ");
                    String fio = vvod.nextLine();
                    System.out.println("Фамилия и имя: " + nameShuffle(fio) + "\n");
                    break;
                case 3:
                    System.out.println("Введите исходную цену: ");
                    int price = Integer.parseInt(vvod.nextLine());
                    System.out.println("Введите процент скидки: ");
                    double percent = Double.parseDouble(vvod.nextLine());
                    System.out.println("Цена после скидки: " + discount(price,percent) + "\n");
                    break;
                case 4:
                    System.out.println("Введите массив: ");
                    String strmas = vvod.nextLine();
                    String[] words = strmas.split(" ");
                    int [] massiv = Arrays.stream(words).mapToInt(Integer::parseInt).toArray();
                    System.out.println("Разница между максимальным и минимальным элементами: " + differenceMaxMin(massiv) + "\n");
                    break;
                case 5:
                    System.out.println("Введите первое число: ");
                    int one = Integer.parseInt(vvod.nextLine());
                    System.out.println("Введите второе число: ");
                    int two = Integer.parseInt(vvod.nextLine());
                    System.out.println("Введите третье число: ");
                    int three = Integer.parseInt(vvod.nextLine());
                    System.out.println("Количество одинаковых чисел: " + equal(one, two, three) + "\n");
                    break;
                case 6:
                    System.out.println("Введите строку: ");
                    String str = vvod.nextLine();
                    System.out.println("Строка в обратном порядке: " + reverse(str) + "\n");
                    break;
                case 7:
                    System.out.println("Введите зарплату первого программиста: ");
                    int firstprog = Integer.parseInt(vvod.nextLine());
                    System.out.println("Введите зарплату второго программиста: ");
                    int secondprog = Integer.parseInt(vvod.nextLine());
                    System.out.println("Введите зарплату третьего программиста: ");
                    int thirdprog = Integer.parseInt(vvod.nextLine());
                    System.out.println("Разница между наибольшей и набольшей зарплатой: " + programmers(firstprog,secondprog,thirdprog) + "\n");
                    break;
                case 8:
                    System.out.println("Введите строку: ");
                    String xo = vvod.nextLine();
                    System.out.println("Одинаковое ли кол-во 'х' и 'о': " + getXO(xo) + "\n");
                    break;
                case 9:
                    System.out.println("Введите строку: ");
                    String bomb = vvod.nextLine();
                    System.out.println(bomb(bomb) + "\n");
                    break;
                case 10:
                    System.out.println("Введите первую строку: ");
                    String firststr = vvod.nextLine();
                    System.out.println("Введите вторую строку: ");
                    String secondstr = vvod.nextLine();
                    System.out.println("Одинакова ли сумма ASCII строк: " + sameAscii(firststr, secondstr) + "\n");
                    break;
                case 0:
                    return;
            }
        }
    }
}