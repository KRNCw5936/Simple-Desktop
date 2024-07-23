import java.awt.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;

public class DesktopApps extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private Connection connection;

    public DesktopApps() {
        initComponents();

        tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);

        tableModel.addColumn("ID");
        tableModel.addColumn("Nama Pelajar");
        tableModel.addColumn("Alamat Pelajar");
        tableModel.addColumn("Program Pelajar");

        try {
            // Update the database connection details
            String url = "jdbc:mysql://localhost:3306/desktop_db_netbeans";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal terhubung ke database.");
            e.printStackTrace();
            System.exit(1);
        }

        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        try {
            String query = "SELECT * FROM desktop_db";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String nama = resultSet.getString("Nama Pelajar");
                String alamat = resultSet.getString("Alamat Pelajar");
                String program = resultSet.getString("Program Pelajar");

                tableModel.addRow(new Object[]{id, nama, alamat, program});
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data dari database.");
            e.printStackTrace();
        }
    }
    
    private void addDataToDatabase(String id, String nama, String alamat, String program) {
    try {
        String query = "INSERT INTO desktop_db (`ID`, `Nama Pelajar`, `Alamat Pelajar`, `Program Pelajar`) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, nama);
        preparedStatement.setString(3, alamat);
        preparedStatement.setString(4, program);

        preparedStatement.executeUpdate();
        preparedStatement.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menambahkan data ke database.");
        e.printStackTrace();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        id_pljr = new javax.swing.JTextField();
        nm_pljr = new javax.swing.JTextField();
        alamat_pljr = new javax.swing.JTextField();
        prg_pljr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cr_data = new javax.swing.JTextField();
        btn_cr = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        srtr_Id = new javax.swing.JButton();
        srtr_Nama = new javax.swing.JButton();
        srtr_Alamat = new javax.swing.JButton();
        srtr_Program = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pelajar", "Alamat Pelajar", "Program Pelajar"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("ID:");

        jLabel2.setText("Nama Pelajar:");

        jLabel3.setText("Alamat Pelajar:");

        jLabel4.setText("Program Pelajar:");

        btn_cr.setText("Cari");
        btn_cr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crActionPerformed(evt);
            }
        });

        btn_add.setText("Add Data");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit Data");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete Data");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_save.setText("Save To SpreadSheet");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        srtr_Id.setText("Sortir Sesuai Id");
        srtr_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srtr_IdActionPerformed(evt);
            }
        });

        srtr_Nama.setText("Sortir Sesuai Nama");
        srtr_Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srtr_NamaActionPerformed(evt);
            }
        });

        srtr_Alamat.setText("Sortir Sesuai Alamat");
        srtr_Alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srtr_AlamatActionPerformed(evt);
            }
        });

        srtr_Program.setText("Sortir Sesuai Program");
        srtr_Program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srtr_ProgramActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prg_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alamat_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nm_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(329, 329, 329))))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(srtr_Id)
                        .addGap(18, 18, 18)
                        .addComponent(srtr_Nama)
                        .addGap(18, 18, 18)
                        .addComponent(srtr_Alamat)
                        .addGap(18, 18, 18)
                        .addComponent(srtr_Program))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_refresh)
                        .addGap(18, 18, 18)
                        .addComponent(btn_save))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cr_data, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cr)))
                .addGap(0, 239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(id_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nm_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prg_pljr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cr_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_edit)
                    .addComponent(btn_delete)
                    .addComponent(btn_refresh)
                    .addComponent(btn_save))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srtr_Id)
                    .addComponent(srtr_Nama)
                    .addComponent(srtr_Alamat)
                    .addComponent(srtr_Program))
                .addGap(0, 67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String id = id_pljr.getText();
        String nama = nm_pljr.getText();
        String alamat = alamat_pljr.getText();
        String program = prg_pljr.getText();

        // Menambahkan data ke tabel di GUI
        tableModel.addRow(new Object[]{id, nama, alamat, program});

        // Menambahkan data ke database
        addDataToDatabase(id, nama, alamat, program);

        // Membersihkan field input
        clearFields();
    }//GEN-LAST:event_btn_addActionPerformed

    
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
         int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            String id = id_pljr.getText();
            String nama = nm_pljr.getText();
            String alamat = alamat_pljr.getText();
            String program = prg_pljr.getText();

            // Mengubah nilai pada tabel di GUI
            tableModel.setValueAt(id, selectedRow, 0);
            tableModel.setValueAt(nama, selectedRow, 1);
            tableModel.setValueAt(alamat, selectedRow, 2);
            tableModel.setValueAt(program, selectedRow, 3);

            // Mengubah data di database
            updateDataInDatabase(id, nama, alamat, program);

            // Membersihkan field input
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu!");
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void updateDataInDatabase(String id, String nama, String alamat, String program) {
    try {
        String query = "UPDATE desktop_db SET `Nama Pelajar`=?, `Alamat Pelajar`=?, `Program Pelajar`=? WHERE `ID`=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nama);
        preparedStatement.setString(2, alamat);
        preparedStatement.setString(3, program);
        preparedStatement.setString(4, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengubah data di database.");
        e.printStackTrace();
    }
}

    
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            // Menghapus baris dari tabel di GUI
            tableModel.removeRow(selectedRow);

            // Menghapus data dari database
            deleteDataFromDatabase(selectedRow);

            // Membersihkan field input
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu!");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void deleteDataFromDatabase(int selectedRow) {
    try {
        String idToDelete = tableModel.getValueAt(selectedRow, 0).toString();
        String query = "DELETE FROM desktop_db WHERE `ID`=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idToDelete);

        preparedStatement.executeUpdate();
        preparedStatement.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database.");
        e.printStackTrace();
    }
}
    
    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        clearFields();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_crActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crActionPerformed
        String searchData = cr_data.getText().toLowerCase();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nama = tableModel.getValueAt(i, 1).toString().toLowerCase();
            if (nama.contains(searchData)) {
                jTable1.setRowSelectionInterval(i, i);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Data tidak ditemukan!");
    }//GEN-LAST:event_btn_crActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try {
            // Membuat workbook baru
            Workbook workbook = new XSSFWorkbook();

            // Membuat sheet baru dengan nama "DataPelajar"
            Sheet sheet = workbook.createSheet("DataPelajar");

            // Menambahkan header ke sheet
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(tableModel.getColumnName(col));
            }

            // Menambahkan data dari tabel ke sheet
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                Row dataRow = sheet.createRow(row + 1);
                for (int col = 0; col < tableModel.getColumnCount(); col++) {
                    Cell cell = dataRow.createCell(col);
                    cell.setCellValue(tableModel.getValueAt(row, col).toString());
                }
            }

            // Menyimpan workbook ke file Excel
            try (FileOutputStream fileOut = new FileOutputStream("DataPelajar.xlsx")) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke Excel (DataPelajar.xlsx)");
            }

            // Menutup workbook
            workbook.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data ke Excel.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void srtr_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srtr_IdActionPerformed
         sortTable(0);
    }//GEN-LAST:event_srtr_IdActionPerformed

    private void srtr_ProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srtr_ProgramActionPerformed
        sortTable(3);
    }//GEN-LAST:event_srtr_ProgramActionPerformed

    private void srtr_NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srtr_NamaActionPerformed
        sortTable(1);
    }//GEN-LAST:event_srtr_NamaActionPerformed

    private void srtr_AlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srtr_AlamatActionPerformed
        sortTable(2);
    }//GEN-LAST:event_srtr_AlamatActionPerformed

