import java.awt.Color;
import java.util.Random;
public class Player{
	String playerName;
	int playerId;
	int rank;
	int money;
	int credits;
	room currentRoom;
	boolean hasRole;
	roles currentRole;
   boolean hasMoved;
   Color playerColor;
   
   public Player(String name, int val, room start,Color color){
      rank = 1;
      playerName = name;
      playerId = val;
      currentRoom = start;
      hasMoved = false;
      playerColor = color;
   }
   public int getPlayerId(){
      return this.playerId;
   }
	public String getplayerName(){
      return this.playerName;
   }
   public void setRank(int rank){
      this.rank = rank;
   }
   public int getRank(){
      return this.rank;
   }
   public void setMoney(int money){
      this.money = money;
   }
   public int getMoney(){
      return this.money;
   }
   public void addMoney(int money){
      this.money += money;
   }
   public void setCredits(int credits){
      this.credits = credits;
   }
   public int getCredits(){
      return this.credits;
   }
   public void addCredits(int credits){
      this.credits += credits;
   }
   public int calcScore(){
		return (this.rank * 5) + this.money + this.credits;
	}
   public room getcurrentRoom(){
      return this.currentRoom;
   }
	public void movePlayer(room room){
      this.currentRoom = room;
      hasMoved = true;
      if(currentRoom.spaceId != 0 && currentRoom.spaceId != 6){
         if(currentRoom.roomScene.sceneCard.cardState == 0){
            currentRoom.roomScene.sceneCard.setCardState(1);
         }
      }
	}
	
	public void changeRole(roles role){
		if(this.hasRole == false){
         this.hasRole = true;
         this.currentRole = role;
         role.setroleTaken();
         addPlayer();
      }
      else{
         this.hasRole = false;
      }   
	}
   public roles getRole(){
      return this.currentRole;
   }
   public void sethasRole(boolean set){
      this.hasRole = set;
   }
   public boolean checkRole(){
      return this.hasRole;
   }
	public boolean act(int rehearseScore,int budget){
      Random rand = new Random();
      int roll = 0;
      roll = 1 + rand.nextInt((6 - 1) + 1);
      if(roll+currentRole.getRehearse() >= budget){
         return true;
      }
      else{
         return false;
      }
	}
   public void actOutcome(boolean pass){
      if(pass){    
         if(currentRole.checkonCard() == true){
            addCredits(2);
            currentRoom.roomScene.changeShotCounter();
         }  
         else if(currentRole.checkonCard() == false){
            addMoney(1);
            addCredits(1);
            currentRoom.roomScene.changeShotCounter();
         }
      }
      else if(currentRole.checkonCard() == false){
         addMoney(1);
      }
   }	
   
   public void addPlayer(){
      currentRoom.roomScene.playersinScene.add(this);
   }  
   
}