/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Orange
 */
public interface UserSubj {
    
    public void registerObserver(UserObserver observer);
    public void removeObserver(UserObserver observer);
    public void notifyObservers();
    public void notifyObserversNaGyud();

}
