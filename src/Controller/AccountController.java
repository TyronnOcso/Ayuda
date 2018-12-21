/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.ConcSubj;
import Model.DBConn;
import Model.Task;
import Model.UserObserver;
import View.Login;
import View.Main;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Orange
 */
public class AccountController {

    public void loginUser(String email, String pass) throws SQLException {
        DBConn db =new DBConn();
            
            int cats = db.loginUser(email,pass);
            db.getAll(cats);
            if(cats == 0){
                new Login().setVisible(true);
            }else{
              Account acc = Account.getInstance();
                acc.setId(db.getId());
                acc.setCourse(db.getCourse());
                acc.setEmail(db.getEmail());
                acc.setName(db.getName());
                acc.setPass(db.getPassword());
                acc.setRating(db.getRating());
                new Main().setVisible(true);
            }
    }
    

        public void addTask(Task task) throws SQLException{
        DBConn db = new DBConn();
        db.addtodb(task);
        ConcSubj conc = ConcSubj.getInstance();
        conc.notifyObservers();
        new Main().setVisible(true);
    }
        
        public void reg(Account acc){
            DBConn db = new DBConn();
            db.registerAcc(acc);
        }
}
