/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Dao_CTHD;
import dao.Dao_HoaDon;
import dao.Dao_NhanVien;
import dao.Dao_QuayCafe;
import dao.Dao_ThucDon;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.CTHD;

/**
 *
 * @author nghia
 */
public class panelDSHD extends javax.swing.JPanel {

    /**
     * Creates new form panelDSHD
     */
    private static DefaultTableModel dtm;

    public panelDSHD() {
        initComponents();
        tableDSHD.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        loadDSHD(Dao_CTHD.layDS());
        labelError.setText("");
    }

    //set model dựa vào text
//    private void setModelComboBoxMaNV(java.awt.event.KeyEvent evt) {
//        String text = ((JTextField) evt.getSource()).getText();
//        System.out.println("text " + text);
//        List<NhanVien> listNV = dao_ThucDon.layDSTD_ten(text);
//        String[] s;
//        if (listNV != null) {
//            s = new String[listNV.size()];
//            for (int i = 0; i < listNV.size(); i++) {
//                s[i] = listNV.get(i).getTen();
//            }
//            cbbTenTD.setModel(new DefaultComboBoxModel(s));
//            cbbTenTD.setSelectedIndex(-1);
//            ((JTextField) cbbTenTD.getEditor().getEditorComponent()).setText(text);
//            cbbTenTD.showPopup();
//        } else {
//            s = new String[1];
//            s[0] = "Không Tìm Thấy";
//            cbbTenTD.setModel(new DefaultComboBoxModel(s));
//            cbbTenTD.setSelectedIndex(-1);
//            ((JTextField) cbbTenTD.getEditor().getEditorComponent()).setText(text);
//            cbbTenTD.showPopup();
//        }
//    }
    public static void loadDSHD(List<CTHD> list) {
        dtm = (DefaultTableModel) tableDSHD.getModel();
        dtm.setRowCount(0);
        for (CTHD hd : list) {
            dtm.addRow(new Object[]{
                hd.getMaHD(),
                panelLapHD.getDate(Dao_HoaDon.layHoaDon(hd.getMaHD()).getNgayTao()),
                Dao_HoaDon.layHoaDon(hd.getMaHD()).getMaNV(),
                Dao_QuayCafe.layQuay(Dao_HoaDon.layHoaDon(hd.getMaHD()).getMaQuay()).getMa(),
                Dao_ThucDon.layThucDon_Ma(hd.getMaTD()).getTen(),
                hd.getSoLuongLy(),
                hd.getGiaTien()
            });
        }
    }

    private void resetTable(){
        dtm=DefaultTableModel.class.cast(tableDSHD.getModel());
        dtm.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel35 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDSHD = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel35.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel35.setPreferredSize(new java.awt.Dimension(810, 60));
        jPanel35.setLayout(new java.awt.GridBagLayout());

        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Theo Mã Nhân Viên");
        jPanel35.add(jLabel19, new java.awt.GridBagConstraints());

        btnTimKiem.setForeground(new java.awt.Color(0, 102, 204));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass-16.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel35.add(btnTimKiem, gridBagConstraints);

        labelError.setForeground(new java.awt.Color(255, 0, 51));
        labelError.setText("Không Tìm Thấy");
        labelError.setMaximumSize(new java.awt.Dimension(150, 28));
        labelError.setPreferredSize(new java.awt.Dimension(150, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 10);
        jPanel35.add(labelError, gridBagConstraints);

        txtMaNV.setMinimumSize(new java.awt.Dimension(150, 28));
        txtMaNV.setPreferredSize(new java.awt.Dimension(150, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel35.add(txtMaNV, gridBagConstraints);

        add(jPanel35, java.awt.BorderLayout.PAGE_START);

        tableDSHD.setAutoCreateRowSorter(true);
        tableDSHD.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tableDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Ngày Lập", "Mã Nhân Viên", "Mã Quầy", "Tên Đồ Uống", "Số Lượng Ly", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSHD.setRowHeight(18);
        jScrollPane5.setViewportView(tableDSHD);
        if (tableDSHD.getColumnModel().getColumnCount() > 0) {
            tableDSHD.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableDSHD.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        add(jPanel36, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            String ma = txtMaNV.getText().trim();
            System.out.println("Chưa Nhập "+(ma.length() == 0));
            System.out.println("empty "+ma.isEmpty());
            if (!ma.isEmpty()) { //null khác rỗng
                int maNV = Integer.parseInt(ma);
                System.out.println("dao "+Dao_NhanVien.kiemTraTonTai(maNV, true));
                if (Dao_NhanVien.kiemTraTonTai(maNV, true)) {
                    System.out.println("tồn tại");
                    loadDSHD(Dao_CTHD.layDSTheoMaNV(maNV));
                    labelError.setText("");
                } else {
                    System.out.println("không tồn tại");
                    labelError.setText("Không Tìm Thấy!");
                    resetTable();
                }
            } else {
                labelError.setText("");
                loadDSHD(Dao_CTHD.layDS());
            }
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelError;
    private static javax.swing.JTable tableDSHD;
    private javax.swing.JTextField txtMaNV;
    // End of variables declaration//GEN-END:variables
}