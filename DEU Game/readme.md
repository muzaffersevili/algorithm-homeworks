# DEU Game

C# program for a simple DEU game. \
There are three arrays (A1, A2, and A3) with 15 in size. Initially, they are empty.\
There are two players: player1 and player2.\
\
The aim of the game is to make the "D-E-U" sequence (straight or reverse) among connected squares (horizontally or vertically or diagonally).\
\
The game turns alternate between players after each move. At each turn of the game, the program randomly inserts one of the three leters “D”, “E” or “U” to any array for a player. In other words, the program determines both the letter and target array randomly. \
\
At the begging of the game, each player has a score of 120. At each turn, the score of the player decreases by 5 points. \
\
\
The game is over
- if a player succeeds in creating a ”DEU” pattern (the winner is the player who made the first “DEU”)
or
- if all arrays are filled up and there is no any “DEU”. (the game is a draw (tie))

The program must display all steps until the game is over.

![image](https://user-images.githubusercontent.com/73431932/226404501-83ad7333-25d4-4191-8dee-94a5ce11de05.png)
![image](https://user-images.githubusercontent.com/73431932/226404608-196dd570-1a0c-4d86-83d7-69de6b92de0a.png)
