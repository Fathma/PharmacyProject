/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import phar.Phar;
import phar.db;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Ana
 */
public class drugReg extends javax.swing.JFrame {
        Connection con;
    /**
     * Creates new form drugReg
     */
    public drugReg() throws SQLException {
        
        initComponents();
        con = db.connect();
        disc.setText("0");
        vat.setText("0");
        showtable();
        showtable2();
        showtable3();
         manufac.setSelectedItem("");
                dgroup.setText("");
                quan.setText("");
                vac.setSelectedItem("");
                tradep.setText("0.0");

                v.setText("0");
                mrpp.setText("0.0");
                drugtype.setSelectedItem("");
                ratio.setText("");
                dis.setText("0");
                bonusr.setText("0");
        Phar ob=new Phar();
        ob.deletet();
        setcombo();
        
        jComboBox1.setSelectedItem("");
        
            
         

    }
    public void setcombo()throws SQLException {
        java.sql.Statement stmt;
//        
//                manufac.removeAllItems();
//                vac.removeAllItems();
//                drugtype.removeAllItems();
//                dtype.removeAllItems();
//                dname.removeAllItems();
// int itemCount = jComboBox1.getItemCount();
//
//    for(int i=0;i<itemCount;i++){
//        jComboBox1.removeItemAt(i);
//     }
         stmt = con.createStatement();
             ResultSet ruu=stmt.executeQuery("SELECT drugname FROM drugreg group by drugname order by drugname");
           
            while(ruu.next())
            {
                 
                jComboBox1.addItem(ruu.getString("drugname"));
            }
         
            
             ResultSet ru=stmt.executeQuery("SELECT unit FROM salerecord group by unit order by unit");
           
            while(ru.next())
            {
                 
                unit.addItem(ru.getString("unit"));
            }
             ResultSet rss=stmt.executeQuery("SELECT MANUFACTURER FROM DRUGREG group by MANUFACTURER order by manufacturer");
           
            while(rss.next())
            {
                 
                manufac.addItem(rss.getString("MANUFACTURER"));
            }
            ResultSet rs1=stmt.executeQuery("SELECT TYPE FROM DRUGREG GROUP BY TYPE order by type");
        
            while(rs1.next())
            {
                drugtype.addItem(rs1.getString("TYPE"));
                
            } 
            ResultSet rs2=stmt.executeQuery("SELECT VACCINE FROM DRUGREG group by VACCINE order by vaccine");

            while(rs2.next())
            {
                vac.addItem(rs2.getString("VACCINE"));
            } 
            
            ResultSet ruui=stmt.executeQuery("SELECT TYPE FROM DRUGREG GROUP BY TYPE order by TYPE");
           
            while(ruui.next())
            {
                 
                dtype.addItem(ruui.getString("type"));
            }
            
    }
    
