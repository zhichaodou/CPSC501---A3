package reflect;
import java.util.Scanner;
import java.net.*;
import java.io.*;


public class ClientMain {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		boolean booltest;
		int inttest;
		char chartest;
		float floattest;
		String catcher;
		int arrayLength;
		
		Scanner in = new Scanner(System.in);
		
		// Create a object
		ObjectMaker om = new ObjectMaker();
		
		// Create a Serialize object
		Serialize s = new Serialize();
		
		System.out.println("Please choose which scenerio you would like to run with:");
		System.out.println("1) A simple object with only primitives for instance variables.");
		System.out.println("2) An object that contains references to other objects.");
		System.out.println("3) An object that contains an array of primitives. ");
		System.out.println("4) An object that contains an array of object references. ");
		System.out.println("5) An object that uses an instance of one of Java’s collection classes to refer to several other objects. ");
		
		System.out.print("Pleace select your choice:");
		int input = in.nextInt();
		
		if (input == 1) {
			System.out.print("Scenerio 1), please pick your boolean:");
			catcher = in.next();
			booltest = Boolean.parseBoolean(catcher);
			om.setboolprimitive(booltest);
			System.out.print("Scenerio 1), please pick your int:");
			inttest = in.nextInt();
			om.setintprimitive(inttest);
			System.out.print("Scenerio 1), please pick your char:");
			chartest = in.next().charAt(0);
			om.setcharprimitive(chartest);
			System.out.print("Scenerio 1), please pick your float:");
			catcher = in.next();
			floattest = Float.valueOf(catcher.trim()).floatValue();
			om.setfloatprimitive(floattest);
			
			// Serialize to XML
			s.serialize(om);
			
		}
		
		else if (input == 2) {
			System.out.print("Scenerio 2), the reference object intakes a float, please set the float to a value of your choice:");
			catcher = in.next();
			floattest = Float.valueOf(catcher.trim()).floatValue();
			om.setreffloat(floattest);
			
			// Serialize to XML
			s.serialize(om);
		}
		
		
		else if (input == 3) {
			System.out.print("Scenerio 3), please build an array of size (6), start by suggesting the size:");
			arrayLength = in.nextInt();
			
			char[] chararrayTest = new char[arrayLength];
			for(int counter = 0; counter < arrayLength; counter++) {
				System.out.print("Enter the value of for index " + (counter) + ":");
				chartest = in.next().charAt(0);
				chararrayTest[counter] = chartest;
			}
			System.out.println("");
			om.setarray(chararrayTest);
			// Serialize to XML
			s.serialize(om);
		}
		
		else if (input == 4) {
			
		}
		
		else if (input == 5) {
			
		}
		
		
		startSocket();
	}
	
	public static void startSocket() throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost",4999);
		
		FileInputStream fr = new FileInputStream("C:\\Users\\Max\\eclipse-workspace\\reflect\\Object.xml");
		byte [] b = new byte[2002];
		fr.read(b,0,b.length);
		
		OutputStream os = s.getOutputStream();
		os.write(b,0,b.length);
		
		
	}
}