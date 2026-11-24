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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVWriter {

    // Save the simulation results into a CSV file.
    public static void saveResults(
            int[] counts,
            int turns,
            String strategy,
            int run) throws IOException {

        String folder = "data/strategy_" + strategy;

        // Create the folder if it does not exist.
        File directory = new File(folder);
        directory.mkdirs();

        String filename = folder
                + "/run_" + run
                + "_turns_" + turns + ".csv";

        PrintWriter writer = new PrintWriter(
                new FileWriter(filename));

        // CSV column names.
        writer.println("Index,Square,Count,Percentage");

        // Write all 40 board squares.
        for (int i = 0; i < Board.SIZE; i++) {

            double percentage =
                    (counts[i] * 100.0) / turns;

            writer.printf(
                    "%d,%s,%d,%.4f%%%n",
                    i,
                    Board.SQUARES[i],
                    counts[i],
                    percentage
            );
        }

        writer.close();

        System.out.println("Saved: " + filename);
    }

    // Display the five most visited squares.
    public static void showTopFive(int[] counts) {

        Integer[] indexes = new Integer[Board.SIZE];

        for (int i = 0; i < Board.SIZE; i++) {
            indexes[i] = i;
        }

        // Sort squares from highest to lowest count.
        java.util.Arrays.sort(
                indexes,
                (a, b) -> Integer.compare(counts[b], counts[a])
        );

        System.out.println("\nTOP FIVE MOST VISITED SQUARES");

        for (int i = 0; i < 5; i++) {

            int square = indexes[i];

            System.out.println(
                    (i + 1) + ". "
                    + Board.SQUARES[square]
                    + " - " + counts[square] + " visits"
            );
        }
    }
}