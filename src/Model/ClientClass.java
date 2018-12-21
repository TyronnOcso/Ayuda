/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.*;
import java.net.*;

/**
 *
 * @author John Tyronn Ocso
 */
public class ClientClass {
    
    public static String ip = "";
    public ClientClass(String ip) throws IOException{
        
        this.ip = ip;
        main();
    }
    public static void main() throws IOException{
        System.out.println("12121212");
        //System.out.println("eqweq");
        Socket s = new Socket("localhost",1414);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String msgin = "", msgout="";
        while(!msgin.equals("end")){
            
            msgin = din.readUTF();
            System.out.println("lllllllllll");
            System.out.println(msgin);
            if(msgin.equals("update")){
                System.out.println("2222222");
                ConcSubj conc = ConcSubj.getInstance();
                conc.notifyObserversNaGyud();
                break;
            }
            System.out.println("33333");
        }
    s.close();
    }
}
