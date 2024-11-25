package org.example;


public class Main {
    public static void main(String[] args) {
        // Test Task 1
        ParenthesesCounter generator = new ParenthesesCounter();
        System.out.println("Task 1 test cases:");
        System.out.println("N=1: " + generator.counterValidCombination(1)); // Should print 1
        System.out.println("N=2: " + generator.counterValidCombination(2)); // Should print 2

        // Test Task 2
        System.out.println("\nTask 2 test case:");
        TransportationNetwork network = new TransportationNetwork();
        // Add cities
        network.addCity("gdansk");
        network.addCity("bydgoszcz");
        network.addCity("torun");
        network.addCity("warszawa");
        // Add connections
        network.addConnection(0, 1, 1); // gdansk - bydgoszcz
        network.addConnection(0, 2, 3); // gdansk - torun
        network.addConnection(1, 2, 1); // bydgoszcz - torun
        network.addConnection(1, 3, 4); // bydgoszcz - warszawa
        network.addConnection(2, 3, 1); // torun - warszawa

        System.out.println("Gdansk to Warszawa: " +
                network.findMinCost("gdansk", "warszawa")); // Should print 3
        System.out.println("Bydgoszcz to Warszawa: " +
                network.findMinCost("bydgoszcz", "warszawa")); // Should print 2

        // Test Task 3
        System.out.println("\nTask 3 result:");
        System.out.println("Sum of digits in 100!: " +
                FactorialDigitSum.calculateFactorialDigitSum(100)); // Should print 648
    }
}