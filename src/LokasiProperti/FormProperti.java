/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LokasiProperti;

import com.mysql.cj.jdbc.Blob;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Types;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adam
 */
public class FormProperti extends javax.swing.JFrame {

    private JFileChooser fileChooser;

    public boolean dataBaru;

    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    Connection con;
    Koneksi db;
    DefaultTableModel model;
    int q, i, id, deleteItem;
    private String filename;

    /**
     * Creates new form FormProperti
     */
    public FormProperti() {
        db = new Koneksi();
        initComponents();
        loadData();
        fileChooser = new JFileChooser();
    }

    public void loadData() {
        String sql = "SELECT * FROM properti";
        try {
            PreparedStatement pst = db.con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabelProperti.getModel();
            while (rs.next()) {
                Blob imageBlob = (Blob) rs.getBlob("gambar");
                
                byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                ImageIcon imageIcon = new ImageIcon(imageData);
                
                Image scaledImage = imageIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), new ImageIcon(scaledImage)});
            }
            model.fireTableDataChanged();
            
            tabelProperti.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                if (value instanceof ImageIcon) {
                    setIcon((ImageIcon) value);
                }

                return this;
            }
            });
        } catch (Exception ex) {
            System.out.println("Eror" + ex.getMessage());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelProperti = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNamaProperti = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPemilik = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKontak = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnUploadGambar = new javax.swing.JButton();
        btnTambahProperti = new javax.swing.JButton();
        btnEditProperti = new javax.swing.JButton();
        btnDeleteProperti = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        containerFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setText("Daftar Properti");

        tabelProperti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Properti", "Pemilik", "Kontak", "Alamat", "Harga", "Gambar"
            }
        ));
        tabelProperti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPropertiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelProperti);

        jLabel2.setText("ID");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNamaProperti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPropertiActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Properti");

        jLabel4.setText("Pemilik");

        txtPemilik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPemilikActionPerformed(evt);
            }
        });

        jLabel5.setText("Kontak");

        txtKontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKontakActionPerformed(evt);
            }
        });

        jLabel6.setText("Alamat");

        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });

        jLabel7.setText("Harga");

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        jLabel8.setText("Gambar");

        btnUploadGambar.setText("Upload Gambar");
        btnUploadGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadGambarActionPerformed(evt);
            }
        });

        btnTambahProperti.setText("Tambah Properti");
        btnTambahProperti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPropertiActionPerformed(evt);
            }
        });

        btnEditProperti.setText("Edit Properti");
        btnEditProperti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPropertiActionPerformed(evt);
            }
        });

        btnDeleteProperti.setText("Delete Properti");
        btnDeleteProperti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePropertiActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        containerFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        containerFoto.setText("Pilih Gambar Terlebih Dahulu");
        containerFoto.setToolTipText("");
        containerFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtKontak)
                                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(containerFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnUploadGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAlamat))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPemilik))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNamaProperti, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTambahProperti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditProperti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteProperti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtNamaProperti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4))
                        .addComponent(txtPemilik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGap(32, 32, 32))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(btnUploadGambar))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(containerFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahProperti)
                    .addComponent(btnEditProperti)
                    .addComponent(btnDeleteProperti)
                    .addComponent(btnKeluar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPropertiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPropertiMouseClicked
        // TODO add your handling code here:
        int row = tabelProperti.getSelectedRow();
        txtNamaProperti.setText(tabelProperti.getValueAt(row, 1).toString());
        txtPemilik.setText(tabelProperti.getValueAt(row, 2).toString());
        txtKontak.setText(tabelProperti.getValueAt(row, 3).toString());
        txtAlamat.setText(tabelProperti.getValueAt(row, 4).toString());
        txtHarga.setText(tabelProperti.getValueAt(row, 5).toString());
        
        Object imageObject = tabelProperti.getValueAt(row, 6);
        if (imageObject instanceof ImageIcon) {
            ImageIcon selectedImageIcon = (ImageIcon) imageObject;
            containerFoto.setIcon(selectedImageIcon);
        } else {
            containerFoto.setIcon(null);
        }
        
    }//GEN-LAST:event_tabelPropertiMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNamaPropertiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPropertiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPropertiActionPerformed

    private void txtPemilikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPemilikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPemilikActionPerformed

    private void txtKontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKontakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKontakActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void btnUploadGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadGambarActionPerformed
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                Image scaledImage = imageIcon.getImage().getScaledInstance(containerFoto.getWidth(), containerFoto.getHeight(), Image.SCALE_SMOOTH);
                containerFoto.setIcon(new ImageIcon(scaledImage));
                containerFoto.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUploadGambarActionPerformed


    private void btnTambahPropertiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPropertiActionPerformed
        File selectedFile = fileChooser.getSelectedFile();
        try {
            Path imagePath = selectedFile.toPath();
            byte[] imageData = Files.readAllBytes(imagePath);
            pst = db.con.prepareStatement("insert into properti (namaProperti, pemilik, kontak, alamat, harga, gambar) VALUES (?,?,?,?,?,?)");
            pst.setString(1, txtNamaProperti.getText());
            pst.setString(2, txtPemilik.getText());
            pst.setString(3, txtKontak.getText());
            pst.setString(4, txtAlamat.getText());
            pst.setString(5, txtHarga.getText());
            pst.setBytes(6, imageData);
            pst.executeUpdate();
            loadData();
            JOptionPane.showMessageDialog(null, "Data Properti Berhasil Ditambahkan !");
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(FormProperti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahPropertiActionPerformed

    private void btnEditPropertiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPropertiActionPerformed
        int row = tabelProperti.getSelectedRow();
        File selectedFile = fileChooser.getSelectedFile();

        String id = tabelProperti.getValueAt(row, 0).toString();
        try {
            Path imagePath = selectedFile.toPath();
            byte[] imageData = Files.readAllBytes(imagePath);
            pst = db.con.prepareStatement("UPDATE properti SET namaProperti=?, pemilik=?, kontak=?, alamat=?, harga=?, gambar=? WHERE id=?");
            pst.setString(1, txtNamaProperti.getText());
            pst.setString(2, txtPemilik.getText());
            pst.setString(3, txtKontak.getText());
            pst.setString(4, txtAlamat.getText());
            pst.setString(5, txtHarga.getText());
            pst.setString(6, containerFoto.getText());
            pst.setBytes(7, imageData);
            pst.setString(8, id);

            pst.executeUpdate();
            loadData();
            JOptionPane.showMessageDialog(null, "Perubahan Data Properti Berhasil Disimpan");
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(FormProperti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditPropertiActionPerformed

    private void btnDeletePropertiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePropertiActionPerformed
        int row = tabelProperti.getSelectedRow();
        String idHapus = tabelProperti.getValueAt(row, 0).toString();
        String sql = "delete from properti where id='" + idHapus + "'";

        try {
            st = db.con.createStatement();
            st.execute(sql);
            loadData();
            JOptionPane.showMessageDialog(null, "Data properti Berhasil Dihapus !");
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_btnDeletePropertiActionPerformed
    private JFrame frame;
    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Apakah anda yakin untuk keluar dari program ?", "MYSQL Connector", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(FormProperti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProperti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProperti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProperti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProperti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteProperti;
    private javax.swing.JButton btnEditProperti;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambahProperti;
    private javax.swing.JButton btnUploadGambar;
    private javax.swing.JLabel containerFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelProperti;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKontak;
    private javax.swing.JTextField txtNamaProperti;
    private javax.swing.JTextField txtPemilik;
    // End of variables declaration//GEN-END:variables
}
