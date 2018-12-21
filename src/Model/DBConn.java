/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Login;
import View.Main;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libanan
 */
public class DBConn {
    
    public String driver = "jdbc:mysql://localhost:3306/ayuda";
    public String user = "root";
    public String pass = "";

    private int id;
    private String name;
    private String email;
    private String course;
    private String password;
    private int rating;

    public Connection myConn;

    public DBConn() {

        connect();

    }

    public void connect() {

        try {

            myConn = DriverManager.getConnection(driver, user, pass);

        } catch (SQLException ex) {
        }
    }

    public void getAll(int id) {

        try {
            Statement log = myConn.createStatement();
            String sql = "SELECT * FROM account WHERE id = " + id;
            ResultSet rs = log.executeQuery(sql);

            while (rs.next()) {
                this.id = rs.getInt("id");
                this.name = rs.getString("name");
                this.email = rs.getString("email");
                this.course = rs.getString("course");
                this.password = rs.getString("password");
                this.rating = rs.getInt("rating");
            }
       
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void registerAcc(Account acc) {

        try {
            String qry1 = "INSERT INTO account"
                    + "(email, password, course, name,rating)"
                    + "VALUES('" + acc.getEmail() + "', '" + acc.getPass() + "', '" + acc.getCourse() + "', '" + acc.getName() + "','" + acc.getRating() + "')";

            Statement sql1 = myConn.createStatement();

            sql1.executeUpdate(qry1);

            System.out.println("Insert Complete");
        } catch (SQLException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int loginUser(String email, String pass) throws SQLException {

        int ret = 0;
        Statement log = myConn.createStatement();

        String sql = "SELECT * FROM account";
        ResultSet rs = log.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("email").equals(email) && rs.getString("password").equals(pass)) {
                ret = rs.getInt("id");
                
                //String sql2 = "UPDATE account SET active = 1 WHERE id = "+rs.getInt("id");
                
                //log.executeUpdate(sql2);
                //System.out.println("qedqwadqa");
                break;
            } else {
                ret = -1;
            }

        }

        return ret;
    }
    
    public ArrayList<Account> getUsers() throws SQLException{
      
            ArrayList<Account> accList = new ArrayList<Account>();
            Account ac = new Account();
            Statement log = myConn.createStatement();
            
            String sql = "SELECT * FROM account ";
            ResultSet rs = log.executeQuery(sql);
            while (rs.next()) {
                ac.setId(rs.getInt("id"));
                ac.setName(rs.getString("name"));
                ac.setEmail(rs.getString("email"));
                ac.setPass(rs.getString("password"));
                ac.setCourse(rs.getString("course"));
                ac.setRating(rs.getInt("rating"));
               accList.add(ac);
            }
        return accList;
    }

    
    public void signOut() throws SQLException{
        Account acc = Account.getInstance();
                String sql2 = "UPDATE account SET active = 0 WHERE id =  "+acc.getId();
                Statement log = myConn.createStatement();
                log.executeUpdate(sql2);
    }

    public int getRating() {
        return rating;
    }
    
    
    public void addtodb(Task task) throws SQLException{
        Account acc = Account.getInstance();
        
        
        String qry1 = "INSERT INTO task"
                    + "(task_title, task_desc, task_time, user_id)"
                    + "VALUES('" + task.getTaskname() + "', '" + task.getTaskdesc()+ "', '" + task.getTasktime()+ "', '" +acc.getId() + "')";

            Statement sql1 = myConn.createStatement();

            sql1.executeUpdate(qry1);

            System.out.println("Insert Complete");
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getPassword() {
        return password;
    }
    
    public ArrayList<Task> taskList() throws SQLException{
       ArrayList<Task> tasksList = new ArrayList<Task>();
       DBConn db = new DBConn();
       
       String query = "SELECT *  FROM task";
       Statement st = db.myConn.createStatement();
       ResultSet rs = st.executeQuery(query);
        System.out.println("aw sa"); 
       while(rs.next()){
           Task task = new Task(rs);
           tasksList.add(task);
       }
       return tasksList;
    }

}