    public void showtable(){
        PreparedStatement st;
    try {
         st = con.prepareStatement("Select * from drugreg;");
         ResultSet rs = st.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex) {
         Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void showtable2(){
        PreparedStatement st;
    try {
         st = con.prepareStatement("Select * from salerecord;");
         ResultSet rs = st.executeQuery();
         saletable.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex) {
         Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void showtable3(){
        PreparedStatement st;
    try {
         st = con.prepareStatement("Select * from receiptrecord;");
         ResultSet rs = st.executeQuery();
         rcpt.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (SQLException ex) {
         Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar2 = new javax.swing.JScrollBar();
        pop = new javax.swing.JPopupMenu();
        Delete = new javax.swing.JMenuItem();
        salepop = new javax.swing.JPopupMenu();
        Delete1 = new javax.swing.JMenuItem();
        salerecord = new javax.swing.JPopupMenu();
        Delete2 = new javax.swing.JMenuItem();
        rcpttable = new javax.swing.JPopupMenu();
        Delete3 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        prodate = new com.toedter.calendar.JDateChooser();
        tradep = new javax.swing.JTextField();
        v = new javax.swing.JTextField();
        quan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        exdate = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        mrpp = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        manufac = new javax.swing.JComboBox<>();
        vac = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        drugtype = new javax.swing.JComboBox<>();
        ratio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bonusr = new javax.swing.JTextField();
        dgroup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dis = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        saletable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rcpt = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        rcptn = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        dress = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cname = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cln = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        gra = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        cas = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        du = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        ddda = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        saa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        rate = new javax.swing.JLabel();
        bratio = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dtype = new javax.swing.JComboBox<>();
        dname = new javax.swing.JComboBox<>();
        dmanu = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        gru = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        disc = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        mrp = new javax.swing.JTextField();
        vat = new javax.swing.JTextField();
        trade = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        qqq = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        ta = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        taa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        totala = new javax.swing.JLabel();
        totalv = new javax.swing.JLabel();
        totalam = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        Dues = new javax.swing.JLabel();
        ca = new javax.swing.JTextField();
        duee = new javax.swing.JTextField();
        unit = new javax.swing.JComboBox<>();
        discounttaka = new javax.swing.JTextField();
        vattaka = new javax.swing.JTextField();
        rn = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cus = new javax.swing.JTextField();
        cl = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        ddatee = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        pop.add(Delete);

        Delete1.setText("Delete");
        Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1ActionPerformed(evt);
            }
        });
        salepop.add(Delete1);

        Delete2.setText("Delete");
        Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete2ActionPerformed(evt);
            }
        });
        salerecord.add(Delete2);

        Delete3.setText("Delete");
        Delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete3ActionPerformed(evt);
            }
        });
        rcpttable.add(Delete3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DRUG REGISTRATION");
        setMinimumSize(new java.awt.Dimension(1366, 700));
        setSize(new java.awt.Dimension(680, 1260));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1366, 738));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1405, 740));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("DRUG NAME");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 50, 130, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("MANUFACTURER");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(110, 110, 160, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("TRADE PRICE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(780, 190, 120, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("VACCINES");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(110, 180, 130, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("PRODUCTION DATE");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(100, 290, 180, 22);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("BONUS RATE");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 500, 120, 22);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("DRUG GROUP");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(780, 40, 140, 22);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("QUANTITY");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(790, 110, 110, 22);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("VAT %");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(790, 260, 110, 22);

        prodate.setDateFormatString("yyyy-M-d ");
        jPanel1.add(prodate);
        prodate.setBounds(290, 280, 260, 30);

        tradep.setText("0.0");
        tradep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tradepActionPerformed(evt);
            }
        });
        jPanel1.add(tradep);
        tradep.setBounds(920, 180, 250, 30);

        v.setText("0");
        jPanel1.add(v);
        v.setBounds(920, 250, 250, 30);

        quan.setText("0");
        jPanel1.add(quan);
        quan.setBounds(920, 100, 250, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("EXPIRY DATE");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(100, 380, 130, 22);

        exdate.setDateFormatString("yyyy-M-d ");
        jPanel1.add(exdate);
        exdate.setBounds(290, 360, 260, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("MRP");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(790, 380, 40, 22);

        mrpp.setText("0.0");
        jPanel1.add(mrpp);
        mrpp.setBounds(910, 370, 270, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(590, 580, 100, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(710, 580, 100, 40);

        manufac.setEditable(true);
        manufac.setToolTipText("");
        manufac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacActionPerformed(evt);
            }
        });
        jPanel1.add(manufac);
        manufac.setBounds(280, 100, 270, 30);

        vac.setEditable(true);
        vac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vacActionPerformed(evt);
            }
        });
        jPanel1.add(vac);
        vac.setBounds(280, 170, 270, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("TYPE");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(790, 450, 50, 22);

        drugtype.setEditable(true);
        jPanel1.add(drugtype);
        drugtype.setBounds(910, 440, 270, 30);

        ratio.setText("0:0");
        jPanel1.add(ratio);
        ratio.setBounds(920, 500, 260, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("BONUS RATIO");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(784, 510, 130, 22);

        bonusr.setText("0");
        jPanel1.add(bonusr);
        bonusr.setBounds(290, 490, 260, 30);
        jPanel1.add(dgroup);
        dgroup.setBounds(920, 40, 250, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("DISCOUNT");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 440, 110, 22);

        dis.setText("0");
        jPanel1.add(dis);
        dis.setBounds(290, 430, 260, 30);

        jComboBox1.setEditable(true);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(280, 40, 270, 30);

        jTabbedPane1.addTab("NEW ENTRY", jPanel1);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1372, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("STOCK", jPanel6);

        saletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        saletable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saletableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saletableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(saletable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1395, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("SALE RECORD", jPanel7);

        rcpt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rcpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rcptMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rcptMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(rcpt);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1395, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("RECEIPT RECORD", jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("RECORDS", jPanel3);

        jPanel4.setLayout(null);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setText("ENTER RECEIPT NUMBER:");
        jPanel4.add(jLabel42);
        jLabel42.setBounds(330, 60, 212, 22);
        jPanel4.add(rcptn);
        rcptn.setBounds(570, 50, 180, 30);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setText("CUSTOMER NAME:");
        jPanel4.add(jLabel43);
        jLabel43.setBounds(280, 130, 190, 22);

        dress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(dress);
        dress.setBounds(800, 130, 580, 20);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("CELL NO:");
        jPanel4.add(jLabel45);
        jLabel45.setBounds(360, 190, 100, 22);

        cname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(cname);
        cname.setBounds(470, 130, 170, 20);

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("ADDRESS:");
        jPanel4.add(jLabel47);
        jLabel47.setBounds(700, 130, 100, 22);

        cln.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(cln);
        cln.setBounds(460, 190, 150, 20);

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setText("GRAND TOTAL:");
        jPanel4.add(jLabel49);
        jLabel49.setBounds(650, 240, 160, 22);

        gra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(gra);
        gra.setBounds(810, 240, 90, 20);

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel51.setText("CASH:");
        jPanel4.add(jLabel51);
        jLabel51.setBounds(390, 240, 70, 22);

        jButton7.setText("SEARCH");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);
        jButton7.setBounds(770, 50, 110, 30);

        cas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(cas);
        cas.setBounds(450, 240, 90, 20);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setText("DUES:");
        jPanel4.add(jLabel46);
        jLabel46.setBounds(390, 290, 60, 22);

        du.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(du);
        du.setBounds(450, 290, 100, 20);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("DATE:");
        jPanel4.add(jLabel44);
        jLabel44.setBounds(740, 190, 60, 22);

        ddda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(ddda);
        ddda.setBounds(810, 190, 90, 20);

        saa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(saa);

        jPanel4.add(jScrollPane5);
        jScrollPane5.setBounds(52, 320, 1260, 260);

        jTabbedPane1.addTab("SEARCH", jPanel4);

        jPanel2.setMinimumSize(new java.awt.Dimension(1400, 720));
        jPanel2.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("DRUG TYPE:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 20, 110, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("DRUG NAME:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(310, 20, 120, 22);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("DRUG GROUP:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(10, 110, 140, 22);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("EXPIRY DATE:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(10, 190, 130, 22);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("BONUS RATE:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(10, 230, 120, 22);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("BONUS RATIO:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(10, 270, 130, 22);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("TRADE PRICE(tk):");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(10, 310, 150, 22);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("VAT(%):");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(10, 550, 70, 22);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("MRP(tk):");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(10, 350, 90, 22);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("DISCOUNT(%):");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(10, 470, 130, 22);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("PRICE WITH DISCOUNT:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(10, 510, 220, 20);

        rate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(rate);
        rate.setBounds(140, 220, 120, 30);

        bratio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(bratio);
        bratio.setBounds(150, 260, 110, 30);

        exp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(exp);
        exp.setBounds(140, 180, 120, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("MANUFACTURER:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 70, 160, 14);

        dtype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dtypeItemStateChanged(evt);
            }
        });
        dtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtypeActionPerformed(evt);
            }
        });
        jPanel2.add(dtype);
        dtype.setBounds(140, 10, 160, 30);

        dname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dnameItemStateChanged(evt);
            }
        });
        dname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnameActionPerformed(evt);
            }
        });
        jPanel2.add(dname);
        dname.setBounds(430, 10, 160, 30);

        dmanu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(dmanu);
        dmanu.setBounds(170, 60, 130, 30);

        jButton4.setText("SEARCH");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(600, 10, 100, 30);

        gru.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(gru);
        gru.setBounds(150, 100, 140, 30);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("AMOUNT AVAILABLE:");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(10, 150, 200, 22);

        amount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(amount);
        amount.setBounds(210, 150, 120, 20);

        disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discActionPerformed(evt);
            }
        });
        disc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discKeyReleased(evt);
            }
        });
        jPanel2.add(disc);
        disc.setBounds(150, 460, 140, 30);
        jPanel2.add(pwd);
        pwd.setBounds(230, 510, 140, 30);
        jPanel2.add(mrp);
        mrp.setBounds(100, 340, 140, 30);

        vat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vatMouseReleased(evt);
            }
        });
        vat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vatActionPerformed(evt);
            }
        });
        jPanel2.add(vat);
        vat.setBounds(80, 550, 140, 30);

        trade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tradeActionPerformed(evt);
            }
        });
        jPanel2.add(trade);
        trade.setBounds(170, 300, 120, 30);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("QUANTITY:");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(10, 390, 120, 22);

        qqq.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qqqStateChanged(evt);
            }
        });
        jPanel2.add(qqq);
        qqq.setBounds(120, 380, 100, 30);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("TRADE AMOUNT:");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(10, 430, 160, 22);
        jPanel2.add(ta);
        ta.setBounds(170, 420, 140, 30);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("TOTAL PRICE:");
        jPanel2.add(jLabel32);
        jLabel32.setBounds(10, 590, 130, 22);
        jPanel2.add(taa);
        taa.setBounds(140, 590, 140, 30);

        jButton5.setText("ADD TO LIST");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton5.setBorderPainted(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(340, 630, 120, 40);

        jPanel5.setLayout(null);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL", "Product Name", "Unit", "Trade Price", "Quantity", "Trade Amount", "VAT Amount", "Total Amount"
            }
        ));
        tab.setMinimumSize(new java.awt.Dimension(500, 0));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabMouseReleased(evt);
            }
        });
        tab.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(tab);
        if (tab.getColumnModel().getColumnCount() > 0) {
            tab.getColumnModel().getColumn(0).setMinWidth(50);
            tab.getColumnModel().getColumn(0).setPreferredWidth(50);
            tab.getColumnModel().getColumn(0).setMaxWidth(50);
            tab.getColumnModel().getColumn(2).setMinWidth(200);
            tab.getColumnModel().getColumn(2).setPreferredWidth(200);
            tab.getColumnModel().getColumn(2).setMaxWidth(200);
            tab.getColumnModel().getColumn(3).setMinWidth(120);
            tab.getColumnModel().getColumn(3).setPreferredWidth(120);
            tab.getColumnModel().getColumn(3).setMaxWidth(120);
            tab.getColumnModel().getColumn(4).setMinWidth(70);
            tab.getColumnModel().getColumn(4).setPreferredWidth(70);
            tab.getColumnModel().getColumn(4).setMaxWidth(70);
            tab.getColumnModel().getColumn(5).setMinWidth(100);
            tab.getColumnModel().getColumn(5).setPreferredWidth(100);
            tab.getColumnModel().getColumn(5).setMaxWidth(100);
            tab.getColumnModel().getColumn(6).setMinWidth(120);
            tab.getColumnModel().getColumn(6).setPreferredWidth(120);
            tab.getColumnModel().getColumn(6).setMaxWidth(120);
            tab.getColumnModel().getColumn(7).setMinWidth(130);
            tab.getColumnModel().getColumn(7).setPreferredWidth(130);
            tab.getColumnModel().getColumn(7).setMaxWidth(130);
        }

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 0, 890, 180);

        jLabel33.setText("TOTAL AMOUNT:");
        jPanel5.add(jLabel33);
        jLabel33.setBounds(150, 190, 100, 14);

        jButton6.setText(" DONE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(740, 240, 140, 30);
        jPanel5.add(totala);
        totala.setBounds(570, 180, 90, 20);
        jPanel5.add(totalv);
        totalv.setBounds(670, 180, 110, 20);
        jPanel5.add(totalam);
        totalam.setBounds(780, 180, 110, 20);

        jLabel36.setText("CASH:");
        jPanel5.add(jLabel36);
        jLabel36.setBounds(150, 220, 50, 14);

        Dues.setText("DUES:");
        jPanel5.add(Dues);
        Dues.setBounds(150, 260, 40, 20);

        ca.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caActionPerformed(evt);
            }
        });
        ca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caKeyReleased(evt);
            }
        });
        jPanel5.add(ca);
        ca.setBounds(190, 210, 170, 30);
        jPanel5.add(duee);
        duee.setBounds(190, 250, 170, 30);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(500, 370, 900, 290);

        unit.setEditable(true);
        unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitActionPerformed(evt);
            }
        });
        jPanel2.add(unit);
        unit.setBounds(350, 380, 100, 30);

        discounttaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discounttakaActionPerformed(evt);
            }
        });
        discounttaka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discounttakaKeyReleased(evt);
            }
        });
        jPanel2.add(discounttaka);
        discounttaka.setBounds(310, 460, 130, 30);

        vattaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vattakaActionPerformed(evt);
            }
        });
        vattaka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vattakaKeyReleased(evt);
            }
        });
        jPanel2.add(vattaka);
        vattaka.setBounds(230, 550, 130, 30);

        rn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnActionPerformed(evt);
            }
        });
        rn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rnKeyReleased(evt);
            }
        });
        jPanel2.add(rn);
        rn.setBounds(120, 630, 110, 30);

        jLabel29.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel29.setText("Receipt No:");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(10, 630, 100, 19);

        jPanel9.setLayout(null);

        jLabel34.setText("CUSTOMER'S INFO");
        jPanel9.add(jLabel34);
        jLabel34.setBounds(90, 10, 130, 14);

        jLabel37.setText("NAME:");
        jPanel9.add(jLabel37);
        jLabel37.setBounds(30, 60, 80, 14);

        jLabel38.setText("CELL:");
        jPanel9.add(jLabel38);
        jLabel38.setBounds(30, 100, 60, 14);

        jLabel39.setText("ADDRESS:");
        jPanel9.add(jLabel39);
        jLabel39.setBounds(20, 140, 70, 14);

        jLabel40.setText("DATE:");
        jPanel9.add(jLabel40);
        jLabel40.setBounds(30, 180, 70, 14);
        jPanel9.add(cus);
        cus.setBounds(100, 50, 170, 30);
        jPanel9.add(cl);
        cl.setBounds(100, 90, 170, 30);
        jPanel9.add(address);
        address.setBounds(100, 130, 170, 30);

        ddatee.setDateFormatString("yyyy-M-d\n");
        jPanel9.add(ddatee);
        ddatee.setBounds(100, 170, 150, 30);

        jPanel2.add(jPanel9);
        jPanel9.setBounds(950, 30, 340, 240);

        jLabel35.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel35.setText("Unit:");
        jPanel2.add(jLabel35);
        jLabel35.setBounds(280, 390, 60, 19);

        jTabbedPane1.addTab("SALE", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        try {
            
            String name=(jComboBox1.getEditor().getItem()).toString();
            String manu=(manufac.getEditor().getItem()).toString();
            String group= dgroup.getText();
            String ddtype=(drugtype.getEditor().getItem()).toString();
            float brate=Float.parseFloat(bonusr.getText());
            String bbratio=ratio.getText();
        
            int Quantity=Integer.parseInt(quan.getText());
            float tp=Float.parseFloat(tradep.getText());
            float vaaat=Float.parseFloat(v.getText());
            float mrrp=Float.parseFloat(mrpp.getText());
            int vaccines=Integer.parseInt(vac.getEditor().getItem().toString());
           
            String expda=((JTextField)exdate.getDateEditor().getUiComponent()).getText();
            String proda=((JTextField)prodate.getDateEditor().getUiComponent()).getText();
            float discount=Float.parseFloat(dis.getText());
            Phar ob=new Phar();
           
            ob.drugReg(name, group, manu, ddtype, Quantity, expda, proda, tp, mrrp, vaaat, brate, bbratio, discount, vaccines);
//                 jComboBox1.removeAllItems();
//                 manufac.removeAllItems();
//                vac.removeAllItems();
//                drugtype.removeAllItems();
//                dtype.removeAllItems();
//                dname.removeAllItems(); 
           
            
            
        } catch (Exception ex) {
            Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
        }
               setVisible(false);
            try {
                drugReg o=new drugReg();
                o.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
            }
            jComboBox1.setSelectedItem("");
           
//            try {
//                
//                
//                setcombo();
// jComboBox1.setSelectedItem("");
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void vacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vacActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
         showtable();
         showtable2();
         showtable3();
      
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void manufacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacActionPerformed
       
    }//GEN-LAST:event_manufacActionPerformed

    private void dtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtypeActionPerformed
          
          dname.removeAllItems();
          String typ=dtype.getSelectedItem().toString();
   
        try{
            
            java.sql.Statement stmt;

            stmt = con.createStatement();
            ResultSet rs2=stmt.executeQuery("select DRUGNAME from DRUGREG WHERE TYPE='"+typ+"' GROUP BY DRUGNAME");
           
            while(rs2.next())
            {
                 
                dname.addItem(rs2.getString("DRUGNAME"));

            }

            
        } catch (SQLException ex) {
            System.err.println(ex);
        }               
    }//GEN-LAST:event_dtypeActionPerformed

    private void dnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnameActionPerformed
      
      
       
    }//GEN-LAST:event_dnameActionPerformed

    private void dtypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dtypeItemStateChanged
        
         dname.removeAllItems();
         String typ=dtype.getSelectedItem().toString();
   
        try{
            
            java.sql.Statement stmt;

            stmt = con.createStatement();
            ResultSet rs2=stmt.executeQuery("select DRUGNAME from DRUGREG WHERE TYPE='"+typ+"' GROUP BY DRUGNAME");
           
            while(rs2.next())
            {
                 
                dname.addItem(rs2.getString("DRUGNAME"));

            }

            
        } catch (SQLException ex) {
            System.out.println(ex);
        }          
    }//GEN-LAST:event_dtypeItemStateChanged

    private void dnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dnameItemStateChanged
    
    
    }//GEN-LAST:event_dnameItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        try {
          
          String n=dname.getSelectedItem().toString();
          PreparedStatement pst;
          pst = con.prepareStatement("Select * from drugreg where drugname=? ");
          pst.setString(1, n);
          ResultSet rs=pst.executeQuery();
          while(rs.next())
            {
                dmanu.setText(rs.getString("MANUFACTURER"));
                gru.setText(rs.getString("druggroup"));
                amount.setText(String.valueOf(rs.getInt("QUANTITY")));
                exp.setText((rs.getDate("EXPIREDATE")).toString());
                rate.setText(String.valueOf(rs.getFloat("BONUSRATE")));
                bratio.setText(rs.getString("BONUSRATIO"));
                trade.setText(String.valueOf(rs.getFloat("TRADEPRICE")));
                mrp.setText(String.valueOf(rs.getFloat("MRP")));
                vat.setText(String.valueOf(rs.getFloat("VAT")));
//                disc.setText(String.valueOf(rs.getFloat("DISCOUNT")));
//                pwd.setText(String.valueOf(rs.getFloat("PRICEWITHDISCOUNT")));
               
                break;
            }
         
    } catch (SQLException ex) {
        Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
          
    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        if(evt.isPopupTrigger())
            {
                pop.show(this,evt.getXOnScreen(),evt.getYOnScreen());
                
            }
    }//GEN-LAST:event_tableMouseReleased

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
       
    }//GEN-LAST:event_formMouseReleased

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
    try {
        PreparedStatement pst = con.prepareStatement("delete from drugreg where drugname=? ");
        pst.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
        pst.executeUpdate();
        showtable();
    } catch (SQLException ex) {
        Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_DeleteActionPerformed

    private void qqqStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qqqStateChanged
        float price=Float.parseFloat(trade.getText());
        int stock=Integer.parseInt(amount.getText());
        int spin=(int)qqq.getValue();
        if (spin>stock){
            JOptionPane.showMessageDialog(null,"Stock out! please check the Stock amount.");
        }
        else{
             ta.setText(String.valueOf(price*spin));
              float total=Float.parseFloat(ta.getText());
              int d= Integer.parseInt(disc.getText());
              float pricewithdis= total-((total*d)/100);
              float vatt=Float.parseFloat(vat.getText());
              float totalamount = pricewithdis+((pricewithdis*vatt)/100);
              vattaka.setText(String.valueOf((pricewithdis*vatt)/100));
              taa.setText(String.valueOf(totalamount));
              discounttaka.setText(String.valueOf((total*d)/100));
              pwd.setText(String.valueOf(pricewithdis));
        }
       
        
        
    }//GEN-LAST:event_qqqStateChanged

    private void discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discActionPerformed
        
        
    }//GEN-LAST:event_discActionPerformed

    private void unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitActionPerformed

    private void vatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vatActionPerformed
       float vatt=Float.parseFloat(vat.getText());
       float pricewithout=Float.parseFloat(pwd.getText());
       float totalamount = pricewithout+((pricewithout*vatt)/100);
       vattaka.setText(String.valueOf((pricewithout*vatt)/100));
       taa.setText(String.valueOf(totalamount));
    }//GEN-LAST:event_vatActionPerformed

    private void tradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tradeActionPerformed
    int sss=0;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
             int receipt= Integer.parseInt(rn.getText());
        Statement s;
            try {
                s = con.createStatement();
                ResultSet rs=s.executeQuery("select * from salerecord where receiptno='"+receipt+"'");
                if(rs.next()){
                     JOptionPane.showMessageDialog(null,"The receipt number is already exist!\n Please try a new one.");
                }
                else{
                    
              String product=dname.getSelectedItem().toString();
              String uni=unit.getSelectedItem().toString();
              int quani=(int) qqq.getValue();
             
              float tp=Float.parseFloat(trade.getText());
              float tamount=Float.parseFloat(ta.getText());
              float vattk=Float.parseFloat(vattaka.getText());
              float total=Float.parseFloat(taa.getText());
              
      
        
        try{
            Calendar cal= Calendar.getInstance();
            DateFormat dtoday = new SimpleDateFormat("yyyy-MM-dd");
            String dat = dtoday.format(cal.getTime());
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dat);
              DefaultTableModel m=(DefaultTableModel)tab.getModel();
            
            sss++;
            m.addRow(new Object[] {sss,product,uni,tp,quani,tamount,vattk,total});
            
            PreparedStatement pst=con.prepareStatement("insert into SALERECORD values(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, receipt);
            pst.setString(2, product);
            pst.setString(3, uni);
            pst.setFloat(4, tp);
            pst.setInt(5, quani);
            pst.setFloat(6,tamount);
            pst.setFloat(7,vattk);
            pst.setFloat(8,total);
            pst.setDate(9, (java.sql.Date) date1);
            pst.executeUpdate();
            Phar ob=new Phar();
            ob.deletet();
            setcombo();
            
            ta.setText("0.0");
            disc.setText("0");
            pwd.setText("0.0");
            vat.setText("0");
            taa.setText("0.0");
            
            
             
       } catch (Exception ex) {
                 
             }
                }
            } catch (SQLException ex) {
                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void rnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnActionPerformed
        int receipt= Integer.parseInt(rn.getText());
        Statement s;
            try {
                s = con.createStatement();
                ResultSet rs=s.executeQuery("select * from salerecord where receiptno='"+receipt+"'");
                while(rs.next()){
                     JOptionPane.showMessageDialog(null,"The receipt number is already exist!\n Please try a new one.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }//GEN-LAST:event_rnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        
            try {
                Calendar cal= Calendar.getInstance();
                DateFormat dtoday = new SimpleDateFormat("yyyy-MM-dd");
                String dat = dtoday.format(cal.getTime());
                java.util.Date dt = dtoday.parse(dat);
                    java.sql.Date exxp = new java.sql.Date(dt.getTime()); 
                String ddname=null;
                int rowcount=tab.getRowCount();
                for(int i=0; i<rowcount; i++){
                    float tp=(Float.parseFloat((tab.getValueAt(i, 3)).toString()));
                    int quani=(Integer.parseInt((tab.getValueAt(i, 4)).toString()));
                    float tamount=(Float.parseFloat((tab.getValueAt(i, 5)).toString()));
                    float vattk=(Float.parseFloat((tab.getValueAt(i, 6)).toString()));
                    float total=(Float.parseFloat((tab.getValueAt(i, 7)).toString()));
                    int r=Integer.parseInt(rn.getText());
                    ddname=(String.valueOf(tab.getValueAt(i, 1)));
                    String d=((JTextField)ddatee.getDateEditor().getUiComponent()).getText();
                    if(cus.getText().isEmpty() || cl.getText().isEmpty() || address.getText().isEmpty() || d.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please fill all the fields of customer info.");
                    }
                    else{
                     PreparedStatement pst=con.prepareStatement("insert into SALERECORD values(?,?,?,?,?,?,?,?,?)");
                    pst.setInt(1, r);
                    pst.setString(2, ddname);
                    pst.setString(3, (String.valueOf(tab.getValueAt(i, 2))));
                    pst.setFloat(4, tp );
                    pst.setInt(5, quani);
                    pst.setFloat(6,tamount);
                    pst.setFloat(7,vattk);
                    pst.setFloat(8,total);
                    pst.setDate(9, exxp);
                    int rs=pst.executeUpdate();
                    
                    if (rs ==1 ){
                         JOptionPane.showMessageDialog(null,"done!");
                    }
                    else{
                         JOptionPane.showMessageDialog(null,"error!");
                    }
                    Phar l=new Phar();
                    l.updatet(quani, ddname);
                    
                    DefaultTableModel m=(DefaultTableModel)tab.getModel();
                    
                    report obb=new report(m,totala.getText(),totalv.getText(),totalam.getText(),
                            
                            rn.getText(),ca.getText(),duee.getText(),cus.getText(),cl.getText(),address.getText(),d);
//                    setcombo();
                    }
                }
                
                
                
               
//                DefaultTableModel m=(DefaultTableModel)tab.getModel();
//            
//            
//                m.addRow(new Object[] {s,product,uni,tp,quani,tamount,vattk,total});
               
               
               
            } catch (Exception ex) {
                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
            }
              
           
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tabPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabPropertyChange
       
    }//GEN-LAST:event_tabPropertyChange

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        int rowcount= tab.getRowCount();
        float tram=0,vaa=0,totalamount=0;
        
        for (int i=0; i<rowcount; i++){
            tram = tram + Float.parseFloat(tab.getValueAt(i, 5).toString());
            vaa=vaa+Float.parseFloat(tab.getValueAt(i, 6).toString());
            totalamount=totalamount+Float.parseFloat(tab.getValueAt(i, 7).toString());
        }
        totala.setText(String.valueOf(tram));
        totalv.setText(String.valueOf(vaa));
        totalam.setText(String.valueOf(totalamount));
            ta.setText("0.0");
            disc.setText("0");
            pwd.setText("0.0");
            vat.setText("0");
            taa.setText("0.0");
    }//GEN-LAST:event_jButton5MouseClicked

    private void tabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseReleased
        if(evt.isPopupTrigger())
            {
                salepop.show(this,evt.getXOnScreen(),evt.getYOnScreen());
                
            }
    }//GEN-LAST:event_tabMouseReleased

    private void Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1ActionPerformed
            int selectedRow = tab.getSelectedRow();
       DefaultTableModel m=(DefaultTableModel)tab.getModel();
       m.removeRow(selectedRow);
    }//GEN-LAST:event_Delete1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    
     
        try {
            
            String productname=(jComboBox1.getEditor().getItem()).toString();
            Statement s=con.createStatement();
            ResultSet rs =s.executeQuery("Select * from drugreg where drugname='"+productname+"'");
            if(rs.next()){

                manufac.setSelectedItem(rs.getString("manufacturer"));
                dgroup.setText(rs.getString("druggroup"));
                quan.setText(String.valueOf(rs.getInt("quantity")));
                vac.setSelectedItem(rs.getString("vaccine"));
                tradep.setText(String.valueOf(rs.getFloat("tradeprice")));
                DateFormat d = new SimpleDateFormat("yyyy-M-d");
                Date expdate=d.parse(rs.getString("prodate"));
                prodate.setDate(expdate);
                exdate.setDate(rs.getDate("expiredate"));
                v.setText(String.valueOf(rs.getFloat("vat")));
                mrpp.setText(String.valueOf(rs.getFloat("mrp")));
                drugtype.setSelectedItem(rs.getString("type"));
                ratio.setText(rs.getString("bonusratio"));
                dis.setText(String.valueOf(rs.getFloat("discount")));
                bonusr.setText(rs.getString("bonusrate"));
            }
            else{
                 manufac.setSelectedItem("");
                dgroup.setText("");
                quan.setText("");
                vac.setSelectedItem("");
                tradep.setText("0.0");
               
                v.setText("0");
                mrpp.setText("0.0");
                drugtype.setSelectedItem("");
                ratio.setText("0:0");
                dis.setText("0");
                bonusr.setText("0");
            }
        } catch (Exception ex) {
            Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
     
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void rnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rnKeyReleased
        int receipt= Integer.parseInt(rn.getText());
        Statement s;
            try {
                s = con.createStatement();
                ResultSet rs=s.executeQuery("select * from salerecord where receiptno='"+receipt+"'");
                while(rs.next()){
                     JOptionPane.showMessageDialog(null,"The receipt number is already exist!\n Please try a new one.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_rnKeyReleased

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked

        
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void vattakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vattakaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vattakaActionPerformed

    private void vattakaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vattakaKeyReleased
      float pw= Float.parseFloat(pwd.getText());
      float vvv= Float.parseFloat(vattaka.getText());
      taa.setText(String.valueOf(pw+vvv));
    }//GEN-LAST:event_vattakaKeyReleased

    private void discounttakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discounttakaActionPerformed
      
    }//GEN-LAST:event_discounttakaActionPerformed

    private void discKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discKeyReleased
        float total=Float.parseFloat(ta.getText());
        int d= Integer.parseInt(disc.getText());
        float pricewithdis= total-((total*d)/100);
        float vatt=Float.parseFloat(vat.getText());
        float totalamount = pricewithdis+((pricewithdis*vatt)/100);
        vattaka.setText(String.valueOf((pricewithdis*vatt)/100));
        taa.setText(String.valueOf(totalamount));
        discounttaka.setText(String.valueOf((total*d)/100));
        pwd.setText(String.valueOf(pricewithdis));
        
    }//GEN-LAST:event_discKeyReleased

    private void caKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caKeyReleased
        float t=Float.parseFloat(totalam.getText());
        float cas=Float.parseFloat(ca.getText());
       
        duee.setText(String.valueOf(t-cas));
        
    }//GEN-LAST:event_caKeyReleased

    private void caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caActionPerformed

    private void tradepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tradepActionPerformed

    private void Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete2ActionPerformed
      try {
        PreparedStatement pst = con.prepareStatement("delete from salerecord where receiptno=? and product=? ");
        pst.setString(1, saletable.getValueAt(saletable.getSelectedRow(), 0).toString());
        pst.setString(2, saletable.getValueAt(saletable.getSelectedRow(), 1).toString());
        pst.executeUpdate();
        showtable2();
    } catch (SQLException ex) {
        Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }//GEN-LAST:event_Delete2ActionPerformed

    private void Delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete3ActionPerformed
         try {
        PreparedStatement pst = con.prepareStatement("delete from receiptrecord where receiptno=?");
        
        pst.setString(1, rcpt.getValueAt(rcpt.getSelectedRow(), 0).toString());
        pst.executeUpdate();
        showtable3();
    } catch (SQLException ex) {
        Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }//GEN-LAST:event_Delete3ActionPerformed

    private void saletableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saletableMouseReleased
         if(evt.isPopupTrigger())
            {
                salerecord.show(this,evt.getXOnScreen(),evt.getYOnScreen());
                
            }
    }//GEN-LAST:event_saletableMouseReleased

    private void rcptMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rcptMouseReleased
         if(evt.isPopupTrigger())
            {
                rcpttable.show(this,evt.getXOnScreen(),evt.getYOnScreen());
                
            }
    }//GEN-LAST:event_rcptMouseReleased

    private void saletableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saletableMouseClicked
       if(evt.isPopupTrigger())
            {
                salerecord.show(this,evt.getXOnScreen(),evt.getYOnScreen());
                
            }
    }//GEN-LAST:event_saletableMouseClicked

    private void rcptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rcptMouseClicked
        if(evt.isPopupTrigger())
            {
                rcpttable.show(this,evt.getXOnScreen(),evt.getYOnScreen());
                
            }
    }//GEN-LAST:event_rcptMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
            try {
                int receipt=Integer.parseInt(rcptn.getText());
                PreparedStatement pst=con.prepareStatement("select * from receiptrecord where receiptno=? ");
                pst.setInt(1, receipt);
                ResultSet rs=pst.executeQuery();
                while(rs.next()){
                    cname.setText(rs.getString("customername"));
                    dress.setText(rs.getString("address"));
                    cln.setText(String.valueOf(rs.getInt("cell")));
                    gra.setText(String.valueOf(rs.getString("grandtotal")));
                    cas.setText(String.valueOf(rs.getFloat("cash")));
                    du.setText(String.valueOf(rs.getFloat("due")));
                    ddda.setText(rs.getString("date"));
                }
                PreparedStatement ps=con.prepareStatement("select * from salerecord where receiptno=? ");
                ps.setInt(1, receipt);
                ResultSet rss=ps.executeQuery();
                
                saa.setModel(DbUtils.resultSetToTableModel(rss));
                
                
            } catch (SQLException ex) {
                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        login ob;
            try {
                ob = new login();
                ob.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void vatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vatMouseReleased
         float vatt=Float.parseFloat(vat.getText());
       float pricewithout=Float.parseFloat(pwd.getText());
       float totalamount = pricewithout+((pricewithout*vatt)/100);
       vattaka.setText(String.valueOf((pricewithout*vatt)/100));
       taa.setText(String.valueOf(totalamount));
    }//GEN-LAST:event_vatMouseReleased

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
                     
            
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
            
    }//GEN-LAST:event_jComboBox1KeyReleased

    private void discounttakaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discounttakaKeyReleased
         float total=Float.parseFloat(ta.getText());
       float distaka= Float.parseFloat(discounttaka.getText());
        float pricewithdis= total-(distaka);
         pwd.setText(String.valueOf(pricewithdis));
        float vatt=Float.parseFloat(vattaka.getText());
        float totalamount = pricewithdis+(vatt);
        vattaka.setText(String.valueOf((pricewithdis*vatt)/100));
        taa.setText(String.valueOf(totalamount));
       
       
       
    }//GEN-LAST:event_discounttakaKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(drugReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(drugReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(drugReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(drugReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {
                    new drugReg().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(drugReg.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem Delete1;
    private javax.swing.JMenuItem Delete2;
    private javax.swing.JMenuItem Delete3;
    private javax.swing.JLabel Dues;
    private javax.swing.JTextField address;
    private javax.swing.JLabel amount;
    private javax.swing.JTextField bonusr;
    private javax.swing.JLabel bratio;
    private javax.swing.JTextField ca;
    private javax.swing.JLabel cas;
    private javax.swing.JTextField cl;
    private javax.swing.JLabel cln;
    private javax.swing.JLabel cname;
    private javax.swing.JTextField cus;
    private com.toedter.calendar.JDateChooser ddatee;
    private javax.swing.JLabel ddda;
    private javax.swing.JTextField dgroup;
    private javax.swing.JTextField dis;
    private javax.swing.JTextField disc;
    private javax.swing.JTextField discounttaka;
    private javax.swing.JLabel dmanu;
    private javax.swing.JComboBox<String> dname;
    private javax.swing.JLabel dress;
    private javax.swing.JComboBox<String> drugtype;
    private javax.swing.JComboBox<String> dtype;
    private javax.swing.JLabel du;
    private javax.swing.JTextField duee;
    private com.toedter.calendar.JDateChooser exdate;
    private javax.swing.JLabel exp;
    private javax.swing.JLabel gra;
    private javax.swing.JLabel gru;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JComboBox<String> manufac;
    private javax.swing.JTextField mrp;
    private javax.swing.JTextField mrpp;
    private javax.swing.JPopupMenu pop;
    private com.toedter.calendar.JDateChooser prodate;
    private javax.swing.JTextField pwd;
    private javax.swing.JSpinner qqq;
    private javax.swing.JTextField quan;
    private javax.swing.JLabel rate;
    private javax.swing.JTextField ratio;
    private javax.swing.JTable rcpt;
    private javax.swing.JTextField rcptn;
    private javax.swing.JPopupMenu rcpttable;
    private javax.swing.JTextField rn;
    private javax.swing.JTable saa;
    private javax.swing.JPopupMenu salepop;
    private javax.swing.JPopupMenu salerecord;
    private javax.swing.JTable saletable;
    private javax.swing.JTextField ta;
    private javax.swing.JTextField taa;
    private javax.swing.JTable tab;
    private javax.swing.JTable table;
    private javax.swing.JLabel totala;
    private javax.swing.JLabel totalam;
    private javax.swing.JLabel totalv;
    private javax.swing.JTextField trade;
    private javax.swing.JTextField tradep;
    private javax.swing.JComboBox<String> unit;
    private javax.swing.JTextField v;
    private javax.swing.JComboBox<String> vac;
    private javax.swing.JTextField vat;
    private javax.swing.JTextField vattaka;
    // End of variables declaration//GEN-END:variables
}
