import java.util.Random;

public class testQueue {

	private static int true_random = 0;
	static Queue bag1 = new Queue(1000);
	static Queue bag2 = new Queue(1000);
	
	//Adding Numbers to cards
	public static void AddNumber_toCard(Queue q) {
		
		Random rnd = new Random();
		int randnum = rnd.nextInt(17) + 1;
		q.enqueue(randnum);

		do {
			boolean flag = false;
			randnum = rnd.nextInt(17) + 1;
			for (int i = 0; i < q.size(); i++) {
				if ((int) q.peek() == randnum) {
					flag = true;
					break;
				} else
					q.enqueue(q.dequeue());
			}

			if (!flag)
				q.enqueue(randnum);
		} while (q.size() != 7);
		
	}

	//Adding numbers to bag1
	public static void bagnumber(Queue q) {
		for (int i = 1; i < 18; i++)
			q.enqueue(i);
	}

	//Selecting Random Number From Bag1
	public static void Select_random_fromBag1(Queue bag1) {
		Random rnd = new Random();
		int random_number;
		boolean isInBag1;

		do {
			random_number = rnd.nextInt(17) + 1;
			isInBag1 = false;
			for (int i = 0; i < bag1.size(); i++) {
				if ((int) bag1.peek() == random_number) {
					isInBag1 = true;
					break;
				} else
					bag1.enqueue(bag1.dequeue());
			}

			if (isInBag1)
				true_random = random_number;

		} while(!isInBag1);
	}
	
	//Delete number from card
	public static void DeleteNumber_fromCard(Queue q) {
		
		for (int i = 0; i < q.size(); i++) {
			if ((int) q.peek() == true_random) {
				q.dequeue();
				break;
			} else
				q.enqueue(q.dequeue());
		}
	}
	
	//Showing numbers inside Queues
	public static void Screen(Queue q) {
		
		for (int i = 0; i < q.size(); i++) {
			if((int) q.peek()>9)
				System.out.print(q.peek() + " ");
			else
				System.out.print(q.peek() + "  ");
			q.enqueue(q.dequeue());
		}
	}

	//Number of spaces for the alignment 
	public static String Spacing(Queue q) {
		
		String Spaces="";
		if( q.size()>4)
			Spaces="			";
		else if( q.size()>2)
			Spaces="				";
		else if( q.size()>0)
			Spaces="					";
		return Spaces;
	}
	
	//Main
	public static void main(String[] args) {

		Queue card1 = new Queue(500);
		Queue card2 = new Queue(500);
		
		AddNumber_toCard(card1);
		AddNumber_toCard(card2);
		bagnumber(bag1);
		
		int player1_money=0;
		int player2_money=0;
		int player_cinko_count=0;
		
		for(int j=0;j<17;j++) {
			
			int cardpeek1=(int) card1.peek();
			System.out.print("Player1 :");
			Screen(card1);
			
			int bagpeek1=(int) bag1.peek();
			System.out.print(Spacing(card1)+"Bag1 :");
			Screen(bag1);
			
			int cardpeek2=(int) card2.peek();
			System.out.print("\nPlayer2 :");
			Screen(card2);
			
			System.out.print(Spacing(card2)+"Bag2 :");
			Screen(bag2);
			
			Select_random_fromBag1(bag1);
			System.out.println("\n");
			System.out.println("Randomly selected number: " + true_random+"\n");

			DeleteNumber_fromCard(card1);
			DeleteNumber_fromCard(card2);

			//Sending Numbers bag2 from bag1
			for (int i = 0; i < bag1.size(); i++) {
				if ((int) bag1.peek() == true_random) {
					bag2.enqueue(bag1.dequeue());
					break;
				} else
					bag1.enqueue(bag1.dequeue());
			}
			
			//Correct queuing of Card1
			for(int i=0;i<card1.size();i++)
				if(card1.peek()!=null&&cardpeek1!=(int) card1.peek())
					card1.enqueue(card1.dequeue());
			
			//Correct queuing of Card2
			for(int i=0;i<card2.size();i++)
				if(card2.peek()!=null&&cardpeek2!=(int) card2.peek())
					card2.enqueue(card2.dequeue());

			//Correct queuing of Bag1
			for(int i=0;i<bag1.size();i++)
				if(bag1.peek()!=null&&bagpeek1!=(int) bag1.peek())
					bag1.enqueue(bag1.dequeue());
			
			//Tie
			if(card1.isEmpty() && card2.isEmpty()) {
				player1_money+=15;
				player2_money+=15;
				break;
			}
			
			//Player 1 wins
			else if(card1.isEmpty()) {
				player1_money+=30;
				break;
			}
			
			//Player 2 wins
			else if(card2.isEmpty()) {
				player2_money+=30;
				break;
			}
			
			//Writing 1. Cinko for Tie
			if( card2.size()==3 &&  card1.size()==3 && player_cinko_count<1) {
				System.out.println("Player 1 gets $10 (Birinci Çinko)\n");
				player1_money+=10;
				System.out.println("Player 2 gets $10 (Birinci Çinko)\n");
				player2_money+=10;
				player_cinko_count++;
			}
			
			//Writing 1. Cinko for Player1
			if( card1.size()==3 && player_cinko_count<1) {
				System.out.println("Player 1 gets $10 (Birinci Çinko)\n");
				player1_money+=10;
				player_cinko_count++;
			}
			
			//Writing 1. Cinko for Player2
			if( card2.size()==3 && player_cinko_count<1) {
				System.out.println("Player 2 gets $10 (Birinci Çinko)\n");
				player2_money+=10;
				player_cinko_count++;
			}	
		}
		
		System.out.print("Player1 :");
		Screen(card1);

		System.out.print("					Bag1 :");
		Screen(bag1);
		
		System.out.print("\nPlayer2 :");
		Screen(card2);

		System.out.print("					Bag2 :");
		Screen(bag2);

		
		if(player1_money>player2_money)
			System.out.println("\n\nPlayer 1 is the winner!");
		else if(player2_money>player1_money)
			System.out.println("\n\nPlayer 2 is the winner!");
		else if(player1_money==player2_money)
			System.out.println("\n\nPlayer 1 and 2 Tie!");
		
		System.out.println("\nPlayer1 gets $" + player1_money);
		System.out.println("Player2 gets $" + player2_money);
	}
}
