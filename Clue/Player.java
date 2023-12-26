public class Player{
	public String card1;
	public String card2;
	public String card3;
	public String card4;
	public String card5;//all the cards per player
	public String[][] checkPage = new String[18][2]; // checklist 2darray

	public Player(String card1, String card2, String card3,String card4,String card5){
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4=card4;
		this.card5 = card5;//construct
	}

	public void printCards(){
		System.out.println("1. "+card1); //prints player's cards
		System.out.println("2. "+card2);
		System.out.println("3. "+card3);
		System.out.println("4. "+card4);
		System.out.println("5. "+card5);
	}
	

	public void setChecklist(String []array,String []array2,String []array3 ){ //sets checklist up with default values, no cards checked off yet, just setting them to X's and the card names. 
		/*
		[Mustard]   [null]
		[Peacock]   [null]
		[Green]     [null]					First for loop
		[Plum]      [null]
		[Scarlet]   [null]
		[White]     [null]

		[rope]      [null]
		[stick]     [null]
		[wrench]    [null]					Second for loop
		[revolver]  [null]
		[dagger]    [null]
		[candle]    [null]

		[room 5]    [null]
		[room 3]    [null]
		[room 4]    [null]					Thrid for loop
		[room 2]    [null]
		[room 1]    [null]
		[room 6]    [null]

		the fourth for loop fills all the "null" with "✘"
		*/
	
		for(int i =0;i<6;i++){
			checkPage[i][0]=array[i];	//sets up column 0 and row 0-6 with the first parameter filled with names of the poeple
		}
		for(int i =0;i<6;i++){
			checkPage[6+i][0]=array2[i];	
		}
		for(int i =0;i<6;i++){
			checkPage[i+12][0]=array3[i];	
		}
		
		for(int i =0;i<18;i++){
			checkPage[i][1]="✘";
			//checkPage[i][1]="✓";
		}
	}


	public void editChecklist(String checker){ //for when someone counters the suggestion, checks off
		/*
		this function takes in a string and then checks the first column of the checklist to see where the string parameter matches, and then, at that row, column 1 is switched from ✘ to ✓
		*/

		for(int i = 0;i<18;i++){
			for(int j= 0; j<2;j++){
				if(checkPage[i][j].equals(checker)){
					checkPage[i][1]="✓";
				}
			}
		}
	}

	public void printChecklist(){//prints the player checklist on their turn
		//double for loop to print 2d array
		for(int i = 0;i<18;i++){
			for(int j= 0; j<2;j++){

				//making the second column line up with each other through tabs

				//the strings in the if statement need an extra tab after them because they are too small and it wouldnt line up with the longer strings like "revolver"
				if(checkPage[i][j].equals("rope")||checkPage[i][j].equals("White")||checkPage[i][j].equals("Plum")||checkPage[i][j].equals("stick")||checkPage[i][j].equals("Green")){ 
					System.out.print("["+checkPage[i][j]+"]\t\t");
				}else
					System.out.print("["+checkPage[i][j]+"]\t");
			}
			System.out.println();
		}
	}

	//retrieves any card state variable through an int parameter, see the switch case
	public String defendCardRetrieve(int num){
		//which card the defender chooses to represent as defense
		switch(num){
			case 1:
			return card1;
			
			case 2:
			return card2;
			
			case 3:
			return card3;
			
			case 4:
			return card4;
			
			case 5:
			return card5;
			
		}
		return "You did not enter a value";//this will never happen but the code won't run without it
	}
	public String getCard1(){
		return card1;
	}
	public String getCard2(){
		return card2;
	}
	public String getCard3(){
		return card3;
	}
	public String getCard4(){
		return card4;
	}
	public String getCard5(){
		return card5;
	}
	
}