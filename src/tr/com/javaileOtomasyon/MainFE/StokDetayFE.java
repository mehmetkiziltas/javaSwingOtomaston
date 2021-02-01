package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.complex.contract.UrunlerContractComplex;
import tr.com.javaileOtomasyon.dal.StokDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StokDetayFE extends JDialog implements FeInterfaces {
    private String Urunad;
    public StokDetayFE(String UrunAdi) {
        setUrunad(UrunAdi);
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);

        setTitle("Mail Gönderme Paneli");
        setVisible(true);
        panel.setSize(new Dimension(100, 100));
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel FaturaUrunDetayPanel = new JPanel(new BorderLayout());


        FaturaUrunDetayPanel.setBorder(BorderFactory.createTitledBorder("Stok Detayları"));
        String[] FaturaUrunDetayKolonlar = {"ID", "ÜRÜN ADI", "MARKA", "MODEL", "YIL", "ADET", "ALIŞ FİYAT", "SATIŞ FİYAT", "DETAY"};
        DefaultTableModel FaturaUrunDetaymodel = new DefaultTableModel(FaturaUrunDetayKolonlar, 0);
        JTable FaturaUrunDetaytablo = new JTable(FaturaUrunDetaymodel);
        JScrollPane FaturaUrunDetayTablePane = new JScrollPane(FaturaUrunDetaytablo);
        FaturaUrunDetayTablePane.setPreferredSize(new Dimension(900,450));

        for (UrunlerContractComplex contract : new StokDAL().GetByAdi(getUrunad())) {
            FaturaUrunDetaymodel.addRow(contract.getVeriler());
        }

        FaturaUrunDetayPanel.add(FaturaUrunDetayTablePane, BorderLayout.CENTER);
        return FaturaUrunDetayPanel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }

    public String getUrunad() {
        return Urunad;
    }

    public void setUrunad(String urunad) {
        Urunad = urunad;
    }
}
