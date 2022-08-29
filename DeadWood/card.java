public class card{
   String cardName;
	int cardId;
	roles[] cardRoles = new roles[3];
	boolean cardUsed;
	int cardState;
   int budget;
   
   public card(String name, int budget, int id){
      cardId = id;
      this.budget = budget;
      this.cardName = name;
   }
   public int getBudget(){
      return budget;
   }
   public void setCardUsed(){
      this.cardUsed = true;
   }
   public boolean checkUsed(){
      return this.cardUsed;
   }
   public void setCardState(int state){
      this.cardState = state;
   }
   public int getcardState(){
      return this.cardState;
   }
   public void addRoles(roles newRoles,int q, int num){
      cardRoles[q] = newRoles;
      newRoles.setonCard();
   }
   public roles[] getcardRoles(){
      return this.cardRoles;
   }
   public roles getcardRole(int roleNum){
      return cardRoles[roleNum];
   }
   public void printRoles(int sceneRoleCount){
      for(int i = 0; i < cardRoles.length && cardRoles[i] != null;i++){   
         System.out.print((i + sceneRoleCount)+" ");
         System.out.print(cardRoles[i].roleName);
         if(cardRoles[i].roleTaken){
            System.out.print("   TAKEN");
         }
         System.out.print("    ");
         System.out.print("Rank:");
         System.out.println(cardRoles[i].roleRank);   
      }
   }
}