string text, pattern;

Console.WriteLine("Please enter a text: ");
text = Console.ReadLine();

//Removing commas and dots
for (int i = 0; i < text.Length - 1; i++)
{
    if (text[i].Equals('.'))
    {
        int index = text.IndexOf('.');
        text = text.Remove(index, 1);
    }
    if (text[i].Equals(','))
    {
        int index = text.IndexOf(',');
        text = text.Remove(index, 1);
    }
}

//Removing last comma or dot
if (text.Contains('.'))
{
    int index = text.IndexOf('.');
    text = text.Remove(index);
}

if (text.Contains(','))
{
    int index = text.IndexOf(',');
    text = text.Remove(index);
}

string[] words = text.Split(' ');   //Words of the text
string[] temp_words = new string[words.Length];   //temp string array for finding distinct words

int counter = 0;
int distinct_counter = 0;

//copying distinct words to temp_words
while (counter != words.Length)
{
    if (!temp_words.Contains(words[counter]))
    {
        temp_words[distinct_counter] = words[counter];
        distinct_counter++;
    }
    counter++;
}

string[] distinct_words = new string[distinct_counter];

for (int i = 0; i < distinct_counter; i++)
    distinct_words[i] = temp_words[i];


Console.WriteLine("\nPlease enter a pattern: ");
pattern = Console.ReadLine();

bool flag;

Console.WriteLine("\n---Words---\n");

//Controlling "-"
if (pattern.Contains('-'))
{
    for (int i = 0; i < distinct_words.Length; i++)
    {
        flag = true;
        if (distinct_words[i].Length == pattern.Length)
        {
            for (int j = 0; j < pattern.Length; j++)
            {
                string pattern_letter = pattern[j].ToString().ToLower();
                if (!pattern_letter.Equals("-") && !pattern_letter.Equals(distinct_words[i][j].ToString().ToLower()))
                {
                    flag = false; break;
                }
            }
            if (flag)
            {
                Console.WriteLine(distinct_words[i]);
            }
        }
    }
}

//Controlling "*"
else if (pattern.Contains('*'))
{
    while (pattern.Contains("**"))
    {
        pattern = pattern.Replace("**", "*");
    }

    for (int i = 0; i < distinct_words.Length; i++)
    {
        flag = true;
        for (int j = 0; j < pattern.Length; j++)
        {
            string pattern_letter = pattern[j].ToString().ToLower();
            if (!pattern_letter.Equals("*") && !distinct_words[i].ToLower().Contains(pattern_letter))
            {
                flag = false; break;
            }
        }
        if (flag)
        {
            Console.WriteLine(distinct_words[i]);
        }
    }
}

Console.ReadLine();