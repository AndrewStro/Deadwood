import java.awt.Dimension;
import java.awt.Color;
import java.util.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Buttons extends JFrame {    
private Toolkit toolkit;
public Buttons(Board game) { 
   
   
    JButton near[] = new JButton[4]; 
    JButton extras[] = new JButton[4];
    JButton lead[] = new JButton[3];
    ImageIcon cardFace[] = new ImageIcon[40];
    JLabel card[] = new JLabel[12];
    JButton upCostsC[] = new JButton[5];
    JButton upCostsD[] = new JButton[5];
    int[] shotShift = {0,0,3,5,6,8,0,11,14,16,17,19};
    
    JLabel shots[] = new JLabel[22];
   
    setTitle("Buttons");        
          
    toolkit = getToolkit();        
    Dimension size = toolkit.getScreenSize();
    setSize(size);          
    //setLocation((size.width - getWidth())/2, (size.height -getHeight())/2);        
    setDefaultCloseOperation(EXIT_ON_CLOSE);        
    JLayeredPane panel;
    panel = getLayeredPane();
         
    //getContentPane().add(panel);
    panel.setLayout(null);        
    
    String[] columnNames = {"Name","Rank","Money","Credits","Rehearsal"};    
    Object[][] data = new Object[game.numPlayers][5];
    
    for(int i = 0; i <game.numPlayers; i++){
      data[i][0] = game.playerList.get(i).getplayerName();
      data[i][1] = game.playerList.get(i).getRank();
      data[i][2] = game.playerList.get(i).getMoney();
      data[i][3] = game.playerList.get(i).getCredits();
      data[i][4] = 0;
    }
    
    
    
    
    
    JLabel playerC = new JLabel("Current Player");
    playerC.setBounds(1550, 1000, 100, 20);
    playerC.setBackground(game.currentPlayer.playerColor);
    playerC.setForeground(Color.lightGray);
    panel.add(playerC,new Integer(4));
    playerC.setOpaque(true);
    
    
    
    
     JTable stats = new JTable(data,columnNames);
     JTextArea area = new JTextArea();
     stats.setEnabled(false); 

    JScrollPane scrollPane = new JScrollPane(stats);
    JScrollPane Board = new JScrollPane();
    stats.setFillsViewportHeight(true);
    stats.setBounds(1260, 40, 200, 300); 
    //scrollPane.setBounds(1650,570,200,155); 
    scrollPane.setBounds(1400,570,400,155); 
    stats.getColumnModel().getColumn(0).setPreferredWidth(150);
    stats.getColumnModel().getColumn(1).setPreferredWidth(50);
    stats.getColumnModel().getColumn(2).setPreferredWidth(50);
    stats.getColumnModel().getColumn(3).setPreferredWidth(50);
    JButton act = new JButton("Act"); 
    JButton rehearse = new JButton("Rehearse"); 
    JButton end = new JButton("End Turn");
    JButton role = new JButton("Take Role");
    JButton move = new JButton("Move"); 
    JButton upgrade = new JButton("Upgrade");
    move.setEnabled(true);       
    move.setBounds(1700, 50, 110, 30);  
    act.setEnabled(false);       
    act.setBounds(1700, 90, 110, 30);
    rehearse.setEnabled(false);       
    rehearse.setBounds(1700, 130, 110, 30);
    end.setEnabled(true);       
    end.setBounds(1700, 290, 110, 30);
    role.setEnabled(false);       
    role.setBounds(1700, 170, 110, 30);
    //upgrade.setEnabled(false);       
    upgrade.setBounds(1700, 210, 110, 30);
    
    JButton back = new JButton("Back");
    back.setBounds(1520, 10, 110, 30);
    panel.add(back);
    back.setVisible(false);

ImageIcon cardBack = new ImageIcon("CardBack.jpg");

ImageIcon shotCounter = new ImageIcon("p0.png");

/*
JLabel card = new JLabel();
card.setBounds(370, 282, 205, 115);
card.setIcon(cardBack);

JLabel card3 = new JLabel();
card3.setBounds(228, 19, 175, 103);
card3.setIcon(cardBack);

JLabel card4 = new JLabel();
card4.setBounds(791, 19, 175, 103);
card4.setIcon(cardBack);
//card4.setVisible(false);

JLabel card2 = new JLabel();
card2.setBounds(515, 226, 175, 103);
card2.setIcon(cardBack);
*/
//Card Face
for(int i = 0; i< 40; i++){
   if(i < 9){
      cardFace[i] = new ImageIcon("0"+(i+1)+".png");
   }
   else{
      cardFace[i] = new ImageIcon((i+1)+".png");
   }
}

//Card objects
for(int i = 0; i<12; i++){
   if(!(i == 0 || i == 6)){
      card[i] = new JLabel();
      card[i].setIcon(cardBack);
      panel.add(card[i], new Integer(3));
   }
}
card[1].setBounds(970, 25, 205, 115);
card[2].setBounds(635, 282, 205, 115);
card[3].setBounds(280, 25, 205, 115);
card[4].setBounds(370, 282, 205, 115);
card[5].setBounds(20, 70, 205, 115);

card[7].setBounds(27, 732, 205, 115);
card[8].setBounds(252, 476, 205, 115);
card[9].setBounds(623, 474, 205, 115);
card[10].setBounds(623, 735, 205, 115);
card[11].setBounds(970, 740, 205, 115);



for(int i = 0; i<22; i++){
   shots[i] = new JLabel();
   shots[i].setIcon(shotCounter);
   panel.add(shots[i], new Integer(3));
}
//Main Street
shots[1].setBounds(806, 25, 42, 42);
shots[0].setBounds(859, 25, 42, 42);
shots[2].setBounds(914, 25, 42, 42);

//Saloon
shots[3].setBounds(650, 225, 42, 42);
shots[4].setBounds(600, 225, 42, 42);

//Jail
shots[5].setBounds(400, 200, 42, 42);

//General Store
shots[6].setBounds(350, 250, 42, 42);
shots[7].setBounds(300, 250, 42, 42);

//Train Station
shots[8].setBounds(50, 25, 42, 42);
shots[9].setBounds(100, 25, 42, 42);
shots[10].setBounds(150, 25, 42, 42);

//Secret Hidout
shots[11].setBounds(50, 900, 42, 42);
shots[12].setBounds(100, 900, 42, 42);
shots[13].setBounds(150, 900, 42, 42);

//Ranch
shots[14].setBounds(1500, 900, 42, 42);
shots[15].setBounds(1550, 900, 42, 42);

//Bank
shots[16].setBounds(900, 600, 42, 42);

//Church

//Hotel


//card.setVisible(true);
ImageIcon background = new ImageIcon("board.jpg");
JLabel label = new JLabel();
label.setBounds(0, 0, 1200, 900);
label.setIcon(background);



//JPanel panel = new JPanel();
//panel.setLayout(null);

panel.add(label,new Integer(1));
/*panel.add(card, new Integer(3));
panel.add(card2, new Integer(3));
panel.add(card3, new Integer(3));
panel.add(card4, new Integer(3));*/

//panel.add(card5, new Integer(3));
//panel.add(card6, new Integer(3));
//panel.add(card7, new Integer(3));
//panel.add(card8, new Integer(3));

JButton close = new JButton("Close");    
   close.setBounds(50, 60, 80, 30); 
   panel.add(upgrade);
   panel.add(role);      
   panel.add(end);
   panel.add(rehearse);
   panel.add(scrollPane); 
   panel.add(move);
   //panel.add(frame);
   stats.setSize(500,200);
   stats.setVisible(true);       
   panel.add(act);
   panel.setVisible(true);        
   //panel.add(close);  
   
   
   end.addActionListener(new ActionListener() {           
   public void actionPerformed(ActionEvent event) {   
     
   //switch player
   back.setVisible(false);
   game.nextPlayer();
   playerC.setBackground(game.currentPlayer.playerColor);

   //check role and location
   if(game.currentPlayer.checkRole()){
      //disable move,take role, upgrade
      move.setEnabled(false);
      role.setEnabled(false);
      upgrade.setEnabled(false);
      //enable rehearse act
      act.setEnabled(true);
      rehearse.setEnabled(true);
   }
   else{
   //set buttons
      //disable act and rehearse
      act.setEnabled(false);
      rehearse.setEnabled(false);
      role.setEnabled(false);
      upgrade.setEnabled(false);
      //enable move
      move.setEnabled(true);
      //check location
      if(game.currentPlayer.getcurrentRoom().getspaceId() == 0){
         move.setEnabled(true);
         role.setEnabled(false);
         upgrade.setEnabled(false);
         act.setEnabled(false);
         rehearse.setEnabled(false);
      }
      else if(game.currentPlayer.getcurrentRoom().getspaceId() == 6){
      //enable upgrade
         upgrade.setEnabled(true);
         move.setEnabled(true);
      }
      else if(game.currentPlayer.currentRoom.roomScene.sceneCard.cardState == 1){
      //enable take role
         role.setEnabled(true);
      } 
      panel.repaint();
      //else{
       /*  move.setEnabled(true);
         role.setEnabled(false);
         upgrade.setEnabled(false);
         act.setEnabled(false);
         rehearse.setEnabled(false);*/

      //}
   }
   
   }});
   
   
  move.addActionListener(new ActionListener() {           
   public void actionPerformed(ActionEvent event) { 
   //$$$$$$$$$$$$$$$$$$$$$$$$$$
         back.setVisible(true);
         end.setEnabled(false);  
         move.setEnabled(false);
         role.setEnabled(false);   
         panel.repaint();
         game.currentPlayer.addMoney(-2);
         game.endGame(); 
         
      
room[] temp = game.currentPlayer.getcurrentRoom().getNearRooms();
//JButton near[] = new JButton[4];  
   
   for(int i = 0; i < (temp.length);i++){
   
   if(temp[i].getspaceId() == 0){
      near[i] = new JButton("Trailer");
   }
   else if(temp[i].getspaceId() == 6){
      near[i] = new JButton("Casting");
   }
   else{
      near[i] = new JButton(temp[i].roomScene.getsceneName());
   }
      near[i].setBounds(1420, 50 +(i*30), 150, 30);
      panel.add(near[i]);
      
   }
 
   near[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
         game.currentPlayer.movePlayer(temp[0]);
         
         //System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);     
         role.setEnabled(false);
         
         if(game.currentPlayer.currentRoom.getspaceId() == 0){
            System.out.println("Current room Trailer");
            role.setEnabled(false);
            panel.repaint();
         }
         else if(game.currentPlayer.currentRoom.getspaceId() == 6){
         upgrade.setEnabled(true);
            panel.repaint();

            System.out.println("Current room Casting");
         }
         else{
            if(game.currentPlayer.currentRoom.roomScene.sceneCard.getcardState() != 2){
               game.currentPlayer.currentRoom.roomScene.sceneCard.setCardState(1);
               role.setEnabled(true);
               panel.repaint();
            }
            else if(game.currentPlayer.currentRoom.roomScene.sceneCard.getcardState() == 2){
               role.setEnabled(false);
            }
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
            //flip card if need be
            room Current = game.currentPlayer.getcurrentRoom();
            if(Current.roomScene.sceneCard.cardState == 1){
               card[Current.getspaceId()].setIcon(cardFace[Current.roomScene.sceneCard.cardId]);
            }
         }
         
         panel.remove(near[0]);
         panel.remove(near[1]);
         panel.remove(near[2]);
         if(near[3] != null){
            panel.remove(near[3]);
         }
         //role.setEnabled(false);
         upgrade.setEnabled(false);
         end.setEnabled(true);
         back.setVisible(false);
         if(game.currentPlayer.getcurrentRoom().spaceId != 0 && game.currentPlayer.getcurrentRoom().spaceId != 6){
            if(game.currentPlayer.getcurrentRoom().roomScene.sceneCard.cardState == 1){
               role.setEnabled(true);
            }
            else{
               role.setEnabled(false);
            }
         }
         if(game.currentPlayer.getcurrentRoom().spaceId == 6){
            upgrade.setEnabled(true);
         }
         panel.repaint();
      }
   });
   
   near[1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
         game.currentPlayer.movePlayer(temp[1]);   
         
         if(game.currentPlayer.currentRoom.getspaceId() == 0){
            System.out.println("Current room Trailer");
            role.setEnabled(false);
            panel.repaint();
         }
         else if(game.currentPlayer.currentRoom.getspaceId() == 6){
         upgrade.setEnabled(true);
            panel.repaint();

            System.out.println("Current room Casting");
         }
         else{
            if(game.currentPlayer.currentRoom.roomScene.sceneCard.getcardState() != 2){
               game.currentPlayer.currentRoom.roomScene.sceneCard.setCardState(1);
               role.setEnabled(true);
               panel.repaint();
            }
            else if(game.currentPlayer.currentRoom.roomScene.sceneCard.getcardState() == 2){
               role.setEnabled(false);
            }
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
            //flip card if need be
            room Current = game.currentPlayer.getcurrentRoom();
            if(Current.roomScene.sceneCard.cardState == 1){
               card[Current.getspaceId()].setIcon(cardFace[Current.roomScene.sceneCard.cardId]);
            }

         }
  
         panel.remove(near[0]);
         panel.remove(near[1]);
         panel.remove(near[2]);
         if(near[3] != null){
         panel.remove(near[3]);         
         }
         //role.setEnabled(false);
         upgrade.setEnabled(false);
         end.setEnabled(true);
         back.setVisible(false);
         if(game.currentPlayer.getcurrentRoom().spaceId != 0 && game.currentPlayer.getcurrentRoom().spaceId != 6){
            if(game.currentPlayer.getcurrentRoom().roomScene.sceneCard.cardState == 1){
               role.setEnabled(true);
            }
            else{
               role.setEnabled(false);
            }
         }
         if(game.currentPlayer.getcurrentRoom().spaceId == 6){
            upgrade.setEnabled(true);
         }
         panel.repaint();
      }
   });
   
   near[2].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
         game.currentPlayer.movePlayer(temp[2]);
         //System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);     
         
         if(game.currentPlayer.currentRoom.getspaceId() == 0){
            System.out.println("Current room Trailer");
         }
         else if(game.currentPlayer.currentRoom.getspaceId() == 6){
         upgrade.setEnabled(true);
            panel.repaint();

            System.out.println("Current room Casting");
         }
         else{
            if(game.currentPlayer.currentRoom.roomScene.sceneCard.getcardState() != 2){
               game.currentPlayer.currentRoom.roomScene.sceneCard.setCardState(1);
               role.setEnabled(true);
               panel.repaint();
            }
            else if(game.currentPlayer.currentRoom.roomScene.sceneCard.getcardState() == 2){
               role.setEnabled(false);
            }
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
            //flip card if need be
            room Current = game.currentPlayer.getcurrentRoom();
            if(Current.roomScene.sceneCard.cardState == 1){
               card[Current.getspaceId()].setIcon(cardFace[Current.roomScene.sceneCard.cardId]);
            }

         }
         
         
         
         
         panel.remove(near[0]);
         panel.remove(near[1]);
         panel.remove(near[2]);      
         if(near[3] != null){
         panel.remove(near[3]);
         }
         //role.setEnabled(false);
         upgrade.setEnabled(false);
         end.setEnabled(true);
         back.setVisible(false);
         if(game.currentPlayer.getcurrentRoom().spaceId != 0 && game.currentPlayer.getcurrentRoom().spaceId != 6){
            if(game.currentPlayer.getcurrentRoom().roomScene.sceneCard.cardState == 1){
               role.setEnabled(true);
            }
            else{
               role.setEnabled(false);
            }
         }
         if(game.currentPlayer.getcurrentRoom().spaceId == 6){
            upgrade.setEnabled(true);
         }
         panel.repaint();

      }
   });
   
   if(near[3] != null){
   near[3].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
         game.currentPlayer.movePlayer(temp[3]);
         //System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);     
         
         if(game.currentPlayer.currentRoom.getspaceId() == 0){
            System.out.println("Current room Trailer");
         }
         else if(game.currentPlayer.currentRoom.getspaceId() == 6){
            System.out.println("Current room Casting");
            upgrade.setEnabled(true);
            panel.repaint();
         }
         else{
            if(game.currentPlayer.currentRoom.roomScene.sceneCard.getcardState() != 2){
               game.currentPlayer.currentRoom.roomScene.sceneCard.setCardState(1);
               role.setEnabled(true);
               panel.repaint();
            }
                       
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
            //flip card if need be
            room Current = game.currentPlayer.getcurrentRoom();
            if(Current.roomScene.sceneCard.cardState == 1){
               card[Current.getspaceId()].setIcon(cardFace[Current.roomScene.sceneCard.cardId]);
            }

         }
  
         panel.remove(near[0]);
         panel.remove(near[1]);
         panel.remove(near[2]);
         panel.remove(near[3]);
         //role.setEnabled(false);
         upgrade.setEnabled(false);      
         end.setEnabled(true);
         back.setVisible(false);
         if(game.currentPlayer.getcurrentRoom().spaceId != 0 && game.currentPlayer.getcurrentRoom().spaceId != 6){
            if(game.currentPlayer.getcurrentRoom().roomScene.sceneCard.cardState == 1){
               role.setEnabled(true);
            }
            else{
               role.setEnabled(false);
            }
         }
         if(game.currentPlayer.getcurrentRoom().spaceId == 6){
            upgrade.setEnabled(true);
         }
         panel.repaint();
      }
   }); 
   }
   
   //$$$$$$$$$$$$$$$$$$$$$$$$$$
          
   }       }); 
   
   
   back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         
            end.setEnabled(true);
            back.setVisible(false);
            role.setEnabled(false);
            
            if(game.currentPlayer.hasMoved == true){
               move.setEnabled(false);
            }
            else{
               move.setEnabled(true);
            }
            
            if(game.currentPlayer.getcurrentRoom().spaceId == 6){
               upgrade.setEnabled(true);      
            }
            else{
               upgrade.setEnabled(false);
            }
            if(game.currentPlayer.getcurrentRoom().spaceId != 6 && game.currentPlayer.getcurrentRoom().spaceId != 0){
               if(game.currentPlayer.getcurrentRoom().roomScene.sceneCard.getcardState() == 1){
                  role.setEnabled(true);
               }
               else if(game.currentPlayer.getcurrentRoom().roomScene.sceneCard.getcardState() == 2){
                  role.setEnabled(false);
               }
            }
            

            panel.remove(near[0]);
            panel.remove(near[1]);
            panel.remove(near[2]);
            if(near[3] != null){
               panel.remove(near[3]);
            }
            
            for(int i = 0; i < 4; i++){
               if(extras[i] != null){
                  panel.remove(extras[i]);
               }
            }
            
            for(int i = 0; i < 3;i++){
               if(lead[i] != null){
                  panel.remove(lead[i]);
               }
            }
            if(upCostsC[0] != null){
               for(int i = 0; i <5; i++){
                  panel.remove(upCostsC[i]);
                  panel.remove(upCostsD[i]);
               }
            }

            panel.repaint();

         
         }
         });

   
   
   
   
   role.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
         back.setVisible(true);
         upgrade.setEnabled(false);      
         end.setEnabled(false);
         move.setEnabled(false);
         rehearse.setEnabled(false);
         role.setEnabled(false);
         act.setEnabled(false);
         panel.repaint();
      
         //System.out.println(game.currentPlayer.currentRoom.roomScene.sceneCard.cardId+1);
      
      roles[] offCard = game.currentPlayer.currentRoom.roomScene.sceneRoles;
      
      
      roles[] onCard = game.currentPlayer.currentRoom.roomScene.sceneCard.cardRoles;
      

      
      
      for(int i = 0; i < offCard.length; i++){
      
         extras[i] = new JButton(offCard[i].roleName);
         extras[i].setBounds(1420, 50 +(i*30), 150, 30);
         panel.add(extras[i]);
         if(offCard[i].roleRank > game.currentPlayer.getRank() || offCard[i].getroleTaken()){
            extras[i].setEnabled(false);
         }
         
         extras[i].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            for(int k = 0; k < offCard.length; k++){
               if(offCard[k].roleName.equals(((JButton)event.getSource()).getText())){
                  game.currentPlayer.changeRole(offCard[k]); 
               }            
            } 
            for(int k = 0; k < offCard.length; k++){
               panel.remove(extras[k]);
            }   
            for(int k = 0; k < 3; k++){
               if(lead[k] != null){
                  panel.remove(lead[k]);
               }
            }  
            end.setEnabled(true); 
            back.setVisible(false); 
            panel.repaint();       
         }   
      });
      
         
         
      }
      
      for(int j = 0; j < 3; j++){
      
         if(onCard[j] != null){
            lead[j] = new JButton(onCard[j].roleName);
            lead[j].setBounds(1420, 180 +(j*30), 150, 30);
            panel.add(lead[j]);
            if(onCard[j].roleRank > game.currentPlayer.getRank() || onCard[j].getroleTaken()){
               lead[j].setEnabled(false);
            }

         lead[j].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            for(int k = 0; k < 3; k++){
               if(onCard[k] != null && onCard[k].roleName.equals(((JButton)event.getSource()).getText())){
                  game.currentPlayer.changeRole(onCard[k]); 
               }            
            }
            for(int k = 0; k < 3; k++){
               if(lead[k] != null){
                  panel.remove(lead[k]);
               }
            } 
            for(int k = 0; k < extras.length; k++){
               if(extras[k] != null){
                  panel.remove(extras[k]);
               }
            }
            
            end.setEnabled(true);
            back.setVisible(false);
            panel.repaint();          
         }
         });


         }
 
      
      }
      //end.setEnabled(true);
      panel.repaint();
      
      
      
      }
      
      
   
   });

   upgrade.addActionListener(new ActionListener() {           
   public void actionPerformed(ActionEvent event) {
      
      /*game.currentPlayer.setCredits(20);
      game.currentPlayer.setMoney(10);
      game.currentPlayer.setRank(1);*/
      
      back.setVisible(true);
      upgrade.setEnabled(false);      
      end.setEnabled(false);
      move.setEnabled(false);
      rehearse.setEnabled(false);
      role.setEnabled(false);
      act.setEnabled(false);
      panel.repaint();
      
      
      
      for(int i = 0; i < 5;i++){
         upCostsC[i] = new JButton(/*"Rank " + (i+2)+":" +*/""+(5+(5*i))); 
         upCostsC[i].setBounds(1420, 50 +(i*30), 150, 30);
         panel.add(upCostsC[i]);
         if(game.currentPlayer.getCredits() < (5+(5*i)) || game.currentPlayer.getRank() >= i+2){
            upCostsC[i].setEnabled(false);
         }
         upCostsC[i].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            game.cOffice.upgrade(game.currentPlayer,((Integer.parseInt(((JButton)event.getSource()).getText())/5) + 1), 1);
            int tempPrevCost = 0;
            for(int k = 0; k < 5; k++){
            if(game.currentPlayer.getMoney() < tempPrevCost + ((k+2)*2) || game.currentPlayer.getRank() >= k+2){
               upCostsD[k].setEnabled(false);
               tempPrevCost = tempPrevCost + ((k+2)*2);
            }
            if(game.currentPlayer.getCredits() < (5+(5*k)) || game.currentPlayer.getRank() >= k+2){
               upCostsC[k].setEnabled(false);
            }
            panel.repaint();
         }
            
         }
         });
      }
      
      int prevCost = 0;
      for(int i = 0; i < 5;i++){
         upCostsD[i] = new JButton(""+(prevCost + (i+2)*2));
         upCostsD[i].setBounds(1270, 50 +(i*30), 150, 30);
         panel.add(upCostsD[i]);
         prevCost = prevCost + ((i+2)*2);
         if(game.currentPlayer.getMoney() < prevCost || game.currentPlayer.getRank() >= i+2){
            upCostsD[i].setEnabled(false);
         }  
         
         upCostsD[i].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            game.cOffice.upgrade(game.currentPlayer,((Integer.parseInt(((JButton)event.getSource()).getText())/9) + 2), 0); 
            int tempPrevCost = 0;
            for(int k = 0; k < 5; k++){
            if(game.currentPlayer.getMoney() < tempPrevCost + ((k+2)*2) || game.currentPlayer.getRank() >= k+2){
               upCostsD[k].setEnabled(false);
               tempPrevCost = tempPrevCost + ((k+2)*2);
            }
            if(game.currentPlayer.getCredits() < (5+(5*k)) || game.currentPlayer.getRank() >= k+2){
               upCostsC[k].setEnabled(false);
            }
            
            for(int i = 0; i <game.numPlayers; i++){
               data[i][1] = game.playerList.get(i).getRank();
               data[i][2] = game.playerList.get(i).getMoney();
               data[i][3] = game.playerList.get(i).getCredits();
               if(game.playerList.get(i).checkRole()){
                  data[i][4] = game.playerList.get(i).getRole().getRehearse();
               }
               else{
                  data[i][4] = 0;
               }
            }
            panel.repaint();
         }
            
         }
         });
      }

      panel.repaint();
      
      
   } 
   });
   
   
   rehearse.addActionListener(new ActionListener() {           
   public void actionPerformed(ActionEvent event) {
      back.setVisible(false);
      upgrade.setEnabled(false);      
      end.setEnabled(true);
      move.setEnabled(false);
      rehearse.setEnabled(false);
      role.setEnabled(false);
      act.setEnabled(false);
      panel.repaint();
      
      game.currentPlayer.getRole().rehearsal();
      
      for(int i = 0; i <game.numPlayers; i++){
         data[i][1] = game.playerList.get(i).getRank();
         data[i][2] = game.playerList.get(i).getMoney();
         data[i][3] = game.playerList.get(i).getCredits();
         if(game.playerList.get(i).checkRole()){
            data[i][4] = game.playerList.get(i).getRole().getRehearse();
         }
         else{
            data[i][4] = 0;
         }
      }
      
   }
   });
   
   act.addActionListener(new ActionListener() {           
   public void actionPerformed(ActionEvent event) {
      back.setVisible(false);
      upgrade.setEnabled(false);      
      end.setEnabled(true);
      move.setEnabled(false);
      rehearse.setEnabled(false);
      role.setEnabled(false);
      act.setEnabled(false);
      panel.repaint();
      
      if(game.currentPlayer.act(game.currentPlayer.getRole().getRehearse(), game.currentPlayer.getcurrentRoom().roomScene.getCard().getBudget())){
         game.currentPlayer.actOutcome(true);
         shots[game.currentPlayer.getcurrentRoom().getroomScene().getCounters()
         +shotShift[game.currentPlayer.getcurrentRoom().getspaceId()]-1].setVisible(false);
      }
      else{
         game.currentPlayer.actOutcome(false);
      }
      
      
      if(game.currentPlayer.currentRoom.roomScene.sceneCard.cardState == 2){
         card[game.currentPlayer.currentRoom.getspaceId()].setVisible(false);
      }
      
      if(game.currentPlayer.currentRoom.roomScene.wrapped){
         game.wrapCount++;
      }
      
      if(game.wrapCount == 9){     
         game.nextDay();
         //reset Cards  
         for(int i = 0; i<12; i++){
            if(!(i == 0 || i == 6)){
               card[i].setIcon(cardBack);
               card[i].setVisible(true);
            }
         }
         
         for(int i = 0; i<22; i++){
            shots[i].setVisible(true);
         }
         
         
      }
      
      for(int i = 0; i <game.numPlayers; i++){
         data[i][1] = game.playerList.get(i).getRank();
         data[i][2] = game.playerList.get(i).getMoney();
         data[i][3] = game.playerList.get(i).getCredits();
         if(game.playerList.get(i).checkRole()){
            data[i][4] = game.playerList.get(i).getRole().getRehearse();
         }
         else{
            data[i][4] = 0;
         }
      }
      
      System.out.println(game.wrapCount + " scenes have wrapped");
      
      System.out.println("returned D"+ game.currentPlayer.getMoney());
      System.out.println("returned C"+ game.currentPlayer.getCredits());
   }
   });
}
}