/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class conexionmysql {
    
    Connection conectar=null;
    
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cs","root","");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No conectada"+e.getMessage());
        }
        return conectar;
    }   
}
