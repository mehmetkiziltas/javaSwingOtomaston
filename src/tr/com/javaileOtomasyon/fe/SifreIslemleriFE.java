package tr.com.javaileOtomasyon.fe;

import tr.com.javaileOtomasyon.dal.AccountsDAL;
import tr.com.javaileOtomasyon.dal.PersonellerDAL;
import tr.com.javaileOtomasyon.dal.YetkilerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.AccountsContract;
import tr.com.javaileOtomasyon.types.PersonellerContract;
import tr.com.javaileOtomasyon.types.YetkilerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class SifreIslemleriFE extends JDialog implements FeInterfaces {

    public SifreIslemleriFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Şifre Belirleme İşlemleri"));
        add(panel);

        setTitle("Şifre Belirleme İşlemleri");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JLabel personelLabel = new JLabel("Personel Seç: ", JLabel.RIGHT);
        panel.add(personelLabel);
        JComboBox personelBox = new JComboBox(new PersonellerDAL().GetAll().toArray());
        panel.add(personelBox);
        JLabel yetkiLabel = new JLabel("Yetki Seç: ", JLabel.RIGHT);
        panel.add(yetkiLabel);
        JComboBox yetkiBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
        panel.add(yetkiBox);
        JLabel passwordLabel = new JLabel("Şifre Belirle", JLabel.RIGHT);
        panel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField(10);
        panel.add(passwordField);
        JLabel passwordTekrarLabel = new JLabel("Şifre Tekrar: ", JLabel.RIGHT);
        panel.add(passwordTekrarLabel);
        JPasswordField passwordTekrarField = new JPasswordField(10);
        panel.add(passwordTekrarField);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AccountsContract contract = new AccountsContract();

                PersonellerContract personellerContract = (PersonellerContract) personelBox.getSelectedItem();
                YetkilerContract yetkilerContract = (YetkilerContract) yetkiBox.getSelectedItem();

                String myPass2 = String.valueOf(passwordField.getPassword());
                String myPass3 = String.valueOf(passwordTekrarField.getPassword());

                if (myPass2.equals(myPass3)) {

                    contract.setPersonelId(Integer.parseInt(personellerContract.getId()));

                    contract.setYetkiliId(yetkilerContract.getId());
                    String myPass = String.valueOf(passwordField.getPassword());
                    contract.setSifre(myPass);

                    new AccountsDAL().Insert(contract);
                    JOptionPane.showMessageDialog(rootPane, personellerContract.getAd()
                            + " adlı Kişiye " + yetkilerContract.getAdi()
                            + " Adlı Yetkilinin Şifresi Başarılı Bir Şekilde Belirlenmiştir.");
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Şifreler uyuşmuyor. Tekrar deneyiniz!");
                }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JTabbedPane initTabs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
