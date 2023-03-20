static string Determination_ofDay(int day, int month, int year)
{

    int first_day = 1, first_month = 1, first_year = 2015;
    int total_days = 0;

    if (month == 1)
        total_days += 0;
    else if (month == 2)
        total_days += 31;

    if (year % 4 == 0)
    {
        if (month == 3)
            total_days += 60;
        else if (month == 4)
            total_days += 91;
        else if (month == 5)
            total_days += 121;
        else if (month == 6)
            total_days += 152;
        else if (month == 7)
            total_days += 182;
        else if (month == 8)
            total_days += 213;
        else if (month == 9)
            total_days += 244;
        else if (month == 10)
            total_days += 274;
        else if (month == 11)
            total_days += 305;
        else if (month == 12)
            total_days += 335;
    }

    else if (year % 4 != 0)
    {
        if (month == 3)
            total_days += 59;
        else if (month == 4)
            total_days += 90;
        else if (month == 5)
            total_days += 120;
        else if (month == 6)
            total_days += 151;
        else if (month == 7)
            total_days += 181;
        else if (month == 8)
            total_days += 212;
        else if (month == 9)
            total_days += 243;
        else if (month == 10)
            total_days += 273;
        else if (month == 11)
            total_days += 304;
        else if (month == 12)
            total_days += 334;
    }

    total_days += (day - first_day);

    while (first_year != year)
    {
        if (first_year % 4 == 0)
            total_days += 366;
        else
            total_days += 365;

        first_year++;
    }


    string return_day;
    if (total_days % 7 == 0)
        return_day = "Thursday";
    else if (total_days % 7 == 1)
        return_day = "Friday";
    else if (total_days % 7 == 2)
        return_day = "Saturday";
    else if (total_days % 7 == 3)
        return_day = "Sunday";
    else if (total_days % 7 == 4)
        return_day = "Monday";
    else if (total_days % 7 == 5)
        return_day = "Tuesday";
    else
        return_day = "Wednesday";

    return return_day;
}
static void Calendar(int year1, int year2, int month1, int month2, int day1, int day2, int n)
{
    int temp_year1, temp_year2, temp_month1, temp_month2, temp_day1, temp_day2;
    if (year1 > year2)
    {
        temp_day1 = day2;
        temp_day2 = day1;
        temp_month1 = month2;
        temp_month2 = month1;
        temp_year1 = year2;
        temp_year2 = year1;
    }

    else if (year1 == year2)
    {

        if (month1 > month2)
        {
            temp_year1 = year2;
            temp_year2 = year1;
            temp_day1 = day2;
            temp_day2 = day1;
            temp_month1 = month2;
            temp_month2 = month1;
        }

        else if (month1 == month2)
        {

            if (day1 > day2)
            {
                temp_year1 = year2;
                temp_year2 = year1;
                temp_month1 = month2;
                temp_month2 = month1;
                temp_day1 = day2;
                temp_day2 = day1;
            }
            else
            {
                temp_year1 = year1;
                temp_year2 = year2;
                temp_month1 = month1;
                temp_month2 = month2;
                temp_day1 = day1;
                temp_day2 = day2;
            }
        }

        else
        {
            temp_year1 = year1;
            temp_year2 = year2;
            temp_month1 = month1;
            temp_month2 = month2;
            temp_day1 = day1;
            temp_day2 = day2;
        }
    }

    else
    {
        temp_day1 = day1;
        temp_day2 = day2;
        temp_month1 = month1;
        temp_month2 = month2;
        temp_year1 = year1;
        temp_year2 = year2;
    }

    int count = 0;
    bool winter_control = false;
    bool spring_control = false;
    bool summer_control = false;
    bool autumn_control = false;

    while (!(temp_year1 == temp_year2 && temp_month1 == temp_month2 && temp_day1 + n > temp_day2))
    {

        if ((temp_month1 == 1 || temp_month1 == 3 || temp_month1 == 5 || temp_month1 == 7 ||
            temp_month1 == 8 || temp_month1 == 10 || temp_month1 == 12))
        {

            if (temp_day1 + n > 31 && temp_month1 == 12)
            {
                temp_day1 = (temp_day1 + count * n) % 31;
                temp_month1 = 1;
                temp_year1++;
            }

            else if (temp_day1 + n > 31)
            {
                temp_day1 = (temp_day1 + count * n) % 31;
                temp_month1++;
            }

            else
                temp_day1 += count * n;

            if ((temp_month1 == 12 || temp_month1 == 1 || temp_month1 == 2) && winter_control == false)
            {
                autumn_control = false;
                winter_control = true;
                Console.WriteLine("\nWinter");
            }

            else if ((temp_month1 == 3 || temp_month1 == 4 || temp_month1 == 5) && spring_control == false)
            {
                winter_control = false;
                spring_control = true;
                Console.WriteLine("\nSpring");
            }

            else if ((temp_month1 == 6 || temp_month1 == 7 || temp_month1 == 8) && summer_control == false)
            {
                spring_control = false;
                summer_control = true;
                Console.WriteLine("\nSummer");
            }

            else if ((temp_month1 == 9 || temp_month1 == 10 || temp_month1 == 11) && autumn_control == false)
            {
                summer_control = false;
                autumn_control = true;
                Console.WriteLine("\nAutumn");
            }

            Console.WriteLine(temp_day1 + " " + Month_string_convert(temp_month1) + " " + temp_year1 + " " + Determination_ofDay(temp_day1, temp_month1, temp_year1));
            count = 1;
        }

        else if ((temp_month1 == 4 || temp_month1 == 6 || temp_month1 == 9 || temp_month1 == 11))
        {
            if (temp_day1 + n > 30)
            {
                temp_day1 = (temp_day1 + count * n) % 30;
                temp_month1++;
            }

            else
                temp_day1 += count * n; ;

            if ((temp_month1 == 12 || temp_month1 == 1 || temp_month1 == 2) && winter_control == false)
            {
                autumn_control = false;
                winter_control = true;
                Console.WriteLine("\nWinter");
            }

            else if ((temp_month1 == 3 || temp_month1 == 4 || temp_month1 == 5) && spring_control == false)
            {
                winter_control = false;
                spring_control = true;
                Console.WriteLine("\nSpring");
            }

            else if ((temp_month1 == 6 || temp_month1 == 7 || temp_month1 == 8) && summer_control == false)
            {
                spring_control = false;
                summer_control = true;
                Console.WriteLine("\nSummer");
            }

            else if ((temp_month1 == 9 || temp_month1 == 10 || temp_month1 == 11) && autumn_control == false)
            {
                summer_control = false;
                autumn_control = true;
                Console.WriteLine("\nAutumn");
            }

            Console.WriteLine(temp_day1 + " " + Month_string_convert(temp_month1) + " " + temp_year1 + " " + Determination_ofDay(temp_day1, temp_month1, temp_year1));
            count = 1;
        }

        else if (temp_month1 == 2)
        {
            if (temp_year1 % 4 == 0)
            {

                if (temp_day1 + n > 29)
                {
                    temp_day1 = (temp_day1 + count * n) % 29;
                    temp_month1++;
                }
                else
                    temp_day1 += count * n; ;
            }

            else
            {
                if (temp_day1 + n > 28)
                {
                    temp_day1 = (temp_day1 + count * n) % 28;
                    temp_month1++;
                }
                else
                    temp_day1 += count * n; ;
            }

            if ((temp_month1 == 12 || temp_month1 == 1 || temp_month1 == 2) && winter_control == false)
            {
                autumn_control = false;
                winter_control = true;
                Console.WriteLine("\nWinter");
            }

            else if ((temp_month1 == 3 || temp_month1 == 4 || temp_month1 == 5) && spring_control == false)
            {
                winter_control = false;
                spring_control = true;
                Console.WriteLine("\nSpring");
            }

            else if ((temp_month1 == 6 || temp_month1 == 7 || temp_month1 == 8) && summer_control == false)
            {
                spring_control = false;
                summer_control = true;
                Console.WriteLine("\nSummer");
            }

            else if ((temp_month1 == 9 || temp_month1 == 10 || temp_month1 == 11) && autumn_control == false)
            {
                summer_control = false;
                autumn_control = true;
                Console.WriteLine("\nAutumn");
            }

            Console.WriteLine(temp_day1 + " " + Month_string_convert(temp_month1) + " " + temp_year1 + " " + Determination_ofDay(temp_day1, temp_month1, temp_year1));
            count = 1;
        }
    }
}
static int Month_int_convert(String month)
{
    int month_int;
    switch (month)
    {
        case "january":
            month_int = 1; break;
        case "february":
            month_int = 2; break;
        case "march":
            month_int = 3; break;
        case "april":
            month_int = 4; break;
        case "may":
            month_int = 5; break;
        case "june":
            month_int = 6; break;
        case "july":
            month_int = 7; break;
        case "august":
            month_int = 8; break;
        case "september":
            month_int = 9; break;
        case "october":
            month_int = 10; break;
        case "november":
            month_int = 11; break;
        case "december":
            month_int = 12; break;
        default:
            month_int = -1; break;
    }
    return month_int;
}

