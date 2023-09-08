package eternal_contest;

//У Кости есть бумажка, на которой написано n чисел. Также у него есть возможность не больше, чем
//k раз, взять любое число с бумажки, после чего закрасить одну из старых цифр,
// а на ее месте написать новую произвольную цифру.
//На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WriteNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amount = scanner.nextInt();
        int changes = scanner.nextInt();
        int[] nums = new int[amount];
        int result = 0;

        for (int i = 0; i < amount; i++) {
            nums[i] = scanner.nextInt();
        }

        ArrayList<Integer> diffs = new ArrayList<>();
        for (int i = amount - 1; i >= 0; i--) {
            if (nums[i] / 1000 > 0 && nums[i] % 1000 != 9) {
                diffs.add((9 - nums[i] / 1000) * 1000);
            }
            if (nums[i] / 100 > 0 && nums[i] % 100 != 9) {
                diffs.add((9 - nums[i] % 1000 / 100) * 100);
            }
            if (nums[i] / 10 > 0 && nums[i] % 10 != 9) {
                diffs.add((9 - nums[i] % 100 / 10) * 10);
            }
            if (nums[i] % 10 != 9) {
                diffs.add(9 - nums[i] % 10);
            }
        }
        Collections.sort(diffs, Collections.reverseOrder());

        for (int i = 0; i < changes; i++) {
            if (i >= diffs.size()) break;
            result += diffs.get(i);
        }

        System.out.println(result);
    }
}