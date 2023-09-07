package tasks.task2;

import java.util.Scanner;

public class SheriffLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int inputLength = str.length();
        int uniqueLetters = "sherif".length();

        if (inputLength < uniqueLetters) {
            System.out.println(0);
        } else {
            int[] letters = new int[uniqueLetters];
            for (int i = 0; i < inputLength; i++) {
                char current = str.charAt(i);
                switch (current) {
                    case 's' -> ++letters[0];
                    case 'h' -> ++letters[1];
                    case 'e' -> ++letters[2];
                    case 'r' -> ++letters[3];
                    case 'i' -> ++letters[4];
                    case 'f' -> ++letters[5];
                }
            }

            int wordNumber = letters[0];
            for (int i = 1; i < uniqueLetters; i++) {
                if (i == 5) {
                    wordNumber = Math.min(wordNumber, letters[i] / 2);
                } else {
                    wordNumber = Math.min(wordNumber, letters[i]);
                }

            }
            scanner.close();
            System.out.println(wordNumber);
        }
    }
}