package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.HareketlerDAL;
import tr.com.javaileOtomasyon.dal.KasaDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.HareketlerContract;
import tr.com.javaileOtomasyon.types.KasaContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class KasaGirisFE extends JPanel implements FeInterfaces {
    public KasaGirisFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel GirisPanel = new JPanel(new BorderLayout());

        GirisPanel.setPreferredSize(new Dimension(1750, 900));

        JPanel KasaSagPanel = new JPanel(new BorderLayout());
        JPanel KasaUstPanel = new JPanel(new BorderLayout());
        JPanel KasaAltPanel = new JPanel(new BorderLayout());

        KasaUstPanel.setBorder(BorderFactory.createTitledBorder("KASA FİRMA HAREKETLERİ"));
        String[] HareketKolonlar = {"HAREKETID", "URUNAD", "ADET", "AD SOYAD", "FIRMA AD", "FIYAT", "TOPLAM", "FATURAID", "TARIH", "NOTLAR"};
        DefaultTableModel Hareketmodel = new DefaultTableModel(HareketKolonlar, 0);
        JTable Harekettablo = new JTable(Hareketmodel);
        JScrollPane HareketTablePane = new JScrollPane(Harekettablo);
        KasaUstPanel.add(HareketTablePane);
        KasaUstPanel.setPreferredSize(new Dimension(720, 800));

        for (HareketlerContract contract: new HareketlerDAL().GetAllFirmaHareketler()) {
            Hareketmodel.addRow(contract.getVeriler());
        }

        KasaAltPanel.setBorder(BorderFactory.createTitledBorder("KASA MÜŞTERİ HAREKETLERİ"));
        String[] MusteriHareketKolonlar = {"HAREKETID", "URUNAD", "ADET", "AD SOYAD", "MÜŞTERİ AD", "FIYAT", "TOPLAM", "FATURAID", "TARIH", "NOTLAR"};
        DefaultTableModel MusteriHareketmodel = new DefaultTableModel(MusteriHareketKolonlar, 0);
        JTable MusteriHarekettablo = new JTable(MusteriHareketmodel);
        JScrollPane MusteriHareketTablePane = new JScrollPane(MusteriHarekettablo);
        KasaAltPanel.add(MusteriHareketTablePane);
        KasaAltPanel.setPreferredSize(new Dimension(720, 800));

        for (HareketlerContract contract: new HareketlerDAL().GetAllMusteriHareketler()) {
            MusteriHareketmodel.addRow(contract.getVeriler());
        }

        JPanel KasaSolPanel = new JPanel(new BorderLayout());
        JPanel KasaSolUstPanel = new JPanel(new GridLayout(10, 2));
        JPanel KasaSolAltPanel = new JPanel();

        KasaSolPanel.setBorder(BorderFactory.createTitledBorder("KASA BİLGİSİ"));
        KasaSolPanel.setPreferredSize(new Dimension(300, 800));
        KasaSolUstPanel.setPreferredSize(new Dimension(300, 800));

        JLabel ToplamTutarLabel = new JLabel("Toplam Tutar: ", JLabel.RIGHT);
        KasaSolUstPanel.add(ToplamTutarLabel);
        JTextField ToplamTutarBox = new JTextField(15);
        KasaSolUstPanel.add(ToplamTutarBox);
        ToplamTutarBox.setEnabled(false);
        for (KasaContract contract: new KasaDAL().GetToplamTutarDAL()) {
            ToplamTutarBox.setText(contract.getToplamTutar() + " TL");
        }

        JLabel OdemelerLabel = new JLabel("Ödemeler: ", JLabel.RIGHT);
        KasaSolUstPanel.add(OdemelerLabel);
        JTextField OdemelerBox = new JTextField(15);
        KasaSolUstPanel.add(OdemelerBox);
        OdemelerBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetOdemelerDAL()) {
            OdemelerBox.setText(contract.getOdemeler() + " TL");
        }

        JLabel PersonelMaaslariLabel = new JLabel("Personel Maaşları: ", JLabel.RIGHT);
        KasaSolUstPanel.add(PersonelMaaslariLabel);
        JTextField PersonelMaaslariBox = new JTextField("",15);
        KasaSolUstPanel.add(PersonelMaaslariBox);
        PersonelMaaslariBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetPersonelMaaslariDAL()) {
            PersonelMaaslariBox.setText(contract.getPersonelMaaslari() + " TL");
        }

        JLabel MusteriSayisiLabel = new JLabel("Müsteri Sayısı: ", JLabel.RIGHT);
        KasaSolUstPanel.add(MusteriSayisiLabel);
        JTextField MusteriSayisiBox = new JTextField(15);
        KasaSolUstPanel.add(MusteriSayisiBox);
        MusteriSayisiBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetMusteriSayisiDAL()) {
            MusteriSayisiBox.setText(contract.getMusteriSayisi());
        }

        JLabel FirmaSayisiLabel = new JLabel("Firma Sayısı: ", JLabel.RIGHT);
        KasaSolUstPanel.add(FirmaSayisiLabel);
        JTextField FirmaSayisiBox = new JTextField(15);
        KasaSolUstPanel.add(FirmaSayisiBox);
        FirmaSayisiBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetFirmaSayisiDAL()) {
            FirmaSayisiBox.setText(contract.getFirmaSayisi());
        }

        JLabel MusteriSehirSayisiLabel = new JLabel("Musteri Şehir Sayısı: ", JLabel.RIGHT);
        KasaSolUstPanel.add(MusteriSehirSayisiLabel);
        JTextField MusteriSehirSayisiBox = new JTextField(15);
        KasaSolUstPanel.add(MusteriSehirSayisiBox);
        MusteriSehirSayisiBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetMusteriSehirSayisiDAL()) {
            MusteriSehirSayisiBox.setText(contract.getMusteriSehirSayisi());
        }

        JLabel FirmaSehirSayisiLabel = new JLabel("Firma Şehir Sayısı: ", JLabel.RIGHT);
        KasaSolUstPanel.add(FirmaSehirSayisiLabel);
        JTextField FirmaSehirSayisiBox = new JTextField(15);
        KasaSolUstPanel.add(FirmaSehirSayisiBox);
        FirmaSehirSayisiBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetFirmaSehirSayisiDAL()) {
            FirmaSehirSayisiBox.setText(contract.getFirmaSehirSayisi());
        }

        JLabel PersonelSayisiLabel = new JLabel("Personel Sayısı: ", JLabel.RIGHT);
        KasaSolUstPanel.add(PersonelSayisiLabel);
        JTextField PersonelSayisiBox = new JTextField(15);
        KasaSolUstPanel.add(PersonelSayisiBox);
        PersonelSayisiBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetPersonelSayisiDAL()) {
            PersonelSayisiBox.setText(contract.getPersonelSayisi());
        }

        JLabel StokSayisiLabel = new JLabel("Stok Sayısı: ", JLabel.RIGHT);
        KasaSolUstPanel.add(StokSayisiLabel);
        JTextField StokSayisiBox = new JTextField(15);
        KasaSolUstPanel.add(StokSayisiBox);
        StokSayisiBox.setEnabled(false);

        for (KasaContract contract: new KasaDAL().GetStokSayisiDAL()) {
            StokSayisiBox.setText(contract.getStokSayisi());
        }

        KasaSolPanel.add(KasaSolUstPanel, BorderLayout.NORTH);
        KasaSolPanel.add(KasaSolAltPanel, BorderLayout.SOUTH);


        GirisPanel.add(KasaSolPanel, BorderLayout.WEST);


        KasaSagPanel.add(KasaUstPanel, BorderLayout.EAST);
        KasaSagPanel.add(KasaAltPanel, BorderLayout.WEST);

        GirisPanel.add(KasaSagPanel, BorderLayout.CENTER);

        return GirisPanel;
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
