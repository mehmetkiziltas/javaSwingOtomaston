package tr.com.javaileOtomasyon.MainFE;

import com.toedter.calendar.JDateChooser;
import tr.com.javaileOtomasyon.dal.BankalarDAL;
import tr.com.javaileOtomasyon.dal.FirmalarDAL;
import tr.com.javaileOtomasyon.dal.IlcelerDAL;
import tr.com.javaileOtomasyon.dal.SehirlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.BankalarContract;

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

import static java.awt.Color.CYAN;

public class BankalarFE extends JPanel implements FeInterfaces {

    public BankalarFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBackground(Color.BLUE);
        add(panel);
    }

    @Override
    public JPanel initPanel() {

        JPanel bankaPanel = new JPanel(new BorderLayout());
        bankaPanel.setBackground(CYAN);
        JPanel bankaSolPanel = new JPanel(new BorderLayout());
        JPanel bankaSolUstPanel = new JPanel(new GridLayout(14, 2));
        JPanel bankaSolAltPanel = new JPanel();
        bankaPanel.setPreferredSize(new Dimension(1800, 900));

        bankaSolPanel.setBorder(BorderFactory.createTitledBorder("Banka İşlemleri"));
        String[] bankaKolonlar = {"Id", "Banka Adı", "İl", "İlçe", "Sube", "Iban", "Hesap No", "Yetkili", "Telefon",
        "Terih", "Hesap Türü","Adı"};
        DefaultTableModel bankamodel = new DefaultTableModel(bankaKolonlar, 0);
        JTable bankatablo = new JTable(bankamodel);
        JScrollPane bankaTablePane = new JScrollPane(bankatablo);
        bankaTablePane.setBackground(CYAN);

        JLabel bankaIdLabel = new JLabel("Id: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaIdLabel);
        JTextField bankaIdBox = new JTextField(15);
        bankaSolUstPanel.add(bankaIdBox);

        JLabel bankaAdLabel = new JLabel("Banka Adı: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaAdLabel);
        JTextField bankaAdField = new JTextField(15);
        bankaSolUstPanel.add(bankaAdField);

        JLabel bankaIlLabel = new JLabel("Il: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaIlLabel);
        JComboBox bankaIlField = new JComboBox(new SehirlerDAL().GetAll().toArray());
        bankaSolUstPanel.add(bankaIlField);

        JLabel bankaIlceLabel = new JLabel("Ilce: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaIlceLabel);
        JComboBox bankaIlceField = new JComboBox();
        bankaSolUstPanel.add(bankaIlceField);

        bankaIlField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model = new DefaultComboBoxModel(new IlcelerDAL().GetByName(bankaIlField
                        .getSelectedItem()
                        .toString()).toArray());
                bankaIlceField.setModel(model);
            }
        });

        JLabel bankaSubeLabel = new JLabel("Sube: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaSubeLabel);
        JTextField bankaSubeField = new JTextField(15);
        bankaSolUstPanel.add(bankaSubeField);

        JLabel bankaIbanLabel = new JLabel("Iban: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaIbanLabel);
        JTextField bankaIbanField = new JTextField(15);
        bankaSolUstPanel.add(bankaIbanField);

        JLabel bankaHesapNoLabel = new JLabel("Hesap No: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaHesapNoLabel);
        JTextField bankaHesapNoField = new JTextField(15);
        bankaSolUstPanel.add(bankaHesapNoField);

        JLabel bankaYetkiliLabel = new JLabel("Yetkili: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaYetkiliLabel);
        JTextField bankaYetkiliField = new JTextField(15);
        bankaSolUstPanel.add(bankaYetkiliField);

        JLabel bankaTelefonLabel = new JLabel("Telefon: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaTelefonLabel);
        JTextField bankaTelefonField = new JTextField(15);
        bankaSolUstPanel.add(bankaTelefonField);

        JLabel bankaTarihiLabel = new JLabel("Tarih: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaTarihiLabel);
        JDateChooser bankaTarihi = new JDateChooser();
        bankaSolUstPanel.add(bankaTarihi);

        JLabel bankaHesapTuruLabel = new JLabel("Hesap Türü: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaHesapTuruLabel);
        JTextField bankaHesapTuruField = new JTextField(15);
        bankaSolUstPanel.add(bankaHesapTuruField);

        JLabel bankaFirmaAdLabel = new JLabel("Firma Adı: ", JLabel.RIGHT);
        bankaSolUstPanel.add(bankaFirmaAdLabel);
        JComboBox bankaFirmaAdField = new JComboBox(new FirmalarDAL().GetOrderByAll().toArray());
        bankaSolUstPanel.add(bankaFirmaAdField);

        for (BankalarContract Bcontract : new BankalarDAL().GetAll()) {
            bankamodel.addRow(Bcontract.getVeriler());
        }

        bankaTablePane.addMouseListener(new MouseListener() {
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
                    DefaultTableModel model = (DefaultTableModel) bankatablo.getModel();
                    int selectedRowIndex = bankatablo.getSelectedRow();

                    bankaIdBox.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    bankaAdField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    bankaIlField.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
                    bankaIlceField.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
                    bankaSubeField.setText(model.getValueAt(selectedRowIndex, 4).toString());
                    bankaIbanField.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    bankaHesapNoField.setText(model.getValueAt(selectedRowIndex, 6).toString());
                    bankaYetkiliField.setText(model.getValueAt(selectedRowIndex, 7).toString());
                    bankaTelefonField.setText(model.getValueAt(selectedRowIndex, 8).toString());
                    String bankaTarih = model.getValueAt(selectedRowIndex, 9).toString();
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy").parse(bankaTarih);
                        bankaTarihi.setDate(date);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    bankaHesapTuruField.setText(model.getValueAt(selectedRowIndex, 10).toString());
                    bankaFirmaAdField.setSelectedItem(model.getValueAt(selectedRowIndex, 11).toString());
                } catch (Exception exception) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JButton bankaKaydetButton = new JButton("Kaydet");
        bankaSolUstPanel.add(bankaKaydetButton);
        bankaKaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankalarContract contract = new BankalarContract();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(bankaTarihi.getDate());
                contract.setBankaAdi(bankaAdField.getText());
                contract.setIl(bankaIlField.getSelectedItem().toString());
                contract.setIlce(bankaIlceField.getSelectedItem().toString());
                contract.setSube(bankaSubeField.getText());
                contract.setIban(bankaIbanField.getText());
                contract.setHesapNo(bankaHesapNoField.getText());
                contract.setYetkili(bankaYetkiliField.getText());
                contract.setTelefon(bankaTelefonField.getText());
                contract.setTarih(date);
                contract.setHesapTuru(bankaHesapTuruField.getText());
                contract.setFirmaId(String.valueOf(bankaFirmaAdField.getSelectedIndex()));

                int input = JOptionPane.showConfirmDialog(null,
                        contract.getBankaAdi() + " Adlı banka Eklendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    new BankalarDAL().Insert(contract);
                    int satir = bankamodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        bankamodel.removeRow(0);
                    }
                    for (BankalarContract Bcontract : new BankalarDAL().GetAll()) {
                        bankamodel.addRow(Bcontract.getVeriler());
                    }
                }
            }
        });

        JButton bankaGuncelleButton = new JButton("Güncelle");
        bankaSolUstPanel.add(bankaGuncelleButton);
        bankaGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankalarContract contract = new BankalarContract();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(bankaTarihi.getDate());
                contract.setId(bankaIdBox.getText());
                contract.setBankaAdi(bankaAdField.getText());
                contract.setIl(bankaIlField.getSelectedItem().toString());
                contract.setIlce(bankaIlceField.getSelectedItem().toString());
                contract.setSube(bankaSubeField.getText());
                contract.setIban(bankaIbanField.getText());
                contract.setHesapNo(bankaHesapNoField.getText());
                contract.setYetkili(bankaYetkiliField.getText());
                contract.setTelefon(bankaTelefonField.getText());
                contract.setTarih(date);
                contract.setHesapTuru(bankaHesapTuruField.getText());
                contract.setFirmaId(String.valueOf(bankaFirmaAdField.getSelectedIndex()));

                int input = JOptionPane.showConfirmDialog(null,
                        contract.getBankaAdi() + " Adlı banka Güncellendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    new BankalarDAL().Update(contract);
                    int satir = bankamodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        bankamodel.removeRow(0);
                    }
                    for (BankalarContract Bcontract : new BankalarDAL().GetAll()) {
                        bankamodel.addRow(Bcontract.getVeriler());
                    }
                }
            }
        });

        JButton bankaSilButton = new JButton("Sil");
        bankaSolUstPanel.add(bankaSilButton);
        bankaSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bankaIdBox.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Ürün Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        new BankalarDAL().DeleteById(Integer.parseInt(bankaIdBox.getText()));
                        int satir = bankamodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            bankamodel.removeRow(0);
                        }

                        for (BankalarContract Bcontract : new BankalarDAL().GetAll()) {
                            bankamodel.addRow(Bcontract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton bankaYenileButton = new JButton("Yenile");
        bankaSolUstPanel.add(bankaYenileButton);
        bankaYenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankaIdBox.setText("");
                bankaAdField.setText("");
                bankaIlField.setSelectedItem(null);
                bankaIlceField.setSelectedItem(null);
                bankaSubeField.setText("");
                bankaIbanField.setText("");
                bankaHesapNoField.setText("");
                bankaYetkiliField.setText("");
                bankaTelefonField.setText("");
                bankaTarihi.setDate(null);
                bankaHesapTuruField.setText("");
                bankaFirmaAdField.setSelectedItem(null);
            }
        });

        bankaSolPanel.add(bankaSolUstPanel, BorderLayout.NORTH);
        bankaSolPanel.add(bankaSolAltPanel, BorderLayout.SOUTH);
        bankaPanel.add(bankaSolPanel, BorderLayout.WEST);
        bankaPanel.add(bankaTablePane, BorderLayout.CENTER);
        return bankaPanel;
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
