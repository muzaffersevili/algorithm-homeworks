import java.io.*;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class main {

    //Writing HighScores to File
    public static void  writeHighscore_toTxt(SingleLinkedList sll3) throws IOException {

        String data = "";

        for (int i = 1; i < 10; i++) {
            data += (sll3.findData(i) + "\n");
            data += (sll3.findPoint(i) + "\n");
        }

        data += (sll3.findData(10) + "\n");
        data += (sll3.findPoint(10));

        File score_file = new File("D:\\HighScoreTable.txt");
        score_file.delete();
        score_file.createNewFile();

        FileWriter file_writer = new FileWriter(score_file, false);
        BufferedWriter b_writer = new BufferedWriter(file_writer);
        b_writer.write(data);
        b_writer.close();
    }

    public static void main(String[] args) throws IOException {

        //Wheel
        SingleLinkedList wheel=new SingleLinkedList();

        wheel.add_NotSort(10);
        wheel.add_NotSort(20);
        wheel.add_NotSort(30);
        wheel.add_NotSort(40);
        wheel.add_NotSort(100);
        wheel.add_NotSort(200);
        wheel.add_NotSort(300);
        wheel.add_NotSort(400);
        wheel.addString_Sort("Bankrupt");
        wheel.addString_Sort("Bankrupt");

        String user_name="Muzaffer";

        //Animals SLL
        SingleLinkedList sll1= new SingleLinkedList();
        FileInputStream animals_file=new FileInputStream("animals.txt");
        Scanner scan = new Scanner(animals_file, "UTF-8");

        //Read Animals.txt
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            sll1.addString_Sort(str.toUpperCase(Locale.ROOT));
        }

        //Characters SLL
        SingleLinkedList sll2=new SingleLinkedList();
        for(int i=65;i<91;i++) {
            String letter=Character.toString((char)i);
            sll2.addString_Sort(letter);
        }

        //HighScore SLL
        SingleLinkedList sll3=new SingleLinkedList();
        FileInputStream score_file=new FileInputStream("HighScoreTable.txt");
        scan = new Scanner(score_file, "UTF-8");

        int counter=0;
        String name[]=new String[20];
        int file_score[]=new int[20];

        ////Read HighScore.txt
        while (scan.hasNextLine()) {
            String str = scan.nextLine();

            if(counter%2==0)
                name[counter]=str;
            else
                file_score[counter]=Integer.parseInt(str);
            counter++;
        }

        //Add and Sort HighScores to SLL3
        for(int i=0;i<counter;i+=2)
            sll3.addName_Score(name[i],file_score[i+1]);

        Random rand=new Random();
        int random= rand.nextInt(10)+1;
        System.out.println("Randomly generated number: "+random);

        //SLL for Selected Animal
        SingleLinkedList sll4=new SingleLinkedList();

        //Random Selecting Animal
        String animal=(String) sll1.findData(random);
        String[] animal_letters=animal.split("");

        //Adding Selected Animal Letters to SLL4
        for(int i=0;i<animal_letters.length;i++)
            sll4.add_NotSort(animal_letters[i]);

        //Hidden Letters of Animal
        SingleLinkedList sll5=new SingleLinkedList();
        for(int i=0;i<animal_letters.length;i++)
            sll5.add_NotSort("_");

        int step=1;
        int score=0;
        int animal_letter_counter=0;

        //Main Loop
        while (!sll4.equals(sll5)){

            //Checking if the selected animal is found
            if(animal_letter_counter==sll5.size()){
                System.out.print("\nWord: ");
                sll4.print();
                System.out.print("                  Step: "+ step+"                  Score: "+ score+ "                  ");
                sll2.print();
                System.out.println("\n\nYou get "+ score+" TL");

                //Checking if the score is higher than scores which in score table
                if(score>=(int)file_score[19]){
                    sll3.delete(name[18]);
                    sll3.delete(file_score[19]);
                    sll3.addName_Score(user_name,score);
                    writeHighscore_toTxt(sll3);
                }

                //Printing High Score
                System.out.println("\nHigh Score Table");
                sll3.printScoreTable();
                break;
            }

            //Printing Word - Step - Score - Alphabet - Wheel - Guess
            System.out.print("\nWord: ");
            sll5.print();
            System.out.print("                  Step: "+ step+"                  Score: "+ score+ "                  ");
            sll2.print();

            step++;

            //Spinning Wheel
            random=rand.nextInt(10)+1;
            Object spinned_wheel=wheel.findData(random);
            System.out.println("\nWheel: "+spinned_wheel);

            //Controlling Bankrupt
            if(spinned_wheel!="Bankrupt"){

                //Random Letter From SLL2
                random= rand.nextInt(sll2.size())+1;
                String guess_letter=(String) sll2.findData(random);
                System.out.println("Guess: "+ guess_letter);
                sll2.delete(guess_letter);

                //Opening Hidden Letters
                for(int i=1;i<=sll5.size();i++){
                    if(sll4.findData(i).equals(guess_letter)){
                        sll5.letter_changer(guess_letter,i);
                        score+=(int) spinned_wheel;
                        animal_letter_counter++;
                    }
                }
            }

            //If Bankrupt
            else{
                System.out.println("You lost your point!");
                score=0;
            }
        }
    }
}
