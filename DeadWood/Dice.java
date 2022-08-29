import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
public class Dice{
   int numRolls;
	int[] rolls;
	
   public Dice(int dicenum){
      numRolls = dicenum;
      rolls = new int[dicenum];
   }
	public void rollDice(){
      for(int x = 0; x < numRolls; x++){
         Random rand = new Random();
         rolls[x] = 1 + rand.nextInt((6 - 1) + 1);
      }
	}
	public void sortDice(){
		Arrays.sort(this.rolls);
	}
   public int[] getRolls(){
      return rolls;
	}
}