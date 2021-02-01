
package tr.com.javaileOtomasyon.fe;

import tr.com.javaileOtomasyon.dal.IlcelerDAL;
import tr.com.javaileOtomasyon.dal.SehirlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class MusteriEkleFE extends JDialog implements FeInterfaces{

    public MusteriEkleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Müşteri Ekle"));
        add(panel);
        setTitle("Müşteri Ekle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridLayout(5, 2));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JLabel adiSoyadiLabel = new JLabel("Adı Soyadı: ",JLabel.RIGHT);
        fieldPanel.add(adiSoyadiLabel);
        JTextField adiSoyadiField = new JTextField(15);
        fieldPanel.add(adiSoyadiField);
        JLabel telefonLabel = new JLabel("Telefon: ",JLabel.RIGHT);
        fieldPanel.add(telefonLabel);
        JTextField telefonField = new JTextField(11);
        fieldPanel.add(telefonField);
        JLabel sehirSecLabel = new JLabel("Şehir Seç: ",JLabel.RIGHT);
        fieldPanel.add(sehirSecLabel);
        JComboBox sehirlerBox = new JComboBox(new SehirlerDAL().GetAll().toArray());
        fieldPanel.add(sehirlerBox);
        JLabel ilceSecLabel = new JLabel("İlçe Seç: ",JLabel.RIGHT);
        fieldPanel.add(ilceSecLabel);
        JComboBox ilcelerBox = new JComboBox();
        fieldPanel.add(ilcelerBox);
        sehirlerBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model = new DefaultComboBoxModel(new IlcelerDAL().GetByName(sehirlerBox
                        .getSelectedItem()
                        .toString()).toArray());
                ilcelerBox.setModel(model);
            }
        });
        JTextArea adresArea = new JTextArea(7,1);
        JScrollPane pane = new JScrollPane(adresArea);
        pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));
        JButton kaydetButton = new JButton("Kaydet");
        buttonPanel.add(kaydetButton);
        JButton iptalButton = new JButton("İptal");
        buttonPanel.add(iptalButton);
        panel.add(fieldPanel,BorderLayout.NORTH);
        panel.add(pane,BorderLayout.CENTER);
        panel.add(buttonPanel,BorderLayout.SOUTH);
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JTabbedPane initTabs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
