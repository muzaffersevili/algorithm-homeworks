using System;

namespace _2019510069_muzaffer_sevili
{
    class Program
    {
        static void Main(string[] args)
        {
            double number_x;  //variable of value of x
            do
            {
                Console.WriteLine("Please enter a number between 0-25");    //Get variable x from user
                number_x = Convert.ToInt32(Console.ReadLine());
            } while (number_x < 0 || number_x > 25);                        //Checking that 0<=x<=25


            char operator_name;                                          //variable of operator's name(sigma)
            Console.WriteLine("Please enter an operator (/ or *)");      //Get variable operator name (sigma) from user
            operator_name = Convert.ToChar(Console.ReadLine());

            double sumK_terms = 0;      //Sum of terms variable
            double numerator_pow;   //variable written for the power of x in the numerator
            double kthTerm;             //variable of K. term


            for (int k = 0; k <= 29; k++)   //k is our terms name       /* This loop our main loop */
            {

                double sign = -1;   //variable of sign between terms

                if (k % 2 == 0)     //Conditional statements with modulo division for determining the sign of every term
                {
                    sign *= sign;
                }
                else
                {
                    sign = -1;
                }

                double factorial = 1; // variable written to calculate the factorial in the numerator

                for (int i = 1; i <= 2 * k + 4; i++) //loop to calculate the factorial
                {
                    factorial *= i;
                }


                double floor_denominator = 2 * k + 2;   // variable written to floor in the denominator
                int denominator_pow = k + 2;            // variable written to calculate power of floors in the denominator
                double denominator_resultK;             // The variable written to calculate the result of the k. term in the denominator
                double denominator_sumK = 0;            // The variable written to calculate sum of the terms in the denominator

                for (int x = 2 * k + 2; x <= 2 * floor_denominator; x += 2)  //main loop to calculate denominator result
                {
                    denominator_resultK = 1; //the purpose of this line is to reset the result after each element in the denominator to calculate the other element(s) correctly. 
                   
                    for (int y = 1; y <= denominator_pow; y++)  //loop to calculate elements in the denominator
                    {
                        denominator_resultK *= x;
                    }
                    denominator_sumK += denominator_resultK;    //sum of the denominator elements for each terms

                }

                numerator_pow = 1;                         //variable written for the power of x in the numerator

                for (int n = 1; n <= 3 * k + 2; n++)   //loop to calculate exponential number (pow of the x) in the numerator for k. term
                {
                    numerator_pow *= number_x;
                }
                numerator_pow *= (4 * k + 3);
        
                if (numerator_pow < factorial)    // conditional statements written to find the minimum of the exponential number and factorial 
                {
                    kthTerm = sign * numerator_pow;  
                }
                else
                {
                    kthTerm = sign * factorial;
                }
                
                

                double constant = 5 * k + 2;     //Variable written for the constant in the numerator

                switch (operator_name)           //switch-case structure to control operator
                {
                    case '*':
                        kthTerm *= constant / denominator_sumK; break;

                    case '/':
                        kthTerm = (kthTerm / (constant) / denominator_sumK); break;

                    default:
                        Console.WriteLine("You had entered wrong operator."); break;
                }

                sumK_terms += kthTerm;      //sum of the terms

            }
            Console.WriteLine("Answer is:" + (sumK_terms));     //Show message
            Console.ReadLine();     //function for the console not to turn off automatically
        }
    }
}

