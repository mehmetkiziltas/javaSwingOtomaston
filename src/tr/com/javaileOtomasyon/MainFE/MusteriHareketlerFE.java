package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.HareketlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.HareketlerContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MusteriHareketlerFE extends JPanel implements FeInterfaces {

    public MusteriHareketlerFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel MusteriHareketPanel = new JPanel(new BorderLayout());
        MusteriHareketPanel.setPreferredSize(new Dimension(1700, 900));

        MusteriHareketPanel.setBorder(BorderFactory.createTitledBorder("Müşteri Hareket İşlemleri"));
        String[] HareketKolonlar = {"HAREKETID", "URUNAD", "ADET", "AD SOYAD", "MÜŞTERİ AD", "FIYAT", "TOPLAM","FATURAID","TARIH","NOTLAR"};
        DefaultTableModel Hareketmodel = new DefaultTableModel(HareketKolonlar, 0);
        JTable Harekettablo = new JTable(Hareketmodel);
        JScrollPane HareketTablePane = new JScrollPane(Harekettablo);
        for (HareketlerContract contract: new HareketlerDAL().GetAllMusteriHareketler()) {
            Hareketmodel.addRow(contract.getVeriler());
        }

        MusteriHareketPanel.add(HareketTablePane, BorderLayout.CENTER);

        return MusteriHareketPanel;

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
