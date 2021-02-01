package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.IlcelerDAL;
import tr.com.javaileOtomasyon.dal.PersonellerDAL;
import tr.com.javaileOtomasyon.dal.SehirlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.PersonellerContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PersonellerFE extends JPanel implements FeInterfaces {

    public PersonellerFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {

        JPanel personelPanel = new JPanel(new BorderLayout());
        JPanel PersonelSolPanel = new JPanel(new BorderLayout());
        JPanel PersonelSolUstPanel = new JPanel(new GridLayout(12, 2));
        JPanel PersonelSolAltPanel = new JPanel();
        personelPanel.setPreferredSize(new Dimension(1700, 900));

        PersonelSolPanel.setBorder(BorderFactory.createTitledBorder("Personel İşlemleri"));
        String[] PersonelKolonlar = {"ID", "AD", "SOYAD", "TELEFON", "TC", "MAIL", "IL", "ILCE", "ADRES", "GOREV"};
        DefaultTableModel Personelmodel = new DefaultTableModel(PersonelKolonlar, 0);
        JTable Personeltablo = new JTable(Personelmodel);
        JScrollPane PersonelTablePane = new JScrollPane(Personeltablo);

        JLabel PersonelIdLabel = new JLabel("ID: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelIdLabel);
        JTextField PersonelIdBox = new JTextField(15);
        PersonelSolUstPanel.add(PersonelIdBox);

        JLabel PersonelAdLabel = new JLabel("Ad: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelAdLabel);
        JTextField PersonelAdField = new JTextField(15);
        PersonelSolUstPanel.add(PersonelAdField);

        JLabel PersonelSoyadLabel = new JLabel("Soyad: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelSoyadLabel);
        JTextField PersonelSoyadField = new JTextField(15);
        PersonelSolUstPanel.add(PersonelSoyadField);

        JLabel PersonelTelefonLabel = new JLabel("Telefon: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelTelefonLabel);
        JTextField PersonelTelefonField = new JTextField(15);
        PersonelSolUstPanel.add(PersonelTelefonField);

        JLabel PersonelTcLabel = new JLabel("TC: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelTcLabel);
        JTextField PersonelTcField = new JTextField(15);
        PersonelSolUstPanel.add(PersonelTcField);

        JLabel PersonelMailLabel = new JLabel("Mail: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelMailLabel);
        JTextField PersonelMailField = new JTextField(15);
        PersonelSolUstPanel.add(PersonelMailField);

        JLabel PersonelIlLabel = new JLabel("Il: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelIlLabel);
        JComboBox PersonelIlField = new JComboBox(new SehirlerDAL().GetAll().toArray());
        PersonelSolUstPanel.add(PersonelIlField);

        JLabel PersonelIlceLabel = new JLabel("AD: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelIlceLabel);
        JComboBox PersonelIlceField = new JComboBox();
        PersonelSolUstPanel.add(PersonelIlceField);

        PersonelIlField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model = new DefaultComboBoxModel(new IlcelerDAL().GetByName(PersonelIlField
                        .getSelectedItem()
                        .toString()).toArray());
                PersonelIlceField.setModel(model);
            }
        });

        JLabel PersonelAdresLabel = new JLabel("Adres: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelAdresLabel);
        JTextField PersonelAdresField = new JTextField(15);
        PersonelSolUstPanel.add(PersonelAdresField);

        JLabel PersonelGorevLabel = new JLabel("Görev: ", JLabel.RIGHT);
        PersonelSolUstPanel.add(PersonelGorevLabel);
        JTextField PersonelGorevField = new JTextField(15);
        PersonelSolUstPanel.add(PersonelGorevField);

        for (PersonellerContract Pcontract : new PersonellerDAL().GetAll()) {
            Personelmodel.addRow(Pcontract.getVeriler());
        }

        PersonelTablePane.addMouseListener(new MouseListener() {
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
                    DefaultTableModel model = (DefaultTableModel) Personeltablo.getModel();
                    int selectedRowIndex = Personeltablo.getSelectedRow();

                    PersonelIdBox.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    PersonelAdField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    PersonelSoyadField.setText(model.getValueAt(selectedRowIndex, 2).toString());
                    PersonelTelefonField.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    PersonelTcField.setText(model.getValueAt(selectedRowIndex, 4).toString());
                    PersonelMailField.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    PersonelIlField.setSelectedItem(model.getValueAt(selectedRowIndex, 6).toString());
                    PersonelIlceField.setSelectedItem(model.getValueAt(selectedRowIndex, 7).toString());
                    PersonelAdresField.setText(model.getValueAt(selectedRowIndex, 8).toString());
                    PersonelGorevField.setText(model.getValueAt(selectedRowIndex, 9).toString());
                } catch (Exception exception) {

                }

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JButton PersonelKaydetButton = new JButton("Kaydet");
        PersonelSolUstPanel.add(PersonelKaydetButton);
        PersonelKaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonellerContract contract = new PersonellerContract();
                contract.setAd(PersonelAdField.getText());
                contract.setSoyad(PersonelSoyadField.getText());
                contract.setTelefon(PersonelTelefonField.getText());
                contract.setTc(PersonelTcField.getText());
                contract.setMail(PersonelMailField.getText());
                contract.setIl(PersonelIlField.getSelectedItem().toString());
                contract.setIlce(PersonelIlceField.getSelectedItem().toString());
                contract.setAdres(PersonelAdresField.getText());
                contract.setGorev(PersonelGorevField.getText());
                new PersonellerDAL().Insert(contract);
                int input = JOptionPane.showConfirmDialog(null,
                        contract.getAd() + " Adlı Personel Eklendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    int satir = Personelmodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        Personelmodel.removeRow(0);
                    }
                    for (PersonellerContract Pcontract : new PersonellerDAL().GetAll()) {
                        Personelmodel.addRow(Pcontract.getVeriler());
                    }
                }
            }
        });

        JButton PersonelGuncelleButton = new JButton("Güncelle");
        PersonelSolUstPanel.add(PersonelGuncelleButton);
        PersonelGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonellerContract contract = new PersonellerContract();
                contract.setId(PersonelIdBox.getText());
                contract.setAd(PersonelAdField.getText());
                contract.setSoyad(PersonelSoyadField.getText());
                contract.setTelefon(PersonelTelefonField.getText());
                contract.setTc(PersonelTcField.getText());
                contract.setMail(PersonelMailField.getText());
                contract.setIl(PersonelIlField.getSelectedItem().toString());
                contract.setIlce(PersonelIlceField.getSelectedItem().toString());
                contract.setAdres(PersonelAdresField.getText());
                contract.setGorev(PersonelGorevField.getText());
                new PersonellerDAL().Update(contract);
                int input = JOptionPane.showConfirmDialog(null,
                        contract.getAd() + " Adlı Personel Eklendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    int satir = Personelmodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        Personelmodel.removeRow(0);
                    }
                    for (PersonellerContract Pcontract : new PersonellerDAL().GetAll()) {
                        Personelmodel.addRow(Pcontract.getVeriler());
                    }
                }
            }
        });

        JButton PersonelSilButton = new JButton("Sil");
        PersonelSolUstPanel.add(PersonelSilButton);
        PersonelSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PersonelIdBox.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Personel Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new PersonellerDAL().DeleteById(Integer.parseInt(PersonelIdBox.getText()));
                        int satir = Personelmodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            Personelmodel.removeRow(0);
                        }

                        for (PersonellerContract Pcontract : new PersonellerDAL().GetAll()) {
                            Personelmodel.addRow(Pcontract.getVeriler());
                        }
                    }
                }

            }
        });

        JButton PersonelYenileButton = new JButton("Yenile");
        PersonelSolUstPanel.add(PersonelYenileButton);
        PersonelYenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonelIdBox.setText("");
                PersonelAdField.setText("");
                PersonelSoyadField.setText("");
                PersonelTelefonField.setText("");
                PersonelTcField.setText("");
                PersonelMailField.setText("");
                PersonelIlField.setSelectedItem(null);
                PersonelIlceField.setSelectedItem(null);
                PersonelAdresField.setText("");
                PersonelGorevField.setText("");
            }
        });

        PersonelSolPanel.add(PersonelSolUstPanel, BorderLayout.NORTH);
        PersonelSolPanel.add(PersonelSolAltPanel, BorderLayout.SOUTH);
        personelPanel.add(PersonelSolPanel, BorderLayout.WEST);
        personelPanel.add(PersonelTablePane, BorderLayout.CENTER);
        return personelPanel;
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
