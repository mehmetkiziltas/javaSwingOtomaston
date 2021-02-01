package tr.com.javaileOtomasyon.MainFE;

import datechooser.beans.customizer.edit.TextChangeListener;
import tr.com.javaileOtomasyon.dal.FaturaDetayDAL;
import tr.com.javaileOtomasyon.dal.UrunlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.FaturaDetayContract;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FaturaUrunDetayFE extends JDialog implements FeInterfaces {

    private String UrunID;
    private String FaturaID;

    public FaturaUrunDetayFE(String UrunId, String FaturaId) {
        setFaturaID(FaturaId);
        setUrunID(UrunId);
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Fatura Ürün Detayları"));

        panel.setSize(new Dimension(100, 100));
        add(panel);
        setTitle("Fatura Ürün Detayları");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel faturaPanel = new JPanel(new BorderLayout());
        JPanel FaturaUrunDetayPanel = new JPanel(new BorderLayout());
        JPanel FaturaSolPanel = new JPanel(new BorderLayout());
        JPanel FaturaSolUstPanel = new JPanel(new GridLayout(12, 2));
        FaturaUrunDetayPanel.setPreferredSize(new Dimension(1200, 500));

        FaturaUrunDetayPanel.setBorder(BorderFactory.createTitledBorder("Fatura Detayları"));
        String[] FaturaUrunDetayKolonlar = {"ID", "Ürün Id", "Ürün Adı", "Miktar", "Fiyat", "Tutar", "Fatura Id"};
        DefaultTableModel FaturaUrunDetaymodel = new DefaultTableModel(FaturaUrunDetayKolonlar, 0);
        JTable FaturaUrunDetaytablo = new JTable(FaturaUrunDetaymodel);

        JLabel FaturaUrunDetayIDLabel = new JLabel("ID: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaUrunDetayIDLabel);
        JTextField FaturaUrunDetayIDField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaUrunDetayIDField);

        JLabel FaturaUrunAdiLabel = new JLabel("Urun Adı: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaUrunAdiLabel);
        JComboBox FaturaUrunAdiField = new JComboBox(new UrunlerDAL().GetAllUrunler().toArray());
        FaturaSolUstPanel.add(FaturaUrunAdiField);

        JLabel FaturaUrunIdLabel = new JLabel("Ürün Id: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaUrunIdLabel);
        JTextField FaturaUrunIdField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaUrunIdField);
        FaturaUrunIdField.setText(getFaturaID());

        FaturaUrunAdiField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FaturaUrunIdField.setText(new UrunlerDAL().GetByName(FaturaUrunAdiField.getSelectedItem().toString()));
            }
        });

        JLabel FaturaMiktarLabel = new JLabel("Miktar: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaMiktarLabel);
        JTextField FaturaMiktarField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaMiktarField);


        JLabel FaturaFiyatLabel = new JLabel("Fiyat: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaFiyatLabel);
        JTextField FaturaFiyatField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaFiyatField);

        JLabel FaturaTutarLabel = new JLabel("Tutar: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaTutarLabel);
        JTextField FaturaTutarField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaTutarField);

        FaturaMiktarField.getDocument().addDocumentListener(new TextChangeListener() {
            @Override
            public void textChanged(DocumentEvent documentEvent) {
                try {
                    if (!FaturaFiyatField.equals("")) {
                        Double fiyat = Double.valueOf(FaturaMiktarField.getText()) * Double.valueOf(FaturaFiyatField.getText());
                        FaturaTutarField.setText(String.valueOf(fiyat));
                    } else {
                        FaturaTutarField.setText(String.valueOf(0));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        FaturaFiyatField.getDocument().addDocumentListener(new TextChangeListener() {
            @Override
            public void textChanged(DocumentEvent documentEvent) {
                try {
                    if (!FaturaMiktarField.equals("")) {
                        Double fiyat = Double.valueOf(FaturaMiktarField.getText()) * Double.valueOf(FaturaFiyatField.getText());
                        FaturaTutarField.setText(String.valueOf(fiyat));
                    } else {
                        FaturaTutarField.setText(String.valueOf(0));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel FaturaDetayIdLabel = new JLabel("Fatura Id: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaDetayIdLabel);
        JTextField FaturaDetayIdField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaDetayIdField);
        FaturaDetayIdField.setText(getUrunID());
        FaturaDetayIdField.setEnabled(false);

        JButton FaturaDetayKaydetButton = new JButton("Kaydet");
        FaturaSolUstPanel.add(FaturaDetayKaydetButton);
        FaturaDetayKaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FaturaDetayContract faturaDetayContract = new FaturaDetayContract();
                    faturaDetayContract.setFaturaUrunId(FaturaUrunIdField.getText());
                    faturaDetayContract.setUrunAdi(FaturaUrunAdiField.getSelectedItem().toString());
                    faturaDetayContract.setMiktar(FaturaMiktarField.getText());
                    faturaDetayContract.setFiyat(FaturaFiyatField.getText());
                    faturaDetayContract.setTutar(FaturaTutarField.getText());
                    faturaDetayContract.setFaturaId(FaturaDetayIdField.getText());

                    int input = JOptionPane.showConfirmDialog(null,
                            " Fatura Eklendi", "", JOptionPane.DEFAULT_OPTION);
                    if (input == 0) {
                        new FaturaDetayDAL().Insert(faturaDetayContract);

                        new UrunlerDAL().UpdateByName(Integer.parseInt(FaturaMiktarField.getText()), FaturaUrunIdField.getText());
                        int satir = FaturaUrunDetaymodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            FaturaUrunDetaymodel.removeRow(0);
                        }
                        for (FaturaDetayContract Pcontract : new FaturaDetayDAL().GetByIdString(getUrunID())) {
                            FaturaUrunDetaymodel.addRow(Pcontract.getVeriler());
                        }

                    }
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }

            }
        });

        JButton FaturaGuncelleButton = new JButton("Güncelle");
        FaturaSolUstPanel.add(FaturaGuncelleButton);
        FaturaGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FaturaDetayContract contract = new FaturaDetayContract();
//"ID","Ürün Id", "Ürün Adı", "Miktar", "Fiyat", "Tutar", "Fatura Id"
                    contract.setID(FaturaUrunDetayIDField.getText());
                    contract.setFaturaUrunId(FaturaUrunIdField.getText());
                    contract.setUrunAdi(FaturaUrunAdiField.getSelectedItem().toString());
                    contract.setMiktar(FaturaMiktarField.getText());
                    contract.setFiyat(FaturaFiyatField.getText());
                    contract.setTutar(FaturaTutarField.getText());
                    contract.setFaturaId(FaturaDetayIdField.getText());
                    int input = JOptionPane.showConfirmDialog(null,
                            contract.getUrunAdi() + " Adlı Fatura Detay Güncellensin mi", "", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        new FaturaDetayDAL().Update(contract);
                        int satir = FaturaUrunDetaymodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            FaturaUrunDetaymodel.removeRow(0);
                        }
                        for (FaturaDetayContract FDcontract : new FaturaDetayDAL().GetByIdString(getUrunID())) {
                            FaturaUrunDetaymodel.addRow(FDcontract.getVeriler());
                        }
                    }
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                }
            }
        });

        JButton FaturaSilButton = new JButton("Sil");
        FaturaSolUstPanel.add(FaturaSilButton);
        FaturaSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (FaturaUrunIdField.getText() != null) {
                        int input = JOptionPane.showConfirmDialog(null, "Seçili Fatura Detayı Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                        if (input == 0) {
                            new FaturaDetayDAL().DeleteById(Integer.parseInt(FaturaUrunDetayIDField.getText()));
                            int satir = FaturaUrunDetaymodel.getRowCount();
                            for (int i = 0; i < satir; i++) {
                                FaturaUrunDetaymodel.removeRow(0);
                            }

                            for (FaturaDetayContract contract : new FaturaDetayDAL().GetAll()) {
                                FaturaUrunDetaymodel.addRow(contract.getVeriler());
                            }
                        }
                    }
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }
            }
        });
        JButton yenileButton = new JButton("Temizle");
        FaturaSolUstPanel.add(yenileButton);
        yenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FaturaUrunDetayIDField.setText("");
                FaturaUrunIdField.setText("");
                FaturaUrunAdiField.setSelectedItem("");
                FaturaMiktarField.setText("");
                FaturaFiyatField.setText("");
                FaturaTutarField.setText("");
                FaturaDetayIdField.setText("");
            }
        });
        JButton kapatButton = new JButton("Kapat");
        FaturaSolUstPanel.add(kapatButton);
        kapatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JScrollPane FaturaUrunDetayTablePane = new JScrollPane(FaturaUrunDetaytablo);
        for (FaturaDetayContract contract : new FaturaDetayDAL().GetByIdString(getUrunID())) {
            FaturaUrunDetaymodel.addRow(contract.getVeriler());
        }

        FaturaUrunDetayTablePane.addMouseListener(new MouseListener() {
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
                    DefaultTableModel model = (DefaultTableModel) FaturaUrunDetaytablo.getModel();
                    int selectedRowIndex = FaturaUrunDetaytablo.getSelectedRow();
                    FaturaUrunDetayIDField.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    FaturaUrunIdField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    FaturaUrunAdiField.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
                    FaturaMiktarField.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    FaturaFiyatField.setText(model.getValueAt(selectedRowIndex, 4).toString());
                    FaturaTutarField.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    FaturaDetayIdField.setText(model.getValueAt(selectedRowIndex, 6).toString());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        FaturaSolPanel.add(FaturaSolUstPanel, BorderLayout.CENTER);
        faturaPanel.add(FaturaSolPanel, BorderLayout.WEST);
        FaturaUrunDetayPanel.add(FaturaUrunDetayTablePane, BorderLayout.CENTER);
        FaturaUrunDetayPanel.add(faturaPanel, BorderLayout.WEST);
        return FaturaUrunDetayPanel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {

        return null;
    }

    public String getUrunID() {
        return UrunID;
    }

    public void setUrunID(String urunID) {
        UrunID = urunID;
    }

    public String getFaturaID() {
        return FaturaID;
    }

    public void setFaturaID(String faturaID) {
        FaturaID = faturaID;
    }
}
