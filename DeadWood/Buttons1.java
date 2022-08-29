import java.awt.Dimension;
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
    
    String[] columnNames = {"Name", "Money","Credits"};
    Object[][] data = {
    {"Player Name", new Integer(0),
     new Integer(0)},
    {"Player2 Name", new Integer(0),
     new Integer(0)},{"Player2 Name", new Integer(0),
     new Integer(0)},{"Player2 Name", new Integer(0),
     new Integer(0)},{"Player2 Name", new Integer(0),
     new Integer(0)},{"Player2 Name", new Integer(0),
     new Integer(0)},{"Player2 Name", new Integer(0),
     new Integer(0)},{"Player2 Name", new Integer(0),
     new Integer(0)}};
     JTable stats = new JTable(data,columnNames);
     JTextArea area = new JTextArea(); 

    JScrollPane scrollPane = new JScrollPane(stats);
    JScrollPane Board = new JScrollPane();
    stats.setFillsViewportHeight(true);
    stats.setBounds(1260, 40, 200, 300); 
    stats.setEnabled(false);
    scrollPane.setBounds(1650,570,200,155);
    stats.getColumnModel().getColumn(0).setPreferredWidth(150);
    stats.getColumnModel().getColumn(1).setPreferredWidth(60);
    stats.getColumnModel().getColumn(2).setPreferredWidth(60);
    JButton act = new JButton("Act"); 
    JButton rehearse = new JButton("Rehearse"); 
    JButton end = new JButton("End Turn");
    JButton role = new JButton("Take Role");
    JButton move = new JButton("Move"); 
    JButton upgrade = new JButton("Upgrade");
    move.setEnabled(true);       
    move.setBounds(1720, 50, 75, 30);  
    act.setEnabled(false);       
    act.setBounds(1720, 90, 75, 30);
    rehearse.setEnabled(false);       
    rehearse.setBounds(1700, 130, 110, 30);
     end.setEnabled(true);       
    end.setBounds(1700, 290, 110, 30);
role.setEnabled(false);       
    role.setBounds(1700, 170, 110, 30);
upgrade.setEnabled(true);       
    upgrade.setBounds(1700, 210, 110, 30);

ImageIcon cardBack = new ImageIcon("CardBack.jpg");
JLabel card = new JLabel();
card.setBounds(1135, 25, 254, 149);
card.setIcon(cardBack);


JLabel card3 = new JLabel();
card3.setBounds(325, 25, 254, 149);
card3.setIcon(cardBack);


JLabel card4 = new JLabel();

card4.setBounds(429, 325, 254, 149);
card4.setIcon(cardBack);


JLabel card5 = new JLabel();
card5.setBounds(19, 73, 254, 149);
card5.setIcon(cardBack);

JLabel card11 = new JLabel();
card11.setBounds(1135, 865, 254, 149);
card11.setIcon(cardBack);


JLabel card7 = new JLabel();
card7.setBounds(25, 857, 254, 149);
card7.setIcon(cardBack);
//
JLabel card2 = new JLabel();
card2.setBounds(738, 322, 254, 149);
card2.setIcon(cardBack);

JLabel card8 = new JLabel();
card8.setBounds(290, 554, 254, 149);
card8.setIcon(cardBack);

JLabel card9 = new JLabel();
card9.setBounds(727, 554, 254, 149);
card9.setIcon(cardBack);


JLabel card10 = new JLabel();
card10.setBounds(727, 857, 254, 149);
card10.setIcon(cardBack);


//card.setVisible(true);
ImageIcon background = new ImageIcon("board.jpg");
JLabel label = new JLabel();
label.setBounds(0, 0, 1413, 1060);
label.setIcon(background);



//JPanel panel = new JPanel();
//panel.setLayout(null);
panel.add(label,new Integer(1));
panel.add(card, new Integer(3));
panel.add(card2, new Integer(3));
panel.add(card3, new Integer(3));
panel.add(card4, new Integer(3));
panel.add(card5, new Integer(3));
panel.add(card11, new Integer(3));
panel.add(card7, new Integer(3));
panel.add(card8, new Integer(3));
panel.add(card9, new Integer(3));
panel.add(card10, new Integer(3));

//panel.add(card5, new Integer(3));
//panel.add(card6, new Integer(3));
//panel.add(card7, new Integer(3));
//panel.add(card8, new Integer(3));

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
   game.nextPlayer();
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
         end.setEnabled(false);  
         move.setEnabled(false);   
   //move.setEnabled(false);
      
room[] temp = game.currentPlayer.getcurrentRoom().getNearRooms();
JButton near[] = new JButton[4];  
   
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
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
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
         panel.repaint();
      }
   });
   
   near[1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
         game.currentPlayer.movePlayer(temp[1]);
         //System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);     
         
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
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
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
            }
            role.setEnabled(true);
            panel.repaint();
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
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
            }
            role.setEnabled(true);
            panel.repaint();
            System.out.println("Current room " + game.currentPlayer.currentRoom.roomScene.sceneName);
         }
  
         panel.remove(near[0]);
         panel.remove(near[1]);
         panel.remove(near[2]);
         panel.remove(near[3]);
         //role.setEnabled(false);
         upgrade.setEnabled(false);      
         end.setEnabled(true);
         panel.repaint();
      }
   }); 
   }
   
   //$$$$$$$$$$$$$$$$$$$$$$$$$$
          
   }       }); 
   } 
}
