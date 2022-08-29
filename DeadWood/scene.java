import java.util.Arrays;
import java.util.ArrayList;
public class scene{
   String sceneName;
	room sceneRoom;
	int counters;
   int maxCounters;
	roles[] sceneRoles; 
	card sceneCard;
   
   boolean wrapped = false;
   
   ArrayList<Player> playersinScene = new ArrayList<>(); 
     
   public static final int UNFLIPPED = 0;
   public static final int FLIPPED = 1;
   public static final int REMOVED = 2;
   
   public scene(String name, int max, room location){
      sceneName = name;
      maxCounters = max;
      counters = maxCounters;
      sceneRoom = location; 
   }
   public String getsceneName(){
      return this.sceneName;
   }
   public void changeShotCounter(){
      counters = counters - 1;      
      if(counters == 0){
         //wrap scene
         wrap(playersinScene);
         sceneCard.setCardState(REMOVED);
         counters = maxCounters;
         wrapped = true;
      }      
	}   
	public void resetShotCounter(){
      counters = maxCounters;
   }	
   public int getCounters(){
      return this.counters;
   }
   public int getmaxCounters(){
      return this.maxCounters;
   }
   public void setRoles(roles role1, roles role2){   
      roles[] newRole = {role1,role2};
      sceneRoles = newRole;
   }
   
   public void setRoles(roles role1, roles role2, roles role3){
      roles[] newRole = {role1,role2, role3};
      sceneRoles = newRole;
   }
   
   public void setRoles(roles role1, roles role2, roles role3, roles role4){
      roles[] newRole = {role1,role2,role3,role4};
      sceneRoles = newRole;
   }
   public roles[] getsceneRoles(){
      return sceneRoles;
   }
   public roles getRole(int roleNum){
      return sceneRoles[roleNum];
   }   
   public void setCard(card newCard){
      sceneCard = newCard;
      sceneCard.setCardState(UNFLIPPED);
   }   
   public card getCard(){
      return sceneCard;
   }   
  /* public void addPlayer(Player player){
      playersinScene.add(player);
   }*/   
   private void wrap(ArrayList<Player> players){         
      int cardPlayerNum;
      int j = 0;
      int k = 0;
      int a = 0;
      int b = 0;
      //determine who is on the card and who is not
      for(int i = 0; i < playersinScene.size(); i++){
         if(playersinScene.get(i).currentRole.onCard == true){            
            j++;
         }
         else{
            k++;
         }
      }
      Player[] lead = new Player[j];
      Player[] extra = new Player[k];
      for(int z = 0; z < playersinScene.size(); z++){
         if(playersinScene.get(z).currentRole.onCard == true){
            lead[a] = playersinScene.get(z);            
            a++;
         }
         else{
            playersinScene.get(z).currentRole.rehearse = 0;
            playersinScene.get(z).currentRole.roleTaken = false;
            extra[b] = playersinScene.get(z);
            b++;
         }
      }
      if(j>1){      
         int[] leadRanks = new int[j];
         for(int y = 0; y < j;y++){
            leadRanks[y] = lead[y].currentRole.roleRank;
         }      
         Arrays.sort(leadRanks);      
         Player[] sortedLead = new Player[j];      
         for(int g = 0; g < j; g++){
            for(int r = 0; r < j; r++){
               if(leadRanks[g] == lead[r].currentRole.roleRank){
                  sortedLead[g] = lead[r];
               }
            }
         }      
         lead = sortedLead;      
      }            
      //determine number of on card players
      cardPlayerNum = lead.length;      
      if(cardPlayerNum > 0){
      //roll dice
         Dice pay = new Dice(sceneCard.getBudget());
         pay.rollDice();      
         //sort dice
         pay.sortDice();      
         //distribute wealth to on card players
         int wealth[] = pay.getRolls();      
         j = lead.length;
         for(int i = wealth.length-1; i >= 0 ; i--){
            lead[j-1].addMoney(wealth[i]);
            j--;
            if(j == 0){
               j=lead.length;
            }
         }      
      //Pay extras
         for(int i = 0; i < extra.length; i++){
            extra[i].addMoney(extra[i].currentRole.roleRank);
         }
      }
      for(int p = 0; p < playersinScene.size(); p++){
         //playersinScene.get(p).currentRole = null;
         //playersinScene.get(p).hasRole = false;
         playersinScene.get(p).changeRole(null);
         playersinScene.get(p).sethasRole(false);   
      }
      
      playersinScene.clear();
      //reset cards
      
      System.out.println(this.sceneName + " has wrapped");
      
   }   
   public void printScene(){
      for(int i = 0; i< sceneRoles.length; i++){      
         System.out.print(i+" ");
         System.out.print(sceneRoles[i].roleName);
         if(sceneRoles[i].roleTaken){
            System.out.print("   TAKEN");
         }
         System.out.print("    ");
         System.out.print("Rank:");
         System.out.println(sceneRoles[i].roleRank);
      }
   }   
}