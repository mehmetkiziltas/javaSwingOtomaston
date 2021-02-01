package tr.com.javaileOtomasyon.fe;

import tr.com.javaileOtomasyon.MainFE.*;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.utilities.MenulerCom;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnaPencereFE extends JFrame implements FeInterfaces {

    public AnaPencereFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JMenuBar bar = initBar();
        JPanel panel = initPanel();
        getContentPane().add(panel,BorderLayout.CENTER);
        getContentPane().setBackground(Color.getColor("#0aa5d1"));
        setJMenuBar(bar);
        setTitle("Satış Ve Stok Programı");
        setExtendedState(MAXIMIZED_BOTH);
        setSize(1200,900);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane pane = initTabs();

        panel.add(pane);
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        JMenuBar bar = MenulerCom.initBar();
        return bar;
    }

    @Override
    public JTabbedPane initTabs() {
        JTabbedPane pane = new JTabbedPane();
        BufferedImage hareket = null;
        BufferedImage img = null;
        BufferedImage img2 = null;
        BufferedImage home = null;
        BufferedImage banka= null;
        BufferedImage fatura = null;
        BufferedImage gelir = null;
        BufferedImage gider = null;
        BufferedImage kasa = null;
        BufferedImage musteri = null;
        BufferedImage notlar = null;
        BufferedImage personel = null;
        BufferedImage rapor = null;
        BufferedImage rehber = null;
        BufferedImage urun = null;
        BufferedImage firma = null;
        try {
            img = ImageIO.read(new File("icons/stok.png"));
            img2 = ImageIO.read(new File("icons/stock.png"));
            home = ImageIO.read(new File("icons/home2.png"));
            firma = ImageIO.read(new File("icons/firma.png"));
            banka = ImageIO.read(new File("icons/banka.png"));
            fatura = ImageIO.read(new File("icons/faturalar.png"));
            gelir = ImageIO.read(new File("icons/gelirler.png"));
            gider = ImageIO.read(new File("icons/giderler.png"));
            hareket = ImageIO.read(new File("icons/hareketler.png"));
            kasa = ImageIO.read(new File("icons/kasa.png"));
            musteri = ImageIO.read(new File("icons/musteriler.png"));
            notlar = ImageIO.read(new File("icons/notlar.png"));
            personel = ImageIO.read(new File("icons/personeller.png"));
            rapor = ImageIO.read(new File("icons/raporlar.png"));
            rehber = ImageIO.read(new File("icons/rehber.png"));
            urun = ImageIO.read(new File("icons/urunler.png"));


        } catch (IOException ex) {
            Logger.getLogger(AnaPencereFE.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image dimg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);

        Image dimg2 = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(dimg2);

        Image homeDimg = home.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon homeIcon = new ImageIcon(homeDimg);

        Image bankalar = banka.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon bankaIcon = new ImageIcon(bankalar);

        Image faturalar = fatura.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon faturaIcon = new ImageIcon(faturalar);

        Image firmalar = firma.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon firmaIcon = new ImageIcon(firmalar);

        Image gelirler = gelir.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon gelirIcon = new ImageIcon(gelirler);

        Image giderler = gider.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon giderIcon = new ImageIcon(giderler);

        Image hareketler = hareket.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon hareketIcon = new ImageIcon(hareketler);

        Image kasalar = kasa.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon kasaIcon = new ImageIcon(kasalar);

        Image musteriler = musteri.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon musteriIcon = new ImageIcon(musteriler);

        Image notlarImg = notlar.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon notlarIcon = new ImageIcon(notlarImg);

        Image personeller = personel.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon personelIcon = new ImageIcon(personeller);

        Image raporlar = rapor.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon raporIcon = new ImageIcon(raporlar);

        Image rehberler = rehber.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon rehberIcon = new ImageIcon(rehberler);

        Image urunler = urun.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon urunIcon = new ImageIcon(urunler);

        pane.setPreferredSize(new Dimension(800,800));

        pane.addTab("ANA SAYFA",homeIcon,new AnaSayfaFE(),"");
        pane.addTab("ÜRÜNLER", urunIcon, new UrunlerFE(), " ");
        pane.addTab("STOKLAR", icon, new StoklarFE(), " ");
        pane.addTab("MÜŞTERİLER",musteriIcon,new MusterilerFE()," ");
        pane.addTab("FİRMALAR", firmaIcon, new FirmalarFE(), " ");
        pane.addTab("PERSONELLER", personelIcon, new PersonellerFE(), " ");
        pane.addTab("GİDERLER",giderIcon,new GiderlerFE()," ");
        pane.addTab("KASA", kasaIcon, new KasaFE(), " ");
        pane.addTab("NOTLAR", notlarIcon, new NotlarFE(), " ");
        pane.addTab("BANKALAR",bankaIcon,new BankalarFE()," ");
        pane.addTab("REHBER", rehberIcon, new RehberFE(), " ");
        pane.addTab("FATURALAR", faturaIcon, new FaturalarFE(), " ");
        pane.addTab("HAREKETLER",hareketIcon,new HareketlerFE()," ");
        pane.addTab("RAPORLAR", raporIcon, new RaporlarFE(), " ");


        return pane;
    }
}
