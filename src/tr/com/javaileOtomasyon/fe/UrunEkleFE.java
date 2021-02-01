package tr.com.javaileOtomasyon.fe;

import com.toedter.calendar.JDateChooser;
import tr.com.javaileOtomasyon.dal.KatagoriDal;
import tr.com.javaileOtomasyon.dal.UrunlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.KatagoriContract;
import tr.com.javaileOtomasyon.types.UrunlerContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class UrunEkleFE extends JDialog implements FeInterfaces {

    public UrunEkleFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Ürün Kayıt Alanı"));
        add(panel);

        setTitle("Ürün Ekle");
        setSize(500, 200);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JLabel adilabel = new JLabel("Ürün Adı : ", JLabel.RIGHT);
        panel.add(adilabel);
        JTextField adiField = new JTextField(10);
        panel.add(adiField);
        JLabel katagoriLabel = new JLabel("Kategori Seç : ", JLabel.RIGHT);
        panel.add(katagoriLabel);
        JComboBox katagoriBox = new JComboBox(new KatagoriDal().GetAll().toArray());
        panel.add(katagoriBox);
        JLabel tarihLabel = new JLabel("Tarih Seç : ", JLabel.RIGHT);
        panel.add(tarihLabel);
        JDateChooser tarihDate = new JDateChooser();
        tarihDate.setDateFormatString("yyyy-MM-dd");
        panel.add(tarihDate);
        JLabel fiyatlLabel = new JLabel("Fiyat Gir : ", JLabel.RIGHT);
        panel.add(fiyatlLabel);
        JTextField fiyatField = new JTextField(10);
        panel.add(fiyatField);
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        kaydetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UrunlerContract contract = new UrunlerContract();
                KatagoriContract casContract = (KatagoriContract) katagoriBox.getSelectedItem();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(tarihDate.getDate());
                contract.setADI(adiField.getText());
                contract.setSATISFIYAT(casContract.getId());
                contract.setYIL(date);
                contract.setSATISFIYAT(Float.parseFloat(fiyatField.getText()));
                new UrunlerDAL().Insert(contract);
                JOptionPane.showMessageDialog(rootPane, contract.getADI() + " Adlı Ürun Eklendi");
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
