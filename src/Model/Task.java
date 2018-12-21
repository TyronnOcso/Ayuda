/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Orange
 */
public class Task {

    
    public Task(){
        
    }
    public Task(ResultSet rs) throws SQLException {
      
            this.id = rs.getInt("id");
            this.taskmaker = rs.getInt("user_id");
            this.taskname = rs.getString("task_title");
            this.taskdesc = rs.getString("task_desc");
            this.tasktime = rs.getString("task_time");

    }
    
    public Task(String taskname, String taskdesc, String tasktime){
        this.tasktime = tasktime;
        this.taskname = taskname;
        this.taskdesc = taskdesc;
    }

    public String getTaskname() {
        return taskname;
    }

  
    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }


    public String getTaskdesc() {
        return taskdesc;
    }

  
    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }

  
    public int getTaskmaker() {
        return taskmaker;
    }


    public void setTaskmaker(int taskmaker) {
        this.taskmaker = taskmaker;
    }

    public String getTasktime() {
        return tasktime;
    }

    public void setTasktime(String tasktime) {
        this.tasktime = tasktime;
    }
    public int id;
    private String taskname;
    private String taskdesc;
    private int taskmaker;
    private String tasktime;
    
   
}
