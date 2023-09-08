package tasks.task6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PossessedBands {
    public static ArrayList<Ghost> allGhosts;
    public static ArrayList<String> questions;

    public static void initializeAllGhosts(int n) {
        allGhosts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            allGhosts.add(new Ghost(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ghosts = scanner.nextInt();
        int questions = scanner.nextInt();
        scanner.nextLine();

        PossessedBands.questions = new ArrayList<>();
        for (int i = 0; i < questions; i++) {
            PossessedBands.questions.add(scanner.nextLine());
        }

        initializeAllGhosts(ghosts);

        processQuestions();
    }

    private static void processQuestions() {
        for (String question : questions) {
            String[] arr = question.split(" ");

            switch (arr[0]) {
                case "1" -> {
                    Ghost ghost1 = allGhosts.get(Integer.parseInt(arr[1]) - 1);
                    Ghost ghost2 = allGhosts.get(Integer.parseInt(arr[2]) - 1);
                    ghost1.addBandMember(ghost2);
                }
                case "2" -> {
                    Ghost ghost1 = allGhosts.get(Integer.parseInt(arr[1]) - 1);
                    Ghost ghost2 = allGhosts.get(Integer.parseInt(arr[2]) - 1);
                    System.out.println(ghost1.checkIfInSameBand(ghost2));
                }
                case "3" -> System.out.println(
                        allGhosts.get(Integer.parseInt(arr[1]) - 1)
                                .getAmountOfBands());
            }
        }
    }
}

class Ghost {
    private final int serialNumber;
    private int bandsTookPartIn;
    private LinkedList<Ghost> band;

    public Ghost(int serialNumber) {
        this.serialNumber = serialNumber;
        this.bandsTookPartIn = 1;

        band = new LinkedList<>();
        band.add(this);
    }

    public int getAmountOfBands() {
        return bandsTookPartIn;
    }

    private void incrementBandsNumber() {
        bandsTookPartIn++;
    }

    public void addBandMember(Ghost otherGost) {
        if (!band.contains(otherGost)) {
            if (band.size() < otherGost.band.size()) {
                otherGost.band.add(this);

                band = otherGost.band;
            } else {
                band.add(otherGost);

                otherGost.band = band;
            }
            for (Ghost ghost:
                    band) {
                ghost.incrementBandsNumber();
            }
        }
    }

    public String checkIfInSameBand(Ghost otherGhost) {
        return band.contains(otherGhost) ? "YES" : "NO";
    }
}

