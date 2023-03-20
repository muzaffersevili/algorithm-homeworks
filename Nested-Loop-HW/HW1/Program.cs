double result = 0;
double x = -1;
while (x < 0 || x > 25)
{
    Console.WriteLine("Please enter the X:");
    x = Convert.ToInt32(Console.ReadLine());
}

Console.WriteLine("Please enter the Operator (* or /):");
char operatorr = Convert.ToChar(Console.ReadLine());


for (double i = 0; i < 30; i++)
{
    double sqr = 1;
    for (int j = 0; j < 3 * i + 2; j++)
    {
        sqr *= x;
    }

    double fact = 1;
    for (int j = 1; j <= 2 * i + 4; j++)
    {
        fact *= j;
    }

    double min = 0;
    if ((4 * i + 3) * sqr < fact)
        min = sqr;
    else
        min = fact;

    double nominator;
    if (operatorr.Equals('*'))
        nominator = min * (5 * i + 2);

    else
        nominator = min / (5 * i + 2);


    double denominator = 0;
    for(double j = i; j < (i + 1)*2; j++)
    {
        double denominator_term = 1;
        double number = (j + 1) * 2;
        for (double k = 0; k < i+2; k++)
        {
            denominator_term *= number;
        }
        denominator += denominator_term;
    }

    if (i % 2 == 0)
        result += (nominator / denominator);
    else
        result -= (nominator / denominator);
}

Console.WriteLine(result);

Console.ReadLine();
