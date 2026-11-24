Monopoly Simulation – Design Document
1. System Overview

The Monopoly simulator models the movement of a single player around a standard 
40-square Monopoly board.

The system uses random dice rolls to determine movement and resolves special 
board spaces through predefined game rules and card effects.

The simulation records the final landing position after all movement effects 
have been resolved.

2. Board Representation

The board contains 40 indexed positions, numbered from 0 through 39.

Each position stores information identifying its square name and type.

Square categories include:

GO
Properties
Railroads
Utilities
Chance
Community Chest
Jail / Just Visiting
Free Parking
Go to Jail
Luxury Tax
Income Tax
3. Player State

The player state must contain the information needed to simulate movement and 
jail behavior.

Relevant information includes:

Current board position.
Consecutive doubles count.
Jail status.
Number of jail attempts.
Get Out of Jail Free cards held.
4. Card Deck Design

Chance and Community Chest are represented as separate collections.

Each deck contains shuffled cards and maintains a discard collection.

When a card is drawn, it is removed from the active deck and placed in the discard collection, unless its rules require it to be retained.

When the active deck becomes empty, the discard collection is shuffled and reused.

Card effects can include moving to a specific square, moving backward, moving to GO, or going directly to Jail.

5. Turn Engine

Each normal turn performs the following operations:

Roll two six-sided dice.
Check whether the dice show doubles.
Update the consecutive doubles counter.
Apply the third-doubles jail rule.
Move the player around the board.
Resolve the destination square.
Resolve additional card movement when necessary.
Record the final landing position.
6. Jail Strategies
Strategy A – Immediate Exit

The player uses a Get Out of Jail Free card if available. Otherwise, the 
player leaves jail immediately on the next turn.

Strategy B – Try for Doubles

The player uses a Get Out of Jail Free card if available. Otherwise, the 
player attempts to roll doubles for up to three turns. If unsuccessful, 
the player leaves jail on the fourth turn.

7. Data Collection

The simulator maintains a landing counter for each board square.

The landing percentage is calculated using:

Landing Percentage = (Landing Count / Total Turns) × 100

Results are exported for analysis and comparison.

8. Design Goal

The design prioritizes accurate movement simulation, reproducible testing, 
clear data collection, and separation of game logic from result analysis.