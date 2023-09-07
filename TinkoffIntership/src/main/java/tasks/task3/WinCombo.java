package tasks.task3;

import java.util.Arrays;
import java.util.Scanner;

public class WinCombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        long[] cowboyCards = new long[limit];
        long[] winCombo = new long[limit];
        boolean printYes;
        boolean printNo;

        for (int i = 0; i < limit; i++) {
            cowboyCards[i] = scanner.nextLong();
        }
        for (int i = 0; i < limit; i++) {
            winCombo[i] = scanner.nextLong();
        }
        scanner.close();

        int start = findStart(cowboyCards, winCombo);
        int finish = limit;

        printYes = start == finish;

        if (printYes) {
            System.out.println("YES");
        } else {
            finish = findFinish(cowboyCards, winCombo);
            printNo = !isIncreasing(start, finish, winCombo);

            if (printNo) {
                System.out.println("NO");
            } else {
                Arrays.sort(cowboyCards, start, finish);
                printNo = !Arrays.equals(cowboyCards, start, finish, winCombo, start, finish);
                if (printNo) System.out.println("NO");
                else System.out.println("YES");
            }
        }
    }

    private static int findStart(long[] cowboyCards, long[] winCombo) {
        int start = 0;

        for (int i = 1; i < cowboyCards.length; i++) {
            if (cowboyCards[i] != winCombo[i]) break;
            else start = i + 1;
        }
        return start;
    }

    private static int findFinish(long[] cowboyCards, long[] winCombo) {
        int finish = cowboyCards.length;

        for (int i = cowboyCards.length - 1; i >= 0; i--) {
            if (cowboyCards[i] != winCombo[i]) break;
            else finish = i;
        }
        return finish;
    }

    private static boolean isIncreasing(int start, int finish, long[] winCombo) {
        for (int i = start + 1; i < finish; i++) {
            if (winCombo[i] < winCombo[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
