/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phar;

import interfaces.drugReg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.h2.expression.Function;

/**
 *
 * @author Ana
 */
public class Phar {

    Connection con;
     public Phar() throws SQLException
	        {
			con = db.connect(); 
                        
	        }
     
    

    public int loginCheck(String name,String pass)  {
        int f=0;
        try {
          
            java.sql.Statement stmt;
             
                 stmt = con.createStatement();
                 
            ResultSet rs2=stmt.executeQuery("select * from login WHERE uname='"+name+"' "); 
            System.out.println("con");
            
            while(rs2.next())
            {
                
               
                if (pass.equals(rs2.getString(2))){
                    f=1;
                    
                }   
            }      
              
             
       } catch (SQLException ex) {
                System.out.println(ex);
             }

          return f;  
    }
    public String checkexp() throws ParseException{
        String nt=null;
        try {
//            Calendar cal= Calendar.getInstance();
//                DateFormat dtoday = new SimpleDateFormat("yyyy-MM-dd");
//                String da = dtoday.format(cal.getTime());
                
            PreparedStatement p = con.prepareStatement("SELECT count(EXPIREDATE) FROM DRUGREG where (datediff(day,curdate(),EXPIREDATE))<0");
            ResultSet rs=p.executeQuery();
            
            while(rs.next()){

                   nt=rs.getString(1);
            }
            System.out.println(nt);
        } catch (SQLException ex) {
            Logger.getLogger(Phar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nt;        
    }
    public String almostexp(){
        String nt=null;
        try {
              
            PreparedStatement p = con.prepareStatement("SELECT count(EXPIREDATE) FROM DRUGREG where (datediff(day,curdate(),EXPIREDATE))<15");
            ResultSet rs=p.executeQuery();
            
            while(rs.next()){

                   nt=rs.getString(1);
            }
            System.out.println(nt);
        } catch (SQLException ex) {
            Logger.getLogger(Phar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nt;
    }
    
    public int checkStock(){
        int nt=0;
        try {
            PreparedStatement p = con.prepareStatement("select *from drugreg");
            ResultSet rs=p.executeQuery();
            while(rs.next()){
                if((rs.getInt("quantity"))<=15){
                    nt++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Phar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nt;        
    }
    public void drugReg(String name,String group,String manu,String dtype,int quantity,String expDate,
            String proDate,float tp,float mrp,float vat, float bonusRate,String bonusRatio,float discount,int vaccine) {
            

            float pricewithdis= tp-((tp*discount)/100);
            
            try
            {   
          
                //Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                //insert into manufac table
                PreparedStatement p = con.prepareStatement("select *from drugreg where drugname=? and druggroup=? and manufacturer=? and expiredate=? ");
                p.setString(1, name);
                p.setString(2, group);
                p.setString(3, manu);
                p.setString(4, expDate);
                ResultSet resultSet=p.executeQuery();
                DateFormat d = new SimpleDateFormat("yyyy-M-d");
                Date date =new Date();
                Date expdate=d.parse(expDate);
                
            
                //checking if the medicine has registered before or not
                if (resultSet.next()){
                   
                        
                        int q=resultSet.getInt("quantity");//remaining amount of drug
                        PreparedStatement pst=con.prepareStatement("update drugreg set quantity=? where expiredate=? and drugname=? ");
                        pst.setInt(1, (q+quantity)); //adding quantity with remaining amount 
                       
                        pst.setString(2, expDate);
                        pst.setString(3, name);
                        int t=pst.executeUpdate();
                                
                        if(t==1){
                             JOptionPane.showMessageDialog(null,"Registration Done!");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Error Update!");
                        }
                        
                    
                    //ResultSet datedif=statement.executeQuery("select datediff('day','"+pre+",'"+expDate+"')");
                }
                else{
                  
                    PreparedStatement pst1=con.prepareStatement("insert into drugreg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst1.setString(1, name);
                    pst1.setString(2, group);
                    pst1.setString(3, manu);
                    pst1.setString(4, dtype);
                    pst1.setInt(5, quantity);
                    pst1.setFloat(6, tp);
                    pst1.setFloat(7, mrp);
                    pst1.setFloat(8, vat);
                    pst1.setFloat(9, bonusRate);
                    pst1.setString(10, bonusRatio);
                    pst1.setFloat(11, discount);
                    pst1.setFloat(12, pricewithdis);
                    pst1.setString(13, d.format(date));
                    pst1.setString(14, proDate);
      
                    pst1.setString(16, expDate);
                    pst1.setInt(15, vaccine);
                    int t2=pst1.executeUpdate();
                              System.out.print(t2+"t2");
                    if(t2==1){
                         JOptionPane.showMessageDialog(null,"Registration Done!");
                    }
                    else{
                         JOptionPane.showMessageDialog(null,"Error2!");
                    }
                }
            }

        catch (Exception ex) {
            Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
public void deletet() throws SQLException{
    int quan=0;
      Statement s=con.createStatement(); 
              
            int r1= s.executeUpdate("delete from drugreg where quantity='"+quan+"'");
            
}
public void updatet(int q,String n){
    
    int qua=0,rest=0;
   
    try
        {    Statement s=con.createStatement(); 
            ResultSet rs= s.executeQuery("Select * from drugreg where drugname='"+n+"'");
            while(rs.next()){
               qua=rs.getInt("QUANTITY");
                rest=(qua-q);
            
            }
           
           
            PreparedStatement pst=con.prepareStatement("update drugreg set quantity=? where drugname=?");
            pst.setInt(1, rest);
            pst.setString(2, n);
            pst.executeUpdate();
            
        }
        catch(SQLException | NumberFormatException e)
        { 
            System.out.println(e);
        }  
        
    }
    
    
}
