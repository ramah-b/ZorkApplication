package zorkApplication;

import java.util.Scanner;

public class Zork {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int input, room = 1, moveCount = 0;
		boolean foundTreasure = false;
		String quit = "xzx";

		System.out.println("Welcome to Zork!");
		System.out
				.println("You will have to find the treasure chest. You can only exit through the Foyer.");

		do {

			// foyer
			if (room == Rooms.FOYER) {
				System.out
						.println("You are standing in the foyer of an old house.");
				System.out.println("You see a dead scorpion.");
				System.out.print("You can (1) exit to the north, (2) run. ");

				input = keyboard.nextInt();
				if (input == 1) {
					room = Rooms.FRONTROOM;
					moveCount++;
				} else if (input == 2)
					quit = "run";

				// front room
			} else if (room == Rooms.FRONTROOM) {
				System.out.println("You are standing in the front room.");
				System.out.println("You see a piano.");
				System.out
						.println("You can (1) exit to the south, (2) exit to the east, (3) exit to the west. ");

				input = keyboard.nextInt();
				if (input == 1) {
					room = Rooms.FOYER;
					moveCount++;
				} else if (input == 2) {
					room = Rooms.LIBRARY;
					moveCount++;
				} else if (input == 3) {
					room = Rooms.KITCHEN;
					moveCount++;
				} // else if (input == 4)
					// quit = "run";

				// library
			} else if (room == Rooms.LIBRARY) {
				System.out.println("You are standing in the library.");
				System.out.println("You see a spiders.");
				System.out
						.println("You can (1) exit to the west, (2) exit to the north. ");

				input = keyboard.nextInt();
				if (input == 1) {
					room = Rooms.FRONTROOM;
					moveCount++;
				} else if (input == 2) {
					room = Rooms.DININGROOM;
					moveCount++;
				} // else if (input == 3)
					// quit = "run";

				// kitchen
			} else if (room == Rooms.KITCHEN) {
				System.out.println("You are standing in the kitchen.");
				System.out.println("You see bats.");
				System.out
						.println("You can (1) exit to the east, (2) exit to the north.");

				input = keyboard.nextInt();
				if (input == 1) {
					room = Rooms.FRONTROOM;
					moveCount++;
				} else if (input == 2) {
					room = Rooms.PARLOR;
					moveCount++;
				} // else if (input == 3)
					// quit = "run";

				// dining room
			} else if (room == Rooms.DININGROOM) {
				System.out.println("You are standing in the dining room.");
				System.out.println("You see a dust and empty box.");
				System.out.println("You can (1) exit to the south. ");

				input = keyboard.nextInt();
				if (input == 1) {
					room = Rooms.LIBRARY;
					moveCount++;
				} // else if (input == 2)
					// quit = "run";

				// vault
			} else if (room == Rooms.VAULT) {
				System.out.println("You are standing in the vault.");
				System.out.println("You see a three walking skeletons.");
				System.out.println("You can (1) exit to the east. ");

				input = keyboard.nextInt();
				if (input == 1) {
					room = Rooms.PARLOR;
					moveCount++;
				} // else if (input == 2)
					// quit = "run";

				// parlor
			} else if (room == Rooms.PARLOR) {
				System.out.println("You are standing in the parlor.");
				System.out.println("You see a treasure chest.");
				System.out
						.println("You can (1) exit to the west, (2) exit to the south, (3) open treasure chest. ");

				input = keyboard.nextInt();
				if (input == 1) {
					room = Rooms.VAULT;
					moveCount++;
				} else if (input == 2) {
					room = Rooms.KITCHEN;
					moveCount++;
				} else if (input == 3) {

					// the user found the treasure and now have to make his/her
					// way back to the exit door
					foundTreasure = true;
					System.out
							.println("You found the treasure. Now you have to go back and exit.");
					System.out
							.print("You can (1) exit to the west, (2) exit to the south. ");
					input = keyboard.nextInt();
					if (input == 1) {
						room = Rooms.VAULT;
						moveCount++;
					} else if (input == 2) {
						room = Rooms.KITCHEN;
						moveCount++;
					}

				}

			}

		} while (!quit.equals("run"));

		if (foundTreasure)
			System.out.println("\n\nCongratulations! You made it with "
					+ moveCount + " moves.");
		else {
			System.out.println("\n\nGame over! try next time.");
			System.out.println("Total number of mmoves is: " + moveCount);
		}

		keyboard.close();

	}

	
	
	/** if we want to use the same concept within main, we can define constants
	*using "Final"
	*/
	
	class Rooms {
		public final static int FOYER = 1;
		public final static int FRONTROOM = 2;
		public final static int LIBRARY = 3;
		public final static int KITCHEN = 4;
		public final static int DININGROOM = 5;
		public final static int VAULT = 1;
		public final static int PARLOR = 1;
	}
}
