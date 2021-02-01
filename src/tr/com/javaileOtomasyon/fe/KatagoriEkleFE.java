package tr.com.javaileOtomasyon.fe;

import static java.awt.Dialog.DEFAULT_MODALITY_TYPE;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.dal.KatagoriDal;
import tr.com.javaileOtomasyon.types.KatagoriContract;

public class KatagoriEkleFE extends JDialog implements FeInterfaces {

    public KatagoriEkleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekleme Alanı"));
        add(panel);

        setTitle("Kategori Ekle");
        setSize(500, 200);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JLabel adiLabel = new JLabel("Kategori Adı: ", JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField = new JTextField(10);
        panel.add(adiField);
        JLabel katagoriLabel = new JLabel("Kategori Seç");
        panel.add(katagoriLabel);
        JComboBox kategoriBox = new JComboBox(new KatagoriDal().GetAllParentId().toArray());
        panel.add(kategoriBox);
        kategoriBox.insertItemAt("--Kategori Seçiniz--", 0);
        kategoriBox.setSelectedIndex(0);
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);

        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                KatagoriContract contract = new KatagoriContract();
                if (kategoriBox.getSelectedIndex() != 0) {
                    KatagoriContract casContract = (KatagoriContract) kategoriBox.getSelectedItem();
                    contract.setAdi(adiField.getText());
                    contract.setParentId(casContract.getId());
                    new KatagoriDal().Insert(contract);
                    int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  contract.getAdi() + " Kayıt Eklensin mi", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        new KatagoriDal().GetAll();
                    }

                } else {
                    contract.setAdi(adiField.getText());
                    contract.setParentId(kategoriBox.getSelectedIndex());
                    new KatagoriDal().Insert(contract);
                    int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  contract.getAdi() + " Kayıt Eklensin mi", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        new KatagoriDal().GetAll();
                    }
                }
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
