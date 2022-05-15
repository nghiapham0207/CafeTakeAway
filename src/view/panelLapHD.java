//nghia
package view;

import dao.Dao_CTHD;
import valid.MaxLength;
import dao.Dao_HoaDon;
import dao.Dao_NhanVien;
import dao.Dao_QuayCafe;
import dao.Dao_ThucDon;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import model.CTHD;
import model.QuayCafe;
import model.ThucDon;
import valid.Regex;
import valid.Valid;

/**
 *
 * @author nghia
 */
public class panelLapHD extends javax.swing.JPanel {

    /**
     * Creates new form panelLapHoaDon
     */
    private DefaultTableModel dtm;
    private List<CTHD> listCTHD;
    public static List<ThucDon> listDSTD;

    public panelLapHD() {
        initComponents();
        tableLapHoaDon.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        snipperSoLuong.setModel(new SpinnerNumberModel(1, 1, 50, 1));
        listDSTD = Dao_ThucDon.layDSTD();
        //listDSTD=new ArrayList<>();
        loadComboBoxQuay(Dao_QuayCafe.layDSQuay());
        loadComboBoxThucDon(listDSTD);
        khoiTao();
        setMaxLength();
        chuaDu.setText("");
    }

    private void setMaxLength() {
        txtMaHD.setDocument(new MaxLength(10));
        txtGiaBan.setDocument(new MaxLength(6));
        txtTienKhachDua.setDocument(new MaxLength(9));
    }

    //lấy db về
    public static String getDate(String ngay) {
        String[] a = ngay.split("-");
        return a[2] + "/" + a[1] + "/" + a[0];
    }

    //để đẩy về DB
    public static String setDate(String ngay) {
        String[] a = ngay.split("/");
        return a[2] + "-" + a[1] + "-" + a[0];
    }

