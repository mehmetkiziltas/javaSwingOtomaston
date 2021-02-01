package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KasaFE extends JPanel implements FeInterfaces {

    public KasaFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane pane = initTabs();

        panel.add(pane,BorderLayout.CENTER);
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        JTabbedPane pane = new JTabbedPane();
        pane.setPreferredSize(new Dimension(1920, 800));
        BufferedImage MusteriHareket = null;
        BufferedImage FirmaHareket = null;
        try {
            MusteriHareket = ImageIO.read(new File("icons/kasa.png"));
            FirmaHareket = ImageIO.read(new File("icons/kasa.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image Musterihareketler = MusteriHareket.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon MusterihareketIcon = new ImageIcon(Musterihareketler);
        Image Firmahareketler = FirmaHareket.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon FirmahareketIcon = new ImageIcon(Firmahareketler);
        pane.addTab("KASA GİRİŞ HAREKETLER",MusterihareketIcon,new KasaGirisFE()," ");
        pane.addTab("KASA ÇIKIŞ HAREKETLER",FirmahareketIcon,new KasaCikisFE()," ");

        return pane;
    }
}
