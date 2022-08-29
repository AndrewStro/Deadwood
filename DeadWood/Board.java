import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import org.w3c.dom.Document;
public class Board{
	int currentDay;
	int maxDays;
	int numPlayers;
   
   int wrapCount = 0;
   
   boolean end;
   ArrayList<Player> playerList = new ArrayList<>();
	Player currentPlayer;
   room Trailer;
   room[] layout = new room[12];
   card[] deck = new card[40];
   Casting cOffice = new Casting();

   public Board(int playernum){
      numPlayers = playernum;
      currentDay = 1;
      end = false;
      if(playernum <=3){
         maxDays = 3;
      }
      else{
         maxDays = 4;
      }
   }
   public int getnumPlayers(){
      return numPlayers;
   }
   public int getmaxDays(){
      return maxDays;
   }
   public Player getcurrentPlayer(){
      return currentPlayer;
   }
   //Builds scenes and roles
   public void buildBoard(){
      for( int x = 0; x < 12; x++){
         layout[x] = new room(x);
      }
      room[] near0 = {layout[1], layout[2], layout[11]};
      layout[0].setnearRooms(near0);   
      Trailer = layout[0];    
      room[] near1 = {layout[0], layout[2], layout[3]};
      layout[1].setnearRooms(near1);
      scene scene1= new scene("Main street", 3, layout[1]);
      roles role1 = new roles("Railroad Worker", 1);
      roles role2 = new roles("Falls off Roof", 2);
      roles role3 = new roles("Woman in Black Dress", 2);
      roles role4 = new roles("Mayor McGinty", 4);
      scene1.setRoles(role1, role2, role3, role4);
      scene1.setCard(randCard());
      layout[1].setroomScene(scene1);
   //
      room[] near2 = {layout[0], layout[1], layout[4], layout[9]};
      layout[2].setnearRooms(near2);
      scene scene2= new scene("Saloon", 2, layout[2]);
      roles role2_1 = new roles("Reluctant Farmer", 1);
      roles role2_2 = new roles("Woman in Red Dress", 2);
      scene2.setRoles(role2_1,role2_2);
      scene2.setCard(randCard());
      layout[2].setroomScene(scene2);
      //
      room[] near3 = {layout[1], layout[4], layout[5]};
      layout[3].setnearRooms(near3);
      scene scene3= new scene("Jail", 1, layout[3]);
      roles role3_1 = new roles("Prisoner in Cell", 2);
      roles role3_2 = new roles("Feller in Irons", 3);
      scene3.setRoles(role3_1, role3_2);
      scene3.setCard(randCard());
      layout[3].setroomScene(scene3);
      //
      room[] near4 = {layout[2], layout[3], layout[5],layout[8]};
      layout[4].setnearRooms(near4);
      scene scene4= new scene("General Store", 2, layout[4]);
      roles role4_1 = new roles("Man in Overalls", 1);
      roles role4_2 = new roles("Mister Keach", 3);
      scene4.setRoles(role4_1, role4_2);
      scene4.setCard(randCard());
      layout[4].setroomScene(scene4);
      //
      room[] near5 = {layout[3], layout[4],layout[6]};
      layout[5].setnearRooms(near5);
      scene scene5= new scene("Train Station", 3, layout[5]);
      roles role5_1 = new roles("Dragged by Train", 1);
      roles role5_2 = new roles("Crusty Prospector", 1);
      roles role5_3 = new roles("Preacher with Bag", 2);
      roles role5_4 = new roles("Cyrus the Gunfighter", 4);
      scene5.setRoles(role5_1, role5_2, role5_3, role5_4);
      scene5.setCard(randCard());
      layout[5].setroomScene(scene5);
      //
      room[] near6 = {layout[5], layout[7], layout[8]};
      layout[6].setnearRooms(near6);
      
      //
      room[] near7 = {layout[6], layout[8], layout[10]};
      layout[7].setnearRooms(near7);
      scene scene7= new scene("Secret Hideout", 3, layout[7]);
      roles role7_1 = new roles("Clumsy Pit Fighter", 1);
      roles role7_2 = new roles("Thug with Knife", 2);
      roles role7_3 = new roles("Dangerous Tom", 3);
      roles role7_4 = new roles("Penny, who is Lost", 4);
      scene7.setRoles(role7_1, role7_2, role7_3, role7_4);
      scene7.setCard(randCard());
      layout[7].setroomScene(scene7);
      //
      room[] near8 = {layout[4], layout[6], layout[7],layout[9]};
      layout[8].setnearRooms(near8);
      scene scene8= new scene("Ranch", 2, layout[8]);
      roles role8_1 = new roles("Shot in Leg", 1);
      roles role8_2 = new roles("Saucy Fred", 2);
      roles role8_3 = new roles("Man Under Horse", 3);
      scene8.setRoles(role8_1, role8_2, role8_3);
      scene8.setCard(randCard());
      layout[8].setroomScene(scene8);
      //
      room[] near9 = {layout[2], layout[8], layout[10],layout[11]};
      layout[9].setnearRooms(near9);
      scene scene9= new scene("Bank", 1, layout[9]);
      roles role9_1 = new roles("Suspicious Gentleman", 2);
      roles role9_2 = new roles("Flustered Teller", 3);
      scene9.setRoles(role9_1, role9_2);
      scene9.setCard(randCard());
      layout[9].setroomScene(scene9);
      //
      room[] near10 = {layout[7], layout[9], layout[11]};
      layout[10].setnearRooms(near10);
      scene scene10 = new scene("Church", 2, layout[10]);
      roles role10_1 = new roles("Dead Man", 1);
      roles role10_2 = new roles("Crying Woman", 2);
      scene10.setRoles(role10_1, role10_2);
      scene10.setCard(randCard());
      layout[10].setroomScene(scene10);
      //
      room[] near11 = {layout[0], layout[9], layout[10]};
      layout[11].setnearRooms(near11);
      scene scene11= new scene("Hotel", 3, layout[11]);
      roles role11_1 = new roles("Faro Player", 1);
      roles role11_2 = new roles("Sleeping Drunkard", 1);
      roles role11_3 = new roles("Falls from Balcony", 2);
      roles role11_4 = new roles("Australian Bartender", 3);
      scene11.setRoles(role11_1, role11_2, role11_3, role11_4);
      scene11.setCard(randCard());
      layout[11].setroomScene(scene11);
   }
   public Casting getCasting(){
      return cOffice;
   }
   public room getTrailer(){
      return Trailer;
   }
   public room getRoom(int num){
      return layout[num];
   }
   public void buildDeck(){
      Document doc = null;
      ParseXML parsing = new ParseXML();
      try{      
         doc = parsing.getDocFromFile("cards.xml");
         this.deck = parsing.readBookData(doc);      
      }
      catch (Exception e){      
         System.out.println("Error = "+e);      
      }    
   }
   public card randCard(){
      boolean repeat = true;
      while (repeat == true){
         Random rand = new Random();
         int cardNum = rand.nextInt(40);
         if(deck[cardNum].checkUsed() == false){
            deck[cardNum].setCardUsed();
            return deck[cardNum];
         }
         else{
            repeat = true;
         }
      }
      return null;
   }
   public void setplayerList(ArrayList<Player> players){
      playerList = players;
      if(numPlayers == 5){
         for(Player p : playerList){
            p.setCredits(2);
         }
      }
      else if(numPlayers == 6){
         for(Player p : playerList){
            p.setCredits(4);
         }
      }
      else if(numPlayers < 9 && numPlayers > 6){
         for(Player p : playerList){
            p.setRank(2);
         }
      }
      currentPlayer = playerList.get(0);
   }
	public void nextDay(){
      if (currentDay == maxDays){
         endGame();
      }
      else{
         for(int x = 0; x < numPlayers; x++){
            playerList.get(x).movePlayer(Trailer);
            playerList.get(x).hasRole = false;
            playerList.get(x).currentRole = null;
         }
		   currentDay = currentDay + 1;      
      //set cards
      
      //set counters
         for(int y = 1; y < layout.length; y++){
            if(y != 6){
               layout[y].roomScene.resetShotCounter();
               layout[y].roomScene.setCard(randCard());
            }
         }
         System.out.println("It is now day " + currentDay + " of " + maxDays);
      }
	}
   public void nextPlayer(){
      if(currentPlayer.getPlayerId() < numPlayers-1){
         currentPlayer = playerList.get(currentPlayer.getPlayerId() + 1);
      }
      else{
         currentPlayer = playerList.get(0);
      }
      currentPlayer.hasMoved = false;
   }
   public boolean getEnd(){
      return end;
   } 
	public void endGame(){
      int[] score = new int[numPlayers];
      int count = 0;
		for (int x = 0; x < numPlayers; x++){      
         Player current = playerList.get(x);
         score[x] = -1 * current.calcScore();
      }
      Arrays.sort(score);
      for(int y = 0; y < numPlayers; y++){
         for(int q = 0; q < numPlayers; q++){
            if(playerList.get(q).calcScore() == score[y] * -1){
               if(count < score.length){
                  System.out.println(playerList.get(q).getplayerName() +"'s score is "+ score[y] * -1);
                  count +=1;
               }
            }
	      }
      }
      end = true;
      System.out.println("GAME OVER");
   }
}