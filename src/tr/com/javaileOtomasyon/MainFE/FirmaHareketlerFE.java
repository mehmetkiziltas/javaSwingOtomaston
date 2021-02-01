
package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.HareketlerDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.HareketlerContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FirmaHareketlerFE extends JPanel implements FeInterfaces {

    public FirmaHareketlerFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel FirmaHareketPanel = new JPanel(new BorderLayout());
        FirmaHareketPanel.setPreferredSize(new Dimension(1700, 900));

        FirmaHareketPanel.setBorder(BorderFactory.createTitledBorder("Firma Hareket İşlemleri"));
        String[] HareketKolonlar = {"HAREKETID", "URUNAD", "ADET", "AD SOYAD", "FIRMA AD", "FIYAT", "TOPLAM","FATURAID","TARIH","NOTLAR"};
        DefaultTableModel Hareketmodel = new DefaultTableModel(HareketKolonlar, 0);
        JTable Harekettablo = new JTable(Hareketmodel);
        JScrollPane HareketTablePane = new JScrollPane(Harekettablo);
        for (HareketlerContract contract: new HareketlerDAL().GetAllFirmaHareketler()) {
            Hareketmodel.addRow(contract.getVeriler());
        }

        FirmaHareketPanel.add(HareketTablePane, BorderLayout.CENTER);

        return FirmaHareketPanel;
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
