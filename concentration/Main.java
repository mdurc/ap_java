import java.util.*;
class Main {

	public static String[][] randomstart(){
		/*
		AC, AD, AH, AS
		2C, 2D, 2H, 2S
		3C, 3D, 3H, 3S
		4C, 4D, 4H, 4S
		5C, 5D, 5H, 5S
		6C, 6D, 6H, 6S
		7C, 7D, 7H, 7S
		8C, 8D, 8H, 8S
		9C, 9D, 9H, 9S
		10C, 10D, 10H, 10S
		JC, JD, JH, JS
		QC, QD, QH, QS
		KC, KD, KH, KS
		*/
		String[][] values = {{"[a♣]","[a♦]","[a♥]","[a♠]","[2♣]","[2♦]","[2♥]","[2♠]","[3♣]","[3♦]","[3♥]","[3♠]","[4♣]"},{"[4♦]","[4♥]","[4♠]","[5♣]","[5♦]","[5♥]","[5♠]","[6♣]","[6♦]","[6♥]","[6♠]","[7♣]","[7♦]"},{"[7♥]","[7♠]","[8♣]","[8♦]","[8♥]","[8♠]","[9♣]","[9♦]","[9♥]","[9♠]","[10♣]","[10♦]","[10♥]"},{"[10♠]","[j♣]","[j♦]","[j♥]","[j♠]","[q♣]","[q♦]","[q♥]","[q♠]","[k♣]","[k♦]","[k♥]","[k♠]"}};
		Random r=new Random();
		for (int a = values.length - 1; a>0; a--) {
      for (int b = values[0].length - 1; b>0; b--) {
        int c = r.nextInt(a);
        int d = r.nextInt(b);
        String switche = values[a][b];
        values[a][b] = values[c][d];
        values[c][d] = switche;
      }
    }

		return values;

		
	}

	public static String[][] Org(){
		String map[][]=new String[4][13];
		for(int r=0;r<4;r++){
			for(int c = 0; c<13;c++){
				map[r][c]="[ ] ";
			}
		}

		return map;
	}

	public static String[][] checker(String[][] randomMap, String[][] shown, String x){
		if(!x.equals("ignore")){
			switch (x){
				case "a1":
					shown[0][0]=randomMap[0][0];
					break;
				case "b1":
					shown[0][1]=randomMap[0][1];
					break;
				case "c1":
					shown[0][2]=randomMap[0][2];
					break;
				case "d1":
					shown[0][3]=randomMap[0][3];
					break;
				case "e1":
					shown[0][4]=randomMap[0][4];
					break;
				case "f1":
					shown[0][5]=randomMap[0][5];
					break;
				case "g1":
					shown[0][6]=randomMap[0][6];
					break;
				case "h1":
					shown[0][7]=randomMap[0][7];
					break;
				case "i1":
					shown[0][8]=randomMap[0][8];
					break;
				case "j1":
					shown[0][9]=randomMap[0][9];
					break;
				case "k1":
					shown[0][10]=randomMap[0][10];
					break;
				case "l1":
					shown[0][11]=randomMap[0][11];
					break;
				case "m1":
					shown[0][12]=randomMap[0][12];
					break;



				case "a2":
					shown[1][0]=randomMap[1][0];
					break;
				case "b2":
					shown[1][1]=randomMap[1][1];
					break;
				case "c2":
					shown[1][2]=randomMap[1][2];
					break;
				case "d2":
					shown[1][3]=randomMap[1][3];
					break;
				case "e2":
					shown[1][4]=randomMap[1][4];
					break;
				case "f2":
					shown[1][5]=randomMap[1][5];
					break;
				case "g2":
					shown[1][6]=randomMap[1][6];
					break;
				case "h2":
					shown[1][7]=randomMap[1][7];
					break;
				case "i2":
					shown[1][8]=randomMap[1][8];
					break;
				case "j2":
					shown[1][9]=randomMap[1][9];
					break;
				case "k2":
					shown[1][10]=randomMap[1][10];
					break;
				case "l2":
					shown[1][11]=randomMap[1][11];
					break;
				case "m2":
					shown[1][12]=randomMap[1][12];
					break;

				


				case "a3":
					shown[2][0]=randomMap[2][0];
					break;
				case "b3":
					shown[2][1]=randomMap[2][1];
					break;
				case "c3":
					shown[2][2]=randomMap[2][2];
					break;
				case "d3":
					shown[2][3]=randomMap[2][3];
					break;
				case "e3":
					shown[2][4]=randomMap[2][4];
					break;
				case "f3":
					shown[2][5]=randomMap[2][5];
					break;
				case "g3":
					shown[2][6]=randomMap[2][6];
					break;
				case "h3":
					shown[2][7]=randomMap[2][7];
					break;
				case "i3":
					shown[2][8]=randomMap[2][8];
					break;
				case "j3":
					shown[2][9]=randomMap[2][9];
					break;
				case "k3":
					shown[2][10]=randomMap[2][10];
					break;
				case "l3":
					shown[2][11]=randomMap[2][11];
					break;
				case "m3":
					shown[2][12]=randomMap[2][12];
					break;

				


				case "a4":
					shown[3][0]=randomMap[3][0];
					break;
				case "b4":
					shown[3][1]=randomMap[3][1];
					break;
				case "c4":
					shown[3][2]=randomMap[3][2];
					break;
				case "d4":
					shown[3][3]=randomMap[3][3];
					break;
				case "e4":
					shown[3][4]=randomMap[3][4];
					break;
				case "f4":
					shown[3][5]=randomMap[3][5];
					break;
				case "g4":
					shown[3][6]=randomMap[3][6];
					break;
				case "h4":
					shown[3][7]=randomMap[3][7];
					break;
				case "i4":
					shown[3][8]=randomMap[3][8];
					break;
				case "j4":
					shown[3][9]=randomMap[3][9];
					break;
				case "k4":
					shown[3][10]=randomMap[3][10];
					break;
				case "l4":
					shown[3][11]=randomMap[3][11];
					break;
				case "m4":
					shown[3][12]=randomMap[3][12];
					break;
				default:
					System.out.println("That is not a valid input so you can only enter one value this turn.");

			}
		}
		return shown;
	}