    private void khoiTao() {
        listCTHD = new ArrayList<>();// để trong constructor nó bảo để thành final
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now;
            String dateString = getDate(LocalDate.now().toString());
//            System.out.println(LocalDate.now().toString());
            now = sdf.parse(dateString);
            labelNgayLap.setText(sdf.format(now));
        } catch (ParseException ex) {
            Logger.getLogger(panelLapHD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadComboBoxQuay(List<QuayCafe> list) {
        cbbQuay.removeAllItems();
        list.forEach((QuayCafe q) -> {
            cbbQuay.addItem(q.getMa() + "");
        });
    }

    public static void loadComboBoxThucDon(List<ThucDon> list) {
        cbbTenDoUong.removeAllItems();
        list.forEach((ThucDon q) -> {
            cbbTenDoUong.addItem(q.getTen());
        });
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

        jPanel37 = new javax.swing.JPanel();
        cbbQuay = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        labelNgayLap = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cbbTenDoUong = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        snipperSoLuong = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        labelTongTien = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        labelTienTraLai = new javax.swing.JLabel();
        chuaDu = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableLapHoaDon = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbbQuay.setForeground(new java.awt.Color(0, 102, 204));
        cbbQuay.setMinimumSize(new java.awt.Dimension(63, 25));
        cbbQuay.setPreferredSize(new java.awt.Dimension(63, 30));

        btnLuu.setForeground(new java.awt.Color(0, 102, 204));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy-disk-16.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });

        btnThem.setForeground(new java.awt.Color(0, 102, 204));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-cart-16.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-16.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/multiply-16.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quầy");
        jLabel1.setPreferredSize(new java.awt.Dimension(63, 30));

        btnSua.setForeground(new java.awt.Color(0, 102, 204));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-info-16.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbQuay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbQuay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnLuu)
                .addGap(35, 35, 35))
        );

        add(jPanel37, java.awt.BorderLayout.LINE_END);

        jPanel38.setLayout(new javax.swing.BoxLayout(jPanel38, javax.swing.BoxLayout.Y_AXIS));

        jPanel39.setMaximumSize(new java.awt.Dimension(2147483647, 120));
        jPanel39.setPreferredSize(new java.awt.Dimension(690, 120));
        jPanel39.setLayout(new javax.swing.BoxLayout(jPanel39, javax.swing.BoxLayout.X_AXIS));

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel41.setPreferredSize(new java.awt.Dimension(300, 190));
        jPanel41.setLayout(new java.awt.GridBagLayout());

        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setText("Mã Hóa Đơn");
        jLabel20.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel41.add(jLabel20, gridBagConstraints);

        txtMaHD.setMinimumSize(new java.awt.Dimension(50, 20));
        txtMaHD.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel41.add(txtMaHD, gridBagConstraints);

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("Ngày Lập");
        jLabel21.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel41.add(jLabel21, gridBagConstraints);

        labelNgayLap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNgayLap.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 255, 102), null));
        labelNgayLap.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel41.add(labelNgayLap, gridBagConstraints);

        jPanel39.add(jPanel41);

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel42.setPreferredSize(new java.awt.Dimension(330, 190));
        jPanel42.setLayout(new java.awt.GridBagLayout());

        jLabel23.setForeground(new java.awt.Color(0, 102, 204));
        jLabel23.setText("Tên Đồ Uống");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel42.add(jLabel23, gridBagConstraints);

        cbbTenDoUong.setPreferredSize(new java.awt.Dimension(150, 25));
        cbbTenDoUong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTenDoUongItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel42.add(cbbTenDoUong, gridBagConstraints);

        jLabel24.setForeground(new java.awt.Color(0, 102, 204));
        jLabel24.setText("Số Lượng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel42.add(jLabel24, gridBagConstraints);

        snipperSoLuong.setMinimumSize(new java.awt.Dimension(50, 20));
        snipperSoLuong.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 50;
        jPanel42.add(snipperSoLuong, gridBagConstraints);

        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Giá Bán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel42.add(jLabel2, gridBagConstraints);

        txtGiaBan.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel42.add(txtGiaBan, gridBagConstraints);

        jLabel3.setText("VND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        jPanel42.add(jLabel3, gridBagConstraints);

        jPanel39.add(jPanel42);

        jPanel38.add(jPanel39);

        jPanel40.setPreferredSize(new java.awt.Dimension(702, 250));
        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel61.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jPanel61.setMinimumSize(new java.awt.Dimension(344, 50));
        jPanel61.setPreferredSize(new java.awt.Dimension(702, 50));
        jPanel61.setLayout(new java.awt.GridBagLayout());

        jLabel46.setForeground(new java.awt.Color(0, 102, 204));
        jLabel46.setText("Tổng Tiền  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel61.add(jLabel46, gridBagConstraints);

        labelTongTien.setMinimumSize(new java.awt.Dimension(80, 25));
        labelTongTien.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel61.add(labelTongTien, gridBagConstraints);

        jLabel48.setForeground(new java.awt.Color(0, 102, 204));
        jLabel48.setText("Tiền Khách Đưa  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel61.add(jLabel48, gridBagConstraints);

        txtTienKhachDua.setMinimumSize(new java.awt.Dimension(60, 20));
        txtTienKhachDua.setPreferredSize(new java.awt.Dimension(80, 25));
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel61.add(txtTienKhachDua, gridBagConstraints);

        jLabel49.setForeground(new java.awt.Color(0, 102, 204));
        jLabel49.setText("Tiền Trả Lại  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel61.add(jLabel49, gridBagConstraints);

        labelTienTraLai.setMinimumSize(new java.awt.Dimension(80, 25));
        labelTienTraLai.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        jPanel61.add(labelTienTraLai, gridBagConstraints);

        chuaDu.setForeground(new java.awt.Color(255, 0, 0));
        chuaDu.setText("jLabel4");
        chuaDu.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel61.add(chuaDu, gridBagConstraints);

        jPanel40.add(jPanel61);

        tableLapHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đồ Uống", "Tên Đồ Uống", "Giá Tiền", "Số Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLapHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLapHoaDonMouseClicked(evt);
            }
        });
        tableLapHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableLapHoaDonKeyPressed(evt);
            }
        });
        jScrollPane14.setViewportView(tableLapHoaDon);

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel62);

        jPanel38.add(jPanel40);

        add(jPanel38, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void reset() {
        dtm = (DefaultTableModel) tableLapHoaDon.getModel();
        dtm.setRowCount(0);

        txtMaHD.setText("");
        txtMaHD.setEditable(true);
        cbbTenDoUong.setSelectedIndex(0);
        snipperSoLuong.setValue(1);
        labelTongTien.setText("");
        labelTienTraLai.setText("");
        txtTienKhachDua.setText("");
        txtGiaBan.setText("");
        cbbTenDoUong.setEnabled(true);
        cbbQuay.setEnabled(true);
    }

    private void resetCTHD() {
        cbbTenDoUong.setSelectedIndex(0);
        snipperSoLuong.setValue(1);
        txtGiaBan.setText("");
        cbbTenDoUong.setEnabled(true);
        tableLapHoaDon.clearSelection();

//        labelTongTien.setText("");
//        labelTienTraLai.setText("");
//        txtTienKhachDua.setText("");
    }

    public void addListToTable(List<CTHD> list) {
        dtm = (DefaultTableModel) tableLapHoaDon.getModel();
        dtm.setRowCount(0);
        for (CTHD cthd : list) {
            dtm.addRow(new Object[]{
                cthd.getMaTD(),
                Dao_ThucDon.layThucDon_Ma(cthd.getMaTD()).getTen(),
                cthd.getGiaTien(),
                cthd.getSoLuongLy(),
                cthd.getGiaTien() * cthd.getSoLuongLy()
            });
        }
    }

    private int tongTien() {
        int tongTien = 0;
        for (CTHD cthd : listCTHD) {
            tongTien = tongTien + cthd.getSoLuongLy() * cthd.getGiaTien();
        }
        return tongTien;
    }

    private int tienThua() {
        String tien = txtTienKhachDua.getText().trim();
        int tienKhachDua;
        if (tien.equals("")) {
            tienKhachDua = 0;
        } else {
            tienKhachDua = Integer.parseInt(tien);
        }
        int tienThua;
        tienThua = tienKhachDua - tongTien();
        if (tienThua >= 0) {
            chuaDu.setText("");
            return tienThua;
        } else {
            chuaDu.setText("Khách chưa đưa đủ tiền!");
            return 0;
        }
    }

    private void layTuBang(int row) {
        String tenTD = tableLapHoaDon.getValueAt(row, 1).toString();
        String gia = tableLapHoaDon.getValueAt(row, 2).toString();
        String sl = tableLapHoaDon.getValueAt(row, 3).toString();

        cbbTenDoUong.setSelectedItem(tenTD);
        txtGiaBan.setText(gia);
        snipperSoLuong.setValue(Integer.parseInt(sl));
    }

    private void suaCTHD(int row) {
        listCTHD.get(row).setSoLuongLy((int) snipperSoLuong.getValue());
        addListToTable(listCTHD);
    }

    public boolean daTonTai(String maHD, int maTD) {
        for (CTHD cthd : listCTHD) {
            if (maHD.equalsIgnoreCase(cthd.getMaHD()) && maTD == cthd.getMaTD()) {
                return true; //tồn tài
            }
        }
        return false;
    }

    private int isMaHDValid() {
        String maHD = txtMaHD.getText().trim();
        if (maHD.equals("")) {
            //set label thông báo
            return 0;
        } else if (!Valid.isTextValid(maHD, Regex.W)) {
            //
            return -1;
        } else {
            //
            return 1;
        }
    }

    private int isGiaBanValid() {
        String gia = txtGiaBan.getText().trim();
        if (gia.equals("")) {
            //
            return 0;
        } else if (!Valid.isTextValid(gia, Regex.NUMBER)) {
            //
            return -1;
        } else {
            //
            return 1;
        }
    }

    private boolean isAllValid() {
        if (isMaHDValid() == 1 && isGiaBanValid() == 1) {
            return true;
        } else if (isMaHDValid() == 0) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn không được trống");
            return false;
        } else if (isMaHDValid() == -1) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn chỉ chứa a-zA-Z0-9");
            return false;
        } else if (isGiaBanValid() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập giá!");
            return false;
        } else if (isGiaBanValid() == -1) {
            JOptionPane.showMessageDialog(this, "Giá không hợp lệ!");
            return false;
        } else {
            return true;
        }
    }

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            reset();
        }
    }//GEN-LAST:event_btnHuyMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int row = tableLapHoaDon.getSelectedRow();
            if (row != -1) {
                listCTHD.remove(row);
                addListToTable(listCTHD);
                resetCTHD();
            } else {
                JOptionPane.showMessageDialog(this, "Chưa Có Dòng Nào Được Chọn!");
            }
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (isAllValid()) {
                if (listDSTD.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy thực đơn!");
                } else {
                    String maHD = txtMaHD.getText().trim().toUpperCase();
                    int maTD = Dao_ThucDon.layMa((String) cbbTenDoUong.getSelectedItem());
                    int slLy = (int) snipperSoLuong.getValue();
                    int giaBan = Integer.parseInt(txtGiaBan.getText().trim());
                    if (!daTonTai(maHD, maTD)) {
                        txtMaHD.setEditable(false);
                        listCTHD.add(new CTHD(maHD, maTD, slLy, giaBan));
                        addListToTable(listCTHD);
                        cbbQuay.setEnabled(false);
                        labelTongTien.setText(tongTien() + "");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thức uống đã được thêm!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (!listCTHD.isEmpty()) {
                //đã bắt dữ liệu
                String maHD = txtMaHD.getText().trim().toUpperCase();
                String date = setDate(labelNgayLap.getText().trim());
                int maQuay = Integer.parseInt((String) cbbQuay.getSelectedItem());
                int maNV = Dao_NhanVien.layThongTinQL(formQuanLy.ql.getTenTK()).getMaNV();
                if (Dao_HoaDon.layHoaDon(maHD).getMaHD() == null) {
                    if (Dao_HoaDon.lapHoaDon(maHD, date, maNV, maQuay, listCTHD)) {
                        reset();
                        JOptionPane.showMessageDialog(this, "Đã Thêm Hóa Đơn!");
                        panelDSHD.loadDSHD(Dao_CTHD.layDS());
                        listCTHD.clear();
                    } else {
                        JOptionPane.showMessageDialog(this, "Không Thể Thêm Hóa Đơn!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Phải thêm chi tiết hóa đơn!");
            }

        }
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int row = tableLapHoaDon.getSelectedRow();
            if (row != -1) {
                suaCTHD(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chưa Có Dòng Nào Được Chọn!");
            }
        }
    }//GEN-LAST:event_btnSuaMouseClicked

    private void cbbTenDoUongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTenDoUongItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbTenDoUongItemStateChanged

    private void tableLapHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLapHoaDonMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int row = tableLapHoaDon.getSelectedRow();
            if (row != -1) {
                layTuBang(row);
                cbbTenDoUong.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tableLapHoaDonMouseClicked

    private void tableLapHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableLapHoaDonKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetCTHD();
        }
    }//GEN-LAST:event_tableLapHoaDonKeyPressed

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            labelTienTraLai.setText(tienThua() + "");
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbQuay;
    private static javax.swing.JComboBox<String> cbbTenDoUong;
    private javax.swing.JLabel chuaDu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JLabel labelNgayLap;
    private javax.swing.JLabel labelTienTraLai;
    private javax.swing.JLabel labelTongTien;
    private javax.swing.JSpinner snipperSoLuong;
    private javax.swing.JTable tableLapHoaDon;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
