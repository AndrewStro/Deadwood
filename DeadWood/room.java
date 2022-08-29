import java.util.Arrays;

public class room{
	int spaceId;
	room[] nearRooms;
   scene roomScene;
   
   public room(int id){
      spaceId = id;
   }
	public int getspaceId(){
      return this.spaceId;
   }
	public void setnearRooms(room[] Ids){
		this.nearRooms = Ids;
	}
   
   public room[] getNearRooms(){
      return nearRooms;
   }
   public void setroomScene(scene scene){
      this.roomScene = scene;
	}
   public scene getroomScene(){
      return roomScene;
   }
   public void printRooms(){
      for(int i = 0; i< nearRooms.length; i++){
         System.out.print(nearRooms[i].spaceId + " ");
      }
      System.out.println();
   }   
}