	public static String[][] MAPorgsave(String[][] saved,String[][] MAPorg,String m1,String m2){

		
		switch (m1){
				case "a1":
					MAPorg[0][0]=saved[0][0];
					break;
				case "b1":
					MAPorg[0][1]=saved[0][1];
					break;
				case "c1":
					MAPorg[0][2]=saved[0][2];
					break;
				case "d1":
					MAPorg[0][3]=saved[0][3];
					break;
				case "e1":
					MAPorg[0][4]=saved[0][4];
					break;
				case "f1":
					MAPorg[0][5]=saved[0][5];
					break;
				case "g1":
					MAPorg[0][6]=saved[0][6];
					break;
				case "h1":
					MAPorg[0][7]=saved[0][7];
					break;
				case "i1":
					MAPorg[0][8]=saved[0][8];
					break;
				case "j1":
					MAPorg[0][9]=saved[0][9];
					break;
				case "k1":
					MAPorg[0][10]=saved[0][10];
					break;
				case "l1":
					MAPorg[0][11]=saved[0][11];
					break;
				case "m1":
					MAPorg[0][12]=saved[0][12];
					break;



				case "a2":
					MAPorg[1][0]=saved[1][0];
					break;
				case "b2":
					MAPorg[1][1]=saved[1][1];
					break;
				case "c2":
					MAPorg[1][2]=saved[1][2];
					break;
				case "d2":
					MAPorg[1][3]=saved[1][3];
					break;
				case "e2":
					MAPorg[1][4]=saved[1][4];
					break;
				case "f2":
					MAPorg[1][5]=saved[1][5];
					break;
				case "g2":
					MAPorg[1][6]=saved[1][6];
					break;
				case "h2":
					MAPorg[1][7]=saved[1][7];
					break;
				case "i2":
					MAPorg[1][8]=saved[1][8];
					break;
				case "j2":
					MAPorg[1][9]=saved[1][9];
					break;
				case "k2":
					MAPorg[1][10]=saved[1][10];
					break;
				case "l2":
					MAPorg[1][11]=saved[1][11];
					break;
				case "m2":
					MAPorg[1][12]=saved[1][12];
					break;

				


				case "a3":
					MAPorg[2][0]=saved[2][0];
					break;
				case "b3":
					MAPorg[2][1]=saved[2][1];
					break;
				case "c3":
					MAPorg[2][2]=saved[2][2];
					break;
				case "d3":
					MAPorg[2][3]=saved[2][3];
					break;
				case "e3":
					MAPorg[2][4]=saved[2][4];
					break;
				case "f3":
					MAPorg[2][5]=saved[2][5];
					break;
				case "g3":
					MAPorg[2][6]=saved[2][6];
					break;
				case "h3":
					MAPorg[2][7]=saved[2][7];
					break;
				case "i3":
					MAPorg[2][8]=saved[2][8];
					break;
				case "j3":
					MAPorg[2][9]=saved[2][9];
					break;
				case "k3":
					MAPorg[2][10]=saved[2][10];
					break;
				case "l3":
					MAPorg[2][11]=saved[2][11];
					break;
				case "m3":
					MAPorg[2][12]=saved[2][12];
					break;

				


				case "a4":
					MAPorg[3][0]=saved[3][0];
					break;
				case "b4":
					MAPorg[3][1]=saved[3][1];
					break;
				case "c4":
					MAPorg[3][2]=saved[3][2];
					break;
				case "d4":
					MAPorg[3][3]=saved[3][3];
					break;
				case "e4":
					MAPorg[3][4]=saved[3][4];
					break;
				case "f4":
					MAPorg[3][5]=saved[3][5];
					break;
				case "g4":
					MAPorg[3][6]=saved[3][6];
					break;
				case "h4":
					MAPorg[3][7]=saved[3][7];
					break;
				case "i4":
					MAPorg[3][8]=saved[3][8];
					break;
				case "j4":
					MAPorg[3][9]=saved[3][9];
					break;
				case "k4":
					MAPorg[3][10]=saved[3][10];
					break;
				case "l4":
					MAPorg[3][11]=saved[3][11];
					break;
				case "m4":
					MAPorg[3][12]=saved[3][12];
					break;

			
		}
		switch (m2){
				case "a1":
					MAPorg[0][0]=saved[0][0];
					break;
				case "b1":
					MAPorg[0][1]=saved[0][1];
					break;
				case "c1":
					MAPorg[0][2]=saved[0][2];
					break;
				case "d1":
					MAPorg[0][3]=saved[0][3];
					break;
				case "e1":
					MAPorg[0][4]=saved[0][4];
					break;
				case "f1":
					MAPorg[0][5]=saved[0][5];
					break;
				case "g1":
					MAPorg[0][6]=saved[0][6];
					break;
				case "h1":
					MAPorg[0][7]=saved[0][7];
					break;
				case "i1":
					MAPorg[0][8]=saved[0][8];
					break;
				case "j1":
					MAPorg[0][9]=saved[0][9];
					break;
				case "k1":
					MAPorg[0][10]=saved[0][10];
					break;
				case "l1":
					MAPorg[0][11]=saved[0][11];
					break;
				case "m1":
					MAPorg[0][12]=saved[0][12];
					break;



				case "a2":
					MAPorg[1][0]=saved[1][0];
					break;
				case "b2":
					MAPorg[1][1]=saved[1][1];
					break;
				case "c2":
					MAPorg[1][2]=saved[1][2];
					break;
				case "d2":
					MAPorg[1][3]=saved[1][3];
					break;
				case "e2":
					MAPorg[1][4]=saved[1][4];
					break;
				case "f2":
					MAPorg[1][5]=saved[1][5];
					break;
				case "g2":
					MAPorg[1][6]=saved[1][6];
					break;
				case "h2":
					MAPorg[1][7]=saved[1][7];
					break;
				case "i2":
					MAPorg[1][8]=saved[1][8];
					break;
				case "j2":
					MAPorg[1][9]=saved[1][9];
					break;
				case "k2":
					MAPorg[1][10]=saved[1][10];
					break;
				case "l2":
					MAPorg[1][11]=saved[1][11];
					break;
				case "m2":
					MAPorg[1][12]=saved[1][12];
					break;

				


				case "a3":
					MAPorg[2][0]=saved[2][0];
					break;
				case "b3":
					MAPorg[2][1]=saved[2][1];
					break;
				case "c3":
					MAPorg[2][2]=saved[2][2];
					break;
				case "d3":
					MAPorg[2][3]=saved[2][3];
					break;
				case "e3":
					MAPorg[2][4]=saved[2][4];
					break;
				case "f3":
					MAPorg[2][5]=saved[2][5];
					break;
				case "g3":
					MAPorg[2][6]=saved[2][6];
					break;
				case "h3":
					MAPorg[2][7]=saved[2][7];
					break;
				case "i3":
					MAPorg[2][8]=saved[2][8];
					break;
				case "j3":
					MAPorg[2][9]=saved[2][9];
					break;
				case "k3":
					MAPorg[2][10]=saved[2][10];
					break;
				case "l3":
					MAPorg[2][11]=saved[2][11];
					break;
				case "m3":
					MAPorg[2][12]=saved[2][12];
					break;

				


				case "a4":
					MAPorg[3][0]=saved[3][0];
					break;
				case "b4":
					MAPorg[3][1]=saved[3][1];
					break;
				case "c4":
					MAPorg[3][2]=saved[3][2];
					break;
				case "d4":
					MAPorg[3][3]=saved[3][3];
					break;
				case "e4":
					MAPorg[3][4]=saved[3][4];
					break;
				case "f4":
					MAPorg[3][5]=saved[3][5];
					break;
				case "g4":
					MAPorg[3][6]=saved[3][6];
					break;
				case "h4":
					MAPorg[3][7]=saved[3][7];
					break;
				case "i4":
					MAPorg[3][8]=saved[3][8];
					break;
				case "j4":
					MAPorg[3][9]=saved[3][9];
					break;
				case "k4":
					MAPorg[3][10]=saved[3][10];
					break;
				case "l4":
					MAPorg[3][11]=saved[3][11];
					break;
				case "m4":
					MAPorg[3][12]=saved[3][12];
					break;

			
		}

		return MAPorg;
	}

