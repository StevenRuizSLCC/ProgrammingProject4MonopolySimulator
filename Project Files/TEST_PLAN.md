Monopoly Simulation – Test Plan
Objective

Verify that the Monopoly simulator correctly implements board movement, card 
effects, doubles, jail behavior, and landing probability calculations.

Test Cases
Test	Description	Expected Result
T01	Board initialization	Exactly 40 squares
T02	Dice generation	Each die produces values from 1 to 6
T03	Board wrapping	Position 39 wraps correctly to position 0
T04	First doubles	Player receives another roll
T05	Second doubles	Player receives another roll
T06	Third doubles	Player is sent directly to Jail
T07	Chance card	Correct card effect is applied
T08	Community Chest card	Correct card effect is applied
T09	Go to Jail	Player moves to Jail
T10	Strategy A	Player exits Jail immediately
T11	Strategy B	Player attempts doubles for up to three turns
T12	Get Out of Jail Free	Card is tracked and reused correctly
T13	Deck reshuffling	Discarded cards are reshuffled when required
T14	Landing counters	Final landing square is counted
T15	Percentage calculation	Percentage equals count divided by turns times 100
T16	Batch simulation	All 80 datasets are generated
Data Validation

For every dataset:

There must be exactly 40 square records.
Landing counts must be nonnegative.
The sum of landing counts should equal the number of recorded landing events.
Percentages must match the corresponding counts.
All square indexes must be valid.
Regression Testing

After changes to movement, cards, or jail logic, rerun the relevant tests to 
verify that previously working functionality remains correct.

Verification Responsibility

Josh Painter – Verification Lead.