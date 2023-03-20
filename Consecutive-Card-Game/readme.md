# Consecutive Card Game

C# program for the following card game.\
Assume that there is a card array with nine slots.\
Each slot includes a letter between A and D (A, B, C, D) in one of the three colors (red, blue, and green).\
The array must contain 3 cards in red color, 3 cards in blue color, and 3 cards in green color.\
The player gets some score, depending on the letters and their colors that land along with the array.\
- If the consecutive three slots show the same letter in the same color, he/she gets 33 points i.e. (A A A) or (B B B) or (D D D)
- If the consecutive three slots show the same letter in different colors, he/she gets 28 points i.e. (A A A) or (D D D)
- If the consecutive three slots show the same letter, but not all the same or different color, he/she gets 22 points i.e. (A A A) or (D D D) 
- If the consecutive three slots show consecutive letters in the same color, he/she gets 18 points i.e. (B C D) or (D B C) or (A C B)
- If the consecutive three slots show consecutive letters in different colors, he/she gets 16 points i.e. (B C D) or (C B A) or (B D C)
- If the consecutive three slots show consecutive letters, but not all the same or different color, he/she gets 14 points i.e. (BC D) or (C B A)
- If the consecutive three slots show the same color, but not all the same letter and not consecutive, he/she gets 12 points i.e. (A B D)
- If the consecutive three slots show different colors, but not all the same letter and not consecutive, he/she gets 10 points i.e. (A A D)
- Otherwise, he/she gets 0 points

![image](https://user-images.githubusercontent.com/73431932/226387692-99674d8a-823c-41f0-a329-c1e01dbe8d30.png)
