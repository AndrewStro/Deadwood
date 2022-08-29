public class roles{
   String roleName;
	int roleRank;
	boolean onCard;
	boolean roleTaken;
   int rehearse;

   public roles(String name, int rank){
      roleName = name;
   	roleRank = rank;
      roleTaken = false;
      rehearse = 0;
      }
   public String getroleName(){
      return this.roleName;
   }
   public int getRoleRank(){
      return this.roleRank;
   }
   public void setroleTaken(){
      this.roleTaken = true;
   }
   public boolean getroleTaken(){
      return this.roleTaken;
   }
   public void rehearsal(){
      rehearse += 1;
   }
   public int getRehearse(){
      return this.rehearse;
   }      
   public boolean checkonCard(){
      return this.onCard;
   }
   public void setonCard(){
      this.onCard = true;
   }
}
