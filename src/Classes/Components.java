/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import Classes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Hp
 */
public class Components {
    
    public void insertBooks(BookItm itm){
        try {
            ConnectionClass connection =new ConnectionClass();
            Connection c=connection.getConnection();
             String Sql="insert into books(ISBN,BookCatag,BookName,AuotherFname,AuthorSname) values(?,?,?,?,?)";
        PreparedStatement pst=c.prepareStatement(Sql);
        pst.setString(1,itm.getIsbn());
        pst.setString(2, itm.getbCatag());
        pst.setString(3, itm.getbName());
        pst.setString(4, itm.getaFname());
        pst.setString(5, itm.getaSname());
       
       
        
        int rs=pst.executeUpdate();
        
        if(rs>0){
            
            JOptionPane.showMessageDialog(null, "SAVED");
            
        }
         else{
             JOptionPane.showMessageDialog(null, "Can not Save");
         }
        } catch (Exception ex) {
            Logger.getLogger(Components.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    public void deleteBooks(BookItm itm){
        
        try {
        ConnectionClass con=new ConnectionClass();
        Connection c=con.getConnection();
        String val1=itm.getIsbn();
        
         
        String sql="delete   from books where ISBN='"+val1+"' ";
        PreparedStatement prest = c.prepareStatement(sql);
        prest.execute();
            JOptionPane.showMessageDialog(null, "DELETED");
    } catch (Exception ex) {
        Logger.getLogger(Components.class.getName()).log(Level.SEVERE, null, ex);
    }
           
    }
    
    
    
}
