package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.FirmalarDAL;
import tr.com.javaileOtomasyon.dal.IlcelerDAL;
import tr.com.javaileOtomasyon.dal.SehirlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.FirmalarContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirmalarFE extends JPanel implements FeInterfaces {

    public FirmalarFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {

        JPanel firmaPanel = new JPanel(new BorderLayout());
        JPanel FirmaSolPanel = new JPanel(new BorderLayout());
        JPanel FirmaSolUstPanel = new JPanel(new GridLayout(16, 2));
        JPanel FirmaSolAltPanel = new JPanel();
        firmaPanel.setPreferredSize(new Dimension(1800, 900));

        FirmaSolPanel.setBorder(BorderFactory.createTitledBorder("Firma İşlemleri"));
        String[] FirmaKolonlar = {"Id", "Ad", "Yetkili Statu", "Yetkili Ad Soyad", "Yetkili Tc", "Sektor", "Telefon1", "Telefon2", "Mail", "Fax",
        "İl", "İlçe", "Vergi Daire", "Adres",};
        DefaultTableModel Firmamodel = new DefaultTableModel(FirmaKolonlar, 0);
        JTable Firmatablo = new JTable(Firmamodel);
        JScrollPane FirmaTablePane = new JScrollPane(Firmatablo);

        JLabel FirmaIdLabel = new JLabel("ID: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaIdLabel);
        JTextField FirmaIdBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaIdBox);

        JLabel FirmaAdLabel = new JLabel("AD: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaAdLabel);
        JTextField FirmaAdiBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaAdiBox);

        JLabel FirmaYetkiliStatuLabel = new JLabel("Yetkili Statü: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaYetkiliStatuLabel);
        JTextField FirmaYetkiliStatuiBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaYetkiliStatuiBox);

        JLabel FirmaYetkiliAdSoyadLabel = new JLabel("Yetkili Ad Soyad: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaYetkiliAdSoyadLabel);
        JTextField FirmaYetkiliAdSoyadBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaYetkiliAdSoyadBox);

        JLabel FirmaYetkiliTcLabel = new JLabel("Yetkili Tc: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaYetkiliTcLabel);
        JTextField FirmaYetkiliTcBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaYetkiliTcBox);

        JLabel FirmaSektorLabel = new JLabel("Sektor: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaSektorLabel);
        JTextField FirmaYeSektorBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaYeSektorBox);

        JLabel FirmaTelefonLabel = new JLabel("Telefon: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaTelefonLabel);
        JTextField FirmaTelefonBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaTelefonBox);

        JLabel FirmaTelefon2Label = new JLabel("Telefon2: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaTelefon2Label);
        JTextField FirmaTelefon2Box = new JTextField(15);
        FirmaSolUstPanel.add(FirmaTelefon2Box);

        JLabel FirmaMailLabel = new JLabel("Mail: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaMailLabel);
        JTextField FirmaMailBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaMailBox);

        JLabel FirmaFaxLabel = new JLabel("Fax: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaFaxLabel);
        JTextField FirmaFaxBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaFaxBox);

        JLabel FirmaIlLabel = new JLabel("Il: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaIlLabel);
        JComboBox FirmaIlBox = new JComboBox(new SehirlerDAL().GetAll().toArray());
        FirmaSolUstPanel.add(FirmaIlBox);

        JLabel FirmaIlceLabel = new JLabel("Ilce: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaIlceLabel);
        JComboBox FirmaIlceBox = new JComboBox();
        FirmaSolUstPanel.add(FirmaIlceBox);

        FirmaIlBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model = new DefaultComboBoxModel(new IlcelerDAL().GetByName(FirmaIlBox
                        .getSelectedItem()
                        .toString()).toArray());
                FirmaIlceBox.setModel(model);
            }
        });

        JLabel FirmaVergiDaireLabel = new JLabel("Vergi Dairesi: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaVergiDaireLabel);
        JTextField FirmaVergiDaireBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaVergiDaireBox);

        JLabel FirmaAdresLabel = new JLabel("Adres: ", JLabel.RIGHT);
        FirmaSolUstPanel.add(FirmaAdresLabel);
        JTextField FirmaAdresBox = new JTextField(15);
        FirmaSolUstPanel.add(FirmaAdresBox);

        JButton FirmaKaydetButton = new JButton("Kaydet");
        FirmaSolUstPanel.add(FirmaKaydetButton);
        for (FirmalarContract Fcontract : new FirmalarDAL().GetAll()) {
            Firmamodel.addRow(Fcontract.getVeriler());
        }

        FirmaTablePane.addMouseListener(new MouseListener() {
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
                    DefaultTableModel model = (DefaultTableModel) Firmatablo.getModel();
                    int selectedRowIndex = Firmatablo.getSelectedRow();

                    FirmaIdBox.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    FirmaAdiBox.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    FirmaYetkiliStatuiBox.setText(model.getValueAt(selectedRowIndex, 2).toString());
                    FirmaYetkiliAdSoyadBox.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    FirmaYetkiliTcBox.setText(model.getValueAt(selectedRowIndex, 4).toString());
                    FirmaYeSektorBox.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    FirmaTelefonBox.setText(model.getValueAt(selectedRowIndex, 6).toString());
                    FirmaTelefon2Box.setText(model.getValueAt(selectedRowIndex, 7).toString());
                    FirmaMailBox.setText(model.getValueAt(selectedRowIndex, 8).toString());
                    FirmaFaxBox.setText(model.getValueAt(selectedRowIndex, 9).toString());
                    FirmaIlBox.setSelectedItem(model.getValueAt(selectedRowIndex, 10).toString());
                    FirmaIlceBox.setSelectedItem(model.getValueAt(selectedRowIndex, 11).toString());
                    FirmaVergiDaireBox.setText(model.getValueAt(selectedRowIndex, 12).toString());
                    FirmaAdresBox.setText(model.getValueAt(selectedRowIndex, 13).toString());
                } catch (Exception exception) {

                }

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        FirmaKaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirmalarContract contract = new FirmalarContract();
                contract.setAd(FirmaAdiBox.getText());
                contract.setYetkiliStatu(FirmaYetkiliStatuiBox.getText());
                contract.setYetkiliAdSoyad(FirmaYetkiliAdSoyadBox.getText());
                contract.setYetkiliTc(FirmaYetkiliTcBox.getText());
                contract.setSektor(FirmaYeSektorBox.getText());
                contract.setTelefon1(FirmaTelefonBox.getText());
                contract.setTelefon2(FirmaTelefon2Box.getText());
                contract.setMail(FirmaMailBox.getText());
                contract.setFax(FirmaFaxBox.getText());
                contract.setIl(FirmaIlBox.getSelectedItem().toString());
                contract.setIlce(FirmaIlceBox.getSelectedItem().toString());
                contract.setVergiDaire(FirmaVergiDaireBox.getText());
                contract.setAdres(FirmaAdresBox.getText());
                new FirmalarDAL().Insert(contract);
                int input = JOptionPane.showConfirmDialog(null,
                        contract.getAd() + " Adlı Firma Eklendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    int satir = Firmamodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        Firmamodel.removeRow(0);
                    }
                    for (FirmalarContract Fcontract : new FirmalarDAL().GetAll()) {
                        Firmamodel.addRow(Fcontract.getVeriler());
                    }
                }
            }
        });

        JButton FirmaGuncelleButton = new JButton("Güncelle");
        FirmaSolUstPanel.add(FirmaGuncelleButton);
        FirmaGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirmalarContract contract = new FirmalarContract();
                contract.setId(FirmaIdBox.getText());
                contract.setAd(FirmaAdiBox.getText());
                contract.setYetkiliStatu(FirmaYetkiliStatuiBox.getText());
                contract.setYetkiliAdSoyad(FirmaYetkiliAdSoyadBox.getText());
                contract.setYetkiliTc(FirmaYetkiliTcBox.getText());
                contract.setSektor(FirmaYeSektorBox.getText());
                contract.setTelefon1(FirmaTelefonBox.getText());
                contract.setTelefon2(FirmaTelefon2Box.getText());
                contract.setMail(FirmaMailBox.getText());
                contract.setFax(FirmaFaxBox.getText());
                contract.setIl(FirmaIlBox.getSelectedItem().toString());
                contract.setIlce(FirmaIlceBox.getSelectedItem().toString());
                contract.setVergiDaire(FirmaVergiDaireBox.getText());
                contract.setAdres(FirmaAdresBox.getText());
                new FirmalarDAL().Update(contract);
                int input = JOptionPane.showConfirmDialog(null,
                        contract.getAd() + " Adlı Firma Güncellendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    int satir = Firmamodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        Firmamodel.removeRow(0);
                    }
                    for (FirmalarContract Fcontract : new FirmalarDAL().GetAll()) {
                        Firmamodel.addRow(Fcontract.getVeriler());
                    }
                }
            }
        });

        JButton FirmaSilButton = new JButton("Sil");
        FirmaSolUstPanel.add(FirmaSilButton);
        FirmaSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FirmaIdBox.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Ürün Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new FirmalarDAL().DeleteById(Integer.parseInt(FirmaIdBox.getText()));
                        int satir = Firmamodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            Firmamodel.removeRow(0);
                        }

                        for (FirmalarContract contract : new FirmalarDAL().GetAll()) {
                            Firmamodel.addRow(contract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton FirmaYenileButton = new JButton("Yenile");
        FirmaSolUstPanel.add(FirmaYenileButton);
        FirmaYenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirmaIdBox.setText("");
                FirmaAdiBox.setText("");
                FirmaYetkiliStatuiBox.setText("");
                FirmaYetkiliAdSoyadBox.setText("");
                FirmaYetkiliTcBox.setText("");
                FirmaYeSektorBox.setText("");
                FirmaTelefonBox.setText("");
                FirmaTelefon2Box.setText("");
                FirmaMailBox.setText("");
                FirmaFaxBox.setText("");
                FirmaIlBox.setSelectedItem(null);
                FirmaIlceBox.setSelectedItem(null);
                FirmaVergiDaireBox.setText("");
                FirmaAdiBox.setText("");
            }
        });

        FirmaSolPanel.add(FirmaSolUstPanel, BorderLayout.NORTH);
        FirmaSolPanel.add(FirmaSolAltPanel, BorderLayout.SOUTH);
        firmaPanel.add(FirmaSolPanel, BorderLayout.WEST);
        firmaPanel.add(FirmaTablePane, BorderLayout.CENTER);
        return firmaPanel;
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
