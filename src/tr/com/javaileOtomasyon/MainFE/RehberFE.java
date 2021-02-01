package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RehberFE extends JPanel implements FeInterfaces {

    public RehberFE() {
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
        BufferedImage MusteriRehber = null;
        BufferedImage FirmaRehber = null;
        pane.setPreferredSize(new Dimension(1700, 900));
        try {
            MusteriRehber = ImageIO.read(new File("icons/rehber.png"));
            FirmaRehber = ImageIO.read(new File("icons/rehber.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image MusteriRehberler = MusteriRehber.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon MusteriRehberIcon = new ImageIcon(MusteriRehberler);
        Image FirmaRehberler = FirmaRehber.getScaledInstance(15,15,Image.SCALE_SMOOTH);
        ImageIcon FirmaRehberlerIcon = new ImageIcon(FirmaRehberler);
        pane.addTab("MÜŞTERİ REHBER",MusteriRehberIcon,new MusteriRehberFE()," ");
        pane.addTab("FİRMA REHBER",FirmaRehberlerIcon,new FirmaRehberFE()," ");

        return pane;
    }
}
