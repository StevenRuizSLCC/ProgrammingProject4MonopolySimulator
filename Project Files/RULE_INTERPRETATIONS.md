Monopoly Rules and Implementation Decisions
1. Board Movement

The player moves clockwise around the 40-square board. Movement wraps around 
to GO after passing the final board position.

2. Doubles

Rolling doubles allows the player to take another roll during the same turn.

Rolling three consecutive doubles during one turn sends the player directly 
to Jail without completing the movement associated with the third roll.

3. Chance and Community Chest

Cards are drawn from shuffled decks. Drawn cards are placed into discard 

collections unless the card is a Get Out of Jail Free card that must be retained.

When a deck is exhausted, its discarded cards are shuffled and returned 
to circulation according to the selected implementation.

4. Get Out of Jail Free

A Get Out of Jail Free card is retained until the player uses it. Once used, 
it returns to the appropriate deck according to the implemented card-deck interpretation.

5. Strategy A

If the player has a Get Out of Jail Free card, it is used immediately. 
Otherwise, the player leaves Jail on the next turn under the assignment's assumed $50 payment rule.

6. Strategy B

If the player has a Get Out of Jail Free card, it is used immediately. 
Otherwise, the player attempts to roll doubles for up to three turns. 
If unsuccessful, the player leaves Jail on the fourth turn.

7. Landing Counters

The simulator records the player's final destination after resolving 
movement and special square effects.

Jail handling and whether remaining in Jail counts as a landing event 
must follow the documented implementation convention.

8. Simplifications

The simulator does not model property purchases, rent, money management, 
auctions, or multiple players.

These simplifications allow the project to focus on movement and empirical 
landing probabilities.

Important: These decisions describe the intended interpretation. 
The implementation and final report must be consistent with the actual Java code.