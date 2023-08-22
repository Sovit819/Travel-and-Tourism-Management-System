
package travel.management.system;

import java.sql.*;


public class Connec {
    
    Connection c;
    Statement s;
    
    Connec(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelManagementSystem", "root", "MYSQL@123");
            s = c.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return c;
    }

    public Statement getStatement() {
        return s;
    }

//    public static void main(String[] args){
//        new Connec();
//        
//    }
}
