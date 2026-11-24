/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Board to edit this template
 */
package com.mycompany.programmingproject4;

/* 
 Team: The Best Programmers
 Members: Yakez Owens, Josh Painter, Saul Prieto, Steven Ruiz
 Course: CS 2430 - Section 501
 Project: Programming Project 4 - Monopoly Simulator
*/ 

public class Board {

    public static final int SIZE = 40;

    public static final String[] SQUARES = {
        "GO",
        "Mediterranean Avenue",
        "Community Chest",
        "Baltic Avenue",
        "Income Tax",
        "Reading Railroad",
        "Oriental Avenue",
        "Chance",
        "Vermont Avenue",
        "Connecticut Avenue",
        "Jail",
        "St. Charles Place",
        "Electric Company",
        "States Avenue",
        "Virginia Avenue",
        "Pennsylvania Railroad",
        "St. James Place",
        "Community Chest",
        "Tennessee Avenue",
        "New York Avenue",
        "Free Parking",
        "Kentucky Avenue",
        "Chance",
        "Indiana Avenue",
        "Illinois Avenue",
        "B&O Railroad",
        "Atlantic Avenue",
        "Ventnor Avenue",
        "Water Works",
        "Marvin Gardens",
        "Go To Jail",
        "Pacific Avenue",
        "North Carolina Avenue",
        "Community Chest",
        "Pennsylvania Avenue",
        "Short Line Railroad",
        "Chance",
        "Park Place",
        "Luxury Tax",
        "Boardwalk"
    };

    public static void showBoard() {

        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " - " + SQUARES[i]);
        }
    }
}
