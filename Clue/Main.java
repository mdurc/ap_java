import java.util.*;

class Main {
  public static void main(String[] args) {
    ArrayList<Map> maps = new ArrayList<Map>();
		ArrayList<Player> players = new ArrayList<Player>();


		String[] weaponValues = {"dagger","rope","revolver","candle","stick","wrench"}; 
		String[] peopleValues ={"Scarlet","White","Peacock","Plum","Green","Mustard"};			//putting all cards in array so that it can be randomized
		String[]roomValues ={"room 1","room 2","room 3","room 4","room 5","room 6"};
		Random r=new Random();
		for (int i = 0; i < 6; i++) {
			int temp = r.nextInt(6);
			String temp2 = weaponValues[temp];
			weaponValues[temp] = weaponValues[i];
			weaponValues[i] = temp2;
		}
		for (int i = 0; i < 6; i++) {
			int temp = r.nextInt(6);
			String temp2 = peopleValues[temp];
			peopleValues[temp] = peopleValues[i];
			peopleValues[i] = temp2;
		}
		for (int i = 0; i < 6; i++) {															//randimizing order of cards
			int temp = r.nextInt(6);
			String temp2 = roomValues[temp];
			roomValues[temp] = roomValues[i];
			roomValues[i] = temp2;
		}
		String[] answerKey = new String[3];
		answerKey[0]=roomValues[5];
		answerKey[1]=weaponValues[4]; //randomized answer key for room person and weapon
		answerKey[2]=peopleValues[5];


		//asigning cards to player objects
		Player player1 = new Player(weaponValues[0],peopleValues[1],weaponValues[1],peopleValues[0],roomValues[0]);   
		Player player2 = new Player(weaponValues[2],peopleValues[2],weaponValues[3],roomValues[1],roomValues[3]);
		Player player3 = new Player(weaponValues[5],peopleValues[4],peopleValues[3],roomValues[2],roomValues[4]);
		players.add(player1);
		players.add(player2);
		players.add(player3);  //arraylist of players so i can access in a loop when i have to switch player turn


		System.out.println("Suspects\tWeapons\t\tRooms");
		System.out.println("------------------------------");
		System.out.println("Scarlet\t\tdagger\t\tRoom 1");
		System.out.println("Peacock\t\trope\t\tRoom 2");
		System.out.println("Plum\t\tcandle\t\tRoom 3");
		System.out.println("Green\t\trevolver\tRoom 4");
		System.out.println("White\t\tstick\t\tRoom 5");
		System.out.println("Mustard\t\twrench\t\tRoom 6\n\n");     //printing all cards in game


		System.out.println("Player 1 Cards");
		player1.printCards();														//shoudnt be seen by everybody probably delete 
		System.out.println("\nPlayer 2 Cards");					// this
		player2.printCards();
		System.out.println("\nPlayer 3 Cards");
		player3.printCards();

		Map map1 = new Map(5,11,"P1");
		map1.setMap();
		Map map2 = new Map(5,11,"P2");
		map2.setMap();     										//making maps for the players to find distance between 																				player and room with formulas, formulas are in 																								map.setDistance()
		Map map3 = new Map(5,11,"P3");
		map3.setMap();

		maps.add(map1);
		maps.add(map2);
		maps.add(map3); 
		
		
		System.out.println("\n\n\n\n\nPlayer 1 starts");
		System.out.println();
		System.out.println("Cards");
		System.out.println("--------------------");
		player1.printCards();
		player1.setChecklist(peopleValues,weaponValues,roomValues);
		player2.setChecklist(peopleValues,weaponValues,roomValues); 
		player3.setChecklist(peopleValues,weaponValues,roomValues);
	
		player1.editChecklist(player1.getCard1());	
		player1.editChecklist(player1.getCard2());
		player1.editChecklist(player1.getCard3());
		player1.editChecklist(player1.getCard4());
		player1.editChecklist(player1.getCard5());
 //setting up checklists with 																																	their cards they start with
		player2.editChecklist(player2.getCard1());	
		player2.editChecklist(player2.getCard2());
		player2.editChecklist(player2.getCard3());
		player2.editChecklist(player2.getCard4());
		player2.editChecklist(player2.getCard5());
		
		player3.editChecklist(player1.getCard1());	
		player3.editChecklist(player1.getCard2());
		player3.editChecklist(player1.getCard3());
		player3.editChecklist(player1.getCard4());
		player3.editChecklist(player1.getCard5());
	
		
		

		

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		boolean gameover=false;
		int playerTurn =0;
		int defendCard;
		String answer = "l";
		// variables for inside the !gameover loop









		int saveDeadPlayerTurn=99; //for later if someone is out of game, their turn should be skipped
		int count = 0;
		while(!gameover){
			if(count==2){ // the amount of dead players is "count" if 2 players lose, the player left is the winner
					System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
				gameover=true;
				break;
			}
		//rolling the dice, player can decide to make a accusation, or move to a  room and make suggestion
		int moveAmt =rand.nextInt(5)+1;
		
		//Starting player turn, player info printed, which room player moves to, player rolls die for movement, if in a room they can make suspect(other players can defend suspection), asks for a accusation, checks for loser players and if a player wins

		System.out.println("--------------------");
		System.out.println("Checklist");
		players.get(playerTurn).printChecklist(); //prints players checklist
		System.out.println("Player "+(playerTurn+1)+", do you want to accuse: ");//asks accuse
		String accuseQues = scan.nextLine();
		if(accuseQues.toLowerCase().equals("yes")){ //if player wants to make an accusation
			System.out.print("Room (ex. room 1): ");
			String roomAccuse = scan.nextLine();  //store room in roomAccuse
			System.out.print("Weapon: ");
			String weaponAccuse = scan.nextLine();//store weapon in weaponAccuse
			System.out.print("Person: ");
			String personAccuse = scan.nextLine();     //store player in personAccuse


			//checks to see if it is correct, else player loses because it is an incorrect accusation
			if(roomAccuse.equals(answerKey[0])&&weaponAccuse.equals(answerKey[1])&&personAccuse.equals(answerKey[2])){
				System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
				gameover=true;
				break;

			}else{
			System.out.println("Player "+(playerTurn+1)+" loses\n");
			saveDeadPlayerTurn = playerTurn;
			//Making that future playerTurn dont go over a player that has lost.
			playerTurn++;


			if(playerTurn==3||playerTurn==saveDeadPlayerTurn){//saveDeadPlayerTurn will be an int 0-2 and if player turn is ever equal to it, playerTurn should pass over it. also, this if checks if playerTurn is 3, which is out of bounds 0-2.
				if(playerTurn==3){
					playerTurn = 0;
				}
				if(saveDeadPlayerTurn==0&&playerTurn==0){
					playerTurn = 1;
				}
				if(saveDeadPlayerTurn==1&&playerTurn==1){
					playerTurn = 2;
				}
				if(saveDeadPlayerTurn==2&&playerTurn==2){
					playerTurn = 0;
				}
			}

				//starts new player turn, this is the code I use over and over to start next player turn.
			System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
			System.out.println("Player "+(playerTurn+1)+" turn starts");
			count++;
			}
		}else{   //!!! this is the start of everything if player dont want to accuse
			if(playerTurn==3||playerTurn==saveDeadPlayerTurn){
				if(playerTurn==3){
					playerTurn = 0;
				}
				if(saveDeadPlayerTurn==0&&playerTurn==0){
					playerTurn = 1;
				}
				if(saveDeadPlayerTurn==1&&playerTurn==1){
					playerTurn = 2;
				}
				if(saveDeadPlayerTurn==2&&playerTurn==2){
					playerTurn = 0;
				}
			}
		System.out.println("\nPlayer "+(playerTurn+1)+" rolls for move: "+ moveAmt);//DICE ROLL stored in random "moveAmt"
		if(maps.get(playerTurn).searchHidden()){ //if the player is not on the map, place player, look at map class
			maps.get(playerTurn).placePlayer();//places the player at the last seen location, the last seen location is stored in array called savePlace[][] in Map class 
		}
		maps.get(playerTurn).printDistance();//rolls amount 
		System.out.println();
		maps.get(playerTurn).printMap();//prints the map and distance to rooms
		System.out.println();
		

		//Everything below is asking which room they go to and which player moves, then the map changing, and finding distance
		System.out.print("Which room do you want to move towards (ex. room 1): ");
		String move = scan.nextLine();
		move = move.toLowerCase();
		switch(move){//Huge switch case based on room, they just ask if they suspect if they get to 																																													room
			case "room 1":
			maps.get(playerTurn).editMap("room 1", moveAmt);//map method moves the player towards parameter 1 which is "room 1" in this case
			maps.get(playerTurn).setDistance1(maps.get(playerTurn).getDistance1()-moveAmt);//sets the distance after the player is moved through editMap method, the getDistance is subtracted by moveAmt, this would = zero if they are in the room, if they are one space away, it would setDistance1 as "1";

			if(maps.get(playerTurn).getDistance1()<=0){//means they are in the room, distance to room is zero
				maps.get(playerTurn).setDistance1(0);
				System.out.println("Do you want to suspect: ");
				String susQuestion = scan.nextLine();
				if(susQuestion.toLowerCase().equals("yes")){//they want to suspect
					System.out.print("Room: room 1");
					System.out.println();
					System.out.print("Weapon: ");
					String weaponGuess = scan.nextLine();//stores weapon guess in weaponGuess
					System.out.print("Person: ");
					String personGuess = scan.nextLine();//stores person guess in personGuess
					System.out.println();
					System.out.print("Can anybody defend this: ");
					String defend = scan.nextLine();//player name "player 1" to see if they have a counter to their suspicion
					if(defend.toLowerCase().equals("yes")){
						System.out.print("Which Player: ");
						String playerDefense = scan.nextLine();
						switch(playerDefense.toLowerCase()){
							case "player 1":  //many inner switch cases based on the counter defense
							System.out.println();
							System.out.println("These are your cards player 1:");
							player1.printCards();//defender cards
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();//look defendCardRetrieve in player class
							System.out.println(player1.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player1.defendCardRetrieve(defendCard));//checks off the card that was used to defend
							players.get(playerTurn).printChecklist();//prints checklist to show their new list
							System.out.println("End of player "+(playerTurn+1)+" turn");  //ends turn
							playerTurn++;

							//this a condenced version of the previously used lines that made sure playerTurn skipped over saveDeadPlayerTurn numbers. goto line 195 main
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }


							//new turn
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							//this whole thing^^ is copied with slight alterations for player 2 and then player 3

							case "player 2":
							System.out.println();
							System.out.println("These are your cards player 2:");
							player2.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player2.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player2.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();

							break;
							case "player 3":
							System.out.println();
							System.out.println("These are your cards player 3:");
							player3.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player3.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player3.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
						}
					}else{//this whole else statement is the lines of code i use to switch player turn
						System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
						gameover=true;
						break;
					}
				}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){
							if(playerTurn==3){
								playerTurn = 0;
							}
							if(saveDeadPlayerTurn==0&&playerTurn==0){
								playerTurn = 1;
							}
							if(saveDeadPlayerTurn==1&&playerTurn==1){
								playerTurn = 2;
							}
							if(saveDeadPlayerTurn==2&&playerTurn==2){
								playerTurn = 0;
							}
						}
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){
							if(playerTurn==3){
								playerTurn = 0;
							}
							if(saveDeadPlayerTurn==0&&playerTurn==0){
								playerTurn = 1;
							}
							if(saveDeadPlayerTurn==1&&playerTurn==1){
								playerTurn = 2;
							}
							if(saveDeadPlayerTurn==2&&playerTurn==2){
								playerTurn = 0;
							}
						}
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			break;
			case "room 2":  // same as room 1 with minor edits to the map and where player travels
			maps.get(playerTurn).editMap("room 2", moveAmt);
			maps.get(playerTurn).setDistance2(maps.get(playerTurn).getDistance2()-moveAmt);
			if(maps.get(playerTurn).getDistance2()<=0){
				maps.get(playerTurn).setDistance2(0);
				System.out.println("Do you want to suspect: ");
				String susQuestion = scan.nextLine();
				if(susQuestion.toLowerCase().equals("yes")){
					System.out.print("Room: room 2");
					System.out.println();
					System.out.print("Weapon: ");
					String weaponGuess = scan.nextLine();
					System.out.print("Person: ");
					String personGuess = scan.nextLine();
					System.out.println();
					System.out.print("Can anybody defend this: ");
					String defend = scan.nextLine();
					if(defend.toLowerCase().equals("yes")){
						System.out.print("Which Player: ");
						String playerDefense = scan.nextLine();
						switch(playerDefense.toLowerCase()){
							case "player 1":
							System.out.println();
							System.out.println("These are your cards player 1:");
							player1.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player1.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player1.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 2":
							System.out.println();
							System.out.println("These are your cards player 2:");
							player2.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player2.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player2.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 3":
							System.out.println();
							System.out.println("These are your cards player 3:");
							player3.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player3.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player3.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
						}
					}else{
						System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
						gameover=true;
						break;
					}
				}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){
							if(playerTurn==3){
								playerTurn = 0;
							}
							if(saveDeadPlayerTurn==0&&playerTurn==0){
								playerTurn = 1;
							}
							if(saveDeadPlayerTurn==1&&playerTurn==1){
								playerTurn = 2;
							}
							if(saveDeadPlayerTurn==2&&playerTurn==2){
								playerTurn = 0;
							}
						}
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){
							if(playerTurn==3){
								playerTurn = 0;
							}
							if(saveDeadPlayerTurn==0&&playerTurn==0){
								playerTurn = 1;
							}
							if(saveDeadPlayerTurn==1&&playerTurn==1){
								playerTurn = 2;
							}
							if(saveDeadPlayerTurn==2&&playerTurn==2){
								playerTurn = 0;
							}
						}
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			break;
			case "room 3":
			maps.get(playerTurn).editMap("room 3", moveAmt);
			maps.get(playerTurn).setDistance3(maps.get(playerTurn).getDistance3()-moveAmt);
			if(maps.get(playerTurn).getDistance3()<=0){
				maps.get(playerTurn).setDistance3(0);
				System.out.println("Do you want to suspect: ");
				String susQuestion = scan.nextLine();
				if(susQuestion.toLowerCase().equals("yes")){
					System.out.print("Room): room 3");
					System.out.println();
					System.out.print("Weapon: ");
					String weaponGuess = scan.nextLine();
					System.out.print("Person: ");
					String personGuess = scan.nextLine();
					System.out.println();
					System.out.print("Can anybody defend this: ");
					String defend = scan.nextLine();
					if(defend.toLowerCase().equals("yes")){
						System.out.print("Which Player: ");
						String playerDefense = scan.nextLine();
						switch(playerDefense.toLowerCase()){
							case "player 1":
							System.out.println();
							System.out.println("These are your cards player 1:");
							player1.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player1.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player1.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 2":
							System.out.println();
							System.out.println("These are your cards player 2:");
							player2.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player2.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player2.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 3":
							System.out.println();
							System.out.println("These are your cards player 3:");
							player3.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player3.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player3.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
						}
					}else{
						System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
						gameover=true;
						break;
					}
				}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			break;
			case "room 4":
			maps.get(playerTurn).editMap("room 4", moveAmt);
			maps.get(playerTurn).setDistance4(maps.get(playerTurn).getDistance4()-moveAmt);
			if(maps.get(playerTurn).getDistance4()<=0){
				maps.get(playerTurn).setDistance4(0);
				System.out.println("Do you want to suspect: ");
				String susQuestion = scan.nextLine();
				if(susQuestion.toLowerCase().equals("yes")){
					System.out.print("Room): room 4");
					System.out.println();
					System.out.print("Weapon: ");
					String weaponGuess = scan.nextLine();
					System.out.print("Person: ");
					String personGuess = scan.nextLine();
					System.out.println();
					System.out.print("Can anybody defend this: ");
					String defend = scan.nextLine();
					if(defend.toLowerCase().equals("yes")){
						System.out.print("Which Player: ");
						String playerDefense = scan.nextLine();
						switch(playerDefense.toLowerCase()){
							case "player 1":
							System.out.println();
							System.out.println("These are your cards player 1:");
							player1.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player1.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player1.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 2":
							System.out.println();
							System.out.println("These are your cards player 2:");
							player2.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player2.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player2.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 3":
							System.out.println();
							System.out.println("These are your cards player 3:");
							player3.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player3.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player3.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
						}
					}else{
						System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
						gameover=true;
						break;
					}
				}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			break;
			case "room 5":
			maps.get(playerTurn).editMap("room 5", moveAmt);
			maps.get(playerTurn).setDistance5(maps.get(playerTurn).getDistance5()-moveAmt);
			if(maps.get(playerTurn).getDistance5()<=0){
				maps.get(playerTurn).setDistance5(0);
				System.out.println("Do you want to suspect: ");
				String susQuestion = scan.nextLine();
				if(susQuestion.toLowerCase().equals("yes")){
					System.out.print("Room: room 5");
					System.out.println();
					System.out.print("Weapon: ");
					String weaponGuess = scan.nextLine();
					System.out.print("Person: ");
					String personGuess = scan.nextLine();
					System.out.println();
					System.out.print("Can anybody defend this: ");
					String defend = scan.nextLine();
					if(defend.toLowerCase().equals("yes")){
						System.out.print("Which Player: ");
						String playerDefense = scan.nextLine();
						switch(playerDefense.toLowerCase()){
							case "player 1":
							System.out.println();
							System.out.println("These are your cards player 1:");
							player1.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player1.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player1.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();

							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 2":
							System.out.println();
							System.out.println("These are your cards player 2:");
							player2.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player2.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player2.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();

							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 3":
							System.out.println();
							System.out.println("These are your cards player 3:");
							player3.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player3.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player3.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
						}
					}else{
						System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
						gameover=true;
						break;
					}
				}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			break;
			case "room 6":
			maps.get(playerTurn).editMap("room 6", moveAmt);
			maps.get(playerTurn).setDistance6(maps.get(playerTurn).getDistance6()-moveAmt);
			if(maps.get(playerTurn).getDistance2()<=0){
				maps.get(playerTurn).setDistance2(0);
				System.out.println("Do you want to suspect: ");
				String susQuestion = scan.nextLine();
				if(susQuestion.toLowerCase().equals("yes")){
					System.out.print("Room: room 6");
					System.out.println();
					System.out.print("Weapon: ");
					String weaponGuess = scan.nextLine();
					System.out.print("Person: ");
					String personGuess = scan.nextLine();
					System.out.println();
					System.out.print("Can anybody defend this: ");
					String defend = scan.nextLine();
					if(defend.toLowerCase().equals("yes")){
						System.out.print("Which Player: ");
						String playerDefense = scan.nextLine();
						switch(playerDefense.toLowerCase()){
							case "player 1":
							System.out.println();
							System.out.println("These are your cards player 1:");
							player1.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player1.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player1.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 2":
							System.out.println();
							System.out.println("These are your cards player 2:");
							player2.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player2.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player2.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
							case "player 3":
							System.out.println();
							System.out.println("These are your cards player 3:");
							player3.printCards();
							System.out.println();
							System.out.println("Which one defends the suggestion (ex. 1)");
							defendCard = scan.nextInt();
							System.out.println(player3.defendCardRetrieve(defendCard)+" was checked off for player "+(playerTurn+1));
							players.get(playerTurn).editChecklist(player3.defendCardRetrieve(defendCard));
							players.get(playerTurn).printChecklist();
							System.out.println("End of player "+(playerTurn+1)+" turn");
							playerTurn++;
							if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
							System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
							System.out.println("Player "+(playerTurn+1)+" turn starts");answer=scan.nextLine();
							break;
						}
					}else{
						System.out.println("Player "+(playerTurn+1)+" is the winner, the game is over");
						gameover=true;
						break;
					}
				}else{
					System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
				}
			}else{
						System.out.println("End of player "+(playerTurn+1)+" turn");
						playerTurn++;
						if(playerTurn==3||playerTurn==saveDeadPlayerTurn){ if(playerTurn==3){ playerTurn = 0; } if(saveDeadPlayerTurn==0&&playerTurn==0){ playerTurn = 1; } if(saveDeadPlayerTurn==1&&playerTurn==1){ playerTurn = 2; } if(saveDeadPlayerTurn==2&&playerTurn==2){ playerTurn = 0; } }
						System.out.println("----------------");System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
						System.out.println("Player "+(playerTurn+1)+" turn starts");
					}
			break;
		}
		}
  }

}}