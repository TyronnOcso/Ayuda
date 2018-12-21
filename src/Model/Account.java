/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Account implements UserObserver{
    
    private static Account instance;
    public Account(){
        
    }
    
    public static synchronized Account getInstance(){

		if (instance == null)
			instance = new Account();

		return instance;
    }
    
        
    private int id;
    private String name;
    private String email;
    private String pass;
    private String course;
    private int rating =0;
    
    public ArrayList<UserObserver> observers = new ArrayList<UserObserver>();

    public Account(ResultSet rs) {
        try {
            this.email = rs.getString("email");
            this.name = rs.getString("name");
            this.pass = rs.getString("password");
            this.course = rs.getString("course");
            this.rating = rs.getInt("rating");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    
   

//    @Override
//    public void registerObserver(UserObserver task) {
//         observers.add(task);
//         notifyObservers();
//    }
//
//    @Override
//    public void removeObserver(UserObserver task) {
//        observers.remove(task);
//    }
//
//    @Override
//    public void notifyObservers() {
//        for (UserObserver ob : observers) {
//                     //System.out.println("There is a new Task listed");
//                     ob.update(observers);
//                     
//              }
//
//    }
//    
//   public void update(){
//       System.out.println("Accc upd");
//   }



   

    @Override
    public void update() {
       DBConn db = new DBConn();
       
    }

    @Override
    public String getIP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
