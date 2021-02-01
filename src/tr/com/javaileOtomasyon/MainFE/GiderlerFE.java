package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.GiderlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.GiderlerContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiderlerFE extends JPanel implements FeInterfaces {

    public GiderlerFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {

        JPanel giderPanel = new JPanel(new BorderLayout());
        JPanel giderSolPanel = new JPanel(new BorderLayout());
        JPanel giderSolUstPanel = new JPanel(new GridLayout(12, 2));
        JPanel giderSolAltPanel = new JPanel();
        giderPanel.setPreferredSize(new Dimension(1700, 900));

        giderSolPanel.setBorder(BorderFactory.createTitledBorder("Gider İşlemleri"));
        String[] giderKolonlar = {"Id", "Yıl", "Ay", "Elektrik", "Su", "Doğalgaz", "İnternet", "Maaşlar", "Extra", "Notlar"};
        DefaultTableModel gidermodel = new DefaultTableModel(giderKolonlar, 0);
        JTable gidertablo = new JTable(gidermodel);
        JScrollPane giderTablePane = new JScrollPane(gidertablo);

        JLabel giderIdLabel = new JLabel("Id: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderIdLabel);
        JTextField giderIdBox = new JTextField();
        giderSolUstPanel.add(giderIdBox);

        JLabel giderYilLabel = new JLabel("Yıl: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderYilLabel);
        JTextField giderYilField = new JTextField(15);
        giderSolUstPanel.add(giderYilField);

        JLabel giderAyLabel = new JLabel("Ay: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderAyLabel);
        JTextField giderAyBox = new JTextField();
        giderSolUstPanel.add(giderAyBox);

        JLabel giderElektrikLabel = new JLabel("Elektrik: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderElektrikLabel);
        JTextField giderElektrikBox = new JTextField(15);
        giderSolUstPanel.add(giderElektrikBox);

        JLabel giderSuLabel = new JLabel("Su: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderSuLabel);
        JTextField giderSuBox = new JTextField(15);
        giderSolUstPanel.add(giderSuBox);

        JLabel giderDogalgazLabel = new JLabel("Doğalgaz: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderDogalgazLabel);
        JTextField giderDogalgazBox = new JTextField(15);
        giderSolUstPanel.add(giderDogalgazBox);

        JLabel giderInternetLabel = new JLabel("İnternet: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderInternetLabel);
        JTextField giderInternetBox = new JTextField(15);
        giderSolUstPanel.add(giderInternetBox);

        JLabel giderMaasLabel = new JLabel("Maaşlar: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderMaasLabel);
        JTextField giderMaasBox = new JTextField(15);
        giderSolUstPanel.add(giderMaasBox);

        JLabel giderExtraLabel = new JLabel("Extralar: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderExtraLabel);
        JTextField giderExtraBox = new JTextField(15);
        giderSolUstPanel.add(giderExtraBox);

        JLabel giderNotlarLabel = new JLabel("Notlar: ", JLabel.RIGHT);
        giderSolUstPanel.add(giderNotlarLabel);
        JTextField gidernotlarBox = new JTextField(15);
        giderSolUstPanel.add(gidernotlarBox);

        giderTablePane.addMouseListener(new MouseListener() {
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
                    DefaultTableModel model = (DefaultTableModel) gidertablo.getModel();
                    int selectedRowIndex = gidertablo.getSelectedRow();

                    giderIdBox.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    giderYilField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    giderAyBox.setText(model.getValueAt(selectedRowIndex, 2).toString());
                    giderElektrikBox.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    giderSuBox.setText(model.getValueAt(selectedRowIndex, 4).toString());
                    giderDogalgazBox.setText(model.getValueAt(selectedRowIndex, 5).toString());
                    giderInternetBox.setText(model.getValueAt(selectedRowIndex, 6).toString());
                    giderMaasBox.setText(model.getValueAt(selectedRowIndex, 7).toString());
                    giderExtraBox.setText(model.getValueAt(selectedRowIndex, 8).toString());
                    gidernotlarBox.setText(model.getValueAt(selectedRowIndex, 9).toString());
                } catch (Exception exception) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        for (GiderlerContract Gcontract : new GiderlerDAL().GetAll()) {
            gidermodel.addRow(Gcontract.getVeriler());
        }

        JButton giderKaydetButton = new JButton("Kaydet");
        giderSolUstPanel.add(giderKaydetButton);
        giderKaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GiderlerContract contract = new GiderlerContract();
                contract.setId(giderIdBox.getText());
                contract.setYil(giderYilField.getText());
                contract.setAy(giderAyBox.getText());
                contract.setElektrik(giderElektrikBox.getText());
                contract.setSu(giderSuBox.getText());
                contract.setDogalgaz(giderDogalgazBox.getText());
                contract.setInternet(giderInternetBox.getText());
                contract.setMaaslar(giderMaasBox.getText());
                contract.setExtralar(giderExtraBox.getText());
                contract.setNotlar(gidernotlarBox.getText());
                int input = JOptionPane.showConfirmDialog(null,
                      contract.getAy() + " Adlı Ayın Gideri Eklendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    new GiderlerDAL().Insert(contract);
                    int satir = gidermodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        gidermodel.removeRow(0);
                    }
                    for (GiderlerContract Gcontract : new GiderlerDAL().GetAll()) {
                        gidermodel.addRow(Gcontract.getVeriler());
                    }
                }
            }
        });

        JButton giderGuncelleButton = new JButton("Güncelle");
        giderSolUstPanel.add(giderGuncelleButton);
        giderGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GiderlerContract contract = new GiderlerContract();
                contract.setYil(giderYilField.getText());
                contract.setAy(giderAyBox.getText());
                contract.setElektrik(giderElektrikBox.getText());
                contract.setSu(giderSuBox.getText());
                contract.setDogalgaz(giderDogalgazBox.getText());
                contract.setInternet(giderInternetBox.getText());
                contract.setMaaslar(giderMaasBox.getText());
                contract.setExtralar(giderExtraBox.getText());
                contract.setNotlar(gidernotlarBox.getText());
                int input = JOptionPane.showConfirmDialog(null,
                        contract.getId() + " nolu gider Güncellendi", "", JOptionPane.DEFAULT_OPTION);
                if (input == 0) {
                    new GiderlerDAL().Update(contract);
                    int satir = gidermodel.getRowCount();
                    for (int i = 0; i < satir; i++) {
                        gidermodel.removeRow(0);
                    }
                    for (GiderlerContract giderlerContract : new GiderlerDAL().GetAll()) {
                        gidermodel.addRow(giderlerContract.getVeriler());
                    }
                }
            }
        });

        JButton giderSilButton = new JButton("Sil");
        giderSolUstPanel.add(giderSilButton);
        giderSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (giderIdBox.getText() != null) {
                    int input = JOptionPane.showConfirmDialog(null, "Seçili Gider Silinsin mi?", "", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new GiderlerDAL().DeleteById(Integer.parseInt(giderIdBox.getText()));
                        int satir = gidermodel.getRowCount();
                        for (int i = 0; i < satir; i++) {
                            gidermodel.removeRow(0);
                        }
                        for (GiderlerContract contract : new GiderlerDAL().GetAll()) {
                            gidermodel.addRow(contract.getVeriler());
                        }
                    }
                }
            }
        });

        JButton giderYenileButton = new JButton("Yenile");
        giderSolUstPanel.add(giderYenileButton);
        giderYenileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giderAyBox.setText("");
                giderIdBox.setText("");
                giderYilField.setText("");
                giderElektrikBox.setText("");
                giderSuBox.setText("");
                giderDogalgazBox.setText("");
                giderInternetBox.setText("");
                giderMaasBox.setText("");
                giderExtraBox.setText("");
                gidernotlarBox.setText("");

            }
        });


        giderSolPanel.add(giderSolUstPanel, BorderLayout.NORTH);
        giderSolPanel.add(giderSolAltPanel, BorderLayout.SOUTH);
        giderPanel.add(giderSolPanel, BorderLayout.WEST);
        giderPanel.add(giderTablePane, BorderLayout.CENTER);
        return giderPanel;
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
