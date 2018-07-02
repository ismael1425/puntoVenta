
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.vProducts;


public class fProducts {
    private conection mysql = new conection();
    private Connection cn = mysql.conect();
    private String aSQL ="";
    
    public int totalRecords;
    
    
    public DefaultTableModel showProducts(String search){
        DefaultTableModel model;
        
        String [] titles= {"ID","Clave", "Precio","Descripción", "Precio Cliente","Fecha de registro" };
        String [] records = new String [7];
        totalRecords = 0;
        model = new DefaultTableModel(null,titles);
        aSQL= "select * from products where clave like '%"+search+"%' or description like'%"+search+"%' order by id";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            
            while(rs.next()){
                records[0]=rs.getString("id");
                records[1]=rs.getString("clave");
                records[2]=rs.getString("price");
                records[3]=rs.getString("description");
                records[4]=rs.getString("priceClient");;
                records[5]=rs.getString("registered");
                totalRecords +=1;
                model.addRow(records);
            }
            return model;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
                
    }
    
    
    public boolean insertProduct(vProducts dts){
         aSQL = "insert into products (clave,price, description,priceClient) values (?,?,?,?)";
           
        try {
            PreparedStatement pst=cn.prepareStatement(aSQL);
            pst.setString(1, dts.getClave());
            pst.setDouble(2, dts.getPrice());
            pst.setString(3, dts.getDescription());
            pst.setDouble(4, dts.getPriceClient());
            int n=pst.executeUpdate();
            if(n!= 0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean updateProduct(vProducts dts){
        aSQL ="update products set clave=?, price=?, description=?,priceClient=? "+
                "where id=?";
        try {
            PreparedStatement pst=cn.prepareStatement(aSQL);
            pst.setString(1, dts.getClave());
            pst.setDouble(2, dts.getPrice());
            pst.setString(3, dts.getDescription());
            pst.setDouble(4, dts.getPriceClient());      
            pst.setInt(5, dts.getId());
            int n=pst.executeUpdate();
            if(n!= 0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    public boolean deleteProduct(vProducts dts){
        aSQL="delete from products where id=?";
        try {
            PreparedStatement pst=cn.prepareStatement(aSQL);
            
            pst.setInt(1, dts.getId());
            
            int n=pst.executeUpdate();
            if(n!= 0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public String[] findProduct(String product){
        DefaultTableModel model;
        String [] records = new String [3];
        totalRecords = 0;
        model = new DefaultTableModel();
        aSQL= "select clave, priceClient, description from products where clave ="+product+" limit 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            
            while(rs.next()){
                records[0]=rs.getString("clave");
                records[1]=rs.getString("description");
                records[2]=rs.getString("priceClient");
                totalRecords +=1;
                //model.addRow(records);
            }
            return records;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
    }
}
