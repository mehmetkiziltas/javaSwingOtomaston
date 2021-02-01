package tr.com.javaileOtomasyon.fe;

import tr.com.javaileOtomasyon.dal.AccountsDAL;
import tr.com.javaileOtomasyon.dal.PersonelDAL;
import tr.com.javaileOtomasyon.dal.PersonellerDAL;
import tr.com.javaileOtomasyon.dal.YetkilerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.PersonellerContract;
import tr.com.javaileOtomasyon.types.YetkilerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YetkiDuzenleFE extends JDialog implements FeInterfaces {

    public YetkiDuzenleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Yetki Düzenle"));
        add(panel);
        setTitle("Yetki Düzenle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel adiSoyadiLabel = new JLabel("Adı Soyadı: ", JLabel.RIGHT);
        panel.add(adiSoyadiLabel);
        JComboBox adiSoyadiField = new JComboBox(new PersonellerDAL().GetAll().toArray());
        panel.add(adiSoyadiField);

        JLabel eMailLabel = new JLabel("Yetki : ", JLabel.RIGHT);
        panel.add(eMailLabel);
        JComboBox yetkiBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
        panel.add(yetkiBox);

        JButton kaydetButton = new JButton("Güncelle");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PersonellerContract personellerContract = (PersonellerContract) adiSoyadiField.getSelectedItem();
                YetkilerContract yetkilerContract = (YetkilerContract) yetkiBox.getSelectedItem();
                //personellerden ada göre id çekme işlemi
                new PersonelDAL().GetByName(adiSoyadiField.getSelectedItem().toString());

                new YetkilerDAL().GetByYetkiName(yetkiBox.getSelectedItem().toString());

                new AccountsDAL().updateByPersonelId(Integer.parseInt(personellerContract.getId()),yetkilerContract.getId());
                JOptionPane.showMessageDialog(rootPane, personellerContract.getAd()
                        + " adlı Kişiye " + yetkilerContract.getAdi()
                        + " Adlı Yetkilinin Yetkisi Başarılı Bir Şekilde Güncellenmiştir.");
                dispose();
            }
        });
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        iptalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return panel;
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
