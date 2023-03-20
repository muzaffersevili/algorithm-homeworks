//Array for letters
string[] letters = new string[4] { "A", "B", "C", "D" };

Random rnd = new Random();
bool control = true;


while (control)
{

    //Array for Slotmachine
    string[] slotmachine = new string[9];

    //Loop for Red Letters
    for (int i = 0; i < slotmachine.Length / 3; i++)
    {
        slotmachine[i] = letters[rnd.Next(0, 4)] + "R";
    }

    //Loop for Green Letters
    for (int i = slotmachine.Length / 3; i < 2 * (slotmachine.Length) / 3; i++)
    {
        slotmachine[i] = letters[rnd.Next(0, 4)] + "G";
    }

    //Loop for Blue Letters
    for (int i = (2 * slotmachine.Length) / 3; i < slotmachine.Length; i++)
    {
        slotmachine[i] = letters[rnd.Next(0, 4)] + "B";
    }

    ////Loop for mixing colored letters
    for (int j = 0; j < 100; j++)
    {
        int random = rnd.Next(0, 9);
        string temp = slotmachine[random];
        int random2 = rnd.Next(0, 9);
        slotmachine[random] = slotmachine[random2];
        slotmachine[random2] = temp;
    }

    //Showing Colored Letters
    Display(slotmachine, 0, 9, 0);
    Console.WriteLine();
    Console.WriteLine();

    int score = 0;

    //Loop to show the scores user have got
    for (int i = 0; i < slotmachine.Length - 2; i++)
    {
        //Controlling that three consecutive slots are the same letter
        if (slotmachine[i][0] == slotmachine[i + 1][0] && slotmachine[i][0] == slotmachine[i + 2][0])
        {
            //Same color
            if (slotmachine[i][1] == slotmachine[i + 1][1] && slotmachine[i][1] == slotmachine[i + 2][1])
            {
                score += 33;
                Display(slotmachine, i, i + 3, 33);

            }

            //Different colors
            else if ((slotmachine[i][1] != slotmachine[i + 1][1]) && (slotmachine[i + 1][1] != slotmachine[i + 2][1]) && (slotmachine[i][1] != slotmachine[i + 2][1]))
            {
                score += 28;
                Display(slotmachine, i, i + 3, 28);
            }

            //Not all the same or different color
            else
            {
                score += 22;
                Display(slotmachine, i, i + 3, 22);
            }
        }

        //Controlling that three consecutive slots are the consecutive letters
        /*start*/
        else if (((Convert.ToInt32(slotmachine[i][0]) - (Convert.ToInt32(slotmachine[i + 1][0])) == -1) && (Convert.ToInt32(slotmachine[i + 1][0]) - Convert.ToInt32(slotmachine[i + 2][0])) == -1) ||
   ((Convert.ToInt32(slotmachine[i][0]) - (Convert.ToInt32(slotmachine[i + 1][0])) == -2) && (Convert.ToInt32(slotmachine[i + 1][0]) - Convert.ToInt32(slotmachine[i + 2][0])) == +1) ||
   ((Convert.ToInt32(slotmachine[i][0]) - (Convert.ToInt32(slotmachine[i + 1][0])) == +1) && (Convert.ToInt32(slotmachine[i + 1][0]) - Convert.ToInt32(slotmachine[i + 2][0])) == +1) ||
   ((Convert.ToInt32(slotmachine[i][0]) - (Convert.ToInt32(slotmachine[i + 1][0])) == +2) && (Convert.ToInt32(slotmachine[i + 1][0]) - Convert.ToInt32(slotmachine[i + 2][0])) == -1) ||
   ((Convert.ToInt32(slotmachine[i][0]) - (Convert.ToInt32(slotmachine[i + 1][0])) == +1) && (Convert.ToInt32(slotmachine[i + 1][0]) - Convert.ToInt32(slotmachine[i + 2][0])) == -2) ||
   ((Convert.ToInt32(slotmachine[i][0]) - (Convert.ToInt32(slotmachine[i + 1][0])) == -1) && (Convert.ToInt32(slotmachine[i + 1][0]) - Convert.ToInt32(slotmachine[i + 2][0])) == +2))
        /*stop*/
        {
            //Same color
            if (slotmachine[i][1] == slotmachine[i + 1][1] && slotmachine[i + 1][1] == slotmachine[i + 2][1])
            {
                score += 18;
                Display(slotmachine, i, i + 3, 18);
            }


            //Different colors
            else if ((slotmachine[i][1] != slotmachine[i + 1][1]) && (slotmachine[i + 1][1] != slotmachine[i + 2][1]) && (slotmachine[i][1] != slotmachine[i + 2][1]))
            {
                score += 16;
                Display(slotmachine, i, i + 3, 16);
            }

            //Not all the same or different color
            else
            {
                score += 14;
                Display(slotmachine, i, i + 3, 14);
            }

        }

        //Controlling that not all the same letter and not consecutive
        else
        {
            //Same Color
            if ((slotmachine[i][1] == slotmachine[i + 1][1] && slotmachine[i + 1][1] == slotmachine[i + 2][1]) &&
                slotmachine[i][0] != slotmachine[i + 1][0] && slotmachine[i + 1][0] != slotmachine[i + 2][0] && slotmachine[i][0] != slotmachine[i + 2][0])
            {
                score += 12;
                Display(slotmachine, i, i + 3, 12);
            }

            //Different Colors
            else if (slotmachine[i][1] != slotmachine[i + 1][1] && slotmachine[i + 1][1] != slotmachine[i + 2][1] && slotmachine[i][1] != slotmachine[i + 2][1])
            {
                score += 10;
                Display(slotmachine, i, i + 3, 10);
            }

            else score += 0;
        }

    }

    Console.WriteLine("\nYou get " + score + " points !!!\n");

    Console.WriteLine("Please enter your name: ");
    string name = Console.ReadLine();

    //Moving old scores
    File.Move("D:\\HighScoreTable.txt", "D:\\HighScoreTable_old.txt");

    StreamReader ChangingFile = new StreamReader("D:\\HighScoreTable_old.txt");

    StreamWriter ChangedFile = new StreamWriter(File.OpenWrite("D:\\HighScoreTable.txt"));

    string line = ChangingFile.ReadLine();


    //Controlling if the line is null or not
    while (line != null)
    {

        ChangedFile.WriteLine(line);      //Moving new scores to HighScoreTable.txt
        line = ChangingFile.ReadLine();

    }


    string username_score = name + ";" + score;

    ChangedFile.WriteLine(username_score);  //Writing user name and score to HighScoreTable.txt

    ChangedFile.Close();
    ChangingFile.Close();

    File.Delete("D:\\HighScoreTable_old.txt");



    //Moving old scores
    File.Move("D:\\HighScoreTable.txt", "D:\\HighScoreTable_old.txt");

    StreamReader ChangingFile2 = new StreamReader("D:\\HighScoreTable_old.txt");

    StreamWriter ChangedFile2 = new StreamWriter(File.OpenWrite("D:\\HighScoreTable.txt"));

    string line2 = ChangingFile2.ReadLine();

    int score_number = 11;

    string[,] old_names_scores = new string[score_number, 2];
    int a = 0;

    //Moving user names and scores (elements) to "old_names_scores" array
    while (a < score_number)
    {
        string[] items = line2.Split(';');
        old_names_scores[a, 0] = items[0];
        old_names_scores[a, 1] = items[1];

        line2 = ChangingFile2.ReadLine();

        a++;
    }

    //Loops for sorting scores
    for (int i = 0; i < old_names_scores.GetLength(0) - 1; i++)
    {

        for (int j = i + 1; j > 0; j--)
        {
            //Sorting scores
            if (Convert.ToInt32(old_names_scores[j - 1, 1]) < Convert.ToInt32(old_names_scores[j, 1]))
            {

                int temp = Convert.ToInt32(old_names_scores[j - 1, 1]);  //temp variable for keeping scores
                string str_temp = old_names_scores[j - 1, 0];            //str_temp variable for keeping names
                old_names_scores[j - 1, 1] = old_names_scores[j, 1];
                old_names_scores[j - 1, 0] = old_names_scores[j, 0];
                old_names_scores[j, 1] = Convert.ToString(temp);
                old_names_scores[j, 0] = str_temp;

            }

        }
    }

    Console.WriteLine("\n\nHigh Score Table");
    for (int k = 0; k < old_names_scores.GetLength(0) - 1; k++)
    {
        ChangedFile2.WriteLine(old_names_scores[k, 0] + ";" + old_names_scores[k, 1]);
        Console.WriteLine(old_names_scores[k, 0] + ";" + old_names_scores[k, 1]);
    }

    ChangingFile2.Close();
    ChangedFile2.Close();

    File.Delete("D:\\HighScoreTable_old.txt");

    //Replay
    Console.WriteLine("\nDo you want to play again? (Y or N)");
    char play_or_not = Convert.ToChar(Console.ReadLine());
    if (play_or_not == 'Y')
    {
        control = true;
    }
    else if (play_or_not == 'N')
    {
        control = false;
    }
    else
    {
        control = false;
    }
    Console.WriteLine();
}


//Display Function
static void Display(string[] arr, int start, int stop, int score)
{
    if (score == 0)
        Console.Write("Randomly generated array:  ");

    //Loop for coloring the letters according to the rules
    for (int i = start; i < stop; i++)
    {

        char color = arr[i][1];

        //Red
        if (color == 'R')
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.Write(arr[i][0] + " ");
        }

        //Green
        else if (color == 'G')
        {
            Console.ForegroundColor = ConsoleColor.Green;
            Console.Write(arr[i][0] + " ");
        }

        //Blue
        else if (color == 'B')
        {
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(arr[i][0] + " ");
        }

        Console.ResetColor();
    }

    if (score != 0)
    {
        Console.Write(score + " points\n");
    }
    Console.WriteLine();
}