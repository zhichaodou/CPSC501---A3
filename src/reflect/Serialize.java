package reflect;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.*;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Serialize {
	
	private Element  root;
	private Element  ele;
	private Element  field_element;
	private Element  value_element;
	private Class<?> clas;
	private Object   value;
	private char count;
	int length;
	
	private Class<?> refClas;
	private Element refEle;
	
	
	public void serialize(Object obj) {
		
		// Set root as serialized
		root = new Element("serialized");
		
		// Create XML document object and set the root
		Document document = new Document(root);
		
		// set object element tag
		ele = new Element("object");
		
		// Get the class of the object
		clas = obj.getClass();
		
		// Set required attributes
		ele.setAttribute("class", clas.getSimpleName());
		ele.setAttribute("id", String.valueOf(clas.hashCode()));
				
		
		// Get the fields of the object
		Field[] fields = obj.getClass().getDeclaredFields();
		
		for(Field f : fields) {
			
			// set field element tag
			field_element = new Element("field");
			
			// get fields of the object
			field_element.setAttribute("name", f.getName() );
			field_element.setAttribute("declaringclass", String.valueOf(f.getDeclaringClass()));
			
			// set value
			try {
				value = f.get(obj).toString();				
			}
			
			
			catch (Exception e) {
				//e.printStackTrace();
				//System.out.println("	Current value: NULL");
				value = "empty";
			}
			
			// CHECK if PRIMITIVE
			if (f.getType().isPrimitive()) {
			
			value_element = new Element("value");
			value_element.setText(String.valueOf(value));
			
			field_element.addContent(value_element);
			
			//ele.addContent(field_element);
			}
			
			else if(f.getType().isArray()) {
				
				
				
				try {
					length = Array.getLength(f.get(obj));
					
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					
				}
				
				
				for (int i =0; i < length; i++) {
					
					
					try {
						count = (char) Array.getInt(f.get(obj), i);
					} 
					catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
					} 
					
					catch (IllegalArgumentException e) {
						//e.printStackTrace();
						count = '0';
					} 
					catch (IllegalAccessException e) {	
						e.printStackTrace();
					}
					//count = i;
					
					value_element = new Element("value");
					value_element.setText(String.valueOf(count));
					
					field_element.addContent(value_element);
					
					//ele.addContent(field_element);
					
				}			
				
			}
			
			// CHECK REFERENCE
			else {
				
				try {
					serializeRef(f.get(obj));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			ele.addContent(field_element);
		}
		
		// 
		root.addContent(ele);
		
		
		
		// Create XML file and XMLOutputStream		
		XMLOutputter xmlout = new XMLOutputter();
		
		
		try {
			FileOutputStream fos = new FileOutputStream("Object.xml");
			
			xmlout.setFormat(Format.getPrettyFormat());
			xmlout.output(document, System.out);
			xmlout.output(document, fos);			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	public void serializeRef(Object obj) {
		
		// set object element tag
		refEle = new Element("object");
				
		// Get the class of the object
		refClas = obj.getClass();
				
		// Set required attributes
		refEle.setAttribute("class", refClas.getSimpleName());
		refEle.setAttribute("id", String.valueOf(refClas.hashCode()));
		
		Field[] refFields = obj.getClass().getDeclaredFields();
		
		for(Field f : refFields) {
			
			// set field element tag
			field_element = new Element("field");
			
			// get fields of the object
			field_element.setAttribute("name", f.getName() );
			field_element.setAttribute("declaringclass", String.valueOf(f.getDeclaringClass()));
			
			// set value
			try {
				value = f.get(obj).toString();				
			}
			
			
			catch (Exception e) {
				//e.printStackTrace();
				//System.out.println("	Current value: NULL");
				value = "empty";
			}
			
			// CHECK if PRIMITIVE
			if (f.getType().isPrimitive()) {
			
			value_element = new Element("reference");
			value_element.setText(String.valueOf(value));
			
			field_element.addContent(value_element);
			
			
			}
		}
		
		//refle.addContent(field_element);
	}
	
	public char convertChar(Object obj) {
		char test = '0';
		
		return test;
				
	}
}
