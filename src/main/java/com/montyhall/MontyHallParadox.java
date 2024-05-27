package com.montyhall;

import java.util.HashMap;
import java.util.Random;

public class MontyHallParadox {

    private final HashMap<Boolean, Integer> results = new HashMap<>();

    public MontyHallParadox() {
        results.put(true, 0);
        results.put(false, 0);
    }

    public void simulateGame(int numberOfGames) {
        Random random = new Random();
        for (int i = 0; i < numberOfGames; i++) {
            int winningDoor = random.nextInt(3) + 1;
            int playerChoice = random.nextInt(3) + 1;
            boolean playerSwitches = random.nextBoolean();

            if (playerSwitches) {
                if (playerChoice != winningDoor) {
                    results.put(true, results.get(true) + 1);
                }
            } else {
                if (playerChoice == winningDoor) {
                    results.put(false, results.get(false) + 1);
                }
            }
        }
    }

    public void printStatistics() {
        System.out.println("Количество выигрышей после изменения выбора: " + results.get(true));
        System.out.println("Количество выигрышей с неизмененным выбором: " + results.get(false));
    }

    public static void main(String[] args) {
        MontyHallParadox game = new MontyHallParadox();
        game.simulateGame(1000);
        game.printStatistics();
    }
}
