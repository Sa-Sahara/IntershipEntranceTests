package tasks.task1;

import java.util.Scanner;

public class BuyGun {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long gun = scanner.nextLong();
        long budget = scanner.nextInt();
        long maxPriceGun = 0;

        for (int i = 0; i < gun; i++) {
            int current = scanner.nextInt();
            if (current > maxPriceGun && current <= budget) {
                maxPriceGun = current;
            }
        }

        scanner.close();

        System.out.println(maxPriceGun);
    }
}
