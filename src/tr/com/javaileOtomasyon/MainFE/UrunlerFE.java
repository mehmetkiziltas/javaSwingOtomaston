package tr.com.javaileOtomasyon.MainFE;

import com.toedter.calendar.JDateChooser;
import tr.com.javaileOtomasyon.complex.contract.UrunlerContractComplex;
import tr.com.javaileOtomasyon.dal.KatagoriDal;
import tr.com.javaileOtomasyon.dal.UrunlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.KatagoriContract;
import tr.com.javaileOtomasyon.types.UrunlerContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UrunlerFE extends JPanel implements FeInterfaces {

    public UrunlerFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();

        add(panel);
    }

    @Override
    public JPanel initPanel() {


        JPanel urunPanel = new JPanel(new BorderLayout());
        JPanel urunSolPanel = new JPanel(new BorderLayout());
        JPanel urunSolUstPanel = new JPanel(new GridLayout(12, 2));
        JPanel urunSolAltPanel = new JPanel();

        urunPanel.setPreferredSize(new Dimension(1700, 900));

        urunSolPanel.setBorder(BorderFactory.createTitledBorder("Ürün İşlemleri"));
        String[] urunKolonlar = {"ID", "Ürün Adı", "Marka", "Model", "Tarih", "Adet", "Alış Fiyat", "Satış Fiyat", "Detay"};
        DefaultTableModel urunmodel = new DefaultTableModel(urunKolonlar, 0);
        JTable uruntablo = new JTable(urunmodel);
        JScrollPane urunTablePane = new JScrollPane(uruntablo);
        for (UrunlerContractComplex contract : new UrunlerDAL().GetAllUrunler()) {
            urunmodel.addRow(contract.getVeriler());
        }

        JLabel UrunIdLabel = new JLabel("ID: ", JLabel.RIGHT);
        urunSolUstPanel.add(UrunIdLabel);
        JTextField UrunIdBox = new JTextField(15);
        urunSolUstPanel.add(UrunIdBox);

        JLabel urunUrunAdiLabel = new JLabel("AD: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunUrunAdiLabel);
        JTextField urunUrunAdiBox = new JTextField(15);
        urunSolUstPanel.add(urunUrunAdiBox);

        JLabel urunMarkaLabel = new JLabel("Marka: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunMarkaLabel);
        JComboBox urunMarkaField = new JComboBox(new KatagoriDal().GetAll().toArray());
        urunSolUstPanel.add(urunMarkaField);

        JLabel urunModelLabel = new JLabel("Model: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunModelLabel);
        JTextField urunModelField = new JTextField(15);
        urunSolUstPanel.add(urunModelField);

        JLabel urunTarihiLabel = new JLabel("Tarih: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunTarihiLabel);
        JDateChooser urunTarihi = new JDateChooser();
        urunSolUstPanel.add(urunTarihi);

        JLabel urunAdetLabel = new JLabel("Adet: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunAdetLabel);
        JTextField urunAdetField = new JTextField(15);
        urunSolUstPanel.add(urunAdetField);

        JLabel urunAlisLabel = new JLabel("Alış Fiyat: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunAlisLabel);
        JTextField urunAlisField = new JTextField(15);
        urunSolUstPanel.add(urunAlisField);

        JLabel urunSatisLabel = new JLabel("Satıs Fıyat: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunSatisLabel);
        JTextField urunSatisField = new JTextField(15);
        urunSolUstPanel.add(urunSatisField);

        JLabel urunDetayLabel = new JLabel("Detay: ", JLabel.RIGHT);
        urunSolUstPanel.add(urunDetayLabel);
        JTextArea urunDetayField = new JTextArea();
        urunDetayField.setWrapStyleWord(true);
        urunSolUstPanel.add(urunDetayField);
        urunTablePane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    DefaultTableModel model = (DefaultTableModel) uruntablo.getModel();
                    int selectedRowIndex = uruntablo.getSelectedRow();

                    UrunIdBox.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    urunUrunAdiBox.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    urunMarkaField.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
                    urunModelField.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    String setTarih = model.getValueAt(selectedRowIndex, 4).toString();
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy").parse(setTarih);
                        urunTarihi.setDate(date);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    urunAdetField.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    urunAlisField.setText(model.getValueAt(selectedRowIndex, 6).toString());
                    urunSatisField.setText(model.getValueAt(selectedRowIndex, 7).toString());
                    urunDetayField.setText(model.getValueAt(selectedRowIndex, 8).toString());
                } catch (Exception exception) {

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton urunEkleButton = new JButton("Kaydet");
        urunSolUstPanel.add(urunEkleButton);

        urunEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrunlerContract contractComplex = new UrunlerContract();
                KatagoriContract casContract = (KatagoriContract) urunMarkaField.getSelectedItem();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(urunTarihi.getDate());
                contractComplex.setADI(urunUrunAdiBox.getText());
                contractComplex.setMARKA(String.valueOf(casContract.getId()));
                contractComplex.setMODEL(urunModelField.getText());
                contractComplex.setYIL(date);
                contractComplex.setADET(urunAdetField.getText());
                contractComplex.setALISFIYAT(Float.parseFloat(urunAlisField.getText()));
                contractComplex.setSATISFIYAT(Float.parseFloat(urunSatisField.getText()));
                contractComplex.setDETAY(urunDetayField.getText());

                new UrunlerDAL().Insert(contractComplex);
                int input = JOptionPane.showConfirmDialog(null,
                        contractComplex.getADI() + " Adlı Ürun Eklendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    int satir = urunmodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        urunmodel.removeRow(0);
                    }
                    for (UrunlerContractComplex contract : new UrunlerDAL().GetAllUrunler()) {
                        urunmodel.addRow(contract.getVeriler());
                    }
                }
            }
        });

        JButton urunGuncelleButton = new JButton("Güncelle");
        urunSolUstPanel.add(urunGuncelleButton);
        urunGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrunlerContract contractComplex = new UrunlerContract();
                KatagoriContract casContract = (KatagoriContract) urunMarkaField.getSelectedItem();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(urunTarihi.getDate());
                contractComplex.setID(Integer.parseInt(UrunIdBox.getText()));
                contractComplex.setADI(urunUrunAdiBox.getText());
                contractComplex.setMARKA(String.valueOf(casContract.getId()));
                contractComplex.setMODEL(urunModelField.getText());
                contractComplex.setYIL(date);
                contractComplex.setADET(urunAdetField.getText());
                contractComplex.setALISFIYAT(Float.parseFloat(urunAlisField.getText()));
                contractComplex.setSATISFIYAT(Float.parseFloat(urunSatisField.getText()));
                contractComplex.setDETAY(urunDetayField.getText());

                int input = JOptionPane.showConfirmDialog(null,
                        contractComplex.getADI() + " Adlı Ürun Güncellensin mi", "", JOptionPane.YES_NO_OPTION);
                if (input == JOptionPane.YES_OPTION) {
                    new UrunlerDAL().Update(contractComplex);
                    int satir = urunmodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        urunmodel.removeRow(0);
                    }
                    for (UrunlerContractComplex contract : new UrunlerDAL().GetAllUrunler()) {
                        urunmodel.addRow(contract.getVeriler());
                    }
                }

            }
        });

        JButton urunSilButton = new JButton("Sil");
        urunSolUstPanel.add(urunSilButton);
        urunSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (UrunIdBox.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Ürün Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new UrunlerDAL().DeleteById(Integer.parseInt(UrunIdBox.getText()));
                        int satir = urunmodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            urunmodel.removeRow(0);
                        }

                        for (UrunlerContractComplex contract : new UrunlerDAL().GetAllUrunler()) {
                            urunmodel.addRow(contract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton urunTemizleButton = new JButton("Temizle");
        urunSolUstPanel.add(urunTemizleButton);
        urunTemizleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrunIdBox.setText("");
                urunUrunAdiBox.setText("");
                urunMarkaField.setSelectedItem("");
                urunModelField.setText("");
                urunTarihi.setDate(null);
                urunAdetField.setText("");
                urunAlisField.setText("");
                urunSatisField.setText("");
                urunDetayField.setText("");
            }
        });


        urunSolPanel.add(urunSolUstPanel, BorderLayout.NORTH);
        urunSolPanel.add(urunSolAltPanel, BorderLayout.SOUTH);


        urunPanel.add(urunSolPanel, BorderLayout.WEST);
        urunPanel.add(urunTablePane, BorderLayout.CENTER);
        return urunPanel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }
}
