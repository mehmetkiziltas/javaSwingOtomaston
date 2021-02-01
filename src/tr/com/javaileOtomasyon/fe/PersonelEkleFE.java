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
import tr.com.javaileOtomasyon.dal.PersonelDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.PersonelContract;

public class PersonelEkleFE extends JDialog implements FeInterfaces {

    public PersonelEkleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Personel Ekle"));
        add(panel);
        setTitle("Personel Ekle");
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
        JTextField adiSoyadiField = new JTextField(10);
        panel.add(adiSoyadiField);
        JLabel eMailLabel = new JLabel("E-Mail: ", JLabel.RIGHT);
        panel.add(eMailLabel);
        JTextField eMailField = new JTextField(10);
        panel.add(eMailField);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PersonelContract contract = new PersonelContract();
                contract.setAdiSoyadi(adiSoyadiField.getText());
                contract.setEmail(eMailField.getText());
                new PersonelDAL().Insert(contract);
                JOptionPane.showMessageDialog(rootPane, contract.getAdiSoyadi()+" adlı personel eklenmiştir.");
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
