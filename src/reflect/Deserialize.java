package reflect;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class Deserialize {
	
	public void deserialize() {
		
		List<Element> elementListF;
		Element elef;
		
		try {
			File inputFile = new File("C:\\Users\\Max\\eclipse-workspace\\reflect\\testing\\getXML.xml");
	        SAXBuilder saxBuilder = new SAXBuilder();
	        Document document = saxBuilder.build(inputFile);
	        System.out.println("\nRoot element :" + document.getRootElement().getName());
	        
	        
	        // Get root element
	        Element root = document.getRootElement();
	        
	        // Get objects of root
	        List<Element> elementList = root.getChildren();
	        
	        // Go through each object
	        Element ele = elementList.get(0); // 0 since we only have 1 object
	        
	        Attribute attribute = ele.getAttribute("class");
	        System.out.println("\tObject class: " + attribute.getValue() );
	        
	        attribute = ele.getAttribute("id");
	        System.out.println("\tObject id: " + attribute.getValue() );
	        
	        // For each object go through its fields
	        elementList = ele.getChildren();
	        
	        int size = elementList.size();
	        //System.out.println(size);
	        for (int i = 0; i < size ; i++) {
	        	ele = elementList.get(i);
		        
		        attribute = ele.getAttribute("name");
		        System.out.println("\t\tField name : " + attribute.getValue() );
		        
		        attribute = ele.getAttribute("declaringclass");
		        System.out.println("\t\tField declaring class : " + attribute.getValue() );
		        
		        // Get value of field
		        elementListF = ele.getChildren();
		        int sizef = elementListF.size();
		        for (int j = 0; j < sizef; j++) {
		        	elef = elementListF.get(j);
			        
			        System.out.println("\t\t\tField value : " + elef.getText() );
		        }
		        
	        }
	        
	        
	    } 
		
		catch(JDOMException e) {
	         e.printStackTrace();
	    }
		
		catch(IOException e) {
	         e.printStackTrace();
	    }	
	}
}