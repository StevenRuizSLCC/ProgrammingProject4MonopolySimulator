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

import java.util.Random;

public class Game {

    private Random random;

    private CardDeck chance;
    private CardDeck community;

    public Game() {

        random = new Random();

        // Official 16 Chance cards.
        chance = new CardDeck(new String[] {
            "GO",
            "ILLINOIS",
            "ST_CHARLES",
            "NEAREST_RAILROAD",
            "NEAREST_RAILROAD",
            "NEAREST_UTILITY",
            "READING",
            "BOARDWALK",
            "JAIL",
            "BACK_THREE",
            "GET_OUT",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE"
        });

        // Official 16 Community Chest cards.
        community = new CardDeck(new String[] {
            "GO",
            "JAIL",
            "GET_OUT",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE",
            "NO_MOVE"
        });
    }

    // Roll two six-sided dice.
    private int[] rollDice() {

        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;

        return new int[] {die1, die2};
    }

    // Find the next railroad.
    private int nextRailroad(int position) {

        int[] railroads = {5, 15, 25, 35};

        for (int railroad : railroads) {

            if (railroad > position) {
                return railroad;
            }
        }

        return 5;
    }

    // Find the next utility.
    private int nextUtility(int position) {

        if (position < 12 || position >= 28) {
            return 12;
        }

        return 28;
    }

    // Return a Get Out of Jail Free card to its original deck.
    private void useGetOutCard(Player player) {

        if (player.getGetOutDeck().equals("CHANCE")) {
            chance.returnCard("GET_OUT");
        }

        if (player.getGetOutDeck().equals("COMMUNITY")) {
            community.returnCard("GET_OUT");
        }

        player.setGetOut(false, "");
    }

    // Resolve the square where the player lands.
    private void resolveSquare(Player player) {

        int position = player.getPosition();

        // Go To Jail square.
        if (position == 30) {
            player.goToJail();
            return;
        }

        // Chance squares.
        if (position == 7 || position == 22 || position == 36) {

            String card = chance.drawCard();

            if (card.equals("GET_OUT")) {
                player.setGetOut(true, "CHANCE");
                return;
            }

            chance.discardCard(card);

            switch (card) {

                case "GO":
                    player.setPosition(0);
                    break;

                case "ILLINOIS":
                    player.setPosition(24);
                    break;

                case "ST_CHARLES":
                    player.setPosition(11);
                    break;

                case "READING":
                    player.setPosition(5);
                    break;

                case "BOARDWALK":
                    player.setPosition(39);
                    break;

                case "NEAREST_RAILROAD":
                    player.setPosition(
                        nextRailroad(position)
                    );
                    break;

                case "NEAREST_UTILITY":
                    player.setPosition(
                        nextUtility(position)
                    );
                    break;

                case "BACK_THREE":
                    player.move(-3);
                    resolveSquare(player);
                    return;

                case "JAIL":
                    player.goToJail();
                    return;

                default:
                    return;
            }

            // Resolve the destination if necessary.
            resolveSquare(player);
            return;
        }

        // Community Chest squares.
        if (position == 2 || position == 17 || position == 33) {

            String card = community.drawCard();

            if (card.equals("GET_OUT")) {
                player.setGetOut(true, "COMMUNITY");
                return;
            }

            community.discardCard(card);

            if (card.equals("GO")) {

                player.setPosition(0);
                resolveSquare(player);

            } else if (card.equals("JAIL")) {

                player.goToJail();
            }
        }
    }

    // Simulate one complete player turn.
    public void takeTurn(Player player, int[] counts, String strategy) {

        // First handle a player already in Jail.
        if (player.isInJail()) {

            if (player.hasGetOut()) {

                useGetOutCard(player);

                player.setInJail(false);
                player.setJailAttempts(0);

            } else if (strategy.equals("A")) {

                // Strategy A: pay $50 and leave immediately.
                player.setInJail(false);
                player.setJailAttempts(0);

            } else {

                // Strategy B: try to roll doubles three times.
                if (player.getJailAttempts() < 3) {

                    int[] dice = rollDice();

                    player.setJailAttempts(
                        player.getJailAttempts() + 1
                    );

                    if (dice[0] == dice[1]) {

                        player.setInJail(false);
                        player.setJailAttempts(0);

                        player.move(dice[0] + dice[1]);

                        resolveSquare(player);

                        counts[player.getPosition()]++;
                    } else {

                        // Stay in Jail after a failed attempt.
                        counts[10]++;
                    }

                    return;

                } else {

                    // Fourth turn: pay $50 and leave Jail.
                    player.setInJail(false);
                    player.setJailAttempts(0);
                }
            }
        }

        // Normal movement and doubles.
        int doubles = 0;

        while (true) {

            int[] dice = rollDice();

            if (dice[0] == dice[1]) {
                doubles++;
            } else {
                doubles = 0;
            }

            // Three consecutive doubles send the player to Jail.
            if (doubles == 3) {

                player.goToJail();

                counts[10]++;
                return;
            }

            player.move(dice[0] + dice[1]);

            resolveSquare(player);

            // Count the final landing only once per turn.
            if (player.isInJail()) {

                counts[10]++;
                return;
            }

            // Stop if the player did not roll doubles.
            if (dice[0] != dice[1]) {

                counts[player.getPosition()]++;
                return;
            }
        }
    }

    // Run a complete simulation.
    public int[] simulate(int turns, String strategy) {

        Player player = new Player();

        int[] landingCounts = new int[Board.SIZE];

        for (int i = 0; i < turns; i++) {

            takeTurn(player, landingCounts, strategy);
        }

        return landingCounts;
    }
}
