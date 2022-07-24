import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class testStack {

    //Stack1 to Stack2
    static void CopyStack(Stack stack1, Stack stack2, Stack tempStack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.peek());
            tempStack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        try {

            FileInputStream file = new FileInputStream("fruits.txt");
            Scanner scan = new Scanner(file, "UTF-8");

            String name = "Muzaffer";

            int size = 10;
            System.out.print("Fruit Stack: ");
            Stack fruitStack = new Stack(size);

            //Temp Stacks
            Stack tempStack1 = new Stack(20);
            Stack tempStack2 = new Stack(5);

            //board
            Stack stack1 = new Stack(5);
            Stack stack2 = new Stack(5);

            int score = 0;
            int step = 0;

            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                fruitStack.push(str);
                System.out.print(fruitStack.peek() + " ");
            }

            Random rnd = new Random();
            int number = 0;

            //Creating Stack1
            for (int i = 0; i < 5; i++) {
                number = rnd.nextInt(size);

                if (i == 1 && number > size - 2)
                    number = size - 2;
                else if (i == 2 && number > size - 3)
                    number = size - 3;
                else if (i == 3 && number > size - 4)
                    number = size - 4;
                else if (i == 4 && number > size - 5)
                    number = size - 5;

                for (int j = 0; j < number; j++)
                    tempStack1.push(fruitStack.pop());

                stack1.push(fruitStack.pop());

                while (!tempStack1.isEmpty()) {
                    fruitStack.push(tempStack1.pop());
                }
            }

            //Moving Stack1 to tempStack2 and creating Stack2
            CopyStack(stack1, stack2, tempStack2);

            System.out.print("\n\nStack1: ");

            //Moving tempStack2 to Stack1
            while (!tempStack2.isEmpty()) {
                stack1.push(tempStack2.pop());
                System.out.print(stack1.peek() + " ");
            }

            System.out.print(" 		Score=" + score);

            while (!tempStack2.isFull())
                tempStack2.push(stack2.pop());

            System.out.print("\nStack2: ");

            //Creating Stack2
            for (int i = 0; i < 5; i++) {
                number = rnd.nextInt(5);

                if (i == 1 && number > 3)
                    number = 3;
                else if (i == 2 && number > 2)
                    number = 2;
                else if (i == 3 && number > 1)
                    number = 1;
                else if (i == 4 && number > 0)
                    number = 0;

                for (int j = 0; j < number; j++)
                    tempStack1.push(tempStack2.pop());

                stack2.push(tempStack2.pop());
                System.out.print(stack2.peek() + " ");
                while (!tempStack1.isEmpty())
                    tempStack2.push(tempStack1.pop());
            }

            System.out.println();

            while (!stack1.isEmpty()) {
                int stacksize = stack1.size();
                int randNum = rnd.nextInt(stacksize) + 1;
                int randNum2 = rnd.nextInt(stacksize) + 1;
                System.out.println();

                step++;

                System.out.print("\nRandomly generated numbers: " + randNum + " " + randNum2);
                System.out.print(" 				Step=" + step);
                System.out.print("\n								Score=");

                for (int i = 0; i < stacksize - randNum; i++)
                    tempStack2.push(stack1.pop());

                for (int i = 0; i < stacksize - randNum2; i++)
                    tempStack1.push(stack2.pop());

                //Right Matching

                if (stack1.peek().equals(stack2.peek())) {
                    score += 20;
                    System.out.print(score);
                    stack1.pop();
                    stack2.pop();
                    System.out.println();
                }

                //Wrong Matching
                else {
                    score -= 1;
                    System.out.print(score);
                    System.out.println();
                }

                while (!tempStack2.isEmpty())
                    stack1.push(tempStack2.pop());

                while (!stack1.isEmpty())
                    tempStack2.push(stack1.pop());

                System.out.print("Stack1: ");
                while (!tempStack2.isEmpty()) {
                    stack1.push(tempStack2.pop());
                    System.out.print(stack1.peek() + " ");
                }

                System.out.println();
                while (!tempStack1.isEmpty())
                    stack2.push(tempStack1.pop());

                while (!stack2.isEmpty())
                    tempStack1.push(stack2.pop());

                System.out.print("Stack2: ");
                while (!tempStack1.isEmpty()) {
                    stack2.push(tempStack1.pop());
                    System.out.print(stack2.peek() + " ");
                }
            }

            System.out.println("\n\nThe game is over."); //End of the game

            FileInputStream score_file = new FileInputStream("highscoretable.txt");
            Scanner score_scan = new Scanner(score_file, "UTF-8");

            Stack highScore = new Stack(20);

            while (score_scan.hasNextLine()) {
                String scr = score_scan.nextLine();
                highScore.push(scr);
            }

            System.out.println();

            //Checking for a high score
            if (score >= Integer.parseInt((String) (highScore.peek()))) {
                while (score >= Integer.parseInt((String) (highScore.peek()))) {
                    tempStack1.push(highScore.pop());
                    tempStack1.push(highScore.pop());
                }
                highScore.push(name);
                highScore.push(Integer.toString(score));
            }

            while (!highScore.isFull())
                highScore.push(tempStack1.pop());

            while (!tempStack1.isEmpty())
                tempStack1.pop();

            while (!highScore.isEmpty())
                tempStack1.push(highScore.pop());

            //Creating high score table on the screen
            System.out.println("High score table:");
            while (!tempStack1.isEmpty()) {
                highScore.push(tempStack1.pop());
                System.out.print(highScore.peek());
                highScore.push(tempStack1.pop());
                System.out.print(" 		" + highScore.peek()+"\n");
            }

            while (!highScore.isEmpty())
                tempStack1.push(highScore.pop());

            //Writing new highscoretable.txt
            File write_file = new File("highscoretable.txt");
            PrintWriter w = new PrintWriter(write_file, "UTF-8");

            for (int i = 0; i < 20; i++)
                w.println(tempStack1.pop());

            w.close();
            scan.close();
            score_scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}