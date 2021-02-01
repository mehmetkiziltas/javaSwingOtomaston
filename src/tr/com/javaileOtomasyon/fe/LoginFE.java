
package tr.com.javaileOtomasyon.fe;

import tr.com.javaileOtomasyon.dal.AccountsDAL;
import tr.com.javaileOtomasyon.dal.PersonelDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.PersonelContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFE extends JFrame implements FeInterfaces{
    
    public static JComboBox emailBox;
    
    public LoginFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Lütfen Sisteme Giriş Yapmak İçin Bilgilerinizi Giriniz"));
        add(panel);
        pack();
        setTitle("Lütfen Giriş Yapınız");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel emailLabel = new JLabel("Kullanıcı Adı: ",JLabel.RIGHT);
        panel.add(emailLabel);
        emailBox = new JComboBox(new PersonelDAL().GetPersonelInfo().toArray());
        panel.add(emailBox);
        JLabel passwordLabel = new JLabel("Şifreniz: ",JLabel.RIGHT);
        panel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField(15){
            @Override
            public void addNotify() {
                super.addNotify();
                requestFocusInWindow();
            }
        };
        panel.add(passwordField);
        
        JButton loginButton = new JButton("Giriş Yap");
        panel.add(loginButton);
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
                String myPass = String.valueOf(passwordField.getPassword());
                if (new AccountsDAL().GetPersonelIdSifre(contract.getId(), myPass).getId() != 0) {
                    new AnaPencereFE();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Giriş Yetkiniz Yok");
                    dispose();
                }
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
