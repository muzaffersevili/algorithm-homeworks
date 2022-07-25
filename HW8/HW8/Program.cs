static void Print_Array(char[] A1, char[] A2, char[] A3)
{
    Console.Write("A1 ");
    for (int i = 0; i < A1.Length; i++)
    {
        if (A1[i] != 'D' && A1[i] != 'E' && A1[i] != 'U')
            break;
        Console.Write(A1[i] + " ");
    }

    Console.Write("\nA2 ");
    for (int i = 0; i < A2.Length; i++)
    {
        if (A2[i] != 'D' && A2[i] != 'E' && A2[i] != 'U')
            break;
        Console.Write(A2[i] + " ");
    }

    Console.Write("\nA3 ");
    for (int i = 0; i < A3.Length; i++)
    {
        if (A3[i] != 'D' && A3[i] != 'E' && A3[i] != 'U')
            break;
        Console.Write(A3[i] + " ");
    }
}

//Determining the random letter
static char Letter_determination(int random)
{
    char letter = 'x';
    switch (random)
    {
        case 1:
            letter = 'D'; break;
        case 2:
            letter = 'E'; break;
        case 3:
            letter = 'U'; break;
    }
    return letter;
}

//Placing new letter to randomly chosen array
static void Place_new_letter(char letter, char[] A)
{
    for (int i = 0; i < A.Length; i++)
        if (A[i] != 'D' && A[i] != 'E' && A[i] != 'U')
        {
            A[i] = letter; break;
        }
}

//Controlling if randomly chosen array is full
//If randomly chosen array is full, method rechoose the array
static void Array_size_control(int choose_array, char[] A1, char[] A2, char[] A3, int choose_letter)
{
    Random rand = new Random();

    if (choose_array == 1)
    {
        if (A1[14] != 'D' && A1[14] != 'E' && A1[14] != 'U')
            Place_new_letter(Letter_determination(choose_letter), A1);
        else
        {
            choose_array = rand.Next(1, 3);
            if (choose_array == 1)
            {
                if (A2[14] != 'D' && A2[14] != 'E' && A2[14] != 'U')
                    Place_new_letter(Letter_determination(choose_letter), A2);
                else
                    Place_new_letter(Letter_determination(choose_letter), A3);
            }

            else
            {
                if (A3[14] != 'D' && A3[14] != 'E' && A3[14] != 'U')
                    Place_new_letter(Letter_determination(choose_letter), A3);
                else
                    Place_new_letter(Letter_determination(choose_letter), A2);
            }
        }
    }

    else if (choose_array == 2)
    {
        if (A2[14] != 'D' && A2[14] != 'E' && A2[14] != 'U')
            Place_new_letter(Letter_determination(choose_letter), A2);
        else
        {
            choose_array = rand.Next(1, 3);
            if (choose_array == 1)
            {
                if (A1[14] != 'D' && A1[14] != 'E' && A1[14] != 'U')
                    Place_new_letter(Letter_determination(choose_letter), A1);
                else
                    Place_new_letter(Letter_determination(choose_letter), A3);
            }

            else
            {
                if (A3[14] != 'D' && A3[14] != 'E' && A3[14] != 'U')
                    Place_new_letter(Letter_determination(choose_letter), A3);
                else
                    Place_new_letter(Letter_determination(choose_letter), A1);
            }
        }
    }

    else if (choose_array == 3)
    {
        if (A3[14] != 'D' && A3[14] != 'E' && A3[14] != 'U')
            Place_new_letter(Letter_determination(choose_letter), A3);
        else
        {
            choose_array = rand.Next(1, 3);
            if (choose_array == 1)
            {
                if (A1[14] != 'D' && A1[14] != 'E' && A1[14] != 'U')
                    Place_new_letter(Letter_determination(choose_letter), A1);
                else
                    Place_new_letter(Letter_determination(choose_letter), A2);
            }

            else
            {
                if (A2[14] != 'D' && A2[14] != 'E' && A2[14] != 'U')
                    Place_new_letter(Letter_determination(choose_letter), A2);
                else
                    Place_new_letter(Letter_determination(choose_letter), A1);
            }
        }
    }


}


char[] A1 = new char[15];
char[] A2 = new char[15];
char[] A3 = new char[15];

Random rand = new Random();
int choose_array;
int choose_letter;

string[] names = { "Derya", "Elife", "Fatih", "Ali", "Azra", "Sibel", "Cem", "Nazan", "Mehmet", "Nil", "Can", "Tarkan" };
int[] scores = { 100, 100, 95, 90, 85, 80, 80, 70, 55, 50, 30, 30 };

string[] temp_names = new string[12];
int[] temp_scores = new int[12];

int player1_score = 120;
int player2_score = 120;

string winner_name = "";
int winner_score = 0;

bool flag = true;
int count = 0;

