
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ParseXML{
        // returns a Document object after loading the card.xml file.
   public Document getDocFromFile(String filename)
      throws ParserConfigurationException{
         {
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document doc = null;           
         try{
            doc = db.parse(filename);
         } 
         catch (Exception ex){
            System.out.println("XML parse failure");
            ex.printStackTrace();
         }
         return doc;
         } // exception handling        
      }          
        // reads data from XML file and fills an array
   public card[] readBookData(Document d){
      card[] buildCard = new card[40];
      Element root = d.getDocumentElement();            
      NodeList cards = root.getElementsByTagName("card");            
      for (int i=0; i<cards.getLength();i++){                
                //reads data from the nodes
         Node card = cards.item(i);
         String roleName = card.getAttributes().getNamedItem("name").getNodeValue();
         String roleBudget = card.getAttributes().getNamedItem("budget").getNodeValue();
         buildCard[i] = new card(roleName,Integer.parseInt(roleBudget), i);
         //reads data
         int q = 0;                             
         NodeList children = card.getChildNodes();       
         for (int j=0; j< children.getLength(); j++){           
            Node sub = children.item(j);                  
            if("part".equals(sub.getNodeName())){
                String partName = sub.getAttributes().getNamedItem("name").getNodeValue();
                String partLevel = sub.getAttributes().getNamedItem("level").getNodeValue();
                roles newRole = new roles(partName, Integer.parseInt(partLevel));
                buildCard[i].addRoles(newRole,q, Integer.parseInt(partLevel));
                q += 1;
            }
         } 
      }
      return buildCard;
   }
}