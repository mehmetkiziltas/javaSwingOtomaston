package tr.com.javaileOtomasyon.MainFE;

import com.toedter.calendar.JDateChooser;
import datechooser.beans.customizer.edit.TextChangeListener;
import tr.com.javaileOtomasyon.dal.*;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.FaturaDetayContract;
import tr.com.javaileOtomasyon.types.FaturalarBilgiContract;
import tr.com.javaileOtomasyon.types.FirmaHareketlerContract;
import tr.com.javaileOtomasyon.types.MusteriHareketlerContract;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FaturalarFE extends JPanel implements FeInterfaces {

    public String PersonelIDCek;
    public String FirmaIDCek;

    public FaturalarFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {

        JPanel faturaPanel = new JPanel(new BorderLayout());
        JPanel FaturaSolPanel = new JPanel(new BorderLayout());
        JPanel FaturaSolUstPanel = new JPanel(new GridLayout(20, 2));
        JPanel FaturaSolAltPanel = new JPanel();

        faturaPanel.setPreferredSize(new Dimension(1800, 900));

        FaturaSolPanel.setBorder(BorderFactory.createTitledBorder("Fatura İşlemleri"));
        String[] FaturaKolonlar = {"Id", "Seri", "Sıra No", "", "Tarih", "Saat", "Vergi Daire", "Alıcı", "T. Eden", "T. Alan"};
        DefaultTableModel Faturamodel = new DefaultTableModel(FaturaKolonlar, 0);
        JTable Faturatablo = new JTable(Faturamodel);
        JScrollPane FaturaTablePane = new JScrollPane(Faturatablo);

        JLabel FaturaIdLabel = new JLabel("Id: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaIdLabel);
        JTextField FaturaIdBox = new JTextField(15);
        FaturaSolUstPanel.add(FaturaIdBox);

        JLabel FaturaSeriLabel = new JLabel("Seri: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaSeriLabel);
        JTextField FaturaSeriField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaSeriField);

        JLabel FaturaSiraNoLabel = new JLabel("Sıra No: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaSiraNoLabel);
        JTextField FaturaSiraNoField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaSiraNoField);

        JLabel FaturaCariTuruLabel = new JLabel("Cari Türü: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaCariTuruLabel);
        JComboBox FaturaCariTuruField = new JComboBox();
        FaturaSolUstPanel.add(FaturaCariTuruField);

        FaturaCariTuruField.addItem("Müşteri");
        FaturaCariTuruField.addItem("Firma");

        JLabel FaturaTarihiLabel = new JLabel("Tarih: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaTarihiLabel);
        JDateChooser FaturaTarihi = new JDateChooser();
        FaturaSolUstPanel.add(FaturaTarihi);

        JLabel FaturaSaatLabel = new JLabel("Saat: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaSaatLabel);
        JTextField FaturaSaatField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaSaatField);

        JLabel FaturaVeriDaireLabel = new JLabel("Vergi Daire: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaVeriDaireLabel);
        JTextField FaturaVergiDaireField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaVergiDaireField);

        JLabel FaturaAliciLabel = new JLabel("Alıcı: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaAliciLabel);
        JTextField FaturaAliciField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaAliciField);

        JLabel FaturaTEdenLabel = new JLabel("T. Eden: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaTEdenLabel);
        JTextField FaturaTEdenField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaTEdenField);

        JLabel FaturaTAlanLabel = new JLabel("T. Alan: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaTAlanLabel);
        JTextField FaturaTAlanField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaTAlanField);

        JLabel FaturaUrunAdiLabel = new JLabel("Ürün Adı: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaUrunAdiLabel);
        JComboBox FaturaUrunAdiField = new JComboBox(new UrunlerDAL().GetAllUrunler().toArray());
        FaturaSolUstPanel.add(FaturaUrunAdiField);

        JLabel FaturaUrunIdLabel = new JLabel("Ürün Id: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaUrunIdLabel);
        JTextField FaturaUrunIdField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaUrunIdField);
        FaturaUrunIdField.setEnabled(false);

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
        FaturaTutarField.setEnabled(false);

        FaturaFiyatField.getDocument().addDocumentListener(new TextChangeListener() {
            @Override
            public void textChanged(DocumentEvent documentEvent) {
                if (FaturaFiyatField.getText() != "") {
                    Double fiyat = Double.valueOf(Double.valueOf(FaturaMiktarField.getText()) * Double.valueOf(FaturaFiyatField.getText()));

                    FaturaTutarField.setText(String.valueOf(fiyat));
                } else {
                    FaturaTutarField.setText("0");
                }
            }
        });


        JLabel FaturaPersonelLabel = new JLabel("Personel: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaPersonelLabel);
        JComboBox FaturaPersonelField = new JComboBox(new PersonellerDAL().GetAll().toArray());
        FaturaSolUstPanel.add(FaturaPersonelField);
        FaturaPersonelField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonelIDCek = (new PersonellerDAL().GetByName(FaturaPersonelField.getSelectedItem().toString()));

            }
        });

        JLabel FaturaFirmaLabel = new JLabel("Firma: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaFirmaLabel);
        JComboBox FaturaFirmaField = new JComboBox(new FirmalarDAL().GetAll().toArray());
        FaturaSolUstPanel.add(FaturaFirmaField);
        FaturaFirmaField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirmaIDCek = (new FirmalarDAL().GetByName(FaturaFirmaField.getSelectedItem().toString()));
            }
        });

        JLabel FaturaDetayIdLabel = new JLabel("Fatura Id: ", JLabel.RIGHT);
        FaturaSolUstPanel.add(FaturaDetayIdLabel);
        JTextField FaturaDetayIdField = new JTextField(15);
        FaturaSolUstPanel.add(FaturaDetayIdField);

        for (FaturalarBilgiContract Pcontract : new FaturalarDAL().GetAll()) {
            Faturamodel.addRow(Pcontract.getVeriler());
        }

        FaturaTablePane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) Faturatablo.getModel();
                int selectedRowIndex = Faturatablo.getSelectedRow();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new FaturaUrunDetayFE((String) model.getValueAt(selectedRowIndex, 0), FaturaUrunIdField.getText());
                    }
                });
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
                    DefaultTableModel model = (DefaultTableModel) Faturatablo.getModel();
                    int selectedRowIndex = Faturatablo.getSelectedRow();

                    FaturaIdBox.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    FaturaSeriField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    FaturaSiraNoField.setText(model.getValueAt(selectedRowIndex, 2).toString());
                    String setTarih = model.getValueAt(selectedRowIndex, 4).toString();
                    Date date;
                    try {
                        date = new SimpleDateFormat("dd-MM-yyyy").parse(setTarih);
                        FaturaTarihi.setDate(date);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    FaturaSaatField.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    FaturaVergiDaireField.setText(model.getValueAt(selectedRowIndex, 6).toString());
                    FaturaAliciField.setText(model.getValueAt(selectedRowIndex, 7).toString());
                    FaturaTEdenField.setText(model.getValueAt(selectedRowIndex, 8).toString());
                    FaturaTAlanField.setText(model.getValueAt(selectedRowIndex, 9).toString());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton FaturaKaydetButton = new JButton("Kaydet");
        FaturaSolUstPanel.add(FaturaKaydetButton);
        FaturaKaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (FaturaDetayIdField.getText().equals("")) {

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String date = format.format(FaturaTarihi.getDate());
                    FaturalarBilgiContract contract = new FaturalarBilgiContract();
                    contract.setSeri(FaturaSeriField.getText());
                    contract.setSiraNo(FaturaSiraNoField.getText());
                    contract.setTarih(date);
                    contract.setSaat(FaturaSaatField.getText());
                    contract.setVergiDaire(FaturaVergiDaireField.getText());
                    contract.setAlici(FaturaAliciField.getText());
                    contract.setTEden(FaturaTEdenField.getText());
                    contract.setTAlan(FaturaTAlanField.getText());
                    int input = JOptionPane.showConfirmDialog(null,
                            " Fatura Eklendi", "", JOptionPane.DEFAULT_OPTION);
                    if (input == 0) {
                        new FaturalarDAL().Insert(contract);
                        int satir = Faturamodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            Faturamodel.removeRow(0);
                        }
                        for (FaturalarBilgiContract Pcontract : new FaturalarDAL().GetAll()) {
                            Faturamodel.addRow(Pcontract.getVeriler());
                        }

                    }
                }
                if (!FaturaDetayIdField.getText().equals("") && FaturaCariTuruField.getSelectedItem() == "Firma") {

                    SimpleDateFormat faturaBilgiformat = new SimpleDateFormat("yyyy-MM-dd");
                    String faturaBilgidate = faturaBilgiformat.format(FaturaTarihi.getDate());
                    FaturalarBilgiContract faturaBilgicontract = new FaturalarBilgiContract();
                    faturaBilgicontract.setSeri(FaturaSeriField.getText());
                    faturaBilgicontract.setSiraNo(FaturaSiraNoField.getText());
                    faturaBilgicontract.setTarih(faturaBilgidate);
                    faturaBilgicontract.setSaat(FaturaSaatField.getText());
                    faturaBilgicontract.setVergiDaire(FaturaVergiDaireField.getText());
                    faturaBilgicontract.setAlici(FaturaAliciField.getText());
                    faturaBilgicontract.setTEden(FaturaTEdenField.getText());
                    faturaBilgicontract.setTAlan(FaturaTAlanField.getText());

                    FaturaDetayContract faturaDetayContract = new FaturaDetayContract();
                    faturaDetayContract.setFaturaUrunId(FaturaUrunIdField.getText());
                    faturaDetayContract.setUrunAdi(FaturaUrunAdiField.getSelectedItem().toString());
                    faturaDetayContract.setMiktar(FaturaMiktarField.getText());
                    faturaDetayContract.setFiyat(FaturaFiyatField.getText());
                    faturaDetayContract.setTutar(FaturaTutarField.getText());
                    faturaDetayContract.setFaturaId(FaturaDetayIdField.getText());

                    FirmaHareketlerContract contract = new FirmaHareketlerContract();
                    contract.setUrunId(FaturaUrunIdField.getText());
                    contract.setAdet(FaturaMiktarField.getText());
                    contract.setPersonel(PersonelIDCek);
                    contract.setFirma(FirmaIDCek);
                    contract.setFiyat(FaturaFiyatField.getText());
                    contract.setToplam(FaturaTutarField.getText());
                    contract.setFaturaId(FaturaDetayIdField.getText());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String date = format.format(FaturaTarihi.getDate());
                    contract.setTarih(date);


                    int input = JOptionPane.showConfirmDialog(null,
                            " Fatura Eklendi", "", JOptionPane.DEFAULT_OPTION);
                    if (input == 0) {
                        new FirmaHareketlerDAL().Insert(contract);
                        new FaturaDetayDAL().Insert(faturaDetayContract);
                        new FaturalarDAL().Insert(faturaBilgicontract);

                        new UrunlerDAL().UpdateByName(Integer.parseInt(FaturaMiktarField.getText()), FaturaUrunIdField.getText());
                        int satir = Faturamodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            Faturamodel.removeRow(0);
                        }
                        for (FaturalarBilgiContract Pcontract : new FaturalarDAL().GetAll()) {
                            Faturamodel.addRow(Pcontract.getVeriler());
                        }

                    }
                }
                if (!FaturaDetayIdField.getText().equals("") && FaturaCariTuruField.getSelectedItem() == "Müşteri") {


                    SimpleDateFormat faturaBilgiformat = new SimpleDateFormat("yyyy-MM-dd");
                    String faturaBilgidate = faturaBilgiformat.format(FaturaTarihi.getDate());
                    FaturalarBilgiContract faturaBilgicontract = new FaturalarBilgiContract();
                    faturaBilgicontract.setSeri(FaturaSeriField.getText());
                    faturaBilgicontract.setSiraNo(FaturaSiraNoField.getText());
                    faturaBilgicontract.setTarih(faturaBilgidate);
                    faturaBilgicontract.setSaat(FaturaSaatField.getText());
                    faturaBilgicontract.setVergiDaire(FaturaVergiDaireField.getText());
                    faturaBilgicontract.setAlici(FaturaAliciField.getText());
                    faturaBilgicontract.setTEden(FaturaTEdenField.getText());
                    faturaBilgicontract.setTAlan(FaturaTAlanField.getText());

                    FaturaDetayContract faturaDetayContract = new FaturaDetayContract();
                    faturaDetayContract.setFaturaUrunId(FaturaUrunIdField.getText());
                    faturaDetayContract.setUrunAdi(FaturaUrunAdiField.getSelectedItem().toString());
                    faturaDetayContract.setMiktar(FaturaMiktarField.getText());
                    faturaDetayContract.setFiyat(FaturaFiyatField.getText());
                    faturaDetayContract.setTutar(FaturaTutarField.getText());
                    faturaDetayContract.setFaturaId(FaturaDetayIdField.getText());


                    MusteriHareketlerContract contract = new MusteriHareketlerContract();
                    contract.setUrunId(FaturaUrunIdField.getText());
                    contract.setAdet(FaturaMiktarField.getText());
                    contract.setPersonel(PersonelIDCek);
                    contract.setMusteri(FirmaIDCek);
                    contract.setFiyat(FaturaFiyatField.getText());
                    contract.setToplam(FaturaTutarField.getText());
                    contract.setFaturaId(FaturaDetayIdField.getText());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String date = format.format(FaturaTarihi.getDate());
                    contract.setTarih(date);


                    int input = JOptionPane.showConfirmDialog(null,
                            " Fatura Eklendi", "", JOptionPane.DEFAULT_OPTION);
                    if (input == 0) {
                        new MusteriHareketlerDAL().Insert(contract);
                        new FaturaDetayDAL().Insert(faturaDetayContract);
                        new FaturalarDAL().Insert(faturaBilgicontract);

                        new UrunlerDAL().UpdateByName(Integer.parseInt(FaturaMiktarField.getText()), FaturaUrunIdField.getText());
                        int satir = Faturamodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            Faturamodel.removeRow(0);
                        }
                        for (FaturalarBilgiContract Pcontract : new FaturalarDAL().GetAll()) {
                            Faturamodel.addRow(Pcontract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton FaturaGuncelleButton = new JButton("Güncelle");
        FaturaSolUstPanel.add(FaturaGuncelleButton);
        FaturaGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(FaturaTarihi.getDate());

                FaturalarBilgiContract contract = new FaturalarBilgiContract();
                FaturaDetayContract faturaDetayContract = new FaturaDetayContract();


                contract.setId(FaturaIdBox.getText());
                contract.setSeri(FaturaSeriField.getText());
                contract.setSiraNo(FaturaSiraNoField.getText());
                contract.setTarih(date);
                contract.setSaat(FaturaSaatField.getText());
                contract.setVergiDaire(FaturaVergiDaireField.getText());
                contract.setAlici(FaturaAliciField.getText());
                contract.setTEden(FaturaTEdenField.getText());
                contract.setTAlan(FaturaTAlanField.getText());

                faturaDetayContract.setFaturaId(FaturaDetayIdField.getText());
                faturaDetayContract.setFaturaUrunId(FaturaUrunIdField.getText());
                faturaDetayContract.setUrunAdi(FaturaUrunAdiField.getSelectedItem().toString());
                faturaDetayContract.setMiktar(FaturaMiktarField.getText());
                faturaDetayContract.setFiyat(FaturaFiyatField.getText());
                faturaDetayContract.setTutar(FaturaTutarField.getText());
                int input = JOptionPane.showConfirmDialog(null,
                        " Fatura Güncellendi.", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    new FaturalarDAL().Update(contract);
                    new FaturaDetayDAL().Update(faturaDetayContract);
                    int satir = Faturamodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        Faturamodel.removeRow(0);
                    }
                    for (FaturalarBilgiContract Pcontract : new FaturalarDAL().GetAll()) {
                        Faturamodel.addRow(Pcontract.getVeriler());
                    }
                }
            }
        });

        JButton FaturaSilButton = new JButton("Sil");
        FaturaSolUstPanel.add(FaturaSilButton);
        FaturaSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FaturaIdBox.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Fatura Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new FaturalarDAL().DeleteById(Integer.parseInt(FaturaIdBox.getText()));
                        int satir = Faturamodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            Faturamodel.removeRow(0);
                        }
                        for (FaturalarBilgiContract Fcontract : new FaturalarDAL().GetAll()) {
                            Faturamodel.addRow(Fcontract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton FaturaYenileButton = new JButton("Yenile");
        FaturaSolUstPanel.add(FaturaYenileButton);
        FaturaYenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FaturaIdBox.setText("");
                FaturaSeriField.setText("");
                FaturaSiraNoField.setText("");
                FaturaTarihi.setDate(null);
                FaturaSaatField.setText("");
                FaturaVergiDaireField.setText("");
                FaturaAliciField.setText("");
                FaturaTEdenField.setText("");
                FaturaTAlanField.setText("");
                FaturaUrunIdField.setText("");
                FaturaUrunAdiField.setSelectedItem("");
                FaturaMiktarField.setText("");
                FaturaFiyatField.setText("");
                FaturaTutarField.setText("");
                FaturaPersonelField.setSelectedItem("");
                FaturaFirmaField.setSelectedItem("");
                FaturaDetayIdField.setText("");
            }
        });

        FaturaSolPanel.add(FaturaSolUstPanel, BorderLayout.NORTH);
        FaturaSolPanel.add(FaturaSolAltPanel, BorderLayout.SOUTH);
        faturaPanel.add(FaturaSolPanel, BorderLayout.WEST);
        faturaPanel.add(FaturaTablePane, BorderLayout.CENTER);
        return faturaPanel;
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