while (flag)
{
    choose_array = rand.Next(1, 4);
    choose_letter = rand.Next(1, 4);

    //Player1's Turn
    if (count % 2 == 0)
    {
        Array_size_control(choose_array, A1, A2, A3, choose_letter);
        player1_score -= 5;

        Console.WriteLine("\n\nPlayer1:        P1-" + player1_score + " P2-" + player2_score);
        Print_Array(A1, A2, A3);
    }

    //Player2's Turn
    else
    {
        Array_size_control(choose_array, A1, A2, A3, choose_letter);
        player2_score -= 5;

        Console.WriteLine("\n\nPlayer2:        P1-" + player1_score + " P2-" + player2_score);
        Print_Array(A1, A2, A3);
    }

    //Controlling of DEU subsequences
    for (int i = 0; i < A1.Length; i++)
    {

        if (i <= A1.Length - 3 && A1[i] == 'D' && A1[i + 1] == 'E' && A1[i + 2] == 'U')//A1: D E U
        {
            flag = false; break;
        }

        else if (i <= A1.Length - 3 && A2[i] == 'D' && A2[i + 1] == 'E' && A2[i + 2] == 'U')//A2: D E U
        {
            flag = false; break;
        }

        else if (i <= A1.Length - 3 && A3[i] == 'D' && A3[i + 1] == 'E' && A3[i + 2] == 'U')//A3: D E U
        {
            flag = false; break;
        }

        else if (i >= 2 && A1[i] == 'D' && A1[i - 1] == 'E' && A1[i - 2] == 'U')//A1: U E D
        {
            flag = false; break;
        }

        else if (i >= 2 && A2[i] == 'D' && A2[i - 1] == 'E' && A2[i - 2] == 'U')//A2: U E D
        {
            flag = false; break;
        }

        else if (i >= 2 && A3[i] == 'D' && A3[i - 1] == 'E' && A3[i - 2] == 'U')//A3: U E D
        {
            flag = false; break;
        }

        else if (i <= A1.Length - 3 && A1[i] == 'D' && A2[i + 1] == 'E' && A3[i + 2] == 'U')//A1: D
        {                                                                                   //A2:   E
            flag = false; break;                                                            //A3:     U
        }


        else if (i <= A1.Length - 3 && A3[i] == 'D' && A2[i + 1] == 'E' && A1[i + 2] == 'U')//A1:     U
        {                                                                                   //A2:   E
            flag = false; break;                                                            //A3: D
        }


        else if (i >= 2 && A3[i] == 'D' && A2[i - 1] == 'E' && A1[i - 2] == 'U')//A1: U
        {                                                                       //A2:   E
            flag = false; break;                                                //A3:     D
        }


        else if (i >= 2 && A1[i] == 'D' && A2[i - 1] == 'E' && A3[i - 2] == 'U')//A1:     D
        {                                                                       //A2:   E
            flag = false; break;                                                //A3: U
        }


        else if (A1[i] == 'D' && A2[i] == 'E' && A3[i] == 'U')//A1: D
        {                                                     //A2: E
            flag = false; break;                              //A3: U
        }


        else if (A3[i] == 'D' && A2[i] == 'E' && A1[i] == 'U')//A1: U
        {                                                     //A2: E
            flag = false; break;                              //A3: D
        }

    }

    //Controlling end of the game with any winner
    if (flag == false)
    {
        if (count % 2 == 0)
        {
            winner_name = "Player1";
            winner_score = player1_score;
            Console.WriteLine("\n\nWinner: Player1");
        }

        else
        {
            winner_name = "Player2";
            winner_score = player2_score;
            Console.WriteLine("\n\nWinner: Player2");
        }

    }

    //Controlling if the game ended with a tie
    if ((A1[14] == 'D' || A1[14] == 'E' || A1[14] == 'U') && (A2[14] == 'D' || A2[14] == 'E' || A2[14] == 'U') &&
        (A3[14] == 'D' || A3[14] == 'E' || A3[14] == 'U'))
    {
        Console.WriteLine("\n\nTie");
        break;
    }
    count++;
}

int highscore_place = 0;

//Controlling if player's score is bigger than the players in the high score table
for (int i = 0; i < scores.Length; i++)
{
    if (scores[i] < winner_score)
    {
        temp_scores[i] = scores[i];
        temp_names[i] = names[i];
    }
    else
        highscore_place = i + 1;
}

//Adding player to high score table
if (highscore_place <= 11)
{
    scores[highscore_place] = winner_score;
    names[highscore_place] = winner_name;
}

//Re-adding scores which is smaller than player's score
if (highscore_place <= 10)
{
    highscore_place++;
    for (int j = highscore_place; j < scores.Length; j++)
    {
        scores[j] = temp_scores[j - 1];
        names[j] = temp_names[j - 1];
    }
}

//Printing High Score Table
Console.WriteLine("\nName" + "\t\t" + "Score");
for (int i = 0; i < scores.Length; i++)
    Console.WriteLine(names[i] + "\t\t" + scores[i]);


Console.ReadLine();