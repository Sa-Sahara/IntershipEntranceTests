package eternal_contest;

//Кате надо передать n разных договоров коллегам. Все на разных этажах, а между этажами можно перемещаться только
// по лестничным пролетам. Прохождение каждого пролета занимает ровно 1 минуту.
//Сейчас Катя на парковочном этаже, планирует свой маршрут. Коллег можно посетить в любом порядке, но один из них покинет офис через
//t минут. С парковочного этажа лестницы нет — только лифт, на котором можно подняться на любой этаж.
//В итоге план Кати следующий:
//Подняться на лифте на произвольный этаж. Считается, что лифт поднимается на любой этаж за 0 минут.
//Передать всем коллегам договоры, перемещаясь между этажами по лестнице. Считается, что договоры на этаже передаются мгновенно.
//В первые t минут передать договор тому коллеге, который планирует уйти.
//Пройти минимальное количество лестничных пролетов.

import java.util.Scanner;

public class Steps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stuff = scanner.nextInt();
        int t = scanner.nextInt();
        int[] floors = new int[stuff];

        for (int i = 0; i < stuff; i++) {
            floors[i] = scanner.nextInt();
        }

        int tIndex = scanner.nextInt();

        if (floors[tIndex - 1] - floors[0] <= t || tIndex == stuff) {
            System.out.println(floors[stuff - 1] - floors[0]);
        } else {
            int result = Math.min(
                    floors[tIndex - 1] - floors[0] * 2 + floors[stuff - 1],
                    floors[stuff - 1] * 2 - floors[tIndex - 1] - floors[0]);
            System.out.println(result);
        }
    }
}
