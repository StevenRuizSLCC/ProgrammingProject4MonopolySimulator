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

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

    private ArrayList<String> cards;
    private ArrayList<String> discard;

    public CardDeck(String[] startingCards) {

        cards = new ArrayList<>();
        discard = new ArrayList<>();

        for (String card : startingCards) {
            cards.add(card);
        }

        Collections.shuffle(cards);
    }

    // Draw one card from the deck.
    public String drawCard() {

        // Reshuffle if the deck is empty.
        if (cards.isEmpty()) {

            cards.addAll(discard);
            discard.clear();

            Collections.shuffle(cards);
        }

        return cards.remove(0);
    }

    // Put a used card in the discard pile.
    public void discardCard(String card) {

        if (!card.equals("GET_OUT")) {
            discard.add(card);
        }
    }

    // Return a Get Out of Jail Free card.
    public void returnCard(String card) {

        cards.add(card);
    }
}

