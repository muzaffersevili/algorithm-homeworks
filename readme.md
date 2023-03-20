# Lotto Game

Two people play this game with:
- cards
- bags
Each card consists of 7 numbers. The numbers are ranged from 1 to 17.
At the beginning of the game, each card (queue) should be randomly filled with distinct values. So, the numbers in one queue should be different from each other.

Example: ![image](https://user-images.githubusercontent.com/73431932/226395175-ae827c69-e751-4025-a7fb-b29480d06e7d.png)

There is a bag1 (queue) that initially includes all integers from 1 to 17. The program selects a number from this bag randomly and removes it from bag1. Each player deletes that number from his/her queue. Selected numbers are added to another bag (queue), named bag2, so the next number is selected from the remaining numbers.

Example: ![image](https://user-images.githubusercontent.com/73431932/226395601-c43aa607-5a9d-4c9c-9272-f9f0b4ecc588.png)

When a player deletes 4 numbers, he/she gets the award $10. (“birinci çinko”)
When a player deletes all numbers from his/her queue, he/she wins the game and gets $30.
If both players delete their last numbers at the same time, the game is over without any winner (tie) and they share the money.
The program must display all steps until the game is over.
At the end of the game, the winner(s) should be displayed.
The money that each player gets should also be printed.

![image](https://user-images.githubusercontent.com/73431932/226396181-296e20a2-8987-4a51-83b7-e707c8b9e04c.png)
![image](https://user-images.githubusercontent.com/73431932/226396533-fcf59ce8-8a23-47bd-bc46-c0b57ecb8208.png)
