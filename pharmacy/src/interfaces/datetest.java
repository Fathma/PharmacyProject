/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ana
 */
public class datetest {
    public static void main(String[] args) throws ParseException {
        
        Calendar cal= Calendar.getInstance();
        DateFormat dtoday = new SimpleDateFormat("yyyy-MM-dd");
            String da = dtoday.format(cal.getTime());
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(da);
            
            
       
        System.out.println(date1);
    }
    
}
