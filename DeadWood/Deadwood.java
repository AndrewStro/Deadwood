import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Deadwood{

public static final String[] Players = {"2","3","4","5","6","7","8"};
   public static void main(String[] args){
      /*try{
         int check = Integer.parseInt(args[0]);
      }
      catch (NumberFormatException nfe){
         System.out.println("Please enter an integer");
         System.exit(1);
      }
      if(args.length > 1){
         System.out.println("Please only enter one argument");
         System.exit(1);
      }*/
      JFrame frame = new JFrame("DeadWood");
      String input = (String) JOptionPane.showInputDialog(frame,
      "How many Players?",
      "DeadWood",
      JOptionPane.QUESTION_MESSAGE,
      null,
      Players,
      Players[0]);
      if(input == null){
         System.exit(1);
      }
      int players = Integer.parseInt(input);
      
      Board game = new Board(players);
      game.buildDeck();
      game.buildBoard();
      
      initializeGame(game, players);
      //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
      Buttons buttons = new Buttons(game);        
      buttons.setVisible(true);
      //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
      
      
      
      //initializeGame(game, players);
      
      //playerTurn(game);
   }




   public static void initializeGame(Board game,int players){
   Color[] playercolors = new Color[8];
   playercolors[0] = new Color(255,0,0);
   playercolors[1] = new Color(0,0,255);
   playercolors[2] = new Color(0,255,0);
   playercolors[3] = new Color(0,255,255);
   playercolors[4] = new Color(255,165,0);
   playercolors[5] = new Color(255,192,203);
   playercolors[6] = new Color(128,0,128);
   playercolors[7] = new Color(255,255,0);
      ArrayList<Player> getPlayers = new ArrayList<>();
      JPanel Players = new JPanel();
      Players.setLayout(new GridLayout(0,9));
      JTextField[] Player = new JTextField[players];
      for(int i=0; i < players; i++){
         Player[i] = new JTextField(10);
         //JPanel Players = new JPanel();
         Players.add(new JLabel("Player "+(i+1)+" Name"));
         Players.add(Player[i]);
         Players.add(Box.createHorizontalStrut(15));
      
      }
      int result = JOptionPane.showConfirmDialog(null, Players,
      "Please enter Player Names", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         for(int j =0; j<players; j++){
            getPlayers.add(new Player(Player[j].getText(),j, game.getTrailer(), playercolors[j]));
         }
         game.setplayerList(getPlayers);
      }
      else{
         System.exit(1);
      }

   }
/*
   public static void playerTurn(Board game){
   Scanner input = new Scanner(System.in);
   
   int wrapCount = 0;
   boolean roleSelected = false;
   boolean hasMoved = false;
   boolean acted = false;
   
      while(!game.getEnd()){
      
      if(wrapCount == 9){
         game.nextDay();
         wrapCount = 0;
      }
      /*else{
    
         System.out.println("Current Player is " + game.getcurrentPlayer().getplayerName());
         System.out.println("Actions: look near map move role act stat rehearse upgrade end");
         System.out.println("Type guide for explanations of actions");
         Player temp = game.getcurrentPlayer();
         String playerInput = input.next();
         int playerInt = 0;
         
         room[] near;
         roles[] onSpace;
         roles[] onCard;
         
                  
         
         
               
         
         
                  
                 
         if(playerInput.equals("move") && (hasMoved || temp.checkRole())){
            System.out.println("You are unable to move right now");
         }
         
         if(playerInput.equals("move") && !hasMoved && !temp.checkRole()){
         boolean back = false;
         int found = 0;
         boolean valid = false;
         System.out.println("Select a room");         
         while(!valid && !back){
         near = temp.getcurrentRoom().getNearRooms();
            //pick room
            System.out.println("The valid rooms are");
            temp.getcurrentRoom().printRooms();

            
            Scanner room = new Scanner(System.in);
           
            if(room.hasNextInt()){
            playerInt = room.nextInt();
            
            //check if the input is an int
             
            for(int i = 0; i < near.length; i++){
               if(playerInt == near[i].getspaceId()){
                  //System.out.println("Hi ");
                  found = i;
                  valid = true;
               } 
            } 
            
            if(valid){
            //move to room
            temp.movePlayer(near[found]);
            if(playerInt != 0 && playerInt != 6){
               if(temp.currentRoom.roomScene.sceneCard.cardState != 2){
               temp.currentRoom.roomScene.sceneCard.setCardState(1);
               }
            }
            System.out.println("You moved to room: " + near[found].spaceId);
            hasMoved = true;
            }          
            else{
            //ask again
            System.out.println("That is not a valid room.");
            }
            }
            else if(room.next().equals("back")){
            back = true;
            }
            else{
            System.out.println("Enter a valid integer");
            }
         }
            
         }
         
         
         
         
         
         //tell players they have moved
         if(playerInput.equals("act") && temp.hasRole){
        
         //while(!acted){
         //acted = true;
         //if(temp.hasRole == true){
         scene currentScene = temp.getcurrentRoom().getroomScene();
         roles role = temp.getRole();
         if(temp.act(role.getRehearse(), currentScene.getCard().getBudget())){
         
         if(role.checkonCard() == true){
         System.out.println("You gain 2 credits");
         temp.addCredits(2);
         currentScene.changeShotCounter();
         System.out.println("You now have " + temp.credits + " credits");
         acted = true;
         }
         
         else if(role.checkonCard() == false){
         System.out.println("You gain 1 dollar and 1 credit");
         temp.addMoney(1);
         temp.addCredits(1);
         currentScene.changeShotCounter();
         System.out.println("You now have " + temp.money +" dollars and "+ temp.credits + " credits");
         acted = true;
         }
         
         }
         else if(role.checkonCard() == false){
         System.out.println("You gain 1 dollar");
         temp.addMoney(1);
         }
         else if(role.checkonCard() == true){
         System.out.println("You gain nothing");
         }
         if(!roleSelected && currentScene.getCard().getcardState() != 2){
            temp.sethasRole(true);
            
            game.nextPlayer();
            hasMoved = false;
            roleSelected = false;
            }
            else if(currentScene.getCard().getcardState() == 2 && acted){
            game.nextPlayer();
            hasMoved = false;
            roleSelected = false;
            }

         }
         else if(playerInput.equals("act") && !temp.checkRole()){
         System.out.println("You cannot act");
         
         }
         //acted = true;
         //}
         //else{
         //System.out.println("You have already acted this turn");
         //}
         //}
         
         
         
         
         
         if(playerInput.equals("rehearse")&& temp.checkRole()){
            temp.getRole().rehearsal();
            System.out.println("You current rehearse score is "+temp.getRole().getRehearse());
            game.nextPlayer();
         }
         else if(playerInput.equals("rehearse") && !temp.checkRole()){
            System.out.println("You don't have a role");
         }
         
                 
                
         if(playerInput.equals("upgrade") && temp.getcurrentRoom().getspaceId() == 6){
         
         boolean done = false;
         
         while(!done){
            //ask for desired rank
            System.out.println("You have "+ temp.getMoney() + " Dollars and " + temp.getCredits() + " credits");
            System.out.println("Select a rank to upgrade to or type '0' to exit");
            game.getCasting().displayCost();
            Scanner rank = new Scanner(System.in);
            if(rank.hasNextInt()){
               int payType = -1;
               int rankUp = rank.nextInt();
               //see if new rank is higher and valid
               if(rankUp > temp.getRank() && rankUp < 7){
                  
                  //check if player has enough
                  //display which payment method has enough
                  if(temp.getMoney() >= game.getCasting().getdollarCost(rankUp-2) && temp.getCredits() >= game.getCasting().getcreditCost(rankUp-2)){
                     payType = 0;
                     //if both ask which one should be used
                  }
                  else if(temp.getMoney() >= game.getCasting().getdollarCost(rankUp-2)){
                     payType = 1;
                  }
                  
                  else if(temp.getCredits() >= game.getCasting().getcreditCost(rankUp-2)){
                     payType = 2;
                  }
                  //if none tell player no
                  else{
                     System.out.println("You don't have enough for that upgrade.");
                  }
                  
                  Scanner payment = new Scanner(System.in);
                  String choice;
                  boolean payed = false;
                  //take money or credit and up rank
                  while(payType == 0){
                     //ask which
                     System.out.println("You have enough money and credits. Which currency would you like to play with? (cash/credit)");
                     //Scanner payment = new Scanner(System.in);
                     choice = payment.next();
                     //wait for confirmation and upgrade or exit  
                     if(choice.equals("cash")){                
                        payType = 1;
                        //System.out.println("I payed with cash");
                     }
                     else if(choice.equals("credit")){
                        payType = 2;
                        //System.out.println("I payed with credits");
                     }
                     else{
                        System.out.println("please try again");
                     }
                  }
                  if(payType == 1){
                     while(!payed){
                     System.out.println("You have enough cash. Would you like to upgrade? (y/n)");
                     //wait for confirmation and upgrade or exit
                     choice = payment.next();
                     if(choice.equals("y")){
                     //System.out.println("Rank "+ temp.rank +" Money " + temp.money);
                        temp.addMoney(-(game.cOffice.dollarCost[rankUp-2]));
                        temp.setRank(rankUp);
                        payed = true;
                        done = true;
                        System.out.println("New: Rank "+ temp.getRank() +" Money " + temp.getMoney());
                     }
                     else if(choice.equals("n")){
                        payed = true;
                     }
                     else{
                        System.out.println("Try again");
                     }
                     }

                  }
                  else if(payType == 2){
                     while(!payed){
                     System.out.println("You have enough credits. Would you like to upgrade? (y/n)");
                     //wait for confirmation and upgrade or exit
                     choice = payment.next();
                     if(choice.equals("y")){
                     //System.out.println("Rank "+ temp.rank +" Credit " + temp.credits);
                        temp.addCredits(-(game.cOffice.creditCost[rankUp-2]));
                        temp.setRank(rankUp);
                        done = true;
                        payed = true;
                        System.out.println("New: Rank "+ temp.getRank() +" Credit " + temp.getCredits());
                     }
                     else if(choice.equals("n")){
                        payed = true;
                     }
                     else{
                        System.out.println("Try again");
                     }
                     }
                  }
                  //or back out
           
               }
               else if(rankUp == 0){
                  done = true;
               }
               else{
                  System.out.println("Not a valid upgrade");
               }
            }
            
         }
         
         }
         else if(playerInput.equals("upgrade") && temp.getcurrentRoom().getspaceId() != 6){
            System.out.println("You can only updgrade from the Casting Office(Space 6)");
         }

         if(playerInput.equals("role") && temp.getcurrentRoom().getroomScene() == null){
         System.out.println("This room has no scene");
         }
         else{
         
         
         if(playerInput.equals("role") && temp.checkRole()){
            System.out.println("You already have a role");
         }
         
         if(playerInput.equals("role") && temp.getcurrentRoom().getroomScene().getCard().getcardState() == 2){
            System.out.println("The scene has wrapped for the day");
         }
         
         if(playerInput.equals("role") && !temp.checkRole() && temp.getcurrentRoom().getroomScene().getCard().getcardState() != 2){
         //show the roles
         boolean back = false;
        
         onSpace = temp.getcurrentRoom().getroomScene().getsceneRoles();
         onCard = temp.getcurrentRoom().getroomScene().getCard().getcardRoles();
         
         System.out.println("Availale Extra roles:");
         temp.getcurrentRoom().getroomScene().printScene();
         System.out.println("Availale Card roles:");
         temp.getcurrentRoom().getroomScene().getCard().printRoles(onSpace.length);
         
         System.out.println("Select a role");
         while(!roleSelected){
         back = false;
         
         Scanner room = new Scanner(System.in);
         if(room.hasNextInt()){
         playerInt = room.nextInt();
         }
         else if(room.next().equals("back")){
         roleSelected = true;
         back = true;
         }
         else{
         System.out.println("Enter a valid input");
         System.out.println("Select a role");
         back = true;
         }
         
         if(!back){
         //while(!roleSelected){
         
         //System.out.println("Select a role");
         //Scanner room = new Scanner(System.in);
         //if(room.next().equals("back")){
         //roleSelected = true;
         
         //}
         //else{
            //if(room.hasNextInt()){
            //playerInt = room.nextInt();
         
         
         
         
         
         //if(playerInput.equals("back")){
         //roleSelected = true;
         //}
         
         //pick a role
         int cardIndex = playerInt-onSpace.length;
         
         if(playerInt < onSpace.length &&playerInt >= 0){
            //check if valid
            if(!onSpace[playerInt].getroleTaken() && (temp.getRank() >= onSpace[playerInt].getRoleRank())){
              System.out.println("You are now role " + temp.getcurrentRoom().getroomScene().getRole(playerInt).getroleName());
              temp.getcurrentRoom().getroomScene().getRole(playerInt).setroleTaken();
              temp.changeRole(temp.getcurrentRoom().getroomScene().getRole(playerInt));
              temp.getcurrentRoom().getroomScene().addPlayer(temp);
              roleSelected = true;
            }
            else{
            
               System.out.println("Role unavailable");
               System.out.println("Select a role");
            }
         }
         else if(cardIndex < temp.getcurrentRoom().getroomScene().getCard().getcardRoles().length && playerInt >= 0){
         //System.out.println("test");
         if(!onCard[cardIndex].getroleTaken() && (temp.getRank() >= onCard[cardIndex].getRoleRank())){
              System.out.println("You are now role " + temp.getcurrentRoom().getroomScene().getCard().getcardRole(cardIndex).getroleName());
              temp.currentRoom.roomScene.sceneCard.cardRoles[cardIndex].setroleTaken();
              temp.changeRole(temp.getcurrentRoom().getroomScene().getCard().getcardRole(cardIndex));
              temp.getcurrentRoom().getroomScene().addPlayer(temp);
              roleSelected = true;
            }
            else{
            
               System.out.println("Role unavailable");
               System.out.println("Select a role");
            }
         }
         
         else{
            System.out.println("Role do not exist");
            System.out.println("Select a role");
         }
         
         }
         }
         
         if(roleSelected && !back){
            temp.hasRole = true;
            
            game.nextPlayer();
            hasMoved = false;
            roleSelected = false;
            }
            else if(back){
            roleSelected = false;
            }
         }
         }
         
         
         
         
         if(playerInput.equals("end")){
         game.nextPlayer();
         hasMoved = false;
         roleSelected = false;
         acted = false;
         }
      }
      }
      //game.endGame();

}*/
}