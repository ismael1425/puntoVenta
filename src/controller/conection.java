
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;




public class conection {
    public  String db ="puntoventa";
    public  String url= "jdbc:mysql://127.0.0.1/"+db;
    public String user= "root";
    public String pass="";

    public conection() {
    }
    
    public Connection conect(){
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
    }
    
}
