import java.util.*;
public class Map{
	public int width;//not really necessary but quality of life later
	public int height;//not really necessary but quality of life later
	public String player; //to print "P1" or "P2" on the map
	public String[][]map;//map
	public int distance1;//distances to room 1
  public int distance2;//distances to room 2
  public int distance3;//etc
  public int distance4;
  public int distance5;
  public int distance6;
	public int[] savePlace = new int[2]; //the saved last position of player when he goes into room
	public int[] arry = {99,99};//aray of players coordinates in 2d array arry[0] will be the player's row and arry[1] will be player's column

	public Map(int width, int height,String player){
		this.width=width;
		this.height=height;
		this.player=player;
		map=new String[width][height];
	}//constructor


	public int[] search(){	//searches for the player string "P1" or "P2" or "P3" stored in player variable
		for(int i = 0;i<width;i++){
			for(int j= 0; j<height;j++){
				if(map[i][j].equals(player)){
					arry[0]=i;
					arry[1]=j;
					savePlace[0] = arry[0]; // saveplace is an array that stores the last known location of the player, just in case the player is inside a room and they are not found on the map
					savePlace[1]=arry[1];
					return arry;
				}
			}
		}
		return savePlace;
	}
	public boolean searchHidden(){	//to see if player is in a room ^^
		for(int i = 0;i<width;i++){
			for(int j= 0; j<height;j++){
				if(map[i][j].equals(player)){
					return false;
				}
			}
		}
		return true;
	}
	public void placePlayer(){//places the player on the map at the players last known location before entering a room
		
		map[savePlace[0]][savePlace[1]]=player;
	}
	public void movePlayerCoord(int[] ary,String direction){//moves the player direction
		int rowY=ary[0];
		int colX=ary[1];
		switch(direction){
			case "up":
				savePlace[0]=rowY;
				savePlace[1]=colX;
				if(searchHidden()){
					map[savePlace[0]][savePlace[1]]=player;
				}
				rowY--;
				map[rowY][colX]=map[rowY+1][colX];
				map[rowY+1][colX]="00";
			break;
			case "down":
				savePlace[0]=rowY;
				savePlace[1]=colX;
				if(searchHidden()){
					map[savePlace[0]][savePlace[1]]=player;
				}
				rowY=rowY+1;
				map[rowY][colX]=map[rowY-1][colX];
				map[rowY-1][colX]="00";
			break;
			case "right":
			savePlace[0]=rowY;
				savePlace[1]=colX;
				if(searchHidden()){
					map[savePlace[0]][savePlace[1]]=player;
				}
				colX=colX+1;
				
				map[rowY][colX]=map[rowY][colX-1];
				map[rowY][colX-1]="00";
			break;
			case "left":
				savePlace[0]=rowY;
				savePlace[1]=colX;
				if(searchHidden()){
					map[savePlace[0]][savePlace[1]]=player;
				}
				colX--;	
					
				map[rowY][colX]=map[rowY][colX+1];
				map[rowY][colX+1]="00";
			break;
		}
		map[0][0]="R1";
		map[0][5]="R2";
		map[0][10]="R3";//sets up rooms
		map[4][0]="R4";
		map[4][5]="R5";
		map[4][10]="R6";
		
	}
	public void printDistance(){//finding distance from players to rooms
		distance1 = Math.abs(search()[0] - 0) + Math.abs(search()[1] - 0);
		System.out.println("Distance to Room 1: "+distance1);
		distance2 = Math.abs(search()[0] - 0) + Math.abs(search()[1] - 5);
		System.out.println("Distance to Room 2: "+distance2);
		distance3 = Math.abs(search()[0] - 0) + Math.abs(search()[1] - 10);
		System.out.println("Distance to Room 3: "+distance3);
		distance4= Math.abs(search()[0] - 4) + Math.abs(search()[1] - 0);
		System.out.println("Distance to Room 4: "+distance4);
		distance5= Math.abs(search()[0] - 4) + Math.abs(search()[1] - 5);
		System.out.println("Distance to Room 5: "+distance5);
		distance6= Math.abs(search()[0] - 4) + Math.abs(search()[1] - 10);
		System.out.println("Distance to Room 6: "+distance6);
		System.out.println("----------------");
	}
	public void setDistance(){//setting distance from players to rooms
		distance1 = Math.abs(search()[0] - 0) + Math.abs(search()[1] - 0);//formulas
		
		distance2 = Math.abs(search()[0] - 0) + Math.abs(search()[1] - 5);
		distance3 = Math.abs(search()[0] - 0) + Math.abs(search()[1] - 10);
		distance4= Math.abs(search()[0] - 4) + Math.abs(search()[1] - 0);
		distance5= Math.abs(search()[0] - 4) + Math.abs(search()[1] - 5);
		distance6= Math.abs(search()[0] - 4) + Math.abs(search()[1] - 10);
	}
	public void editMap(String room, int distance){
		//edits the map using movement method "distance" parameter is the dice roll
		room=room.toLowerCase();
		int count =0;
		int row=search()[0];
		int col = search()[1];
		label1: switch(room){
			case "room 1":
			if(search()[1]==0){
				while(search()[0]!=0){
					movePlayerCoord(search(),"up");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else if(search()[0]==0){
				while(search()[1]!=0){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else{
				while(search()[1]!=0){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[0]!=0){
					movePlayerCoord(search(),"up");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}
			

			break;
			case "room 2":
			if(search()[1]==5){
				while(search()[0]!=0){
					movePlayerCoord(search(),"up");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else if(search()[0]==0){
				while(search()[1]>5){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[1]<5){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else{
				while(search()[1]>5){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[1]<5){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[0]!=0){
					movePlayerCoord(search(),"up");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}

			break;


			case "room 3":
			if(search()[1]==10){
				while(search()[0]!=0){
					movePlayerCoord(search(),"up");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else if(search()[0]==0){
				while(search()[1]!=10){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else{
				while(search()[1]!=10){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[0]!=0){
					movePlayerCoord(search(),"up");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}

			
			break;

			case "room 4":


			if(search()[1]==0){
				while(search()[0]!=4){
					movePlayerCoord(search(),"down");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else if(search()[0]==4){
				while(search()[1]!=0){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else{
				while(search()[1]!=0){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[0]!=4){
					movePlayerCoord(search(),"down");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}
			break;



			case "room 5":
			if(search()[1]==5){
				while(search()[0]!=4){
					movePlayerCoord(search(),"down");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else if(search()[0]==4){
				while(search()[1]>5){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[1]<5){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else{
				while(search()[1]>5){
					movePlayerCoord(search(),"left");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[1]<5){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[0]!=4){
					movePlayerCoord(search(),"down");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}
			
			
			break;
			case "room 6":
	
			if(search()[1]==10){
				while(search()[0]!=4){
					movePlayerCoord(search(),"down");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else if(search()[0]==4){
				while(search()[1]!=10){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}else{
				while(search()[1]!=10){
					movePlayerCoord(search(),"right");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
				while(search()[1]!=4){
					movePlayerCoord(search(),"down");
					count++;
					if(count==distance){
						count=0;
						break label1;
					}
				}
			}
			
			break;
		}
	}

	public void setMap(){ //sets up map initially, fills all coords
		for(int i = 0;i<width;i++){
			for(int j= 0; j<height;j++){
				map[i][j]="00";
			}
		}
		map[0][0]="R1";
		map[2][2]=player;
		map[0][5]="R2";
		map[0][10]="R3";
		map[4][0]="R4";
		map[4][5]="R5";
		map[4][10]="R6";
	}
	public void printMap(){//prints map
		for(int i = 0;i<width;i++){
			for(int j= 0; j<height;j++){
				System.out.print("["+map[i][j]+"] ");
			}
			System.out.println();
		}
	}


	public int getDistance1() {
        return distance1;
    }

    public void setDistance1(int distance1) {
        this.distance1 = distance1;
    }

    public int getDistance2() {
        return distance2;
    }

    public void setDistance2(int distance2) {
        this.distance2 = distance2;
    }

    public int getDistance3() {
        return distance3;
    }

    public void setDistance3(int distance3) {
        this.distance3 = distance3;
    }

    public int getDistance4() {
        return distance4;
    }

    public void setDistance4(int distance4) {
        this.distance4 = distance4;
    }

    public int getDistance5() {
        return distance5;
    }

    public void setDistance5(int distance5) {
        this.distance5 = distance5;
    }

    public int getDistance6() {
        return distance6;
    }

    public void setDistance6(int distance6) {
        this.distance6 = distance6;
    }
	
}