static string Month_string_convert(int month)
{
    string month_string;
    switch (month)
    {
        case 1:
            month_string = " January"; break;
        case 2:
            month_string = " February"; break;
        case 3:
            month_string = " March"; break;
        case 4:
            month_string = " April"; break;
        case 5:
            month_string = " May"; break;
        case 6:
            month_string = " June"; break;
        case 7:
            month_string = " July"; break;
        case 8:
            month_string = " August"; break;
        case 9:
            month_string = " September"; break;
        case 10:
            month_string = " October"; break;
        case 11:
            month_string = " November"; break;
        case 12:
            month_string = " December"; break;
        default:
            month_string = "Invalid month"; break;
    }
    return month_string;
}

static bool Date_controller(int day, int month, int year)
{
    bool flag = false;
    bool day_flag = false;

    if (year % 4 != 0 && (month == 2 || month == -1) && (day > 28 || day < 1))
        day_flag = true;

    else if (year % 4 == 0 && (month == 2 || month == -1) && (day > 29 || day < 1))
        day_flag = true;

    else if ((month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12 || month == -1) && (day > 31 || day < 1))
        day_flag = true;

    else if ((month == 4 || month == 6 || month == 9 || month == 11 || month == -1) && (day > 30 || day < 1))
        day_flag = true;

    if (day_flag == true)
    {
        flag = true;
        Console.WriteLine("Day is Wrong!");
    }

    if (month == -1)
    {
        flag = true;
        Console.WriteLine("Month is Wrong!");
    }

    if (year < 2015)
    {
        flag = true;
        Console.WriteLine("Year is Wrong!");
    }
    return flag;
}

