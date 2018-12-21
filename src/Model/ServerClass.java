
package Model;


import java.io.*;
import java.net.*;

/**
 *
 * @author John Tyronn Ocso
 */
public class ServerClass {
    private static ServerClass instance;
    
    public ServerClass() throws IOException{
        main();
    }
    
     public static synchronized ServerClass getInstance() throws IOException{

		if (instance == null)
			instance = new ServerClass();

		return instance;
    }
     
    public static void main() throws IOException{
    
    ServerSocket ss = new ServerSocket(1414);
    Socket s = ss.accept();
    
    DataInputStream din = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
     
        String msgin = "", msgout="";
        while(!msgin.equals("end")){
            System.out.println("SSSSSSSS");
            msgout = "update";
            dout.writeUTF(msgout);
            break;
        }
    s.close();
    }
}
