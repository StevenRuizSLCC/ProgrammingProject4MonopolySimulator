/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Player to edit this template
 */
package com.mycompany.programmingproject4;

/* 
 Team: The Best Programmers
 Members: Yakez Owens, Josh Painter, Saul Prieto, Steven Ruiz
 Course: CS 2430 - Section 501
 Project: Programming Project 4 - Monopoly Simulator
*/ 

public class Player {

    private int position;
    private boolean inJail;
    private int jailAttempts;

    private boolean hasGetOut;
    private String getOutDeck;

    public Player() {

        position = 0;
        inJail = false;
        jailAttempts = 0;

        hasGetOut = false;
        getOutDeck = "";
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int spaces) {
        position = (position + spaces + 40) % 40;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getJailAttempts() {
        return jailAttempts;
    }

    public void setJailAttempts(int attempts) {
        jailAttempts = attempts;
    }

    public boolean hasGetOut() {
        return hasGetOut;
    }

    public void setGetOut(boolean value, String deck) {
        hasGetOut = value;
        getOutDeck = deck;
    }

    public String getGetOutDeck() {
        return getOutDeck;
    }

    public void goToJail() {

        position = 10;
        inJail = true;
        jailAttempts = 0;
    }
}
