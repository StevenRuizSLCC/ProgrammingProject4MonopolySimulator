/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programmingproject4;

/* 
 Team: The Best Programmers
 Members: Yakez Owens, Josh Painter, Saul Prieto, Steven Ruiz
 Course: CS 2430 - Section 501
 Project: Programming Project 4 - Monopoly Simulator
*/ 

public class ProgrammingProject4 {

    public static void main(String[] args) {

        // Required simulation sizes.
        int[] turnCounts = {
            1000,
            10000,
            100000,
            1000000
        };

        // Two required Jail strategies.
        String[] strategies = {"A", "B"};

        System.out.println("MONOPOLY SIMULATION");
        System.out.println("The Best Programmers");
        System.out.println("------------------------------");

        // Run both strategies.
        for (String strategy : strategies) {

            System.out.println(
                    "\nStarting Strategy " + strategy
            );

            // Run all four turn counts.
            for (int turns : turnCounts) {

                // Add results from the ten independent runs.
                int[] totalCounts = new int[Board.SIZE];

                for (int run = 1; run <= 10; run++) {

                    System.out.println(
                            "Strategy " + strategy
                            + " | Turns: " + turns
                            + " | Run: " + run
                    );

                    // A new Game creates fresh shuffled decks.
                    Game game = new Game();

                    int[] counts = game.simulate(
                            turns,
                            strategy
                    );

                    // Save this independent dataset.
                    try {

                        CSVWriter.saveResults(
                                counts,
                                turns,
                                strategy,
                                run
                        );

                    } catch (Exception e) {

                        System.out.println(
                                "Error saving CSV: "
                                + e.getMessage()
                        );
                    }

                    // Add counts for the combined summary.
                    for (int i = 0; i < Board.SIZE; i++) {
                        totalCounts[i] += counts[i];
                    }
                }

                // Show the top five squares.
                System.out.println(
                        "\nSUMMARY: Strategy " + strategy
                        + " - " + turns + " turns"
                );

                CSVWriter.showTopFive(totalCounts);
            }
        }

        System.out.println(
                "\nALL SIMULATIONS COMPLETED!"
        );

        System.out.println(
                "Check the data folder for your CSV files."
        );
    }
}
