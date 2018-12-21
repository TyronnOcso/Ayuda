/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Main;

/**
 *
 * @author John Tyronn Ocso
 */
public class IPS implements UserObserver{
    public String ip = "";
    
    public IPS(String ip){
        this.ip = ip;
    }

    @Override
    public void update() {
        //closes then opens Main page to refresh
        System.out.println("UPDATE!!!!");
        new Main().setVisible(true);
    }

    @Override
    public String getIP() {
        return this.ip;
    }
    
    
}
