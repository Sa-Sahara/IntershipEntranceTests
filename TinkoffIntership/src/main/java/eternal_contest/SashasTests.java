package eternal_contest;

import java.util.Scanner;

//Во время разработки некоторой задачи Саша решил сгенерировать несколько новых тестов.
// Каждый тест Саши должен представлять собой натуральное число, не меньшее l и не большее
//r. Кроме того, натуральное число в тесте обязательно должно состоять из одинаковых цифр.
//Например, число
//999 подходит под это требование, а число
//123 — нет. Какое максимальное число различных тестов сможет создать Саша?

public class SashasTests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = 0;
        long indicator = 1;
        long start = scanner.nextLong();
        long end = scanner.nextLong();
        if (end < start) {
            System.out.println(0);
        } else {
            while (start / indicator >= 10) {
                indicator = indicator * 10 + 1;
            }

            while (indicator <= end) {
                for (int i = 1; i <= 9; i++) {
                    if (indicator * i <= end
                            && indicator * i >= start) {
                        test++;
                    }
                }
                indicator = indicator * 10 + 1;
            }
        }
        System.out.println(test);
    }
}
