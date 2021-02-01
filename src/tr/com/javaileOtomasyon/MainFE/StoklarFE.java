package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.StokDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.StokContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StoklarFE extends JPanel implements FeInterfaces {

    public StoklarFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {

        JPanel stockPanel = new JPanel(new BorderLayout());
        JPanel stockSolPanel = new JPanel(new BorderLayout());
        stockPanel.setPreferredSize(new Dimension(1700, 900));

        stockSolPanel.setBorder(BorderFactory.createTitledBorder("Stok İşlemleri"));
        String[] stokKolonlar = {"Ürün Adı", "Miktar"};
        DefaultTableModel model = new DefaultTableModel(stokKolonlar, 0);
        JTable tablo = new JTable(model);
        JScrollPane stokTablePane = new JScrollPane(tablo);

        for (StokContract contract : new StokDAL().GetAllStok()) {
            model.addRow(contract.GetVeriler());
        }
        stokTablePane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) tablo.getModel();
                int selectedRowIndex = tablo.getSelectedRow();
                new StokDetayFE(model.getValueAt(selectedRowIndex, 0).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        stockPanel.add(stokTablePane, BorderLayout.CENTER);

        return stockPanel;
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
