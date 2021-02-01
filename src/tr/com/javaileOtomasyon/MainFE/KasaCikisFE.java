package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.HareketlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.GiderlerContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class KasaCikisFE extends JPanel implements FeInterfaces {
    public KasaCikisFE() {
        initPencere();
    }

    @Override
    public void initPencere() {

        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel HareketPanel = new JPanel(new BorderLayout());
        HareketPanel.setPreferredSize(new Dimension(1700, 900));

        HareketPanel.setBorder(BorderFactory.createTitledBorder("KASA Çıkış HAREKETLERİ"));
        String[] MusteriHareketKolonlar = {"ID", "YIL", "AY", "ELEKTRIK", "SU", "DOGALGAZ", "INTERNET","MAASLAR","EKSTRA","NOTLAR"};
        DefaultTableModel MusteriHareketmodel = new DefaultTableModel(MusteriHareketKolonlar, 0);
        JTable MusteriHarekettablo = new JTable(MusteriHareketmodel);
        JScrollPane MusteriHareketTablePane = new JScrollPane(MusteriHarekettablo);

        for (GiderlerContract contract: new HareketlerDAL().GetAllKasaCikisHareketleri()) {
            MusteriHareketmodel.addRow(contract.getVeriler());
        }

        HareketPanel.add(MusteriHareketTablePane, BorderLayout.CENTER);

        return HareketPanel;
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
