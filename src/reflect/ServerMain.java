package reflect;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) throws IOException {
		
		
		byte [] b = new byte[20002];
		ServerSocket ss = new ServerSocket(4999);
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		FileOutputStream fr = new FileOutputStream("C:\\Users\\Max\\eclipse-workspace\\reflect\\testing\\getXML.xml");
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		
		
		// Create a Deserialize object
		Deserialize d = new Deserialize();
				
		// Deserialize
		d.deserialize();
	}
}