	public static boolean pair(String[][]shown,String x, String y){
		String paircheck = " ";
		String paircheck2 = " ";

		

		switch (x){
			case "a1":
				paircheck = shown[0][0];
				break;
			case "b1":
				paircheck = shown[0][1];
				break;
			case "c1":
				paircheck = shown[0][2];
				break;
			case "d1":
				paircheck = shown[0][3];
				break;
			case "e1":
				paircheck = shown[0][4];
				break;
			case "f1":
				paircheck = shown[0][5];
				break;
			case "g1":
				paircheck = shown[0][6];
				break;
			case "h1":
				paircheck = shown[0][7];
				break;
			case "i1":
				paircheck = shown[0][8];
				break;
			case "j1":
				paircheck = shown[0][9];
				break;
			case "k1":
				paircheck = shown[0][10];
				break;
			case "l1":
				paircheck = shown[0][11];
				break;
			case "m1":
				paircheck = shown[0][12];
				break;



			case "a2":
				paircheck = shown[1][0];
				break;
			case "b2":
				paircheck = shown[1][1];
				break;
			case "c2":
				paircheck = shown[1][2];
				break;
			case "d2":
				paircheck = shown[1][3];
				break;
			case "e2":
				paircheck = shown[1][4];
				break;
			case "f2":
				paircheck = shown[1][5];
				break;
			case "g2":
				paircheck = shown[1][6];
				break;
			case "h2":
				paircheck = shown[1][7];
				break;
			case "i2":
				paircheck = shown[1][8];
				break;
			case "j2":
				paircheck = shown[1][9];
				break;
			case "k2":
				paircheck = shown[1][10];
				break;
			case "l2":
				paircheck = shown[1][11];
				break;
			case "m2":
				paircheck = shown[1][12];
				break;

			


			case "a3":
				paircheck = shown[2][0];
				break;
			case "b3":
				paircheck = shown[2][1];
				break;
			case "c3":
				paircheck = shown[2][2];
				break;
			case "d3":
				paircheck = shown[2][3];
				break;
			case "e3":
				paircheck = shown[2][4];
				break;
			case "f3":
				paircheck = shown[2][5];
				break;
			case "g3":
				paircheck = shown[2][6];
				break;
			case "h3":
				paircheck = shown[2][7];
				break;
			case "i3":
				paircheck = shown[2][8];
				break;
			case "j3":
				paircheck = shown[2][9];
				break;
			case "k3":
				paircheck = shown[2][10];
				break;
			case "l3":
				paircheck = shown[2][11];
				break;
			case "m3":
				paircheck = shown[2][12];
				break;

			


			case "a4":
				paircheck = shown[3][0];
				break;
			case "b4":
				paircheck = shown[3][1];
				break;
			case "c4":
				paircheck = shown[3][2];
				break;
			case "d4":
				paircheck = shown[3][3];
				break;
			case "e4":
				paircheck = shown[3][4];
				break;
			case "f4":
				paircheck = shown[3][5];
				break;
			case "g4":
				paircheck = shown[3][6];
				break;
			case "h4":
				paircheck = shown[3][7];
				break;
			case "i4":
				paircheck = shown[3][8];
				break;
			case "j4":
				paircheck = shown[3][9];
				break;
			case "k4":
				paircheck = shown[3][10];
				break;
			case "l4":
				paircheck = shown[3][11];
				break;
			case "m4":
				paircheck = shown[3][12];
				break;
		}
		switch (y){
			case "a1":
				paircheck2 = shown[0][0];
				break;
			case "b1":
				paircheck2 = shown[0][1];
				break;
			case "c1":
				paircheck2 = shown[0][2];
				break;
			case "d1":
				paircheck2 = shown[0][3];
				break;
			case "e1":
				paircheck2 = shown[0][4];
				break;
			case "f1":
				paircheck2 = shown[0][5];
				break;
			case "g1":
				paircheck2 = shown[0][6];
				break;
			case "h1":
				paircheck2 = shown[0][7];
				break;
			case "i1":
				paircheck2 = shown[0][8];
				break;
			case "j1":
				paircheck2 = shown[0][9];
				break;
			case "k1":
				paircheck2 = shown[0][10];
				break;
			case "l1":
				paircheck2 = shown[0][11];
				break;
			case "m1":
				paircheck2 = shown[0][12];
				break;



			case "a2":
				paircheck2 = shown[1][0];
				break;
			case "b2":
				paircheck2 = shown[1][1];
				break;
			case "c2":
				paircheck2 = shown[1][2];
				break;
			case "d2":
				paircheck2 = shown[1][3];
				break;
			case "e2":
				paircheck2 = shown[1][4];
				break;
			case "f2":
				paircheck2 = shown[1][5];
				break;
			case "g2":
				paircheck2 = shown[1][6];
				break;
			case "h2":
				paircheck2 = shown[1][7];
				break;
			case "i2":
				paircheck2 = shown[1][8];
				break;
			case "j2":
				paircheck2 = shown[1][9];
				break;
			case "k2":
				paircheck2 = shown[1][10];
				break;
			case "l2":
				paircheck2 = shown[1][11];
				break;
			case "m2":
				paircheck2 = shown[1][12];
				break;

			


			case "a3":
				paircheck2 = shown[2][0];
				break;
			case "b3":
				paircheck2 = shown[2][1];
				break;
			case "c3":
				paircheck2 = shown[2][2];
				break;
			case "d3":
				paircheck2 = shown[2][3];
				break;
			case "e3":
				paircheck2 = shown[2][4];
				break;
			case "f3":
				paircheck2 = shown[2][5];
				break;
			case "g3":
				paircheck2 = shown[2][6];
				break;
			case "h3":
				paircheck2 = shown[2][7];
				break;
			case "i3":
				paircheck2 = shown[2][8];
				break;
			case "j3":
				paircheck2 = shown[2][9];
				break;
			case "k3":
				paircheck2 = shown[2][10];
				break;
			case "l3":
				paircheck2 = shown[2][11];
				break;
			case "m3":
				paircheck2 = shown[2][12];
				break;

			


			case "a4":
				paircheck2 = shown[3][0];
				break;
			case "b4":
				paircheck2 = shown[3][1];
				break;
			case "c4":
				paircheck2 = shown[3][2];
				break;
			case "d4":
				paircheck2 = shown[3][3];
				break;
			case "e4":
				paircheck2 = shown[3][4];
				break;
			case "f4":
				paircheck2 = shown[3][5];
				break;
			case "g4":
				paircheck2 = shown[3][6];
				break;
			case "h4":
				paircheck2 = shown[3][7];
				break;
			case "i4":
				paircheck2 = shown[3][8];
				break;
			case "j4":
				paircheck2 = shown[3][9];
				break;
			case "k4":
				paircheck2 = shown[3][10];
				break;
			case "l4":
				paircheck2 = shown[3][11];
				break;
			case "m4":
				paircheck2 = shown[3][12];
				break;
		}
		boolean pair;
		
		if(paircheck.substring(1,2).equals(paircheck2.substring(1,2))){
			pair=true;
		}else{
			pair=false;
		}

		return pair;
	}
	
