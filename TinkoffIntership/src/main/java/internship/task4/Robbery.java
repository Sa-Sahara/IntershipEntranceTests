package internship.task4;

import java.util.*;

public class Robbery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = scanner.nextLong();
        int amount = scanner.nextInt();
        ArrayList<Long> notes = new ArrayList<>();
        long halfSum = 0;

        for (int i = 0; i < amount; i++) {
            long tmp = scanner.nextLong();
            halfSum += tmp;
            notes.add(tmp);
            notes.add(tmp);
        }
        Collections.sort(notes);

        if (notes.get(0) > sum / 2 || halfSum < sum / 2 + sum % 2) {
            System.out.println(-1);
        } else {
            List<Long> combination = new ArrayList<>();

            if (findCombination(0, sum, notes, combination)){
                System.out.println(combination.size());
                for (long l :
                        combination) {
                    System.out.print(l + " ");
                }
            } else {
                System.out.println(-1);
            }
        }
    }

    private static boolean findCombination(int index,
                                           long target,
                                           List<Long> notes,
                                           List<Long> combination) {
        if (target == 0) {
            return true;
        }

        for (int i = index; i < notes.size(); i++) {
            long num = notes.get(i);
            if (num <= target) {
                combination.add(num);

                if (findCombination(i + 1, target - num, notes, combination)) {
                    return true;
                }

                combination.remove(combination.size() - 1);
            }
        }

        return false;
    }
}