/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orange
 */
public class ConcSubj implements UserSubj{
    private static ConcSubj instance;
    public ArrayList<UserObserver> ips = new ArrayList<UserObserver>();
    public ConcSubj(){
        IPS ip = new IPS("192.168.254.115");
        ips.add(ip);
    }
    
    public static synchronized ConcSubj getInstance(){

		if (instance == null)
			instance = new ConcSubj();

		return instance;
    }
    

    
    @Override
    public void registerObserver(UserObserver observer) {
         ips.add(observer);
    }

    @Override
    public void removeObserver(UserObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers() {
        try {
            ServerClass sv = ServerClass.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(ConcSubj.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(UserObserver i : ips){
            
            try {
                ClientClass cc = new ClientClass(i.getIP());
            } catch (IOException ex) {
                Logger.getLogger(ConcSubj.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void notifyObserversNaGyud() {
        
        for(UserObserver i : ips){
                i.update();
        }    
    
    }
    
}