bool control = true;
int day_1 = 1, month_1_int = 1, year_1 = 2015, day_2 = 1, month_2_int = 1, year_2 = 2015, n = 0;

while (control)
{
    Console.WriteLine("D1: ");
    day_1 = Convert.ToInt32(Console.ReadLine());

    Console.WriteLine("M1: ");
    string month_1 = Console.ReadLine();
    month_1 = month_1.ToLower();
    month_1_int = Month_int_convert(month_1); ;

    Console.WriteLine("Y1: ");
    year_1 = Convert.ToInt32(Console.ReadLine());

    control = Date_controller(day_1, month_1_int, year_1);
    if (control == true) continue;

    Console.WriteLine("D2: ");
    day_2 = Convert.ToInt32(Console.ReadLine());

    Console.WriteLine("M2: ");
    string month_2 = Console.ReadLine();
    month_2 = month_2.ToLower();
    month_2_int = Month_int_convert(month_2); ;

    Console.WriteLine("Y2: ");
    year_2 = Convert.ToInt32(Console.ReadLine());

    control = Date_controller(day_2, month_2_int, year_2);

    Console.WriteLine("N: ");
    n = Convert.ToInt32(Console.ReadLine());

    if (n < 1)
    {
        Console.WriteLine("N must be bigger than 0!\n");
        control = true;
    }
}

if (control == false)
    Calendar(year_1, year_2, month_1_int, month_2_int, day_1, day_2, n);

Console.ReadLine();
