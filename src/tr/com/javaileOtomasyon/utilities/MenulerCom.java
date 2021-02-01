package tr.com.javaileOtomasyon.utilities;

import tr.com.javaileOtomasyon.dal.AccountsDAL;
import tr.com.javaileOtomasyon.fe.*;
import tr.com.javaileOtomasyon.types.PersonelContract;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenulerCom {

    public static JMenuBar initBar() {
        JMenuBar bar = new JMenuBar();

        /*Dosya Menü*/
        JMenu dosyaMenu = new JMenu("Dosya");
        bar.add(dosyaMenu);
        JMenuItem cikisItem = new JMenuItem("Çıkış");
        dosyaMenu.add(cikisItem);

        /*Ürünler Menü*/
        JMenu urunlerMenu = new JMenu("Katagoriler");
        bar.add(urunlerMenu);
        JMenuItem katagoriEkleItem = new JMenuItem("Katagori Ekle");
        urunlerMenu.add(katagoriEkleItem);
        urunlerMenu.addSeparator();
        JMenuItem katagoriDuzenleItem = new JMenuItem("Katagoriyi Düzenle");
        urunlerMenu.add(katagoriDuzenleItem);

        /*Personeller Menü*/
        JMenu personellerMenu = new JMenu("Personel İşlemleri");
        bar.add(personellerMenu);
        JMenuItem yetkiEkleItem = new JMenuItem("Yetki Ekle");
        personellerMenu.add(yetkiEkleItem);
        JMenuItem sifreBelirleItem = new JMenuItem("Şifre Belirle");
        personellerMenu.add(sifreBelirleItem);
        personellerMenu.addSeparator();
        JMenuItem yetkiDuzenleItem = new JMenuItem("Yetki Düzenle");
        personellerMenu.add(yetkiDuzenleItem);
        JMenuItem sifreduzenlemeItem = new JMenuItem("Şifre Düzenle");
        personellerMenu.add(sifreduzenlemeItem);

        PersonelContract contract = (PersonelContract) LoginFE.emailBox.getSelectedItem();

        if (new AccountsDAL().GetYetkiId(contract.getId()).getYetkiliId() == 2) {

            personellerMenu.hide();
            
        }

        katagoriEkleItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new KatagoriEkleFE();
            }
        });
        yetkiEkleItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        new YetkiEkleFE();
                    }
                });
            }
        });
        sifreBelirleItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        new SifreIslemleriFE();
                    }
                });
            }
        });
        cikisItem.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> {
                int cevap = JOptionPane.showConfirmDialog(null, "Program Kapatılsın mı?", "Uyarı!!", JOptionPane.YES_NO_OPTION);
                if (cevap == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            });
        });
        katagoriDuzenleItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        new KategoriDuzenleFE();
                    }
                });
            }
        });
        yetkiDuzenleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new YetkiDuzenleFE();
                    }
                });
            }
        });
        sifreduzenlemeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new SifreDuzenleFE();
                    }
                });
            }
        });
        return bar;
    }
}
