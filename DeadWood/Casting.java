import java.util.Arrays;

public class Casting{
   int[] dollarCost = {4,10,18,28,40};
	int[] creditCost = {5,10,15,20,25};
   
	public void upgrade(Player currentPlayer, int uprank, int currency){
	   if(currency == 0){
         currentPlayer.setMoney(currentPlayer.getMoney() - dollarCost[uprank]);
         currentPlayer.setRank(uprank);
      }
      else if(currency == 1){
         currentPlayer.setCredits(currentPlayer.getCredits() - creditCost[uprank]);
         currentPlayer.setRank(uprank);
      }
	}
   public int getdollarCost(int x){
      return dollarCost[x];
   }
   public int getcreditCost(int y){
      return creditCost[y];
   }   
   public void displayCost(){
      int[][] costChart = {{2,3,4,5,6},{4,10,18,28,40}, {5,10,15,20,25}};
      System.out.println("Costs");
      System.out.println("Level    " + Arrays.toString(costChart[0]));
      System.out.println("Dollars " + Arrays.toString(costChart[1]));
      System.out.println("Credits " + Arrays.toString(costChart[2]));
   }
}