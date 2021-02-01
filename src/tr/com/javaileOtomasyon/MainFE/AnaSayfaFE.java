package tr.com.javaileOtomasyon.MainFE;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import tr.com.javaileOtomasyon.dal.AnaSayfaDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.AnaSayfaContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AnaSayfaFE extends JPanel implements FeInterfaces {

    public AnaSayfaFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
        setSize(600, 600);
        setVisible(true);
    }

    @Override
    public JPanel initPanel() {
        JPanel homePanel = new JPanel(new BorderLayout());
        JPanel homeSolPanel = new JPanel(new BorderLayout());
        JPanel homeSagPanel = new JPanel(new BorderLayout());
        homePanel.setPreferredSize(new Dimension(1920, 900));

        String[] azalanStoklar = {"Ürün Adı", "Adet"};
        DefaultTableModel azalanModel = new DefaultTableModel(azalanStoklar,0);
        JTable azalanTablo = new JTable(azalanModel);
        JScrollPane azalanTablePane = new JScrollPane(azalanTablo);

        for (AnaSayfaContract AScontract:new AnaSayfaDAL().GetAzalanStoklar()) {
            azalanModel.addRow(AScontract.GetVerilerAzalanStoklarVeriler());
        }

        String[] son10Hareket = {"Ürün Adı", "Adet","Ad","Fiyat","Toplam"};
        DefaultTableModel son10HareketModel = new DefaultTableModel(son10Hareket,0);
        JTable son10HareketTablo = new JTable(son10HareketModel);
        JScrollPane son10HareketTablePane = new JScrollPane(son10HareketTablo);

        for (AnaSayfaContract SHcontract:new AnaSayfaDAL().GetSonHareketler()) {
            son10HareketModel.addRow(SHcontract.GetSonUrunlerVeriler());
        }

        String[] ajanda = {"Tarih", "Saat","Başlık"};
        DefaultTableModel ajandaModel = new DefaultTableModel(ajanda,0);
        JTable ajandaTablo = new JTable(ajandaModel);
        JScrollPane ajandaTablePane = new JScrollPane(ajandaTablo);

        for (AnaSayfaContract Ajcontract:new AnaSayfaDAL().GetAjanda()) {
            ajandaModel.addRow(Ajcontract.GetAjandaVeriler());
        }

        String[] doviz = {"DÖVİZ ADI", "FİYAT","ORAN","SON GÜNCELLEME"};
        DefaultTableModel dovizModel = new DefaultTableModel(doviz,0);
        JTable dovizTablo = new JTable(dovizModel);
        JScrollPane dovizKurlarıPane = new JScrollPane(dovizTablo);
        String url = "https://www.doviz.com/";
        Document document;
        try {
            document = Jsoup.connect(url).get();
            for (Element row : document.select(
                    "div.table.table-narrow tr")) {
                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    final String dovizAd =
                            row.select("td:nth-of-type(1)").text();
                    final String ilkFiyat =
                            row.select("td:nth-of-type(2)").text();
                    final String degisimOrani =
                            row.select("td:nth-of-type(3)").text();
                    final String sonGuncelleme =
                            row.select("td:nth-of-type(4)").text();
                    dovizModel.addRow(new List[]
                            {Collections.singletonList(dovizAd),
                                    Collections.singletonList(ilkFiyat),
                                    Collections.singletonList(degisimOrani),
                                    Collections.singletonList(sonGuncelleme)});
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        dovizKurlarıPane.setBorder(BorderFactory.createTitledBorder("Döviz Kurları"));
        ajandaTablePane.setBorder(BorderFactory.createTitledBorder("Ajanda"));
        azalanTablePane.setBorder(BorderFactory.createTitledBorder("Azalan Stoklar"));
        son10HareketTablePane.setBorder(BorderFactory.createTitledBorder("Son 10 Hareket"));


        homeSolPanel.add(azalanTablePane,BorderLayout.WEST);
        homeSolPanel.add(son10HareketTablePane,BorderLayout.EAST);

        homeSagPanel.add(ajandaTablePane,BorderLayout.WEST);
        homeSagPanel.add(dovizKurlarıPane,BorderLayout.EAST);

        homePanel.add(homeSolPanel,BorderLayout.WEST);
        homePanel.add(homeSagPanel,BorderLayout.CENTER);

        return homePanel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        JTabbedPane homePanel = new JTabbedPane();
        return null;
    }
}
