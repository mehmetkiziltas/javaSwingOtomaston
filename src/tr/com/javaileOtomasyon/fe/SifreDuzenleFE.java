package tr.com.javaileOtomasyon.fe;

import tr.com.javaileOtomasyon.dal.AccountsDAL;
import tr.com.javaileOtomasyon.dal.PersonelDAL;
import tr.com.javaileOtomasyon.dal.PersonellerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.PersonellerContract;
import tr.com.javaileOtomasyon.types.YetkilerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifreDuzenleFE extends JDialog implements FeInterfaces {

    public SifreDuzenleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Şifre Düzenle"));
        add(panel);
        setTitle("Şifre Düzenle");
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
        JLabel yeniSifreLabel = new JLabel("Yeni Şifre: ", JLabel.RIGHT);
        panel.add(yeniSifreLabel);
        JTextField yeniSifreField = new JTextField(10);
        panel.add(yeniSifreField);

        JButton kaydetButton = new JButton("Güncelle");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PersonellerContract personellerContract = (PersonellerContract) adiSoyadiField.getSelectedItem();
                YetkilerContract yetkilerContract = new YetkilerContract();

                new PersonelDAL().GetByName(adiSoyadiField.getSelectedItem().toString());

                new AccountsDAL().updateByPassword(Integer.parseInt(personellerContract.getId()), Integer.parseInt(yeniSifreField.getText()));

                JOptionPane.showMessageDialog(rootPane, personellerContract.getAd()
                        + " adlı Kişiye " + yetkilerContract.getAdi()
                        + " Adlı Yetkilinin Şifresi Başarılı Bir Şekilde Güncellenmiştir.");
                dispose();
            }
        });
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);

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
