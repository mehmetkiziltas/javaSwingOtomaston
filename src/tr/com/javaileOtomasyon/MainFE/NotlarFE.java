package tr.com.javaileOtomasyon.MainFE;

import com.toedter.calendar.JDateChooser;
import tr.com.javaileOtomasyon.dal.NotlarDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.NotlarContract;

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

public class NotlarFE extends JPanel implements FeInterfaces {

    public NotlarFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
        this.setSize(900,900);
    }

    @Override
    public JPanel initPanel() {

        JPanel notPanel = new JPanel(new BorderLayout());
        JPanel notSolPanel = new JPanel(new BorderLayout());
        JPanel notSolUstPanel = new JPanel(new GridLayout(9, 2));
        JPanel notSolAltPanel = new JPanel();
        notPanel.setPreferredSize(new Dimension(1700, 900));

        notSolPanel.setBorder(BorderFactory.createTitledBorder("Not İşlemleri"));
        String[] notKolonlar = {"Id", "Tarih", "Saat", "Başlık", "Detay", "Oluşturan", "Hitap"};
        DefaultTableModel notmodel = new DefaultTableModel(notKolonlar, 0);
        JTable nottablo = new JTable(notmodel);
        JScrollPane notTablePane = new JScrollPane(nottablo);

        JLabel notIdLabel = new JLabel("Id: ", JLabel.RIGHT);
        notSolUstPanel.add(notIdLabel);
        JTextField notIdField = new JTextField(15);
        notSolUstPanel.add(notIdField);

        JLabel notTarihiLabel = new JLabel("Tarih: ", JLabel.RIGHT);
        notSolUstPanel.add(notTarihiLabel);
        JDateChooser notTarihi = new JDateChooser();
        notSolUstPanel.add(notTarihi);

        JLabel notSaatLabel = new JLabel("Saat: ", JLabel.RIGHT);
        notSolUstPanel.add(notSaatLabel);
        JTextField notSaatField = new JTextField(15);
        notSolUstPanel.add(notSaatField);

        JLabel notBaslikLabel = new JLabel("Başlık: ", JLabel.RIGHT);
        notSolUstPanel.add(notBaslikLabel);
        JTextField notBaslikField = new JTextField(15);
        notSolUstPanel.add(notBaslikField);

        JLabel notDetayLabel = new JLabel("Detay: ", JLabel.RIGHT);
        notSolUstPanel.add(notDetayLabel);
        JTextField notDetayField = new JTextField(15);
        notSolUstPanel.add(notDetayField);

        JLabel notOlusturanLabel = new JLabel("Oluşturan: ", JLabel.RIGHT);
        notSolUstPanel.add(notOlusturanLabel);
        JTextField notOlusturanField = new JTextField(15);
        notSolUstPanel.add(notOlusturanField);

        JLabel notHitapLabel = new JLabel("Hitap: ", JLabel.RIGHT);
        notSolUstPanel.add(notHitapLabel);
        JTextField notHitapField = new JTextField(15);
        notSolUstPanel.add(notHitapField);

        for (NotlarContract Ncontract : new NotlarDAL().GetAll()) {
            notmodel.addRow(Ncontract.getVeriler());
        }

        notTablePane.addMouseListener(new MouseListener() {
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
                    DefaultTableModel model = (DefaultTableModel) nottablo.getModel();
                    int selectedRowIndex = nottablo.getSelectedRow();

                    notIdField.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    String setTarih = model.getValueAt(selectedRowIndex, 1).toString();
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy").parse(setTarih);
                        notTarihi.setDate(date);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    notSaatField.setText(model.getValueAt(selectedRowIndex, 2).toString());
                    notBaslikField.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    notDetayField.setText(model.getValueAt(selectedRowIndex, 4).toString());
                    notOlusturanField.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    notHitapField.setText(model.getValueAt(selectedRowIndex, 6).toString());
                } catch (Exception exception) {

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton notKaydetButton = new JButton("Kaydet");
        notSolUstPanel.add(notKaydetButton);
        notKaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotlarContract contract = new NotlarContract();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(notTarihi.getDate());
                contract.setTarih(date);
                contract.setSaat(notSaatField.getText());
                contract.setBaslik(notBaslikField.getText());
                contract.setDetay(notDetayField.getText());
                contract.setOlusturan(notOlusturanField.getText());
                contract.setHitap(notHitapField.getText());

                new NotlarDAL().Insert(contract);
                int input = JOptionPane.showConfirmDialog(null,
                        contract.getOlusturan() + " Tarafından Oluşturulan Not Kaydedildi.", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    int satir = notmodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        notmodel.removeRow(0);
                    }
                    for (NotlarContract Ncontract : new NotlarDAL().GetAll()) {
                        notmodel.addRow(Ncontract.getVeriler());
                    }
                }
            }
        });

        JButton notGuncelleButton = new JButton("Güncelle");
        notSolUstPanel.add(notGuncelleButton);
        notGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotlarContract contract = new NotlarContract();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(notTarihi.getDate());
                contract.setId(notIdField.getText());
                contract.setTarih(date);
                contract.setSaat(notSaatField.getText());
                contract.setBaslik(notBaslikField.getText());
                contract.setDetay(notDetayField.getText());
                contract.setOlusturan(notOlusturanField.getText());
                contract.setHitap(notHitapField.getText());

                int input = JOptionPane.showConfirmDialog(null,
                        contract.getTarih() + "Tarihli Not Güncellendi.", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    new NotlarDAL().Update(contract);
                    int satir = notmodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        notmodel.removeRow(0);
                    }
                    for (NotlarContract Ncontract : new NotlarDAL().GetAll()) {
                        notmodel.addRow(Ncontract.getVeriler());
                    }
                }
            }
        });

        JButton notSilButton = new JButton("Sil");
        notSolUstPanel.add(notSilButton);
        notSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notIdField.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Not Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new NotlarDAL().DeleteById(Integer.parseInt(notIdField.getText()));
                        int satir = notmodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            notmodel.removeRow(0);
                        }

                        for (NotlarContract Ncontract : new NotlarDAL().GetAll()) {
                            notmodel.addRow(Ncontract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton notYenileButton = new JButton("Yenile");
        notSolUstPanel.add(notYenileButton);
        notYenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notIdField.setText("");
                notTarihi.setDate(null);
                notSaatField.setText("");
                notBaslikField.setText("");
                notDetayField.setText("");
                notOlusturanField.setText("");
                notHitapField.setText("");
            }
        });


        notSolPanel.add(notSolUstPanel, BorderLayout.NORTH);
        notSolPanel.add(notSolAltPanel, BorderLayout.SOUTH);
        notPanel.add(notSolPanel, BorderLayout.WEST);
        notPanel.add(notTablePane, BorderLayout.CENTER);
        return notPanel;
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
