
package tr.com.javaileOtomasyon.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import tr.com.javaileOtomasyon.dal.YetkilerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.YetkilerContract;


public class YetkiEkleFE extends JDialog implements FeInterfaces{

    public YetkiEkleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle"));
        add(panel);
        setTitle("Yetki Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel adiLabel = new JLabel("Yetki Adı: ");
        panel.add(adiLabel);
        JTextField adiField = new JTextField(10);
        panel.add(adiField);
        
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                YetkilerContract contract = new YetkilerContract();
                contract.setAdi(adiField.getText());
                new YetkilerDAL().Insert(contract);
                JOptionPane.showMessageDialog(rootPane, contract.getAdi()
                        + " adli yetki başarılı şekilde eklenmiştir.");
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