	public static void mapUp(String[][]changed){
		System.out.println(" a   b   c   d   e   f   g   h   i   j   k   l   m");
		System.out.println("----------------------------------------------------");
		int i = 1;

		for(int r=0;r<4;r++){
			
			for(int c = 0; c<13;c++){
				System.out.print(changed[r][c]);
			}
			System.out.println("| "+i);
			i++;
		}
	}
	

  public static void main(String[] args) {
		String map[][]=new String[4][13];
		System.out.println(" a   b   c   d   e   f   g   h   i   j   k   l   m");
		System.out.println("----------------------------------------------------");
		int i = 1;

		for(int r=0;r<4;r++){
			
			for(int c = 0; c<13;c++){
				map[r][c]="[ ] ";
				System.out.print(map[r][c]);
			}
			System.out.println("| "+i);
			i++;
		}



		/*public static String[][] saved(){
		

		return savedarray;
		}*/







		Scanner scan = new Scanner(System.in);
		boolean win=false;
		boolean turn1 = true;
		String MAP[][];
		MAP = randomstart();
		int player1s=0;
		int player2s=0;
		

		String cur[][] = new String[4][13];
		String MAPorg[][];
		MAPorg=Org();
		String saved[][]=new String[4][13];

		saved = checker(MAP,Org(),"ignore");
		
		while(win==false){
			if(turn1){
				System.out.println();
				System.out.println("------------------------------------- Player 1 ------------------------------------- ");System.out.println();
			}else {
				System.out.println();
				System.out.println("-------------------------------------Player 2 -------------------------------------");
				System.out.println();
			}
			
			

			System.out.println("Enter in a value (Value 1): ");
			
			String m1 = scan.nextLine();

			
			
			mapUp(checker(MAP,MAPorg,m1));
			
		
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("-----------------");
			System.out.println("Enter in a value (Value 2): ");
			String m2 = scan.nextLine();
			mapUp(checker(MAP,MAPorg,m2));
			


			if(m1.equals(m2)){
				System.out.println("You cannot input the same values, your turn is skipped.");
				
				MAPorg=Org();
			}else{
				System.out.println(pair(checker(MAP,MAPorg,m2),m1,m2));
			if(pair(checker(MAP,MAPorg,m2),m1,m2)==true){

				
				if(turn1==true){
					player1s++;
					System.out.println("Player 1 has a score of "+player1s);
					saved=checker(MAP,saved,m1);
					saved=checker(MAP,saved,m2);
					turn1=true;
				}else{
					player2s++;
					System.out.println("Player 2 has a score of "+player2s);
					saved=checker(MAP,saved,m1);
					saved=checker(MAP,saved,m2);
					turn1=true;
				}

			}else if(player2s==0&&player1s==0){
				MAPorg=Org();
				turn1=!turn1;
			}else{
				MAPorgsave(saved,MAPorg,m1,m2);
				turn1=!turn1;
			}

			if (MAPorg == MAP){
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("Player 1 got: "+player1s);
				System.out.println("Player 2 got: "+player2s);
				win=true;
			}
			System.out.println();
			System.out.println();
			System.out.println();

			
			
			/*
			for(int r=0;r<4;r++){
				
				for(int c = 0; c<13;c++){
					System.out.print(MAP[r][c]);
				}
				System.out.println();
			}
			*/
				
			}
		}
  }
}