private void sortTable(int columnIndex) {
    TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) jTable1.getRowSorter();

    if (sorter == null) {
        sorter = new TableRowSorter<>((DefaultTableModel) jTable1.getModel());
        jTable1.setRowSorter(sorter);
    }

    switch (columnIndex) {
        case 0: // Sort by ID
            sorter.setComparator(columnIndex, Comparator.comparingInt(str -> Integer.parseInt((String) str)));
            break;
        case 1: // Sort by Nama Pelajar
        case 2: // Sort by Alamat Pelajar
        case 3: // Sort by Program Pelajar
            sorter.setComparator(columnIndex, Comparator.naturalOrder());
            break;
        default:
            break;
    }

    sorter.setSortable(columnIndex, true);
    ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
    sortKeys.add(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING));
    sorter.setSortKeys(sortKeys);
    sorter.sort();
}
    
    private void clearFields() {
    id_pljr.setText("");
    nm_pljr.setText("");
    alamat_pljr.setText("");
    prg_pljr.setText("");
    cr_data.setText(""); // Menggunakan setText untuk membersihkan teks
}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesktopApps().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_pljr;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cr;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_save;
    private javax.swing.JTextField cr_data;
    private javax.swing.JTextField id_pljr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nm_pljr;
    private javax.swing.JTextField prg_pljr;
    private javax.swing.JButton srtr_Alamat;
    private javax.swing.JButton srtr_Id;
    private javax.swing.JButton srtr_Nama;
    private javax.swing.JButton srtr_Program;
    // End of variables declaration//GEN-END:variables

}