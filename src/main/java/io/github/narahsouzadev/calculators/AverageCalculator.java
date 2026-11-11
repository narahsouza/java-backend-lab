package io.github.narahsouzadev.calculators;
import java.util.Scanner;

public class AverageCalculator {
    public static void run(Scanner scanner) {
        System.out.println("Average Calculator");

        while (true) {
            System.out.println("\nWhat do you want to calculate?");
            System.out.println("1 - Arithmetic Mean");
            System.out.println("2 - Weighted Average");
            System.out.println("Enter the option number or '0' to return.");

            // Select operation
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid command, try again.");
                scanner.next(); // Consumes the invalid token to prevent an infinite loop
                continue;
            }

            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("Returning to main menu...");
                return;
            }

            switch (input) {
                case 1 -> {
                    System.out.println("\nHow many values do you want to calculate the average of?");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input, please try again.");
                        scanner.next(); // Consumes the invalid token to prevent an infinite loop
                        continue;
                    }

                    int valuesQuantity = scanner.nextInt();

                    if (valuesQuantity < 2) {
                        System.out.println("The quantity must be greater than one.");
                        continue;
                    }

                    double valuesSum = 0.0;

                    boolean isCalculationValid = true;

                    for (int i = 1; i <= valuesQuantity; i++) {
                        System.out.println("Enter the value " + i + ": ");

                        if (scanner.hasNextDouble()) {
                            double nextValue = scanner.nextDouble();
                            valuesSum += nextValue;
                        } else {
                            scanner.next(); // Clears the buffer
                            System.out.println("Invalid input, please try again.");
                            isCalculationValid = false; // Indicates that the calculation has been canceled/is invalid.
                            break;
                        }
                    }
                    // Only calculates and displays the average if isCalculationValid = true.
                    if (isCalculationValid) {
                        double average = valuesSum / valuesQuantity;
                        System.out.println("Average: " + average);
                    }
                }
                case 2 -> {
                    int valueNumber = 1;
                    double weightedSum = 0.0;
                    double weightsSum = 0.0;
                    boolean running = true;
                    while (running) {
                        System.out.println("\nEnter the value " + valueNumber);

                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input, please try again.");
                            scanner.next(); // Consumes the invalid token to prevent an infinite loop
                            continue;
                        }

                        double nextValue = scanner.nextDouble();

                        System.out.println("What is the weight of this value?");

                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input, please try again.");
                            scanner.next(); // Consumes the invalid token to prevent an infinite loop
                            continue;
                        }

                        double weight = scanner.nextDouble();

                        double weightedValue = nextValue * weight;

                        weightedSum += weightedValue;
                        weightsSum += weight;

                        System.out.println("Is there any other value?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        System.out.println("Enter the option number or '0' to return.");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input, please try again.");
                            scanner.next(); // Consumes the invalid token to prevent an infinite loop
                            continue;
                        }

                        int option = scanner.nextInt();

                        if (option == 0) {
                            System.out.println("Returning to main menu...");
                            return;
                        }

                        switch (option) {
                            case 1 -> {
                                valueNumber += 1;
                                continue;
                            }
                            case 2 -> {
                                double average = weightedSum / weightsSum;
                                System.out.println(average);
                                running = false;
                            }
                        }
                    }
                }
                default -> System.out.println("\nInvalid option, try again.");
            }
        }
    }
}
