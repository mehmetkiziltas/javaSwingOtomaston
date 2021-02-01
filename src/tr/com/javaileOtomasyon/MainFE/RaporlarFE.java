package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RaporlarFE extends JPanel implements FeInterfaces {

    public RaporlarFE() {
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

        panel.add(pane, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        JTabbedPane pane = new JTabbedPane();
        pane.setPreferredSize(new Dimension(1700, 900));
        BufferedImage MusteriRapor = null;
        BufferedImage KasaRaporBI = null;
        BufferedImage GiderRaporBI = null;
        BufferedImage FirmaRapor = null;
        try {
            GiderRaporBI = ImageIO.read(new File("icons/hareketler.png"));
            KasaRaporBI = ImageIO.read(new File("icons/hareketler.png"));
            MusteriRapor = ImageIO.read(new File("icons/hareketler.png"));
            FirmaRapor = ImageIO.read(new File("icons/hareketler.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image KasaRaporImg = KasaRaporBI.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon KasaRaporIcon = new ImageIcon(KasaRaporImg);

        Image GiderRaporImg = GiderRaporBI.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon GiderRaporIcon = new ImageIcon(GiderRaporImg);

        Image MusteriRaporImg = MusteriRapor.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon MusteriRaporIcon = new ImageIcon(MusteriRaporImg);

        Image FirmaRaporImg = FirmaRapor.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon FirmaRaporIcon = new ImageIcon(FirmaRaporImg);

        pane.addTab("Musteri Raporları",MusteriRaporIcon,new MusteriRaporFE()," ");
        pane.addTab("Firma Raporları",FirmaRaporIcon,new FirmaRaporFE()," ");
        pane.addTab("Kasa Raporları",KasaRaporIcon,new KasaRaporFE()," ");
        pane.addTab("Gider Raporları",GiderRaporIcon,new GiderRaporFE()," ");

        return pane;
    }
}
