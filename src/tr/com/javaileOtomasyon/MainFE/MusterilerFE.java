package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.IlcelerDAL;
import tr.com.javaileOtomasyon.dal.MusteriDAL;
import tr.com.javaileOtomasyon.dal.SehirlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.MusteriContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MusterilerFE extends JPanel implements FeInterfaces {

    public MusterilerFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {


        JPanel musteriPanel = new JPanel(new BorderLayout());
        JPanel musteriSolPanel = new JPanel(new BorderLayout());
        JPanel musteriSolUstPanel = new JPanel(new GridLayout(13, 2));
        JPanel musteriSolAltPanel = new JPanel();
        musteriPanel.setPreferredSize(new Dimension(1700, 900));

        musteriSolPanel.setBorder(BorderFactory.createTitledBorder("Müşteri İşlemleri"));
        String[] musteriKolonlar = {"Id", "Ad", "Soyad", "Telefon1", "Telefon2", "Tc", "Mail","İl", "İlçe", "Adres", "Vergi Daire"};
        DefaultTableModel musterimodel = new DefaultTableModel(musteriKolonlar, 0);
        JTable musteritablo = new JTable(musterimodel);

        JScrollPane musteriTablePane = new JScrollPane(musteritablo);

        for (MusteriContract contract:new MusteriDAL().GetAll()) {
            musterimodel.addRow(contract.getVeriler());
        }

        JLabel musteriIdLabel = new JLabel("Id: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriIdLabel);
        JTextField musteriIdBox = new JTextField(15);
        musteriSolUstPanel.add(musteriIdBox);

        JLabel musteriAdiLabel = new JLabel("Ad: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriAdiLabel);
        JTextField musteriAdiBox = new JTextField(15);
        musteriSolUstPanel.add(musteriAdiBox);

        JLabel musteriSoyadLabel = new JLabel("Soyad: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriSoyadLabel);
        JTextField musteriSoyadField = new JTextField(15);
        musteriSolUstPanel.add(musteriSoyadField);

        JLabel musteriTelefon1Label = new JLabel("Telefon1: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriTelefon1Label);
        JTextField musteriTelefon1Field = new JTextField(15);
        musteriSolUstPanel.add(musteriTelefon1Field);

        JLabel musteriTelefon2Label = new JLabel("Telefon2: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriTelefon2Label);
        JTextField musteriTelefon2Field = new JTextField(15);
        musteriSolUstPanel.add(musteriTelefon2Field);

        JLabel musteriTcLabel = new JLabel("Tc: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriTcLabel);
        JTextField musteriTcField = new JTextField(15);
        musteriSolUstPanel.add(musteriTcField);

        JLabel musteriMailLabel = new JLabel("Mail: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriMailLabel);
        JTextField musteriMailField = new JTextField(15);
        musteriSolUstPanel.add(musteriMailField);

        JLabel musteriIlLabel = new JLabel("Il: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriIlLabel);
        JComboBox musteriIlField = new JComboBox(new SehirlerDAL().GetAll().toArray());
        musteriSolUstPanel.add(musteriIlField);

        JLabel musteriIlceLabel = new JLabel("Ilce: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriIlceLabel);
        JComboBox musteriIlceField = new JComboBox();
        musteriSolUstPanel.add(musteriIlceField);

        musteriIlField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model = new DefaultComboBoxModel(new IlcelerDAL().GetByName(musteriIlField
                        .getSelectedItem()
                        .toString()).toArray());
                musteriIlceField.setModel(model);
            }
        });

        JLabel musteriVergiDaireLabel = new JLabel("Vergi Daire: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriVergiDaireLabel);
        JTextField musteriVergiDaireField = new JTextField(15);
        musteriSolUstPanel.add(musteriVergiDaireField);

        JLabel musteriAdresLabel = new JLabel("Adres: ", JLabel.RIGHT);
        musteriSolUstPanel.add(musteriAdresLabel);
        JTextField musteriAdresField = new JTextField(15);
        musteriSolUstPanel.add(musteriAdresField);

        musteriTablePane.addMouseListener(new MouseListener() {
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
                DefaultTableModel model = (DefaultTableModel) musteritablo.getModel();
                int selectedRowIndex = musteritablo.getSelectedRow();
                musteriIdBox.setText(model.getValueAt(selectedRowIndex,0).toString());
                musteriAdiBox.setText(model.getValueAt(selectedRowIndex,1).toString());
                musteriSoyadField.setText(model.getValueAt(selectedRowIndex,2).toString());
                musteriTelefon1Field.setText(model.getValueAt(selectedRowIndex,3).toString());
                musteriTelefon2Field.setText(model.getValueAt(selectedRowIndex,4).toString());
                musteriTcField.setText(model.getValueAt(selectedRowIndex,5).toString());
                musteriMailField.setText(model.getValueAt(selectedRowIndex,6).toString());
                musteriIlField.setSelectedItem(model.getValueAt(selectedRowIndex,7));
                musteriIlceField.setSelectedItem(model.getValueAt(selectedRowIndex,8));
                musteriVergiDaireField.setText(model.getValueAt(selectedRowIndex,9).toString());
                musteriAdresField.setText(model.getValueAt(selectedRowIndex,10).toString());
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton musteriEkleButton = new JButton("Kaydet");
        musteriSolUstPanel.add(musteriEkleButton);
        musteriEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusteriContract musteriContract = new MusteriContract();
                musteriContract.setAd(musteriAdiBox.getText());
                musteriContract.setSoyad(musteriSoyadField.getText());
                musteriContract.setTelefon1(musteriTelefon1Field.getText());
                musteriContract.setTelefon2(musteriTelefon2Field.getText());
                musteriContract.setTc(musteriTcField.getText());
                musteriContract.setMail(musteriMailField.getText());
                musteriContract.setIl(musteriIlField.getSelectedItem().toString());
                musteriContract.setIlce(musteriIlceField.getSelectedItem().toString());
                musteriContract.setVergiDaire(musteriVergiDaireField.getText());
                musteriContract.setAdres(musteriAdresField.getText());
                new MusteriDAL().Insert(musteriContract);
                int input = JOptionPane.showConfirmDialog(null,
                        musteriContract.getAd() + " Adlı Müşteri Eklendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    int satir = musterimodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        musterimodel.removeRow(0);
                    }
                    for (MusteriContract contract : new MusteriDAL().GetAll()) {
                        musterimodel.addRow(contract.getVeriler());
                    }
                }
            }
        });

        JButton musteriGuncelleButton = new JButton("Güncelle");
        musteriSolUstPanel.add(musteriGuncelleButton);
        musteriGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusteriContract musteriContract = new MusteriContract();
                musteriContract.setAd(musteriAdiBox.getText());
                musteriContract.setSoyad(musteriSoyadField.getText());
                musteriContract.setTelefon1(musteriTelefon1Field.getText());
                musteriContract.setTelefon2(musteriTelefon2Field.getText());
                musteriContract.setTc(musteriTcField.getText());
                musteriContract.setMail(musteriMailField.getText());
                musteriContract.setIl(musteriIlField.getSelectedItem().toString());
                musteriContract.setIlce(musteriIlceField.getSelectedItem().toString());
                musteriContract.setVergiDaire(musteriVergiDaireField.getText());
                musteriContract.setAdres(musteriAdresField.getText());
                int input = JOptionPane.showConfirmDialog(null,
                        musteriContract.getAd() + " Adlı Müşteri Güncellendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    new MusteriDAL().Update(musteriContract);
                    int satir = musterimodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        musterimodel.removeRow(0);
                    }
                    for (MusteriContract contract : new MusteriDAL().GetAll()) {
                        musterimodel.addRow(contract.getVeriler());
                    }
                }
            }
        });

        JButton musteriSilButton = new JButton("Sil");
        musteriSolUstPanel.add(musteriSilButton);
        musteriSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (musteriIdBox.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Müşteri Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new MusteriDAL().DeleteById(Integer.parseInt(musteriIdBox.getText()));
                        int satir = musterimodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            musterimodel.removeRow(0);
                        }
                        for (MusteriContract contract : new MusteriDAL().GetAll()) {
                            musterimodel.addRow(contract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton musteriYenileButton = new JButton("Yenile");
        musteriSolUstPanel.add(musteriYenileButton);
        musteriYenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musteriIdBox.setText("");
                musteriAdiBox.setText("");
                musteriSoyadField.setText("");
                musteriTelefon1Field.setText("");
                musteriTelefon2Field.setText("");
                musteriTcField.setText("");
                musteriMailField.setText("");
                musteriIlceField.setSelectedItem(null);
                musteriIlField.setSelectedItem(null);
                musteriVergiDaireField.setText("");
                musteriAdresField.setText("");
            }
        });

        musteriSolPanel.add(musteriSolUstPanel, BorderLayout.NORTH);
        musteriSolPanel.add(musteriSolAltPanel, BorderLayout.SOUTH);
        musteriPanel.add(musteriSolPanel, BorderLayout.WEST);
        musteriPanel.add(musteriTablePane, BorderLayout.CENTER);
        return musteriPanel;
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
