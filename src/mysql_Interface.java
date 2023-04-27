import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class mysql_Interface extends javax.swing.JFrame {

    public mysql_Interface() {
        initComponents();
        Connect();
        LoadBook_id();
        Fetch();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bookstore", "root", "12378945t*");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadBook_id(){
        
        try {
            pst = con.prepareStatement("SELECT Book_id FROM Book");
            rs = pst.executeQuery();
            txtBID.removeAllItems();
            while(rs.next()){
                txtBID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void Fetch() {
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM Book");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()) {
                Vector v2 = new Vector();
                for(int a = 1; a <= q; a++) {
                    v2.add(rs.getString("Book_id"));
                    v2.add(rs.getString("Title"));
                    v2.add(rs.getString("Language"));
                    v2.add(rs.getString("Publication_Date"));
                    v2.add(rs.getString("Price"));
                    v2.add(rs.getString("Publisher_Publisher_id"));
                    v2.add(rs.getString("Author_Author_id"));
                    
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Bookid = new javax.swing.JTextField();
        txt_Title = new javax.swing.JTextField();
        txt_Pagenum = new javax.swing.JTextField();
        txt_Language = new javax.swing.JTextField();
        txt_Price = new javax.swing.JTextField();
        txt_Authorid = new javax.swing.JTextField();
        txt_Publisherid = new javax.swing.JTextField();
        txt_Publication = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_Add = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_Search = new javax.swing.JButton();
        txtBID = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Book_id");

        jLabel2.setText("Title");

        jLabel3.setText("Language");

        jLabel4.setText("Page_num");

        jLabel5.setText("Publication_date");

        jLabel6.setText("Price");

        jLabel7.setText("Publisher_id");

        jLabel8.setText("Author_,id");

        btn_Add.setText("Add");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_Update.setText("Update");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_Delete.setText("Delete");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_Add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Update)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btn_Delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Update)
                    .addComponent(btn_Add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Delete)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Book_id", "Title", "Language", "Page_num", "Publication_date", "Price", "Publisher_id", "Author_id"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        txtBID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Book_ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Bookid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Language, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Pagenum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Publication, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Authorid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Publisherid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btn_Search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_Bookid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Pagenum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_Publication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_Publisherid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_Authorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(btn_Search)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        try {
            
            String Book_id = txt_Bookid.getText();
            String Title = txt_Title.getText();
            String Language = txt_Language.getText();
            String Page_num = txt_Pagenum.getText();
            String Pub_date= txt_Publication.getText();
            String Price = txt_Price.getText();
            String Pub_id= txt_Publisherid.getText();
            String Author_id= txt_Authorid.getText();
            
            pst = con.prepareStatement("INSERT INTO Book(Book_id, Title, Language, Page_num, Publication_date, Price, Publisher_Publisher_id, Author_Author_id) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, Book_id);
            pst.setString(2, Title);
            pst.setString(3, Language);
            pst.setString(4, Page_num);
            pst.setString(5, Pub_date);
            pst.setString(6, Price);
            pst.setString(7, Pub_id);
            pst.setString(8, Author_id);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, " Record Added");
                txt_Bookid.setText("");
                txt_Title.setText("");
                txt_Language.setText("");
                txt_Pagenum.setText("");
                txt_Publication.setText("");
                txt_Price.setText("");
                txt_Publisherid.setText("");
                txt_Authorid.setText("");
                Fetch();
                LoadBook_id();
            } else {
                JOptionPane.showMessageDialog(this, " Record failed to add");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        try {
            
            String BID = txtBID.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM Book WHERE Book_id=?");
            pst.setString(1, BID);
            rs = pst.executeQuery();
            
            if(rs.next() == true) {
                txt_Bookid.setText(rs.getString(1));
                txt_Title.setText(rs.getString(2));
                txt_Language.setText(rs.getString(3));
                txt_Pagenum.setText(rs.getString(4));
                txt_Publication.setText(rs.getString(5));
                txt_Price.setText(rs.getString(6));
                txt_Publisherid.setText(rs.getString(7));
                txt_Authorid.setText(rs.getString(8));
                
            }else{
                JOptionPane.showMessageDialog(this, " No Record Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        try {
            
            String Book_id = txt_Bookid.getText();
            String Title = txt_Title.getText();
            String Language = txt_Language.getText();
            String Pagenum = txt_Pagenum.getText();
            String Publication = txt_Publication.getText();
            String Price = txt_Price.getText();
            String Publisherid = txt_Publisherid.getText();
            String Authorid = txt_Authorid.getText();
            String BID = txtBID.getSelectedItem().toString();
            
            
            pst = con.prepareStatement("UPDATE Book SET Book_id = ?, Title = ?, Language = ?,"
                    + " Page_num = ?, Publication_date = ?, Price = ?, Publisher_Publisher_id = ? , Author_Author_id = ? WHERE Book_id = ?");
            
            pst.setString(1,Book_id);
            pst.setString(2,Title);
            pst.setString(3,Language);
            pst.setString(4,Pagenum);
            pst.setString(5,Publication);
            pst.setString(6,Price);
            pst.setString(7,Publisherid);
            pst.setString(8,Authorid);
            pst.setString(9,Book_id);
            
            int k = pst.executeUpdate();
            if(k == 1) {
                JOptionPane.showMessageDialog(this, "Record Updated");
                    
                txt_Bookid.setText("");
                txt_Title.setText("");
                txt_Language.setText("");
                txt_Pagenum.setText("");
                txt_Publication.setText("");
                txt_Price.setText("");
                txt_Publisherid.setText("");
                txt_Authorid.setText("");
                txt_Bookid.requestFocus();
                Fetch();
                LoadBook_id();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        try {
            
            String BID = txtBID.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM Book WHERE Book_id = ?");
            pst.setString(1, BID);
            
            int k = pst.executeUpdate();
            if(k == 1) {
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                txt_Bookid.setText("");
                txt_Title.setText("");
                txt_Language.setText("");
                txt_Pagenum.setText("");
                txt_Publication.setText("");
                txt_Price.setText("");
                txt_Publisherid.setText("");
                txt_Authorid.setText("");
                txt_Bookid.requestFocus();
                Fetch();
                LoadBook_id();
            }else {
                JOptionPane.showMessageDialog(this, "Record Deletion Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(mysql_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(mysql_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mysql_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mysql_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mysql_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mysql_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtBID;
    private javax.swing.JTextField txt_Authorid;
    private javax.swing.JTextField txt_Bookid;
    private javax.swing.JTextField txt_Language;
    private javax.swing.JTextField txt_Pagenum;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txt_Publication;
    private javax.swing.JTextField txt_Publisherid;
    private javax.swing.JTextField txt_Title;
    // End of variables declaration//GEN-END:variables
}
