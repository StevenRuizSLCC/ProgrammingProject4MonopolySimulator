Monopoly Simulation – CS 2430

Project Information

Team Name: The Best Programmers
Course: CS 2430 – Section 501
Project: Programming Project 4 – Monopoly Simulation
Semester: Fall 2026
Programming Language: Java
Start Date: November 4, 2026
Due Date: December 6, 2026

Team Members

Yakez Owens
Josh Painter
Saul Prieto
Steven Ruiz

Project Description

- This project implements a single-player Monopoly movement simulator based on 
the 2018 U.S. classic Monopoly rules.

- The purpose of the simulation is to estimate the probability of landing on 
each of the 40 Monopoly board squares and determine whether different 
jail-exit strategies affect the landing distribution.

- The program simulates dice rolls, player movement, Chance and Community 
Chest cards, doubles, and jail behavior.

Simulation Strategies

Strategy A – Immediate Exit

Use a Get Out of Jail Free card immediately if available.
Otherwise, leave jail immediately on the next turn using the assignment's assumed $50 payment rule.

Strategy B – Try for Doubles

Use a Get Out of Jail Free card immediately if available.
Otherwise, attempt to roll doubles for up to three turns.
If doubles are not rolled, leave jail on the fourth turn using the assumed $50 payment rule.

Simulation Requirements

Each strategy runs 10 independent simulations for the following turn counts:

1,000 turns
10,000 turns
100,000 turns
1,000,000 turns
A total of 80 datasets are generated.

Each dataset records:

Board square index and name.
Number of landings.
Landing percentage.
Simulation strategy.
Run number.
Number of turns.
Technologies
Java
GitHub
Java standard libraries
CSV and text files for simulation output
Project Structure
src/ – Java source code.
data/ – Simulation results and generated datasets.
docs/ – Project planning, design documentation, pseudocode, and testing documentation.
README.md – Project overview and execution instructions.
CONTRIBUTIONS.md – Team responsibilities.

How to Run

Install a compatible Java Development Kit (JDK).
Clone or download this repository.
Open the project in an IDE such as IntelliJ IDEA, Eclipse, or VS Code.
Compile the Java source files.
Run the main simulation class.
Use the following commands if the project is configured for command-line compilation:


bash
javac -d out src/*.java
java -cp out Main
Replace Main with the actual main class name if different. Adjust the compilation command if your source files use Java packages.

Expected Output
The program should generate landing counts and percentages for all 40 board squares under both jail strategies.

Results should be saved in CSV or text format so they can be analyzed and included in the final project report.

Documentation
Additional project documentation is available in the docs/ directory.

Academic Purpose
This project demonstrates programming, simulation, probability, testing, data 
analysis, teamwork, and technical documentation skills developed in CS 2430.