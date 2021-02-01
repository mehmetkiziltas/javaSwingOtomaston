package tr.com.javaileOtomasyon.fe;

import tr.com.javaileOtomasyon.dal.KatagoriDal;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.KatagoriContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KategoriDuzenleFE extends JDialog implements FeInterfaces {

    public KategoriDuzenleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);

        setTitle("Katagori Düzenle");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Düzenleme İşlemleri"));
        JPanel ustPanel = new JPanel(new GridLayout(3, 2));
        ustPanel.setBorder(BorderFactory.createTitledBorder("Kategori Düzenle"));
        JLabel kategoriAdiLabel = new JLabel("Kategori Adı: ",JLabel.RIGHT);
        ustPanel.add(kategoriAdiLabel);
        JTextField kategoriAdiField = new JTextField(10);
        ustPanel.add(kategoriAdiField);
        JLabel ustKategoriLabel = new JLabel("Üst Kategorisi: ",JLabel.RIGHT);
        ustPanel.add(ustKategoriLabel);
        JComboBox ustKategoriBox = new JComboBox(new KatagoriDal().GetAll().toArray());
        ustPanel.add(ustKategoriBox);
        JButton kategoriDuzenle = new JButton("Düzenle");
        ustPanel.add(kategoriDuzenle);
        kategoriDuzenle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KatagoriContract contract = new KatagoriContract();
                contract.setAdi(kategoriAdiField.getText());
                new KatagoriDal().Update(contract);
            }
        });

        JButton kategoriSil = new JButton("Sil");
        ustPanel.add(kategoriSil);
        kategoriSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JList kategoriList = new JList();
        kategoriList.setListData(new KatagoriDal().GetAll().toArray());
        JScrollPane pane = new JScrollPane(kategoriList);
        pane.setBorder(BorderFactory.createTitledBorder("Düzenlenecek Liste"));
        
        kategoriAdiField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                return;
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                kategoriList.setListData(new KatagoriDal().GetSearchKatagori(kategoriAdiField.getText()).toArray());
                kategoriList.setSelectedIndex(0);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                return;
            }
        });
        
        
        panel.add(ustPanel, BorderLayout.NORTH);
        panel.add(pane, BorderLayout.CENTER);

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
